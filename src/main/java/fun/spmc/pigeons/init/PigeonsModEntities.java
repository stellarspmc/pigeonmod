package fun.spmc.pigeons.init;

import fun.spmc.pigeons.entity.*;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

@EventBusSubscriber()
public class PigeonsModEntities {
    public static final DeferredRegister<EntityType<?>> REGISTRY;
    public static final Supplier<EntityType<PigeonEntity>> PIGEON;
    public static final Supplier<EntityType<WoodPigeonEntity>> WOOD_PIGEON;
    public static final Supplier<EntityType<EurasianCollaredDoveEntity>> EURASIAN_COLLARED_DOVE;
    public static final Supplier<EntityType<MourningDoveEntity>> MOURNING_DOVE;
    public static final Supplier<EntityType<WesternCrownedPigeonEntity>> WESTERN_CROWNED_PIGEON;
    public static final Supplier<EntityType<KereruEntity>> KERERU;
    public static final Supplier<EntityType<SpeckledPigeonEntity>> SPECKLED_PIGEON;
    public static final Supplier<EntityType<ArchangelPigeonEntity>> ARCHANGEL_PIGEON;
    public static final Supplier<EntityType<DiamondDoveEntity>> DIAMOND_DOVE;
    public static final Supplier<EntityType<EmeraldDoveEntity>> EMERALD_DOVE;

    private static <T extends Entity> Supplier<EntityType<T>> register(String regName, EntityType.Builder<T> entityTypeBuilder) {
        return REGISTRY.register(regName, () -> entityTypeBuilder.build(regName));
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(PIGEON.get(), PigeonEntity.createMobAttributes().build());
        event.put(WOOD_PIGEON.get(), WoodPigeonEntity.createMobAttributes().build());
        event.put(EURASIAN_COLLARED_DOVE.get(), EurasianCollaredDoveEntity.createMobAttributes().build());
        event.put(MOURNING_DOVE.get(), MourningDoveEntity.createMobAttributes().build());
        event.put(WESTERN_CROWNED_PIGEON.get(), WesternCrownedPigeonEntity.createMobAttributes().build());
        event.put(KERERU.get(), KereruEntity.createMobAttributes().build());
        event.put(SPECKLED_PIGEON.get(), SpeckledPigeonEntity.createMobAttributes().build());
        event.put(ARCHANGEL_PIGEON.get(), ArchangelPigeonEntity.createMobAttributes().build());
        event.put(DIAMOND_DOVE.get(), DiamondDoveEntity.createMobAttributes().build());
        event.put(EMERALD_DOVE.get(), EmeraldDoveEntity.createMobAttributes().build());
    }

    static {
        REGISTRY = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, "pigeons");
        PIGEON = register("pigeon", EntityType.Builder.of(PigeonEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).sized(0.3F, 0.3F));
        WOOD_PIGEON = register("wood_pigeon", EntityType.Builder.of(WoodPigeonEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).sized(0.5F, 0.3F));
        EURASIAN_COLLARED_DOVE = register("eurasian_collared_dove", EntityType.Builder.of(EurasianCollaredDoveEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).sized(0.5F, 0.3F));
        MOURNING_DOVE = register("mourning_dove", EntityType.Builder.of(MourningDoveEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).sized(0.5F, 0.3F));
        WESTERN_CROWNED_PIGEON = register("western_crowned_pigeon", EntityType.Builder.of(WesternCrownedPigeonEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).sized(0.6F, 1.5F));
        KERERU = register("kereru", EntityType.Builder.of(KereruEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).sized(0.5F, 0.5F));
        SPECKLED_PIGEON = register("speckled_pigeon", EntityType.Builder.of(SpeckledPigeonEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).sized(0.3F, 0.3F));
        ARCHANGEL_PIGEON = register("archangel_pigeon", EntityType.Builder.of(ArchangelPigeonEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).sized(0.6F, 1.8F));
        DIAMOND_DOVE = register("diamond_dove", EntityType.Builder.of(DiamondDoveEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).sized(0.3F, 1.0F));
        EMERALD_DOVE = register("emerald_dove", EntityType.Builder.of(EmeraldDoveEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).sized(0.3F, 0.3F));
    }
}
