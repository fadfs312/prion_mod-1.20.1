package net.demod.prionmod;

import net.demod.prionmod.entity.ModEntities;
import net.demod.prionmod.entity.custom.BloodseekerEntity;
import net.demod.prionmod.entity.custom.CannibalEntity;
import net.demod.prionmod.entity.custom.NightwalkerEntity;
import net.demod.prionmod.entity.custom.SotonaEntity;
import net.demod.prionmod.item.custom.ModItemGroups;
import net.demod.prionmod.item.custom.ModItems;
import net.demod.prionmod.sound.ModSounds;
import net.demod.prionmod.world.gen.ModEntityGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrionMod implements ModInitializer {
	public static final String MOD_ID = "prionmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
		FabricDefaultAttributeRegistry.register(ModEntities.SOTONA, SotonaEntity.createSotonaAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.CANNIBAL, CannibalEntity.createCannibalAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.NIGHTWALKER, NightwalkerEntity.createNightwalkerAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.BLOODSEEKER, BloodseekerEntity.createBloodseekerAttributes());
		ModItems.registerModItems();
		ModEntityGeneration.addSpawns();
		ModSounds.registerSounds();
		ModItemGroups.registerItemGroups();
	}
}