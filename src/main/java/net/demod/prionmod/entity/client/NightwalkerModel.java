package net.demod.prionmod.entity.client;

import net.demod.prionmod.entity.animation.ModAnimations;
import net.demod.prionmod.entity.custom.CannibalEntity;
import net.demod.prionmod.entity.custom.NightwalkerEntity;
import net.demod.prionmod.entity.custom.SotonaEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

// Made with Blockbench 4.9.3
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class NightwalkerModel<T extends NightwalkerEntity> extends SinglePartEntityModel<T> {
	private final ModelPart nightwalker;
	private final ModelPart head;

	public NightwalkerModel(ModelPart root) {
		this.nightwalker = root.getChild("nightwalker");
		this.head = nightwalker.getChild("torso").getChild("head");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData nightwalker = modelPartData.addChild("nightwalker", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 43.4F, -4.0F));

		ModelPartData torso = nightwalker.addChild("torso", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -27.0F, 3.0F));

		ModelPartData head = torso.addChild("head", ModelPartBuilder.create().uv(32, 26).cuboid(-3.0F, -4.0F, -5.7F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 10).cuboid(-2.0F, -5.0F, -5.0F, 4.0F, 6.0F, 5.0F, new Dilation(0.0F))
				.uv(32, 22).cuboid(1.0F, -4.3F, -6.1F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 31).cuboid(-2.7F, -1.0F, -6.0F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F))
				.uv(30, 15).cuboid(0.7F, -1.0F, -6.0F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 1.0F, -1.0F));

		ModelPartData cube_r1 = head.addChild("cube_r1", ModelPartBuilder.create().uv(32, 10).cuboid(-1.7F, 1.0F, -4.3F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.0F, -2.0F, 0.0F, 0.0F, 0.2443F));

		ModelPartData cube_r2 = head.addChild("cube_r2", ModelPartBuilder.create().uv(8, 32).cuboid(-0.3F, 1.0F, -4.3F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.0F, -2.0F, 0.0F, 0.0F, -0.2443F));

		ModelPartData body = torso.addChild("body", ModelPartBuilder.create().uv(14, 17).cuboid(-3.0F, -1.0F, -4.0F, 6.0F, 3.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 1.0F, 1.0F));

		ModelPartData cube_r3 = body.addChild("cube_r3", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -3.6F, 4.3F, 6.0F, 5.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 2.0F, -1.0F, 0.4189F, 0.0F, 0.0F));

		ModelPartData cube_r4 = body.addChild("cube_r4", ModelPartBuilder.create().uv(18, 10).cuboid(-2.0F, -4.0F, 1.3F, 4.0F, 4.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 2.0F, -1.0F, 0.1745F, 0.0F, 0.0F));

		ModelPartData legs = nightwalker.addChild("legs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -19.4F, 8.0F));

		ModelPartData thirdright = legs.addChild("thirdright", ModelPartBuilder.create(), ModelTransform.pivot(-3.8F, -7.0F, -4.0F));

		ModelPartData cube_r5 = thirdright.addChild("cube_r5", ModelPartBuilder.create().uv(24, 24).cuboid(-2.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.8F, 0.0F, 0.0F, 0.2443F, 0.4887F, 0.4887F));

		ModelPartData secondright = legs.addChild("secondright", ModelPartBuilder.create(), ModelTransform.pivot(-3.8F, -7.0F, -6.0F));

		ModelPartData cube_r6 = secondright.addChild("cube_r6", ModelPartBuilder.create().uv(0, 21).cuboid(-2.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.8F, 0.0F, 0.0F, 0.0F, 0.0F, 0.4887F));

		ModelPartData firstright = legs.addChild("firstright", ModelPartBuilder.create(), ModelTransform.pivot(-3.8F, -7.0F, -8.0F));

		ModelPartData cube_r7 = firstright.addChild("cube_r7", ModelPartBuilder.create().uv(8, 22).cuboid(-2.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.8F, 0.0F, 0.0F, -0.2647F, -0.4572F, 0.5506F));

		ModelPartData thirdleft = legs.addChild("thirdleft", ModelPartBuilder.create(), ModelTransform.pivot(3.8F, -7.0F, -4.0F));

		ModelPartData cube_r8 = thirdleft.addChild("cube_r8", ModelPartBuilder.create().uv(30, 0).cuboid(0.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-0.8F, 0.0F, 0.0F, 0.2443F, -0.4887F, -0.4887F));

		ModelPartData secondleft = legs.addChild("secondleft", ModelPartBuilder.create(), ModelTransform.pivot(3.8F, -7.0F, -6.0F));

		ModelPartData cube_r9 = secondleft.addChild("cube_r9", ModelPartBuilder.create().uv(16, 24).cuboid(0.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-0.8F, 0.0F, 0.0F, 0.0F, 0.0F, -0.4887F));

		ModelPartData firstleft = legs.addChild("firstleft", ModelPartBuilder.create(), ModelTransform.pivot(3.8F, -7.0F, -8.0F));

		ModelPartData cube_r10 = firstleft.addChild("cube_r10", ModelPartBuilder.create().uv(22, 0).cuboid(0.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-0.8F, 0.0F, 0.0F, -0.2647F, 0.4572F, -0.5506F));
		return TexturedModelData.of(modelData, 64, 64);
	}
	@Override
	public void setAngles(NightwalkerEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw, headPitch);

		this.animateMovement(ModAnimations.NIGHTWALKER_RUN, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, ModAnimations.NIGHTWALKER_IDLE, ageInTicks, 1f);
	}
	private void setHeadAngles(float headYaw, float headPitch){
		headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
		headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		nightwalker.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return nightwalker;
	}

	}
