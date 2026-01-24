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
        PIGEONS = REGISTRY.register("pigeons", () -> CreativeModeTab.builder().title(Component.translatable("item_group.pigeons.pigeons")).icon(() -> new ItemStack(PigeonsModItems.PIGEON_SPAWN_EGG.get())).displayItems((parameters, output) -> {
            output.accept(PigeonsModItems.PIGEON_SPAWN_EGG.get());
            output.accept(PigeonsModItems.ARCHANGEL_PIGEON_SPAWN_EGG.get());
            output.accept(PigeonsModItems.WOOD_PIGEON_SPAWN_EGG.get());
            output.accept(PigeonsModItems.EURASIAN_COLLARED_DOVE_SPAWN_EGG.get());
            output.accept(PigeonsModItems.MOURNING_DOVE_SPAWN_EGG.get());
            output.accept(PigeonsModItems.WESTERN_CROWNED_PIGEON_SPAWN_EGG.get());
            output.accept(PigeonsModItems.KERERU_SPAWN_EGG.get());
            output.accept(PigeonsModItems.SPECKLED_PIGEON_SPAWN_EGG.get());
            output.accept(PigeonsModItems.DIAMOND_DOVE_SPAWN_EGG.get());
            output.accept(PigeonsModItems.EMERALD_DOVE_SPAWN_EGG.get());
            output.accept(PigeonsModItems.PIGEON_MEAT.get());
            output.accept(PigeonsModItems.COOKED_PIGEON_MEAT.get());
        }).build());
    }
}
