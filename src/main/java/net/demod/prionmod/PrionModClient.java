package net.demod.prionmod;

import net.demod.prionmod.entity.ModEntities;
import net.demod.prionmod.entity.client.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class PrionModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.SOTONA, SotonaModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.SOTONA, SotonaRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.CANNIBAL, CannibalModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.CANNIBAL, CannibalRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.NIGHTWALKER, NightwalkerModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.NIGHTWALKER, NightwalkerRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.BLOODSEEKER, BloodseekerModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.BLOODSEEKER, BloodseekerRenderer::new);
    }
}
