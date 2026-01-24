package fun.spmc.pigeons.client.model;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class PigeonChildModel<T extends Entity> extends PigeonModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("pigeons", "model_pigeon_child"), "main");

    public PigeonChildModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition All = partdefinition.addOrReplaceChild("All", CubeListBuilder.create(), PartPose.offset(0.05F, 19.4054F, -1.7325F));
        All.addOrReplaceChild("Body_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -1.5F, -3.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.05F, 1.1173F, 1.0761F, -0.3927F, 0.0F, 0.0F));
        PartDefinition RWing = All.addOrReplaceChild("RWing", CubeListBuilder.create(), PartPose.offset(-1.5F, -1.0F, -0.7F));
        RWing.addOrReplaceChild("RWing_r1", CubeListBuilder.create().texOffs(8, 9).addBox(-0.5F, -0.1752F, -0.1002F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4F, 0.0F, 0.0F, -0.2182F, 0.0F, 0.0F));
        PartDefinition LWing = All.addOrReplaceChild("LWing", CubeListBuilder.create(), PartPose.offset(1.5F, -1.0F, -0.7F));
        LWing.addOrReplaceChild("LWing_r1", CubeListBuilder.create().texOffs(8, 13).addBox(-0.5F, -0.1752F, -0.1002F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4F, 0.0F, 0.0F, -0.2182F, 0.0F, 0.0F));
        PartDefinition RLeg = All.addOrReplaceChild("RLeg", CubeListBuilder.create().texOffs(6, 16).addBox(-0.5F, -1.05F, -0.05F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.9F, 2.65F, 1.35F));
        RLeg.addOrReplaceChild("RLeg1_r1", CubeListBuilder.create().texOffs(16, 12).addBox(-0.5F, -1.5F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.95F, -1.55F, -1.5708F, 0.0F, 0.0F));
        PartDefinition LLeg = All.addOrReplaceChild("LLeg", CubeListBuilder.create().texOffs(16, 9).addBox(-0.4F, -1.0F, 0.0F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.7F, 2.6F, 1.3F));
        LLeg.addOrReplaceChild("LLeg1_r1", CubeListBuilder.create().texOffs(16, 13).addBox(-0.5F, -1.5F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, 2.0F, -1.5F, -1.5708F, 0.0F, 0.0F));
        All.addOrReplaceChild("HeadBeak", CubeListBuilder.create().texOffs(0, 9).addBox(-1.05F, -4.6554F, -0.8675F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 16).addBox(-0.6F, -4.15F, -1.8F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -1.4F));
        return LayerDefinition.create(meshdefinition, 32, 32);
    }
}
