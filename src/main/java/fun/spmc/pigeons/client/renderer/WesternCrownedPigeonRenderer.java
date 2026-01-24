package fun.spmc.pigeons.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import fun.spmc.pigeons.client.model.PigeonChildModel;
import fun.spmc.pigeons.client.model.PigeonModel;
import fun.spmc.pigeons.client.model.WesternCrownedPigeonModel;
import fun.spmc.pigeons.entity.WesternCrownedPigeonEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class WesternCrownedPigeonRenderer extends MobRenderer<WesternCrownedPigeonEntity, PigeonModel<WesternCrownedPigeonEntity>> {
    private final PigeonChildModel<WesternCrownedPigeonEntity> baby;
    private final WesternCrownedPigeonModel<WesternCrownedPigeonEntity> adult = (WesternCrownedPigeonModel<WesternCrownedPigeonEntity>) this.getModel();

    public WesternCrownedPigeonRenderer(EntityRendererProvider.Context context) {
        super(context, new WesternCrownedPigeonModel<>(context.bakeLayer(WesternCrownedPigeonModel.LAYER_LOCATION)), 0.3F);
        this.baby = new PigeonChildModel<>(context.bakeLayer(PigeonChildModel.LAYER_LOCATION));
    }

    @Override
    protected void scale(WesternCrownedPigeonEntity entity, @NotNull PoseStack poseStack, float f) {
        if (entity.isBaby()) poseStack.scale(.4f, .4f, .4f);
        else poseStack.scale(entity.getScale(), entity.getScale(), entity.getScale());
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull WesternCrownedPigeonEntity entity) {
        return entity.isBaby() ? ResourceLocation.parse("pigeons:textures/entities/pigeon_child_texture.png") : ResourceLocation.parse("pigeons:textures/entities/western_crowned_pigeon_texture.png");
    }

    @Override
    public void render(@NotNull WesternCrownedPigeonEntity entity, float p_115309_, float p_115310_, @NotNull PoseStack p_115311_, @NotNull MultiBufferSource p_115312_, int p_115313_) {
        if (entity.isBaby()) this.model = this.baby;
        else this.model = this.adult;
        super.render(entity, p_115309_, p_115310_, p_115311_, p_115312_, p_115313_);
    }
}
