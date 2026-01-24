package fun.spmc.pigeons.client.renderer;

import fun.spmc.pigeons.entity.AbstractPigeonEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class SpeckledPigeonRenderer extends PigeonRenderer {

    public SpeckledPigeonRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull AbstractPigeonEntity entity) {
        return entity.isBaby() ? ResourceLocation.parse("pigeons:textures/entities/pigeon_child_texture.png") : ResourceLocation.parse("pigeons:textures/entities/speckled_pigeon_texture.png");
    }
}
