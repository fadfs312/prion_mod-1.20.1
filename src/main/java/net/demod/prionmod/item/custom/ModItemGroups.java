package net.demod.prionmod.item.custom;
import net.demod.prionmod.PrionMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;


public class ModItemGroups {
    public static final ItemGroup PRION_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(PrionMod.MOD_ID, "prion"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.prion"))
                    .icon(() -> new ItemStack(ModItems.MEAT)).entries((displayContext, entries) -> {
                        entries.add(ModItems.CANNIBAL_SPAWN_EGG);
                        entries.add(ModItems.BLOODSEEKER_SPAWN_EGG);
                        entries.add(ModItems.SOTONA_SPAWN_EGG);
                        entries.add(ModItems.NIGHTWALKER_SPAWN_EGG);
                        entries.add(ModItems.MEAT);
                    }).build());
    public static void registerItemGroups() {
        PrionMod.LOGGER.info("Registering Item Groups for " + PrionMod.MOD_ID);
    }
}