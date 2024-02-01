package net.demod.prionmod.entity.client;

import net.demod.prionmod.entity.animation.ModAnimations;
import net.demod.prionmod.entity.custom.BloodseekerEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

// Made with Blockbench 4.9.3
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class BloodseekerModel<T extends BloodseekerEntity> extends SinglePartEntityModel<T> {
	private final ModelPart bloodseeker;
	private final ModelPart head;
	public BloodseekerModel(ModelPart root) {
		this.bloodseeker = root.getChild("bloodseeker");
		this.head=bloodseeker.getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bloodseeker = modelPartData.addChild("bloodseeker", ModelPartBuilder.create(), ModelTransform.of(0.0F, 24.0F, -2.0F, 0.0F, 3.1416F, 0.0F));

		ModelPartData head = bloodseeker.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData wingleft = bloodseeker.addChild("wingleft", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData wingright = bloodseeker.addChild("wingright", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData tentacles = bloodseeker.addChild("tentacles", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r1 = tentacles.addChild("cube_r1", ModelPartBuilder.create().uv(18, 10).cuboid(-1.1F, -2.5F, -2.0F, 0.0F, 0.0F, 6.0F, new Dilation(-0.05F))
				.uv(-3, 25).cuboid(-1.1F, -3.2F, -2.8F, 0.0F, 0.0F, 5.0F, new Dilation(-0.05F))
				.uv(29, 23).cuboid(-0.9F, -2.2F, -2.1F, 0.0F, 0.0F, 5.0F, new Dilation(-0.05F))
				.uv(-3, -5).cuboid(-1.1F, -3.5F, -2.5F, 0.0F, 0.0F, 7.0F, new Dilation(-0.05F))
				.uv(18, 17).cuboid(-0.9F, -2.8F, -2.3F, 0.0F, 0.0F, 6.0F, new Dilation(-0.05F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -0.1047F, 0.0F));

		ModelPartData cube_r2 = tentacles.addChild("cube_r2", ModelPartBuilder.create().uv(12, -5).cuboid(-0.9F, -2.9F, -2.9F, 0.0F, 0.0F, 5.0F, new Dilation(-0.05F))
				.uv(-3, 17).cuboid(0.9F, -3.0F, -2.1F, 0.0F, 0.0F, 6.0F, new Dilation(-0.05F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0175F, 0.0F));

		ModelPartData cube_r3 = tentacles.addChild("cube_r3", ModelPartBuilder.create().uv(-3, 10).cuboid(0.4F, -4.0F, -2.3F, 0.0F, 0.0F, 6.0F, new Dilation(-0.05F)), ModelTransform.of(0.2F, 0.0F, 0.0F, 0.0873F, 0.1047F, 0.0F));

		ModelPartData cube_r4 = tentacles.addChild("cube_r4", ModelPartBuilder.create().uv(-3, 3).cuboid(0.3F, -2.0F, -2.3F, 0.0F, 0.0F, 6.0F, new Dilation(-0.05F)), ModelTransform.of(0.2F, 0.0F, 0.0F, -0.0524F, 0.0349F, 0.0F));

		ModelPartData cube_r5 = tentacles.addChild("cube_r5", ModelPartBuilder.create().uv(5, -5).cuboid(-0.6F, -2.0F, -2.3F, 0.0F, 0.0F, 6.0F, new Dilation(-0.05F)), ModelTransform.of(0.2F, 0.0F, 0.0F, -0.1047F, 0.0349F, 0.0F));

		ModelPartData cube_r6 = tentacles.addChild("cube_r6", ModelPartBuilder.create().uv(4, 4).cuboid(0.0F, -2.3F, -2.3F, 0.0F, 0.0F, 6.0F, new Dilation(-0.05F))
				.uv(11, 2).cuboid(-0.4F, -2.2F, -2.3F, 0.0F, 0.0F, 6.0F, new Dilation(-0.05F))
				.uv(11, 9).cuboid(-0.4F, -3.9F, -2.3F, 0.0F, 0.0F, 6.0F, new Dilation(-0.05F)), ModelTransform.of(0.2F, 0.0F, 0.0F, 0.0F, 0.0349F, 0.0F));

		ModelPartData cube_r7 = tentacles.addChild("cube_r7", ModelPartBuilder.create().uv(18, -5).cuboid(0.2F, -4.0F, -2.3F, 0.0F, 0.0F, 6.0F, new Dilation(-0.05F))
				.uv(18, 3).cuboid(0.9F, -3.8F, -2.3F, 0.0F, 0.0F, 6.0F, new Dilation(-0.05F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0873F, 0.1047F, 0.0F));

		ModelPartData cube_r8 = tentacles.addChild("cube_r8", ModelPartBuilder.create().uv(4, 11).cuboid(-0.5F, -3.9F, -2.3F, 0.0F, 0.0F, 6.0F, new Dilation(-0.05F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.1745F, -0.1047F, 0.0F));

		ModelPartData cube_r9 = tentacles.addChild("cube_r9", ModelPartBuilder.create().uv(11, 16).cuboid(-0.9F, -3.8F, -2.3F, 0.0F, 0.0F, 6.0F, new Dilation(-0.05F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.1222F, -0.1571F, 0.0F));

		ModelPartData cube_r10 = tentacles.addChild("cube_r10", ModelPartBuilder.create().uv(23, 26).cuboid(0.9F, -2.6F, -2.6F, 0.0F, 0.0F, 5.0F, new Dilation(-0.05F))
				.uv(25, 17).cuboid(1.1F, -3.2F, -2.1F, 0.0F, 0.0F, 5.0F, new Dilation(-0.05F))
				.uv(25, 10).cuboid(0.9F, -3.3F, -2.6F, 0.0F, 0.0F, 5.0F, new Dilation(-0.05F))
				.uv(31, 8).cuboid(1.1F, -2.5F, -2.1F, 0.0F, 0.0F, 5.0F, new Dilation(-0.05F))
				.uv(31, 14).cuboid(0.9F, -2.2F, -2.1F, 0.0F, 0.0F, 5.0F, new Dilation(-0.05F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.1047F, 0.0F));

		ModelPartData body = bloodseeker.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r11 = body.addChild("cube_r11", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -3.4F, -3.6F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(0, 3).cuboid(-0.5F, -3.5F, -2.1F, 1.0F, 1.0F, 1.0F, new Dilation(0.2F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));

		ModelPartData cube_r12 = body.addChild("cube_r12", ModelPartBuilder.create().uv(9, 28).cuboid(-1.3F, -1.0F, -2.8F, 1.0F, 2.0F, 4.0F, new Dilation(-0.2F)), ModelTransform.of(0.0F, -3.0F, -5.0F, 0.0F, 0.384F, 0.0F));

		ModelPartData cube_r13 = body.addChild("cube_r13", ModelPartBuilder.create().uv(28, 0).cuboid(-1.0F, -1.3F, -2.8F, 2.0F, 1.0F, 4.0F, new Dilation(-0.2F)), ModelTransform.of(0.0F, -3.0F, -5.0F, -0.384F, 0.0F, 0.0F));

		ModelPartData cube_r14 = body.addChild("cube_r14", ModelPartBuilder.create().uv(28, 7).cuboid(-1.0F, 0.3F, -2.8F, 2.0F, 1.0F, 4.0F, new Dilation(-0.2F)), ModelTransform.of(0.0F, -3.0F, -5.0F, 0.384F, 0.0F, 0.0F));

		ModelPartData cube_r15 = body.addChild("cube_r15", ModelPartBuilder.create().uv(20, 29).cuboid(0.3F, -1.0F, -2.8F, 1.0F, 2.0F, 4.0F, new Dilation(-0.2F)), ModelTransform.of(0.0F, -3.0F, -5.0F, 0.0F, -0.384F, 0.0F));

		ModelPartData cube_r16 = body.addChild("cube_r16", ModelPartBuilder.create().uv(34, 34).cuboid(-1.0F, -2.0F, -5.0F, 2.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}
	@Override
	public void setAngles(BloodseekerEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw, headPitch);

		this.animateMovement(ModAnimations.FLYING, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, ModAnimations.IDLE, ageInTicks, 1f);
	}
	private void setHeadAngles(float headYaw, float headPitch){
		headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
		headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		bloodseeker.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return bloodseeker;
	}
}