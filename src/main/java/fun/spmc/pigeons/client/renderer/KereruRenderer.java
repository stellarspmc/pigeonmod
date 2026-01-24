package fun.spmc.pigeons.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import fun.spmc.pigeons.client.model.KereruChildModel;
import fun.spmc.pigeons.client.model.PigeonModel;
import fun.spmc.pigeons.client.model.WesternCrownedPigeonModel;
import fun.spmc.pigeons.entity.KereruEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class KereruRenderer extends MobRenderer<KereruEntity, PigeonModel<KereruEntity>> {
    private final KereruChildModel<KereruEntity> baby;
    private final WesternCrownedPigeonModel<KereruEntity> adult = (WesternCrownedPigeonModel<KereruEntity>) this.getModel();

    public KereruRenderer(EntityRendererProvider.Context context) {
        super(context, new WesternCrownedPigeonModel<>(context.bakeLayer(WesternCrownedPigeonModel.LAYER_LOCATION)), 0.3F);
        this.baby = new KereruChildModel<>(context.bakeLayer(KereruChildModel.LAYER_LOCATION));
    }

    @Override
    protected void scale(KereruEntity entity, @NotNull PoseStack poseStack, float f) {
        if (entity.isBaby()) poseStack.scale(.4f, .4f, .4f);
        else poseStack.scale(entity.getScale(), entity.getScale(), entity.getScale());
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull KereruEntity entity) {
        return entity.isBaby() ? ResourceLocation.parse("pigeons:textures/entities/kereru_baby_texture.png") : ResourceLocation.parse("pigeons:textures/entities/kereru_texture.png");
    }

    @Override
    public void render(@NotNull KereruEntity entity, float p_115309_, float p_115310_, @NotNull PoseStack p_115311_, @NotNull MultiBufferSource p_115312_, int p_115313_) {
        if (entity.isBaby()) this.model = this.baby;
        else this.model = this.adult;
        super.render(entity, p_115309_, p_115310_, p_115311_, p_115312_, p_115313_);
    }
}
