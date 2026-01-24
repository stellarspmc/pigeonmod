package fun.spmc.pigeons.client.renderer;

import fun.spmc.pigeons.entity.PigeonEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class WoodPigeonRenderer extends PigeonRenderer {

    public WoodPigeonRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull PigeonEntity entity) {
        return entity.isBaby() ? ResourceLocation.parse("pigeons:textures/entities/pigeon_child_texture.png") : ResourceLocation.parse("pigeons:textures/entities/wood_pigeon_texture.png");
    }
}
