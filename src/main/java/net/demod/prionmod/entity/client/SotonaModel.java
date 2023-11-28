import net.demod.prionmod.entity.custom.SotonaEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class SotonaModel<T extends SotonaEntity> extends SinglePartEntityModel<T>{
	private final ModelPart sotona;
	private final ModelPart head;
	public SotonaModel(ModelPart root) {
		this.sotona = root.getChild("sotona");
		this.head=sotona.getChild("upper").getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData sotona = modelPartData.addChild("sotona", ModelPartBuilder.create(), ModelTransform.of(0.0F, 7.0F, 1.6F, 0.0F, 3.1416F, 0.0F));

		ModelPartData upper = sotona.addChild("upper", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 4.0F, 0.0F));

		ModelPartData head = upper.addChild("head", ModelPartBuilder.create().uv(18, 44).cuboid(-4.0F, -4.2F, -2.1F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(27, 44).cuboid(1.0F, -4.2F, -2.1F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -12.7F, 8.6F, -0.3491F, 0.0F, 0.0F));

		ModelPartData cube_r1 = head.addChild("cube_r1", ModelPartBuilder.create().uv(0, 51).cuboid(-2.3F, 0.2F, 1.0F, 1.3F, 0.1F, 1.5F, new Dilation(0.0F))
		.uv(38, 57).cuboid(-2.5133F, -0.8248F, 2.4927F, 0.5F, 1.0F, 0.4F, new Dilation(0.0F))
		.uv(0, 57).cuboid(-2.6F, 0.1F, 0.9F, 0.1F, 0.1F, 1.7F, new Dilation(0.0F))
		.uv(38, 59).cuboid(-2.3F, 0.1F, 0.5F, 0.3F, 0.1F, 0.3F, new Dilation(0.0F))
		.uv(30, 47).cuboid(-2.5F, 0.1F, 0.5F, 0.5F, 0.1F, 2.2F, new Dilation(0.0F))
		.uv(0, 54).cuboid(-1.7F, -1.0F, 1.0F, 0.7F, 0.1F, 1.5F, new Dilation(0.0F))
		.uv(37, 47).cuboid(-2.0F, -1.0F, 2.5F, 1.0F, 1.2F, 1.5F, new Dilation(0.0F))
		.uv(29, 51).cuboid(-2.0F, -1.0F, 0.0F, 1.0F, 1.3F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.2F, -1.2F, -1.023F, -0.1494F, -0.0906F));

		ModelPartData cube_r2 = head.addChild("cube_r2", ModelPartBuilder.create().uv(21, 57).cuboid(-1.8F, -1.0F, 1.0F, 0.6F, 0.1F, 0.8F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.2F, -1.2F, -1.0819F, -0.2973F, 0.1735F));

		ModelPartData cube_r3 = head.addChild("cube_r3", ModelPartBuilder.create().uv(23, 47).cuboid(2.0F, 0.1F, 0.5F, 0.5F, 0.1F, 2.2F, new Dilation(0.0F))
		.uv(39, 57).cuboid(2.0F, 0.1F, 0.5F, 0.3F, 0.1F, 0.3F, new Dilation(0.0F))
		.uv(42, 54).cuboid(2.5F, 0.1F, 0.9F, 0.1F, 0.1F, 1.7F, new Dilation(0.0F))
		.uv(44, 47).cuboid(1.0F, -1.0F, 2.5F, 1.0F, 1.2F, 1.5F, new Dilation(0.0F))
		.uv(37, 57).cuboid(2.0133F, -0.8248F, 2.4927F, 0.5F, 1.0F, 0.4F, new Dilation(0.0F))
		.uv(7, 51).cuboid(1.0F, 0.2F, 1.0F, 1.3F, 0.1F, 1.5F, new Dilation(0.0F))
		.uv(39, 51).cuboid(1.0F, -1.0F, 1.0F, 0.7F, 0.1F, 1.5F, new Dilation(0.0F))
		.uv(24, 51).cuboid(1.0F, -1.0F, 0.0F, 1.0F, 1.3F, 1.0F, new Dilation(0.0F))
		.uv(0, 11).cuboid(-0.2F, -1.0F, 0.0F, 1.2F, 1.3F, 9.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.2F, -1.2F, -1.023F, 0.1494F, 0.0906F));

		ModelPartData cube_r4 = head.addChild("cube_r4", ModelPartBuilder.create().uv(31, 57).cuboid(3.3962F, -0.8248F, 0.1581F, 0.4F, 1.0F, 0.6F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.2F, -1.2F, -1.0717F, -0.2788F, 0.7974F));

		ModelPartData cube_r5 = head.addChild("cube_r5", ModelPartBuilder.create().uv(34, 57).cuboid(-3.7962F, -0.8248F, 0.1581F, 0.4F, 1.0F, 0.6F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.2F, -1.2F, -1.0717F, 0.2788F, -0.7974F));

		ModelPartData cube_r6 = head.addChild("cube_r6", ModelPartBuilder.create().uv(15, 57).cuboid(-1.8F, -0.9F, 1.0F, 0.4F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.2F, -1.2F, -1.113F, -0.3451F, 0.2718F));

		ModelPartData cube_r7 = head.addChild("cube_r7", ModelPartBuilder.create().uv(16, 47).cuboid(0.6637F, -1.0441F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(5, 57).cuboid(2.6637F, -0.9441F, -0.4F, 1.0F, 0.8F, 0.8F, new Dilation(0.0F)), ModelTransform.of(6.4F, -7.5F, -1.6F, 0.0F, 0.0F, -0.3403F));

		ModelPartData cube_r8 = head.addChild("cube_r8", ModelPartBuilder.create().uv(17, 54).cuboid(0.1637F, -0.4441F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(6.4F, -7.5F, -1.6F, 0.0F, 0.0F, -0.9687F));

		ModelPartData cube_r9 = head.addChild("cube_r9", ModelPartBuilder.create().uv(9, 44).cuboid(0.0925F, -0.9934F, -0.5F, 3.2F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(6.4F, -4.5F, -1.6F, 0.0F, 0.0F, -1.3526F));

		ModelPartData cube_r10 = head.addChild("cube_r10", ModelPartBuilder.create().uv(32, 54).cuboid(-0.0167F, -0.945F, -0.5F, 0.9F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(5.8F, -4.0F, -1.6F, 0.0F, 0.0F, -0.829F));

		ModelPartData cube_r11 = head.addChild("cube_r11", ModelPartBuilder.create().uv(27, 54).cuboid(-0.0196F, -1.0212F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(5.0F, -3.4F, -1.6F, 0.0F, 0.0F, -0.5672F));

		ModelPartData cube_r12 = head.addChild("cube_r12", ModelPartBuilder.create().uv(34, 51).cuboid(0.0F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, -3.2F, -1.6F, 0.0F, 0.0F, -0.2182F));

		ModelPartData cube_r13 = head.addChild("cube_r13", ModelPartBuilder.create().uv(10, 57).cuboid(-3.6637F, -0.9441F, -0.4F, 1.0F, 0.8F, 0.8F, new Dilation(0.0F))
		.uv(9, 47).cuboid(-2.6637F, -1.0441F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-6.4F, -7.5F, -1.6F, 0.0F, 0.0F, 0.3403F));

		ModelPartData cube_r14 = head.addChild("cube_r14", ModelPartBuilder.create().uv(22, 54).cuboid(-1.1637F, -0.4441F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-6.4F, -7.5F, -1.6F, 0.0F, 0.0F, 0.9687F));

		ModelPartData cube_r15 = head.addChild("cube_r15", ModelPartBuilder.create().uv(0, 44).cuboid(-3.2925F, -0.9934F, -0.5F, 3.2F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-6.4F, -4.5F, -1.6F, 0.0F, 0.0F, 1.3526F));

		ModelPartData cube_r16 = head.addChild("cube_r16", ModelPartBuilder.create().uv(37, 54).cuboid(-0.8833F, -0.945F, -0.5F, 0.9F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-5.8F, -4.0F, -1.6F, 0.0F, 0.0F, 0.829F));

		ModelPartData cube_r17 = head.addChild("cube_r17", ModelPartBuilder.create().uv(12, 54).cuboid(-0.9804F, -1.0212F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-5.0F, -3.4F, -1.6F, 0.0F, 0.0F, 0.5672F));

		ModelPartData cube_r18 = head.addChild("cube_r18", ModelPartBuilder.create().uv(7, 54).cuboid(-1.0F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, -3.2F, -1.6F, 0.0F, 0.0F, 0.2182F));

		ModelPartData cube_r19 = head.addChild("cube_r19", ModelPartBuilder.create().uv(18, 57).cuboid(1.4F, -0.9F, 1.0F, 0.4F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.2F, -1.2F, -1.113F, 0.3451F, -0.2718F));

		ModelPartData cube_r20 = head.addChild("cube_r20", ModelPartBuilder.create().uv(26, 57).cuboid(1.2F, -1.0F, 1.0F, 0.6F, 0.1F, 0.8F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.2F, -1.2F, -1.0819F, 0.2973F, -0.1735F));

		ModelPartData cube_r21 = head.addChild("cube_r21", ModelPartBuilder.create().uv(27, 0).cuboid(-1.0F, -1.0F, 0.0F, 1.2F, 1.3F, 9.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.2F, -1.2F, -1.023F, -0.1494F, -0.0906F));

		ModelPartData cube_r22 = head.addChild("cube_r22", ModelPartBuilder.create().uv(36, 44).cuboid(-0.2F, -1.0F, 0.0F, 2.6F, 1.3F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.6F, -1.7F, -0.708F, 0.1142F, 0.1323F));

		ModelPartData cube_r23 = head.addChild("cube_r23", ModelPartBuilder.create().uv(14, 51).cuboid(-1.0F, -1.0F, 0.0F, 1.2F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.4F, -2.1F, 0.0F, 0.0F, -0.1745F));

		ModelPartData cube_r24 = head.addChild("cube_r24", ModelPartBuilder.create().uv(19, 51).cuboid(-0.2F, -1.0F, 0.0F, 1.2F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.4F, -2.1F, 0.0F, 0.0F, 0.1745F));

		ModelPartData cube_r25 = head.addChild("cube_r25", ModelPartBuilder.create().uv(0, 47).cuboid(-2.4F, -1.0F, 0.0F, 2.6F, 1.3F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.6F, -1.7F, -0.708F, -0.1142F, -0.1323F));

		ModelPartData chest = upper.addChild("chest", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, -1.0F));

		ModelPartData cube_r26 = chest.addChild("cube_r26", ModelPartBuilder.create().uv(26, 33).cuboid(-1.5F, -2.8F, -0.1F, 3.0F, 2.8F, 2.3F, new Dilation(0.0F)), ModelTransform.of(0.0F, -11.0F, 7.0F, -0.6545F, 0.0F, 0.0F));

		ModelPartData cube_r27 = chest.addChild("cube_r27", ModelPartBuilder.create().uv(0, 0).cuboid(-5.0F, -13.8F, -0.2F, 10.0F, 4.0F, 3.0F, new Dilation(0.0F))
		.uv(21, 11).cuboid(-4.0F, -9.8F, -0.2F, 8.0F, 4.0F, 3.0F, new Dilation(0.0F))
		.uv(0, 22).cuboid(-3.0F, -5.8F, 0.0F, 6.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -1.0F, -0.6109F, 0.0F, 0.0F));

		ModelPartData tentacle = chest.addChild("tentacle", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -6.0F, 7.0F));

		ModelPartData cube_r28 = tentacle.addChild("cube_r28", ModelPartBuilder.create().uv(58, 60).cuboid(-7.3F, -18.4F, -7.5F, 0.4F, 0.4F, 3.0F, new Dilation(0.0F))
		.uv(57, 59).cuboid(-8.6F, -19.4F, -6.8F, 0.4F, 0.4F, 4.0F, new Dilation(0.0F))
		.uv(58, 60).cuboid(-9.2F, -17.9F, -6.8F, 0.3F, 0.3F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 19.0F, -9.6F, -0.7272F, 0.2549F, 0.335F));

		ModelPartData lower = sotona.addChild("lower", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData leftleg = lower.addChild("leftleg", ModelPartBuilder.create().uv(17, 22).cuboid(0.0145F, 0.043F, -0.998F, 3.0F, 7.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(1.1F, 3.6F, -0.8F, 0.3491F, 0.0F, -0.0436F));

		ModelPartData leftknee = leftleg.addChild("leftknee", ModelPartBuilder.create().uv(0, 33).cuboid(-1.0F, 1.0F, 0.0F, 3.0F, 7.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(1.0145F, 5.443F, -0.298F, -0.4363F, 0.0F, 0.0F));

		ModelPartData rightleg = lower.addChild("rightleg", ModelPartBuilder.create().uv(30, 22).cuboid(-3.014F, 0.2747F, -0.9975F, 3.0F, 7.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 3.6F, -1.0F, 0.3491F, 0.0F, 0.0436F));

		ModelPartData rightknee = rightleg.addChild("rightknee", ModelPartBuilder.create().uv(13, 33).cuboid(-2.0131F, 0.7028F, 1.0609F, 3.0F, 7.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-1.001F, 5.3564F, -1.2F, -0.48F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}
	@Override
	public void setAngles(SotonaEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		sotona.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return null;
	}
}