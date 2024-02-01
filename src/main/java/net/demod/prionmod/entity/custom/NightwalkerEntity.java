package net.demod.prionmod.entity.custom;

import net.demod.prionmod.entity.ModEntities;
import net.demod.prionmod.sound.ModSounds;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.ZombifiedPiglinEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class NightwalkerEntity extends HostileEntity {
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public NightwalkerEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    private void setupAnimationStates(){
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }

    }
    @Override
    protected void updateLimbs(float posDelta) {
        float f = this.getPose() == EntityPose.STANDING ? Math.min(posDelta * 6.0f, 1.0f) : 0.0f;
        this.limbAnimator.updateLimbs(f, 0.2f);
    }
    @Override
    public void tick(){
        super.tick();
        if (this.getWorld().isClient()) {
            setupAnimationStates();
        }
    }
    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new MeleeAttackGoal(this, 1f, true){
            @Override
            protected double getSquaredMaxAttackDistance(LivingEntity entity) {
                return 2;
            }
        });
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 1f, 10f));
        this.goalSelector.add(4, new LookAroundGoal(this));
        this.targetSelector.add(2, new RevengeGoal(this, new Class[0]).setGroupRevenge(ZombifiedPiglinEntity.class));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, LivingEntity.class, true,
                livingEntity -> !(livingEntity instanceof CannibalEntity) && !(livingEntity instanceof SotonaEntity)
                        && !(livingEntity instanceof NightwalkerEntity)&& !(livingEntity instanceof CreeperEntity)
                        && !(livingEntity instanceof BloodseekerEntity)));
    }
    public static DefaultAttributeContainer.Builder createNightwalkerAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH,12)
                .add(EntityAttributes.GENERIC_ARMOR,6f)
                .add(EntityAttributes.GENERIC_ARMOR_TOUGHNESS,3f)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE,0f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED,0.35f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE,2)
                .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK,-1f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED,0.25f)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE,40);
    }
    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source){
        return SoundEvents.ENTITY_SPIDER_AMBIENT;
    }
    @Override
    public boolean onKilledOther(ServerWorld world, LivingEntity other) {
        ModEntities EntitiesRegistry = new ModEntities();
        var cannibalEntity = EntitiesRegistry.CANNIBAL.create(world);
        Entity entity = (Entity)other;
        world.spawnEntity(cannibalEntity);
        if (cannibalEntity != null) {
            cannibalEntity.refreshPositionAndAngles(this.getX(), this.getY(), this.getZ(), this.getYaw(), this.getPitch());
            cannibalEntity.initialize(world, world.getLocalDifficulty(entity.getBlockPos()), SpawnReason.CONVERSION, null, null);
            cannibalEntity.setAiDisabled(this.isAiDisabled());
        }
        return false;
    }

}
