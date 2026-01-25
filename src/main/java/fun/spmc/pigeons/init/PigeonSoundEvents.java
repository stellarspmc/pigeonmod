package fun.spmc.pigeons.init;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class PigeonSoundEvents {
    public static final DeferredRegister<SoundEvent> REGISTRY;
    public static final DeferredHolder<SoundEvent, SoundEvent> PIGEON_COO;
    public static final DeferredHolder<SoundEvent, SoundEvent> PIGEON_DEATH;
    public static final DeferredHolder<SoundEvent, SoundEvent> WOOD_PIGEON_COO;
    public static final DeferredHolder<SoundEvent, SoundEvent> ECD_COO;
    public static final DeferredHolder<SoundEvent, SoundEvent> MOURNING_DOVE_COO;
    public static final DeferredHolder<SoundEvent, SoundEvent> MOURNING_DOVE_DEATH;
    public static final DeferredHolder<SoundEvent, SoundEvent> WCP_COO;
    public static final DeferredHolder<SoundEvent, SoundEvent> WCP_DEATH;
    public static final DeferredHolder<SoundEvent, SoundEvent> KERERU_COO;
    public static final DeferredHolder<SoundEvent, SoundEvent> KERERU_DEATH;
    public static final DeferredHolder<SoundEvent, SoundEvent> SPECKLED_PIGEON_COO;
    public static final DeferredHolder<SoundEvent, SoundEvent> SPECKLED_PIGEON_DEATH;
    public static final DeferredHolder<SoundEvent, SoundEvent> DIAMOND_DOVE_COO;
    public static final DeferredHolder<SoundEvent, SoundEvent> DIAMOND_DOVE_DEATH;
    public static final DeferredHolder<SoundEvent, SoundEvent> EMERALD_DOVE_COO;
    public static final DeferredHolder<SoundEvent, SoundEvent> EMERALD_DOVE_DEATH;
    public static final DeferredHolder<SoundEvent, SoundEvent> CHILD_PIGEON_COO;

    static {
        REGISTRY = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, "pigeons");
        PIGEON_COO = REGISTRY.register("pigeon_coo", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("pigeons", "pigeon_coo")));
        PIGEON_DEATH = REGISTRY.register("pigeon_death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("pigeons", "pigeon_death")));
        WOOD_PIGEON_COO = REGISTRY.register("wood_pigeon_coo", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("pigeons", "wood_pigeon_coo")));
        ECD_COO = REGISTRY.register("ecd_coo", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("pigeons", "ecd_coo")));
        MOURNING_DOVE_COO = REGISTRY.register("mourning_dove_coo", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("pigeons", "mourning_dove_coo")));
        MOURNING_DOVE_DEATH = REGISTRY.register("mourning_dove_death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("pigeons", "mourning_dove_death")));
        WCP_COO = REGISTRY.register("wcp_coo", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("pigeons", "wcp_coo")));
        WCP_DEATH = REGISTRY.register("wcp_death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("pigeons", "wcp_death")));
        KERERU_COO = REGISTRY.register("kereru_coo", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("pigeons", "kereru_coo")));
        KERERU_DEATH = REGISTRY.register("kereru_death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("pigeons", "kereru_death")));
        SPECKLED_PIGEON_COO = REGISTRY.register("speckled_pigeon_coo", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("pigeons", "speckled_pigeon_coo")));
        SPECKLED_PIGEON_DEATH = REGISTRY.register("speckled_death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("pigeons", "speckled_pigeon_death")));
        DIAMOND_DOVE_COO = REGISTRY.register("diamond_dove_coo", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("pigeons", "diamond_dove_coo")));
        DIAMOND_DOVE_DEATH = REGISTRY.register("diamond_dove_death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("pigeons", "diamond_dove_death")));
        EMERALD_DOVE_COO = REGISTRY.register("emerald_dove_coo", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("pigeons", "emerald_dove_coo")));
        EMERALD_DOVE_DEATH = REGISTRY.register("emerald_dove_death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("pigeons", "emerald_dove_death")));
        CHILD_PIGEON_COO = REGISTRY.register("child_pigeon_coo", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("pigeons", "child_pigeon_coo")));
    }
}