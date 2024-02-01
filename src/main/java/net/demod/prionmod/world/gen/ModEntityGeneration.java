package net.demod.prionmod.world.gen;


import net.demod.prionmod.entity.ModEntities;
import net.demod.prionmod.entity.custom.SotonaEntity;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;

public class ModEntityGeneration {
    public static void addSpawns() {
        BiomeModifications.addSpawn(BiomeSelectors.all(), SpawnGroup.MONSTER,
                ModEntities.SOTONA, 22, 1, 1);
        SpawnRestriction.register(ModEntities.SOTONA,SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,HostileEntity::canSpawnIgnoreLightLevel);

        BiomeModifications.addSpawn(BiomeSelectors.all(), SpawnGroup.MONSTER,
                ModEntities.NIGHTWALKER, 100, 3, 3);
        SpawnRestriction.register(ModEntities.NIGHTWALKER,SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,HostileEntity::canSpawnIgnoreLightLevel);

        BiomeModifications.addSpawn(BiomeSelectors.all(), SpawnGroup.MONSTER,
                ModEntities.CANNIBAL, 70, 1, 3);
        SpawnRestriction.register(ModEntities.CANNIBAL,SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,HostileEntity::canSpawnIgnoreLightLevel);

        BiomeModifications.addSpawn(BiomeSelectors.all(), SpawnGroup.WATER_CREATURE,
                ModEntities.BLOODSEEKER, 33, 1, 1);
        SpawnRestriction.register(ModEntities.BLOODSEEKER,SpawnRestriction.Location.IN_WATER,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,FishEntity::canSpawn);
    }
}