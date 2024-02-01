package net.demod.prionmod.entity.client;

import net.demod.prionmod.PrionMod;
import net.demod.prionmod.entity.custom.CannibalEntity;
import net.demod.prionmod.entity.custom.NightwalkerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class NightwalkerRenderer extends MobEntityRenderer<NightwalkerEntity,NightwalkerModel<NightwalkerEntity>> {
    private static final Identifier TEXTURE = new Identifier(PrionMod.MOD_ID,"textures/entity/nightwalker.png");
    public NightwalkerRenderer(EntityRendererFactory.Context context) {
        super(context,new NightwalkerModel<>(context.getPart(ModModelLayers.NIGHTWALKER)),0.5f );
    }

    @Override
    public Identifier getTexture(NightwalkerEntity entity) {
        return TEXTURE;
    }
    @Override
    public void render(NightwalkerEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if (mobEntity.isBaby()) {
            matrixStack.scale(0.85f, 0.85f, 0.85f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

}
