package fun.spmc.pigeons.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class PigeonsModTabs {
    public static final DeferredRegister<CreativeModeTab> REGISTRY;
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> PIGEONS;

    static {
        REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, "pigeons");
        PIGEONS = REGISTRY.register("pigeons", () -> CreativeModeTab.builder().title(Component.translatable("item_group.pigeons.pigeons")).icon(() -> new ItemStack(PigeonItems.PIGEON_SPAWN_EGG.get())).displayItems((parameters, output) -> {
            output.accept(PigeonItems.PIGEON_SPAWN_EGG.get());
            output.accept(PigeonItems.ARCHANGEL_PIGEON_SPAWN_EGG.get());
            output.accept(PigeonItems.WOOD_PIGEON_SPAWN_EGG.get());
            output.accept(PigeonItems.EURASIAN_COLLARED_DOVE_SPAWN_EGG.get());
            output.accept(PigeonItems.MOURNING_DOVE_SPAWN_EGG.get());
            output.accept(PigeonItems.WESTERN_CROWNED_PIGEON_SPAWN_EGG.get());
            output.accept(PigeonItems.KERERU_SPAWN_EGG.get());
            output.accept(PigeonItems.SPECKLED_PIGEON_SPAWN_EGG.get());
            output.accept(PigeonItems.DIAMOND_DOVE_SPAWN_EGG.get());
            output.accept(PigeonItems.EMERALD_DOVE_SPAWN_EGG.get());
        }).build());
    }
}
