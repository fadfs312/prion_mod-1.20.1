package net.demod.prionmod.entity.client;

import net.demod.prionmod.entity.custom.CannibalEntity;
import net.demod.prionmod.entity.custom.SotonaEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class CannibalModel<T extends CannibalEntity> extends SinglePartEntityModel<T> {
	private final ModelPart cannibal;
	private final ModelPart head;
	public CannibalModel(ModelPart root) {
		this.cannibal = root.getChild("cannibal");
		this.head=cannibal.getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData cannibal = modelPartData.addChild("cannibal", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData rightleg = cannibal.addChild("rightleg", ModelPartBuilder.create().uv(16, 32).cuboid(-4.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -12.0F, 0.0F));

		ModelPartData rightknee = rightleg.addChild("rightknee", ModelPartBuilder.create().uv(32, 32).cuboid(-4.0F, -6.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 12.0F, 0.0F));

		ModelPartData head = cannibal.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -24.0F, 0.0F));

		ModelPartData leftleg = cannibal.addChild("leftleg", ModelPartBuilder.create().uv(32, 0).cuboid(0.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -12.0F, 0.0F));

		ModelPartData leftknee = leftleg.addChild("leftknee", ModelPartBuilder.create().uv(36, 10).cuboid(0.0F, -6.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 12.0F, 0.0F));

		ModelPartData uppperbody = cannibal.addChild("uppperbody", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData torso = uppperbody.addChild("torso", ModelPartBuilder.create().uv(0, 16).cuboid(-4.0F, -24.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData lefthand = uppperbody.addChild("lefthand", ModelPartBuilder.create().uv(24, 16).cuboid(0.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(4.0F, -24.0F, 0.0F));

		ModelPartData righthand = uppperbody.addChild("righthand", ModelPartBuilder.create().uv(0, 32).cuboid(-4.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, -24.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public ModelPart getPart() {
		return cannibal;
	}

	@Override
	public void setAngles(T CannibalEntity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {


	}
}
