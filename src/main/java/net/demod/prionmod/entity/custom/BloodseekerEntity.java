package net.demod.prionmod.entity.custom;

import net.demod.prionmod.entity.ModEntities;
import net.demod.prionmod.sound.ModSounds;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.brain.task.SeekWaterTask;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.entity.passive.SchoolingFishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

public class BloodseekerEntity extends FishEntity {

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public BloodseekerEntity(EntityType<? extends FishEntity> entityType, World world) {
        super(entityType, world);
    }
    @Override
    public void travel(Vec3d movementInput) {
        if (this.canMoveVoluntarily() && this.isTouchingWater()) {
            this.updateVelocity(0.1f, movementInput);
            this.move(MovementType.SELF, this.getVelocity());
            this.setVelocity(this.getVelocity().multiply(0.8));
            if (this.getTarget() == null) {
                this.setVelocity(this.getVelocity().add(0.0, -0.005, 0.0));
            }
        } else {
            super.travel(movementInput);
        }
    }

    @Override
    protected void updateLimbs(float posDelta) {
        float f = this.getPose() == EntityPose.STANDING ? Math.min(posDelta * 6.0f, 1.0f) : 0.0f;
        this.limbAnimator.updateLimbs(f, 0.2f);
    }
    @Override
    public void tick() {
        super.tick();
        if (this.getWorld().isClient()) {
            setupAnimationStates();
        }
    }


    @Override
    protected void initGoals() {
        this.goalSelector.add(2, new MeleeAttackGoal(this, 1f, true) {
            @Override
            protected double getSquaredMaxAttackDistance(LivingEntity entity) {
                return 2;
            }
        });
        this.targetSelector.add(2, new RevengeGoal(this, new Class[0]).setGroupRevenge(ZombifiedPiglinEntity.class));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, LivingEntity.class, true,
                livingEntity -> !(livingEntity instanceof CannibalEntity) && !(livingEntity instanceof SotonaEntity)
                        && !(livingEntity instanceof NightwalkerEntity)&& !(livingEntity instanceof CreeperEntity)
                        && !(livingEntity instanceof BloodseekerEntity)));
    }

    @Override
    protected SoundEvent getFlopSound() {
        return SoundEvents.BLOCK_SLIME_BLOCK_BREAK;
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }

    }
    public static DefaultAttributeContainer.Builder createBloodseekerAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 2)
                .add(EntityAttributes.GENERIC_ARMOR, 4f)
                .add(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, 4f)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.4f)
                .add(EntityAttributes.GENERIC_FLYING_SPEED, 0.4f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 6)
                .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 12f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 1f)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 40);
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_SQUID_AMBIENT;
    }

    @Override
    public boolean onKilledOther(ServerWorld world, LivingEntity other) {
        ModEntities EntitiesRegistry = new ModEntities();
        var BloodseekerEntity = EntitiesRegistry.BLOODSEEKER.create(world);
        Entity entity = (Entity) other;
        world.spawnEntity(BloodseekerEntity);
        if (BloodseekerEntity != null) {
            BloodseekerEntity.refreshPositionAndAngles(this.getX(), this.getY(), this.getZ(), this.getYaw(), this.getPitch());
            BloodseekerEntity.initialize(world, world.getLocalDifficulty(entity.getBlockPos()), SpawnReason.CONVERSION, null, null);
            BloodseekerEntity.setAiDisabled(this.isAiDisabled());
        }
        return false;
    }

    @Override
    public ItemStack getBucketItem() {
        return null;
    }
}








