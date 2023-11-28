package net.demod.prionmod;

import net.demod.prionmod.entity.ModEntities;
import net.demod.prionmod.entity.client.ModModelLayers;
import net.demod.prionmod.entity.client.SotonaModel;
import net.demod.prionmod.entity.client.SotonaRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class PrionModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.SOTONA, SotonaModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.SOTONA, SotonaRenderer::new);
    }
}
