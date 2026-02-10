package fun.spmc.pigeons.entity;

import fun.spmc.pigeons.init.PigeonSoundEvents;
import fun.spmc.pigeons.util.PigeonType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Mth;
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
import net.minecraft.world.entity.ai.util.LandRandomPos;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.EventHooks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;
import java.util.Objects;

public class AbstractPigeonEntity extends TamableAnimal implements FlyingAnimal {

    public final AnimationState animationState0;
    private final PigeonType type;

    public AbstractPigeonEntity(EntityType<? extends TamableAnimal> entityType, Level level, PigeonType type) {
        super(entityType, level);
        this.type = type;

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
        FlyingPathNavigation flyingpathnavigation = new FlyingPathNavigation(this, level);
        flyingpathnavigation.setCanOpenDoors(false);
        flyingpathnavigation.setCanFloat(true);
        flyingpathnavigation.setCanPassDoors(true);
        return flyingpathnavigation;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new TamableAnimal.TamableAnimalPanicGoal(1.2));
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new LookAtPlayerGoal(this, Player.class, 8));
        this.goalSelector.addGoal(1, new TemptGoal(this, 1f, this::isFood, false));
        this.goalSelector.addGoal(1, new BreedGoal(this, 1f));
        this.goalSelector.addGoal(2, new PigeonSitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(2, new FollowOwnerGoal(this, 1, 5, 1));
        this.goalSelector.addGoal(2, new PigeonWanderGoal(this, 1));
        this.goalSelector.addGoal(3, new FollowMobGoal(this, 1, 3, 7));
    }

    @Override
    public SoundEvent getAmbientSound() {
        return this.isBaby() ? PigeonSoundEvents.CHILD_PIGEON_COO.get() : type.getCooSound();
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
        return type.getDeathSound();
    }

    @Override
    protected boolean canFlyToOwner() {
        return true;
    }

    @Override
    public boolean causeFallDamage(float l, float d, @NotNull DamageSource source) {
        return false;
    }

    @Override
    public @NotNull InteractionResult mobInteract(@NotNull Player sourceEntity, @NotNull InteractionHand hand) {
        ItemStack stack = sourceEntity.getItemInHand(hand);
        if (!this.isTame() && stack.is(ItemTags.CHICKEN_FOOD)) {
            stack.consume(1, sourceEntity);

            if (!this.level().isClientSide) {
                if (this.random.nextInt(10) == 0 && !EventHooks.onAnimalTame(this, sourceEntity)) {
                    this.tame(sourceEntity);
                    this.level().broadcastEntityEvent(this, (byte)7);
                } else this.level().broadcastEntityEvent(this, (byte)6);
            }
            return InteractionResult.sidedSuccess(this.level().isClientSide);
        } else if (stack.is(ItemTags.CHICKEN_FOOD)) {
            if (this.getHealth() < this.getMaxHealth()) {
                stack.consume(1, sourceEntity);
                this.heal(1f);
                return InteractionResult.sidedSuccess(this.level().isClientSide);
            } else return super.mobInteract(sourceEntity, hand);
        } else if (!stack.is(Items.BREAD) || !stack.is(Items.COOKIE)) {
            if (this.isTame() && this.isOwnedBy(sourceEntity)) {
                if (!this.level().isClientSide) this.setOrderedToSit(!this.isOrderedToSit());
                return InteractionResult.sidedSuccess(this.level().isClientSide);
            } else return super.mobInteract(sourceEntity, hand);
        } else {
            stack.consume(1, sourceEntity);
            this.addEffect(new MobEffectInstance(MobEffects.POISON, 900));
            return InteractionResult.sidedSuccess(this.level().isClientSide);
        }
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
        if (this.isTame()) {
            entity.setOwnerUUID(this.getOwnerUUID());
            entity.setTame(true, true);
        }
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

    @Override
    public boolean isFlying() {
        return !this.onGround();
    }

    static class PigeonWanderGoal extends WaterAvoidingRandomFlyingGoal {
        public PigeonWanderGoal(PathfinderMob p_186224_, double p_186225_) {
            super(p_186224_, p_186225_);
        }

        @javax.annotation.Nullable
        protected Vec3 getPosition() {
            Vec3 vec3 = null;
            if (this.mob.isInWater()) vec3 = LandRandomPos.getPos(this.mob, 10, 5);
            if (this.mob.getRandom().nextFloat() >= this.probability) vec3 = this.getTreePos();
            return vec3 == null ? super.getPosition() : vec3;
        }

        @javax.annotation.Nullable
        private Vec3 getTreePos() {
            BlockPos blockpos = this.mob.blockPosition();
            BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
            BlockPos.MutableBlockPos blockPos = new BlockPos.MutableBlockPos();

            for(BlockPos blockPos1 : BlockPos.betweenClosed(Mth.floor(this.mob.getX() - (double)3.0F), Mth.floor(this.mob.getY() - (double)6.0F), Mth.floor(this.mob.getZ() - (double)3.0F), Mth.floor(this.mob.getX() + (double)3.0F), Mth.floor(this.mob.getY() + (double)6.0F), Mth.floor(this.mob.getZ() + (double)3.0F))) {
                if (!blockpos.equals(blockPos1)) {
                    BlockState blockstate = this.mob.level().getBlockState(blockPos.setWithOffset(blockPos1, Direction.DOWN));
                    boolean flag = blockstate.getBlock() instanceof LeavesBlock || blockstate.is(BlockTags.LOGS);
                    if (flag && this.mob.level().isEmptyBlock(blockPos1) && this.mob.level().isEmptyBlock(blockpos$mutableblockpos.setWithOffset(blockPos1, Direction.UP))) return Vec3.atBottomCenterOf(blockPos1);
                }
            }

            return null;
        }
    }

    static class PigeonSitWhenOrderedToGoal extends Goal {
        private final AbstractPigeonEntity mob;

        public PigeonSitWhenOrderedToGoal(AbstractPigeonEntity mob) {
            this.mob = mob;
            this.setFlags(EnumSet.of(Flag.JUMP, Flag.MOVE));
        }

        public boolean canContinueToUse() {
            return this.mob.isOrderedToSit();
        }

        public boolean canUse() {
            if (!this.mob.isTame()) return false;
            else if (this.mob.isInWaterOrBubble()) return false;
            else {
                LivingEntity livingentity = this.mob.getOwner();
                if (livingentity == null) return true;
                else return (!(this.mob.distanceToSqr(livingentity) < (double) 144.0F) || livingentity.getLastHurtByMob() == null) && this.mob.isOrderedToSit();
            }
        }

        public void start() {
            this.mob.getNavigation().stop();
            this.mob.setInSittingPose(true);
        }

        public void stop() {
            this.mob.setInSittingPose(false);
        }
    }
}
