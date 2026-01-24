package fun.spmc.pigeons.client.model;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class WesternCrownedPigeonModel<T extends Entity> extends PigeonModel<T>{
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("pigeons", "model_western_crowned_pigeon"), "main");

    public WesternCrownedPigeonModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition All = partdefinition.addOrReplaceChild("All", CubeListBuilder.create(), PartPose.offset(0.05F, 18.4054F, -1.7325F));
        All.addOrReplaceChild("Tail_r1", CubeListBuilder.create().texOffs(24, 26).addBox(-2.0F, -0.057F, 0.6105F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4F, -1.1F, 6.0F, -0.4363F, 0.0F, 0.0F));
        All.addOrReplaceChild("Body_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -4.5F, -3.0F, 5.0F, 6.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.05F, 0.1173F, 1.0761F, -0.1745F, 0.0F, 0.0F));
        PartDefinition RWing = All.addOrReplaceChild("RWing", CubeListBuilder.create(), PartPose.offset(-2.5F, -4.5F, -0.7F));
        RWing.addOrReplaceChild("RWing_r1", CubeListBuilder.create().texOffs(0, 15).addBox(-0.5F, -0.1752F, -0.1002F, 1.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4F, 0.0F, 0.0F, -0.2182F, 0.0F, 0.0F));
        PartDefinition LWing = All.addOrReplaceChild("LWing", CubeListBuilder.create(), PartPose.offset(2.5F, -4.6F, -0.7F));
        LWing.addOrReplaceChild("LWing_r1", CubeListBuilder.create().texOffs(16, 15).addBox(-0.5F, -0.1752F, -0.1002F, 1.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4F, 0.1F, 0.0F, -0.2182F, 0.0F, 0.0F));
        PartDefinition RLeg = All.addOrReplaceChild("RLeg", CubeListBuilder.create().texOffs(28, 4).addBox(-0.5F, -0.05F, -0.05F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.9F, 1.65F, 2.35F));
        RLeg.addOrReplaceChild("RLeg1_r1", CubeListBuilder.create().texOffs(28, 12).addBox(-0.5F, -1.5F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.95F, -1.55F, -1.5708F, 0.0F, 0.0F));
        PartDefinition LLeg = All.addOrReplaceChild("LLeg", CubeListBuilder.create().texOffs(28, 8).addBox(-0.4F, 0.0F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.7F, 1.6F, 2.3F));
        LLeg.addOrReplaceChild("LLeg1_r1", CubeListBuilder.create().texOffs(28, 13).addBox(-0.5F, -1.5F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, 4.0F, -1.5F, -1.5708F, 0.0F, 0.0F));
        All.addOrReplaceChild("HeadBeak", CubeListBuilder.create().texOffs(12, 26).addBox(-1.55F, -7.6554F, -1.8675F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(28, 0).addBox(-0.6F, -6.4F, -3.8F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 26).addBox(0.0F, -10.0F, -1.5F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, -0.4F));
        return LayerDefinition.create(meshdefinition, 64, 64);
    }
}
