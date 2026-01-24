package fun.spmc.pigeons.entity;

import fun.spmc.pigeons.util.PigeonType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.neoforge.event.EventHooks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class AbstractPigeonEntity extends TamableAnimal {

    public final AnimationState animationState0;
    private final String pigeonCooingSound;
    private final String pigeonDeathSound;
    private final PigeonType type;

    public AbstractPigeonEntity(EntityType<? extends TamableAnimal> entityType, Level level, String pigeonDeathSound, String pigeonCooingSound, PigeonType type) {
        super(entityType, level);
        this.pigeonCooingSound = pigeonCooingSound;
        this.pigeonDeathSound = pigeonDeathSound;
        this.type = type;

        this.animationState0 = new AnimationState();
        this.xpReward = 1;
        this.setNoAi(false);
        this.setPersistenceRequired();
        this.moveControl = new FlyingMoveControl(this, 10, true);
    }

    public AbstractPigeonEntity(EntityType<? extends TamableAnimal> entityType, Level level, PigeonType type) {
        this(entityType, level, "pigeon_death", "pigeon_coo", type);
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
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.2));
        this.goalSelector.addGoal(2, new BreedGoal(this, .7));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1, item -> item.is(ItemTags.CHICKEN_FOOD), false));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1));
        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 0.8F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(7, new LeapAtTargetGoal(this, 0.7F));
    }

    @Override
    public SoundEvent getAmbientSound() {
        return this.isBaby() ? BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("pigeons:child_pigeon_coo")) : BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("pigeons:" + pigeonCooingSound));
    }

    @Override
    public void playStepSound(@NotNull BlockPos pos, @NotNull BlockState blockIn) {
        this.playSound(SoundEvents.CHICKEN_STEP, 0.15F, 1.0F);
    }

    @Override
    public SoundEvent getHurtSound(@NotNull DamageSource damageSource) {
        return SoundEvents.GENERIC_HURT;
    }

    @Override
    public SoundEvent getDeathSound() {
        return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("pigeons:" + pigeonDeathSound));
    }

    @Override
    public boolean causeFallDamage(float l, float d, @NotNull DamageSource source) {
        return false;
    }

    @Override
    public @NotNull InteractionResult mobInteract(Player sourceEntity, @NotNull InteractionHand hand) {
        ItemStack itemStack = sourceEntity.getItemInHand(hand);
        if (!this.level().isClientSide || this.isBaby() && this.isFood(itemStack)) {
            if (this.isFood(itemStack) && this.getHealth() < this.getMaxHealth()) {
                FoodProperties foodproperties = itemStack.getFoodProperties(this);
                float f = foodproperties != null ? (float) foodproperties.nutrition() : 1.0F;
                this.heal(2.0F * f);
                itemStack.consume(1, sourceEntity);
                this.gameEvent(GameEvent.EAT);
                return InteractionResult.sidedSuccess(this.level().isClientSide());
            } else if (itemStack.is(ItemTags.CHICKEN_FOOD)) {
                itemStack.consume(1, sourceEntity);
                if (this.random.nextInt(3) == 0 && !EventHooks.onAnimalTame(this, sourceEntity)) {
                    this.tame(sourceEntity);
                    this.navigation.stop();
                    this.setTarget(null);
                    this.setOrderedToSit(true);
                    this.level().broadcastEntityEvent(this, (byte) 7);
                } else this.level().broadcastEntityEvent(this, (byte) 6);
                return InteractionResult.SUCCESS;
            } else if (itemStack.is(Items.COOKIE) || itemStack.is(Items.BREAD)) this.addEffect(new MobEffectInstance(MobEffects.POISON, 80, 1));
            else return super.mobInteract(sourceEntity, hand);
        } else return this.isOwnedBy(sourceEntity) || this.isTame() ? InteractionResult.CONSUME : InteractionResult.PASS;

        return super.mobInteract(sourceEntity, hand);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.level().isClientSide()) this.animationState0.animateWhen((!this.level().getBlockState(BlockPos.containing(this.getX(), this.getY() - 0.05, this.getZ())).canOcclude()), this.tickCount);
    }

    @Override
    public boolean isFood(ItemStack itemStack) {
        return itemStack.is(ItemTags.CHICKEN_FOOD);
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(@NotNull ServerLevel serverWorld, @NotNull AgeableMob ageableMob) {
        AbstractPigeonEntity entity = type.getEntityType().create(serverWorld);
        Objects.requireNonNull(entity).finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(entity.getOnPos()), MobSpawnType.BREEDING, null);
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
}
