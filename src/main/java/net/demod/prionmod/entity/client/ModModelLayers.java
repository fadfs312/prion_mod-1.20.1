package net.demod.prionmod.entity.client;

import net.demod.prionmod.PrionMod;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer SOTONA =
            new EntityModelLayer(new Identifier(PrionMod.MOD_ID,"sotona"),"main");

    public static final EntityModelLayer CANNIBAL =
            new EntityModelLayer(new Identifier(PrionMod.MOD_ID,"cannibal"),"main");
}
