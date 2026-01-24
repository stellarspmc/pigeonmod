package fun.spmc.pigeons.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import fun.spmc.pigeons.client.model.DiamondDoveModel;
import fun.spmc.pigeons.client.model.PigeonChildModel;
import fun.spmc.pigeons.client.model.PigeonModel;
import fun.spmc.pigeons.entity.DiamondDoveEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class DiamondDoveRenderer extends MobRenderer<DiamondDoveEntity, PigeonModel<DiamondDoveEntity>> {
    private final PigeonChildModel<DiamondDoveEntity> baby;

    private final DiamondDoveModel<DiamondDoveEntity> adult = (DiamondDoveModel<DiamondDoveEntity>) this.getModel();
    public DiamondDoveRenderer(EntityRendererProvider.Context context) {
        super(context, new DiamondDoveModel<>(context.bakeLayer(DiamondDoveModel.LAYER_LOCATION)), 0.3F);
        this.baby = new PigeonChildModel<>(context.bakeLayer(PigeonChildModel.LAYER_LOCATION));
    }

    @Override
    protected void scale(DiamondDoveEntity entity, @NotNull PoseStack poseStack, float f) {
        if (entity.isBaby()) poseStack.scale(.3f, .3f, .3f);
        else poseStack.scale(entity.getScale(), entity.getScale(), entity.getScale());
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull DiamondDoveEntity entity) {
        return entity.isBaby() ? ResourceLocation.parse("pigeons:textures/entities/pigeon_child_texture.png") : ResourceLocation.parse("pigeons:textures/entities/diamond_dove_texture.png");
    }

    @Override
    public void render(@NotNull DiamondDoveEntity entity, float p_115309_, float p_115310_, @NotNull PoseStack p_115311_, @NotNull MultiBufferSource p_115312_, int p_115313_) {
        if (entity.isBaby()) this.model = this.baby;
        else this.model = this.adult;
        super.render(entity, p_115309_, p_115310_, p_115311_, p_115312_, p_115313_);
    }
}
