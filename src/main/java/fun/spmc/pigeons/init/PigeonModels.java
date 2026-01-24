package fun.spmc.pigeons.init;

import fun.spmc.pigeons.client.model.*;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber( value = {Dist.CLIENT} )
public class PigeonModels {
    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(DiamondDoveModel.LAYER_LOCATION, DiamondDoveModel::createBodyLayer);
        event.registerLayerDefinition(PigeonModel.LAYER_LOCATION, PigeonModel::createBodyLayer);
        event.registerLayerDefinition(WesternCrownedPigeonModel.LAYER_LOCATION, WesternCrownedPigeonModel::createBodyLayer);
        event.registerLayerDefinition(ArchangelPigeonModel.LAYER_LOCATION, ArchangelPigeonModel::createBodyLayer);
        event.registerLayerDefinition(KereruChildModel.LAYER_LOCATION, KereruChildModel::createBodyLayer);
        event.registerLayerDefinition(PigeonChildModel.LAYER_LOCATION, PigeonChildModel::createBodyLayer);
    }
}

