package fun.spmc.pigeons.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import fun.spmc.pigeons.client.model.anim.PigeonFlyingAnimation;
import fun.spmc.pigeons.client.model.anim.PigeonWalkingAnimation;
import fun.spmc.pigeons.entity.AbstractPigeonEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import org.jetbrains.annotations.NotNull;

public class PigeonModel<T extends Entity> extends EntityModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("pigeons", "model_pigeon"), "main");
    public final ModelPart root;
    public final ModelPart All;
    public final ModelPart RWing;
    public final ModelPart LWing;
    public final ModelPart RLeg;
    public final ModelPart LLeg;
    public final ModelPart HeadBeak;

    public PigeonModel(ModelPart root) {
        this.root = root;
        this.All = root.getChild("All");
        this.RWing = this.All.getChild("RWing");
        this.LWing = this.All.getChild("LWing");
        this.RLeg = this.All.getChild("RLeg");
        this.LLeg = this.All.getChild("LLeg");
        this.HeadBeak = this.All.getChild("HeadBeak");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition root = meshDefinition.getRoot();
        PartDefinition All = root.addOrReplaceChild("All", CubeListBuilder.create(), PartPose.offset(0.05F, 19.4054F, -1.7325F));
        All.addOrReplaceChild("Tail_r1", CubeListBuilder.create().texOffs(0, 18).addBox(-1.0F, -0.057F, -0.3895F, 2.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.9F, 4.0F, -0.4363F, 0.0F, 0.0F));
        All.addOrReplaceChild("Body_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -1.5F, -3.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.05F, 1.1173F, 1.0761F, -0.3927F, 0.0F, 0.0F));
        PartDefinition RWing = All.addOrReplaceChild("RWing", CubeListBuilder.create(), PartPose.offset(-1.5F, -1.0F, -0.7F));
        RWing.addOrReplaceChild("RWing_r1", CubeListBuilder.create().texOffs(0, 9).addBox(-0.5F, -0.1752F, -0.1002F, 1.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4F, 0.0F, 0.0F, -0.2182F, 0.0F, 0.0F));
        PartDefinition LWing = All.addOrReplaceChild("LWing", CubeListBuilder.create(), PartPose.offset(1.5F, -1.0F, -0.7F));
        LWing.addOrReplaceChild("LWing_r1", CubeListBuilder.create().texOffs(14, 9).addBox(-0.5F, -0.1752F, -0.1002F, 1.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4F, 0.0F, 0.0F, -0.2182F, 0.0F, 0.0F));
        PartDefinition RLeg = All.addOrReplaceChild("RLeg", CubeListBuilder.create().texOffs(18, 18).addBox(-0.5F, -1.05F, -0.05F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.9F, 2.65F, 1.35F));
        RLeg.addOrReplaceChild("RLeg1_r1", CubeListBuilder.create().texOffs(18, 7).addBox(-0.5F, -1.5F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.95F, -1.55F, -1.5708F, 0.0F, 0.0F));
        PartDefinition LLeg = All.addOrReplaceChild("LLeg", CubeListBuilder.create().texOffs(20, 18).addBox(-0.4F, -1.0F, 0.0F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.7F, 2.6F, 1.3F));
        LLeg.addOrReplaceChild("LLeg1_r1", CubeListBuilder.create().texOffs(18, 8).addBox(-0.5F, -1.5F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, 2.0F, -1.5F, -1.5708F, 0.0F, 0.0F));
        All.addOrReplaceChild("HeadBeak", CubeListBuilder.create().texOffs(18, 0).addBox(-1.05F, -4.6554F, -0.8675F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(12, 18).addBox(-0.6F, -4.15F, -1.8F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -1.4F));
        return LayerDefinition.create(meshDefinition, 32, 32);
    }

    @Override
    public void setupAnim(@NotNull Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.animator.setupAnim((T) entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
    }

    @Override
    public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int i, int i1, int i2) {
        this.All.render(poseStack, vertexConsumer, i, i1, i2);
    }

    private final HierarchicalModel<T> animator = new HierarchicalModel<>() {

        @Override
        public @NotNull ModelPart root() {
            return PigeonModel.this.root;
        }

        @Override
        public void setupAnim(@NotNull T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
            this.root().getAllParts().forEach(ModelPart::resetPose);
            this.animate(((AbstractPigeonEntity)entity).animationState0, PigeonFlyingAnimation.FLYING, ageInTicks, 1.0F);
            this.animateWalk(PigeonWalkingAnimation.WALKING, limbSwing, limbSwingAmount, 4.0F, 2.0F);
        }
    };
}
