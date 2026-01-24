package fun.spmc.pigeons;

import fun.spmc.pigeons.init.*;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(Pigeons.MODID)
public class Pigeons {
    public static final String MODID = "pigeons";
    public Pigeons(IEventBus modEventBus) {
        PigeonsModSounds.REGISTRY.register(modEventBus);
        PigeonsModItems.REGISTRY.register(modEventBus);
        PigeonsModEntities.REGISTRY.register(modEventBus);
        PigeonsModTabs.REGISTRY.register(modEventBus);
    }

}
