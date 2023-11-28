package net.demod.prionmod.entity.client;

import net.demod.prionmod.PrionMod;
import net.demod.prionmod.entity.custom.SotonaEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class SotonaRenderer extends MobEntityRenderer<SotonaEntity,SotonaModel<SotonaEntity>> {
    private static final Identifier TEXTURE = new Identifier(PrionMod.MOD_ID,"textures/entity/sotona.png");
    public SotonaRenderer(EntityRendererFactory.Context context) {
        super(context,new SotonaModel<>(context.getPart(ModModelLayers.SOTONA)),0.8f );
    }

    @Override
    public Identifier getTexture(SotonaEntity entity) {
        return null;
    }
}
