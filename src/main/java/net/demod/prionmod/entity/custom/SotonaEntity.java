package net.demod.prionmod.entity.custom;

import net.demod.prionmod.entity.ModEntities;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class SotonaEntity extends HostileEntity {
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public SotonaEntity(EntityType<? extends HostileEntity> entityType, World world) {
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
        this.goalSelector.add(2, new MeleeAttackGoal(this, 2.3, true){
            @Override
            protected double getSquaredMaxAttackDistance(LivingEntity entity) {
                return 3;
            }
        });
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 1.6f, 10f));
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 1.6f, 10f));
        this.goalSelector.add(4, new LookAroundGoal(this));

        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, VillagerEntity.class, true));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, IronGolemEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, PigEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, HorseEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, DonkeyEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, CowEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, ChickenEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, SheepEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, EndermanEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, ZombieEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, SkeletonEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, SpiderEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, HuskEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, DrownedEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, WitchEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, MerchantEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, ZombieVillagerEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, StrayEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, EvokerEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, PillagerEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, VindicatorEntity.class, true));
    }
    public static DefaultAttributeContainer.Builder createSotonaAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH,26)
                .add(EntityAttributes.GENERIC_ARMOR,5f)
                .add(EntityAttributes.GENERIC_ARMOR_TOUGHNESS,5f)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE,0.1f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED,0.18f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE,6)
                .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK,2f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED,0.25f)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE,40);
    }
    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source){
        return SoundEvents.ENTITY_HORSE_DEATH;
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
