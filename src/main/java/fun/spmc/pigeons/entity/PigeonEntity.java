package fun.spmc.pigeons.entity;

import fun.spmc.pigeons.init.PigeonsModEntities;
import fun.spmc.pigeons.init.PigeonsModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.EventHooks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;


public class PigeonEntity extends TamableAnimal {

    public final AnimationState animationState0;

    public PigeonEntity(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level);

        this.animationState0 = new AnimationState();
        this.xpReward = 1;
        this.setNoAi(false);
        this.setPersistenceRequired();
        this.moveControl = new FlyingMoveControl(this, 10, true);
    }

    @Override
    public float maxUpStep() {
        return 0.6F;
    }

    @Override
    protected @NotNull PathNavigation createNavigation(@NotNull Level level) {
        return new FlyingPathNavigation(this, level);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.2));
        this.goalSelector.addGoal(2, new BreedGoal(this, 0.7));
        this.goalSelector.addGoal(3, new RandomStrollGoal(this, 0.8, 20) {
            protected Vec3 getPosition() {
                RandomSource random = this.mob.getRandom();
                double randomMovement = (random.nextFloat() * 2.0F - 1.0F) * 16.0F;

                double x = this.mob.getX() + randomMovement;
                double y = this.mob.getY() + randomMovement;
                double z = this.mob.getZ() + randomMovement;
                return new Vec3(x, y, z);
            }
        });
        this.goalSelector.addGoal(4, new RandomStrollGoal(this, 0.5F));
        this.goalSelector.addGoal(5, new TemptGoal(this, 1, item -> item.is(ItemTags.CHICKEN_FOOD), false));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(7, new FloatGoal(this));
        this.goalSelector.addGoal(8, new LeapAtTargetGoal(this, 0.7F));
    }

    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    @Override
    public SoundEvent getAmbientSound() {
        return !this.isBaby() ? BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("pigeons:common_pigeon_cooing")) : BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("pigeons:chick_sound"));
    }

    @Override
    public void playStepSound(@NotNull BlockPos pos, @NotNull BlockState blockIn) {
        this.playSound(Objects.requireNonNull(BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.chicken.step"))), 0.15F, 1.0F);
    }

    @Override
    public SoundEvent getHurtSound(@NotNull DamageSource damageSource) {
        return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.hurt"));
    }

    @Override
    public SoundEvent getDeathSound() {
        return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("pigeons:common_pigeon_death"));
    }

    @Override
    public boolean causeFallDamage(float l, float d, @NotNull DamageSource source) {
        return false;
    }

    @Override
    public void die(@NotNull DamageSource source) {
        super.die(source);

        Level world = this.level();
        double x = this.getX();
        double y = this.getY();
        double z = this.getZ();

        if (Math.random() <= (double)0.5F && world instanceof ServerLevel _level) {
            ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PigeonsModItems.PIGEON_MEAT.get()));
            entityToSpawn.setPickUpDelay(10);
            _level.addFreshEntity(entityToSpawn);
        }
    }

    @Override
    public @NotNull SpawnGroupData finalizeSpawn(@NotNull ServerLevelAccessor world, @NotNull DifficultyInstance difficulty, @NotNull MobSpawnType reason, @org.jetbrains.annotations.Nullable SpawnGroupData livingdata) {
        SpawnGroupData spawnGroupData = super.finalizeSpawn(world, difficulty, reason, livingdata);
        this.getPersistentData().putDouble("homeposX", this.getX());
        this.getPersistentData().putDouble("homeposZ", this.getZ());
        this.getPersistentData().putDouble("homeposY", this.getY());

        return spawnGroupData;
    }

    @Override
    public @NotNull InteractionResult mobInteract(Player sourceEntity, @NotNull InteractionHand hand) {
        ItemStack itemStack = sourceEntity.getItemInHand(hand);
        if (!this.level().isClientSide || this.isBaby() && this.isFood(itemStack)) {
            if (this.isTame()) {
                if (this.isFood(itemStack) && this.getHealth() < this.getMaxHealth()) {
                    FoodProperties foodproperties = itemStack.getFoodProperties(this);
                    float f = foodproperties != null ? (float) foodproperties.nutrition() : 1.0F;
                    this.heal(2.0F * f);
                    itemStack.consume(1, sourceEntity);
                    this.gameEvent(GameEvent.EAT);
                    return InteractionResult.sidedSuccess(this.level().isClientSide());
                }
            } else if (itemStack.is(ItemTags.CHICKEN_FOOD)) {
                itemStack.consume(1, sourceEntity);
                if (this.random.nextInt(3) == 0 && !EventHooks.onAnimalTame(this, sourceEntity)) {
                    this.tame(sourceEntity);
                    this.navigation.stop();
                    this.setTarget(null);
                    this.setOrderedToSit(true);
                    this.level().broadcastEntityEvent(this, (byte) 7);
                } else {
                    this.level().broadcastEntityEvent(this, (byte) 6);
                }
                return InteractionResult.SUCCESS;
            } else if (itemStack.is(Items.COOKIE) || itemStack.is(Items.BREAD)) {
                this.addEffect(new MobEffectInstance(MobEffects.POISON, 80, 1));
            } else {
                return super.mobInteract(sourceEntity, hand);
            }
        } else {
            boolean flag = this.isOwnedBy(sourceEntity) || this.isTame() || itemStack.is(ItemTags.CHICKEN_FOOD) && !this.isTame();
            return flag ? InteractionResult.CONSUME : InteractionResult.PASS;
        }

        return super.mobInteract(sourceEntity, hand);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.level().isClientSide()) {
            this.animationState0.animateWhen((!this.level().getBlockState(BlockPos.containing(this.getX(), this.getY() - 0.05, this.getZ())).canOcclude()), this.tickCount);
        }
    }

    @Override
    public boolean isFood(ItemStack itemStack) {
        return itemStack.is(ItemTags.CHICKEN_FOOD);
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(@NotNull ServerLevel serverWorld, @NotNull AgeableMob ageableMob) {
        PigeonEntity entity = (PigeonsModEntities.PIGEON.get()).create(serverWorld);
        assert entity != null;
        entity.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(entity.getOnPos()), MobSpawnType.BREEDING, null);
        return entity;
    }

    @Override
    public void setNoGravity(boolean ignored) {
        super.setNoGravity(true);
    }

    @Override
    public void aiStep() {
        super.aiStep();
        this.setNoGravity(true);
    }

    /*public static void init() {
        SpawnPlacements.checkSpawnRules(this, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> world.getBlockState(pos).m_204336_(BlockTags.f_184228_) && world.m_45524_(pos, 0) > 8);
    }*/

    public static AttributeSupplier.@NotNull Builder createMobAttributes() {
        AttributeSupplier.Builder builder = Mob.createMobAttributes();
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
        builder = builder.add(Attributes.MAX_HEALTH, 6.0F);
        builder = builder.add(Attributes.ARMOR, 0.0F);
        builder = builder.add(Attributes.ATTACK_DAMAGE, 3.0F);
        builder = builder.add(Attributes.FOLLOW_RANGE, 16.0F);
        builder = builder.add(Attributes.FLYING_SPEED, 0.3);
        return builder;
    }
}
