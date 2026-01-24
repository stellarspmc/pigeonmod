package fun.spmc.pigeons.init;

import fun.spmc.pigeons.client.renderer.*;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber( value = {Dist.CLIENT} )
public class PigeonsRenderers {
    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(PigeonEntities.PIGEON.get(), PigeonRenderer::new);
        event.registerEntityRenderer(PigeonEntities.WOOD_PIGEON.get(), WoodPigeonRenderer::new);
        event.registerEntityRenderer(PigeonEntities.EURASIAN_COLLARED_DOVE.get(), EurasianCollaredDoveRenderer::new);
        event.registerEntityRenderer(PigeonEntities.MOURNING_DOVE.get(), MourningDoveRenderer::new);
        event.registerEntityRenderer(PigeonEntities.WESTERN_CROWNED_PIGEON.get(), WesternCrownedPigeonRenderer::new);
        event.registerEntityRenderer(PigeonEntities.KERERU.get(), KereruRenderer::new);
        event.registerEntityRenderer(PigeonEntities.SPECKLED_PIGEON.get(), SpeckledPigeonRenderer::new);
        event.registerEntityRenderer(PigeonEntities.ARCHANGEL_PIGEON.get(), ArchangelPigeonRenderer::new);
        event.registerEntityRenderer(PigeonEntities.DIAMOND_DOVE.get(), DiamondDoveRenderer::new);
        event.registerEntityRenderer(PigeonEntities.EMERALD_DOVE.get(), EmeraldDoveRenderer::new);
    }
}
