package net.demod.prionmod.world.gen;


import net.demod.prionmod.entity.ModEntities;
import net.demod.prionmod.entity.custom.SotonaEntity;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;

public class ModEntityGeneration {
    public static void addSpawns() {
        BiomeModifications.addSpawn(BiomeSelectors.all(), SpawnGroup.MONSTER,
                ModEntities.SOTONA, 36, 1, 1);
        SpawnRestriction.register(ModEntities.SOTONA,SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,HostileEntity::canSpawnInDark);

        BiomeModifications.addSpawn(BiomeSelectors.all(), SpawnGroup.MONSTER,
                ModEntities.CANNIBAL, 100, 1, 6);
        SpawnRestriction.register(ModEntities.CANNIBAL,SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,HostileEntity::canSpawnInDark);
    }
}