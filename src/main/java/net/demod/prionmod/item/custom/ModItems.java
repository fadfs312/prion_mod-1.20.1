package net.demod.prionmod.item.custom;


import net.demod.prionmod.PrionMod;
import net.demod.prionmod.entity.ModEntities;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item SOTONA_SPAWN_EGG = registerItem("sotona_spawn_egg",
        new SpawnEggItem(ModEntities.SOTONA, 0xffffff, 0xffffff, new FabricItemSettings()));


    private static void addItemsToSpawnEggsItemGroup(FabricItemGroupEntries entries) {

    }
    public static final Item MEAT = registerItem("meat", new Item(new FabricItemSettings().food(ModFoodComponents.MEAT)));

    public static final Item CANNIBAL_SPAWN_EGG = registerItem("cannibal_spawn_egg",
            new SpawnEggItem(ModEntities.CANNIBAL, 0xffffff, 0xffffff, new FabricItemSettings()));
    public static final Item NIGHTWALKER_SPAWN_EGG = registerItem("nightwalker_spawn_egg",
            new SpawnEggItem(ModEntities.NIGHTWALKER, 0xffffff, 0xffffff, new FabricItemSettings()));
    public static final Item BLOODSEEKER_SPAWN_EGG = registerItem("bloodseeker_spawn_egg",
            new SpawnEggItem(ModEntities.BLOODSEEKER, 0xffffff, 0xffffff, new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(PrionMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        PrionMod.LOGGER.info("Registering Mod Items for " + PrionMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(ModItems::addItemsToSpawnEggsItemGroup);
    }
}