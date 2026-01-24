package fun.spmc.pigeons.init;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class PigeonsModItems {
    public static final DeferredRegister.Items REGISTRY;
    public static final DeferredItem<Item> PIGEON_SPAWN_EGG;
    public static final DeferredItem<Item> WOOD_PIGEON_SPAWN_EGG;
    public static final DeferredItem<Item> EURASIAN_COLLARED_DOVE_SPAWN_EGG;
    public static final DeferredItem<Item> MOURNING_DOVE_SPAWN_EGG;
    public static final DeferredItem<Item> WESTERN_CROWNED_PIGEON_SPAWN_EGG;
    public static final DeferredItem<Item> KERERU_SPAWN_EGG;
    public static final DeferredItem<Item> SPECKLED_PIGEON_SPAWN_EGG;
    public static final DeferredItem<Item> ARCHANGEL_PIGEON_SPAWN_EGG;
    public static final DeferredItem<Item> DIAMOND_DOVE_SPAWN_EGG;
    public static final DeferredItem<Item> EMERALD_DOVE_SPAWN_EGG;

    static {
        REGISTRY = DeferredRegister.createItems("pigeons");
        PIGEON_SPAWN_EGG = REGISTRY.register("pigeon_spawn_egg", () -> new DeferredSpawnEggItem(PigeonsModEntities.PIGEON, -6697729, -11704964, new Item.Properties()));
        WOOD_PIGEON_SPAWN_EGG = REGISTRY.register("wood_pigeon_spawn_egg", () -> new DeferredSpawnEggItem(PigeonsModEntities.WOOD_PIGEON, -9928058, -1, new Item.Properties()));
        EURASIAN_COLLARED_DOVE_SPAWN_EGG = REGISTRY.register("eurasian_collared_dove_spawn_egg", () -> new DeferredSpawnEggItem(PigeonsModEntities.EURASIAN_COLLARED_DOVE, -3160924, -16777216, new Item.Properties()));
        MOURNING_DOVE_SPAWN_EGG = REGISTRY.register("mourning_dove_spawn_egg", () -> new DeferredSpawnEggItem(PigeonsModEntities.MOURNING_DOVE, -134954, -9149105, new Item.Properties()));
        WESTERN_CROWNED_PIGEON_SPAWN_EGG = REGISTRY.register("western_crowned_pigeon_spawn_egg", () -> new DeferredSpawnEggItem(PigeonsModEntities.WESTERN_CROWNED_PIGEON, -16750849, -16737793, new Item.Properties()));
        KERERU_SPAWN_EGG = REGISTRY.register("kereru_spawn_egg", () -> new DeferredSpawnEggItem(PigeonsModEntities.KERERU, -13408513, -13382656, new Item.Properties()));
        SPECKLED_PIGEON_SPAWN_EGG = REGISTRY.register("speckled_pigeon_spawn_egg", () -> new DeferredSpawnEggItem(PigeonsModEntities.SPECKLED_PIGEON, -10092544, -1, new Item.Properties()));
        ARCHANGEL_PIGEON_SPAWN_EGG = REGISTRY.register("archangel_pigeon_spawn_egg", () -> new DeferredSpawnEggItem(PigeonsModEntities.ARCHANGEL_PIGEON, -5685730, -16777216, new Item.Properties()));
        DIAMOND_DOVE_SPAWN_EGG = REGISTRY.register("diamond_dove_spawn_egg", () -> new DeferredSpawnEggItem(PigeonsModEntities.DIAMOND_DOVE, -3355393, -7505574, new Item.Properties()));
        EMERALD_DOVE_SPAWN_EGG = REGISTRY.register("emerald_dove_spawn_egg", () -> new DeferredSpawnEggItem(PigeonsModEntities.EMERALD_DOVE, -6737152, -16724941, new Item.Properties()));
    }
}
