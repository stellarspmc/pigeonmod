package fun.spmc.pigeons.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import fun.spmc.pigeons.client.model.PigeonChildModel;
import fun.spmc.pigeons.client.model.PigeonModel;
import fun.spmc.pigeons.entity.PigeonEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class PigeonRenderer extends MobRenderer<PigeonEntity, PigeonModel<PigeonEntity>> {
    private final PigeonChildModel<PigeonEntity> baby;

    private final PigeonModel<PigeonEntity> adult = this.getModel();
    public PigeonRenderer(EntityRendererProvider.Context context) {
        super(context, new PigeonModel<>(context.bakeLayer(PigeonModel.LAYER_LOCATION)), 0.3F);
        this.baby = new PigeonChildModel<>(context.bakeLayer(PigeonChildModel.LAYER_LOCATION));
    }

    @Override
    protected void scale(PigeonEntity entity, @NotNull PoseStack poseStack, float f) {
        if (entity.isBaby()) poseStack.scale(.5f, .5f, .5f);
        else poseStack.scale(entity.getScale(), entity.getScale(), entity.getScale());
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull PigeonEntity entity) {
        return entity.isBaby() ? ResourceLocation.parse("pigeons:textures/entities/pigeon_child_texture.png") : ResourceLocation.parse("pigeons:textures/entities/pigeon_texture.png");
    }

    @Override
    public void render(@NotNull PigeonEntity entity, float p_115309_, float p_115310_, @NotNull PoseStack p_115311_, @NotNull MultiBufferSource p_115312_, int p_115313_) {
        if (entity.isBaby()) this.model = this.baby;
        else this.model = this.adult;
        super.render(entity, p_115309_, p_115310_, p_115311_, p_115312_, p_115313_);
    }
}
