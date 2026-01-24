package fun.spmc.pigeons.init;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class PigeonsModSounds {
    public static final DeferredRegister<SoundEvent> REGISTRY;
    public static final DeferredHolder<SoundEvent, SoundEvent> COMMON_PIGEON_COOING;
    public static final DeferredHolder<SoundEvent, SoundEvent> COMMON_PIGEON_DEATH;
    public static final DeferredHolder<SoundEvent, SoundEvent> WOOD_PIGEON_SOUND;
    public static final DeferredHolder<SoundEvent, SoundEvent> ECD_SOUND;
    public static final DeferredHolder<SoundEvent, SoundEvent> MOURNING_DOVE_SOUND;
    public static final DeferredHolder<SoundEvent, SoundEvent> MOURNING_DOVE_DEATH;
    public static final DeferredHolder<SoundEvent, SoundEvent> WESTERN_CROWNED_PIGEON_SOUND;
    public static final DeferredHolder<SoundEvent, SoundEvent> WESTERN_CROWNED_PIGEON_DEATH;
    public static final DeferredHolder<SoundEvent, SoundEvent> KERERU_SOUND;
    public static final DeferredHolder<SoundEvent, SoundEvent> KERERU_DEATH;
    public static final DeferredHolder<SoundEvent, SoundEvent> SPECKLED_PIGEON_SOUND;
    public static final DeferredHolder<SoundEvent, SoundEvent> SPECKLED_DEATH;
    public static final DeferredHolder<SoundEvent, SoundEvent> DIAMOND_DOVE_VOICE;
    public static final DeferredHolder<SoundEvent, SoundEvent> DIAMOND_DOVE_DEATH;
    public static final DeferredHolder<SoundEvent, SoundEvent> EMERALD_DOVE_SOUND;
    public static final DeferredHolder<SoundEvent, SoundEvent> EMERALD_DOVE_DEATH;
    public static final DeferredHolder<SoundEvent, SoundEvent> CHICK_SOUND;

    static {
        REGISTRY = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, "pigeons");
        COMMON_PIGEON_COOING = REGISTRY.register("common_pigeon_cooing", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("pigeons", "common_pigeon_cooing")));
        COMMON_PIGEON_DEATH = REGISTRY.register("common_pigeon_death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("pigeons", "common_pigeon_death")));
        WOOD_PIGEON_SOUND = REGISTRY.register("wood_pigeon_sound", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("pigeons", "wood_pigeon_sound")));
        ECD_SOUND = REGISTRY.register("ecd_sound", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("pigeons", "ecd_sound")));
        MOURNING_DOVE_SOUND = REGISTRY.register("mourning_dove_sound", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("pigeons", "mourning_dove_sound")));
        MOURNING_DOVE_DEATH = REGISTRY.register("mourning_dove_death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("pigeons", "mourning_dove_death")));
        WESTERN_CROWNED_PIGEON_SOUND = REGISTRY.register("western_crowned_pigeon_sound", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("pigeons", "western_crowned_pigeon_sound")));
        WESTERN_CROWNED_PIGEON_DEATH = REGISTRY.register("western_crowned_pigeon_death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("pigeons", "western_crowned_pigeon_death")));
        KERERU_SOUND = REGISTRY.register("kereru_sound", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("pigeons", "kereru_sound")));
        KERERU_DEATH = REGISTRY.register("kereru_death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("pigeons", "kereru_death")));
        SPECKLED_PIGEON_SOUND = REGISTRY.register("speckled_pigeon_sound", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("pigeons", "speckled_pigeon_sound")));
        SPECKLED_DEATH = REGISTRY.register("speckled_death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("pigeons", "speckled_death")));
        DIAMOND_DOVE_VOICE = REGISTRY.register("diamond_dove_voice", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("pigeons", "diamond_dove_voice")));
        DIAMOND_DOVE_DEATH = REGISTRY.register("diamond_dove_death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("pigeons", "diamond_dove_death")));
        EMERALD_DOVE_SOUND = REGISTRY.register("emerald_dove_sound", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("pigeons", "emerald_dove_sound")));
        EMERALD_DOVE_DEATH = REGISTRY.register("emerald_dove_death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("pigeons", "emerald_dove_death")));
        CHICK_SOUND = REGISTRY.register("chick_sound", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("pigeons", "chick_sound")));
    }
}