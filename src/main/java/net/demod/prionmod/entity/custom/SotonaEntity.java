package net.demod.prionmod.entity.custom;

import net.demod.prionmod.entity.ModEntities;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class SotonaEntity extends AnimalEntity {
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    public SotonaEntity(EntityType<? extends AnimalEntity> entityType, World world) {
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
                return 4;
            }
        });
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 1.6f, 10f));
        this.goalSelector.add(4, new LookAroundGoal(this));

        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, VillagerEntity.class, true));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, IronGolemEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, PigEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, HorseEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, CowEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, ChickenEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, SheepEntity.class, true));
    }
    public static DefaultAttributeContainer.Builder createSotonaAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH,33)
                .add(EntityAttributes.GENERIC_ARMOR,5f)
                .add(EntityAttributes.GENERIC_ARMOR_TOUGHNESS,5f)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE,0.1f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED,0.18f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE,6)
                .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK,5f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED,6f)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE,80);
    }
    @Override
    public boolean isBreedingItem(ItemStack stack){
        return stack.isOf(Items.ROTTEN_FLESH);
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.SOTONA.create(world);
    }
}
