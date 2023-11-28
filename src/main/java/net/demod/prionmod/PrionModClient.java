package net.demod.prionmod;

import net.demod.prionmod.entity.client.ModModelLayers;
import net.demod.prionmod.entity.client.SotonaModel;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;

public class PrionModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.SOTONA, SotonaModel::getTexturedModelData);

    }
}
