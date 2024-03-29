package net.demod.prionmod.entity;

import net.demod.prionmod.PrionMod;
import net.demod.prionmod.entity.custom.BloodseekerEntity;
import net.demod.prionmod.entity.custom.CannibalEntity;
import net.demod.prionmod.entity.custom.NightwalkerEntity;
import net.demod.prionmod.entity.custom.SotonaEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<SotonaEntity> SOTONA= Registry.register(Registries.ENTITY_TYPE,
            new Identifier(PrionMod.MOD_ID,"sotona"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER,SotonaEntity::new).dimensions(EntityDimensions.fixed(0.8f,1.84f)).build());
    public static final EntityType<CannibalEntity> CANNIBAL= Registry.register(Registries.ENTITY_TYPE,
            new Identifier(PrionMod.MOD_ID,"cannibal"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, CannibalEntity::new).dimensions(EntityDimensions.fixed(0.8f,1.97f)).build());
    public static final EntityType<NightwalkerEntity> NIGHTWALKER= Registry.register(Registries.ENTITY_TYPE,
            new Identifier(PrionMod.MOD_ID,"nightwalker"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, NightwalkerEntity::new).dimensions(EntityDimensions.fixed(1f,0.9f)).build());
    public static final EntityType<BloodseekerEntity> BLOODSEEKER= Registry.register(Registries.ENTITY_TYPE,
            new Identifier(PrionMod.MOD_ID,"bloodseeker"),
            FabricEntityTypeBuilder.create(SpawnGroup.WATER_CREATURE, BloodseekerEntity::new).dimensions(EntityDimensions.fixed(1f,0.9f)).build());
}
