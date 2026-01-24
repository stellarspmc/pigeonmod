package fun.spmc.pigeons.init;

import fun.spmc.pigeons.client.renderer.*;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber( value = {Dist.CLIENT} )
public class PigeonsModEntityRenderers {
    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(PigeonsModEntities.PIGEON.get(), PigeonRenderer::new);
        event.registerEntityRenderer(PigeonsModEntities.WOOD_PIGEON.get(), WoodPigeonRenderer::new);
        event.registerEntityRenderer(PigeonsModEntities.EURASIAN_COLLARED_DOVE.get(), EurasianCollaredDoveRenderer::new);
        event.registerEntityRenderer(PigeonsModEntities.MOURNING_DOVE.get(), MourningDoveRenderer::new);
        event.registerEntityRenderer(PigeonsModEntities.WESTERN_CROWNED_PIGEON.get(), WesternCrownedPigeonRenderer::new);
        event.registerEntityRenderer(PigeonsModEntities.KERERU.get(), KereruRenderer::new);
        event.registerEntityRenderer(PigeonsModEntities.SPECKLED_PIGEON.get(), SpeckledPigeonRenderer::new);
        event.registerEntityRenderer(PigeonsModEntities.ARCHANGEL_PIGEON.get(), ArchangelPigeonRenderer::new);
        event.registerEntityRenderer(PigeonsModEntities.DIAMOND_DOVE.get(), DiamondDoveRenderer::new);
        event.registerEntityRenderer(PigeonsModEntities.EMERALD_DOVE.get(), EmeraldDoveRenderer::new);
    }
}
