package fun.spmc.pigeons.util;

import fun.spmc.pigeons.entity.AbstractPigeonEntity;
import fun.spmc.pigeons.init.PigeonsModEntities;
import net.minecraft.world.entity.EntityType;

public enum PigeonType {
    ARCHANGEL_PIGEON(PigeonsModEntities.ARCHANGEL_PIGEON.get()),
    DIAMOND_DOVE(PigeonsModEntities.DIAMOND_DOVE.get()),
    EMERALD_DOVE(PigeonsModEntities.EMERALD_DOVE.get()),
    ECDOVE(PigeonsModEntities.EURASIAN_COLLARED_DOVE.get()),
    KERERU(PigeonsModEntities.KERERU.get()),
    MOURNING_DOVE(PigeonsModEntities.MOURNING_DOVE.get()),
    PIGEON(PigeonsModEntities.PIGEON.get()),
    SPECKLED_PIGEON(PigeonsModEntities.SPECKLED_PIGEON.get()),
    WCPIGEON(PigeonsModEntities.WESTERN_CROWNED_PIGEON.get()),
    WOOD_PIGEON(PigeonsModEntities.WOOD_PIGEON.get());

    private final EntityType<? extends AbstractPigeonEntity> entityType;
    PigeonType(EntityType<? extends AbstractPigeonEntity> entityType) {
        this.entityType = entityType;
    }

    public EntityType<? extends AbstractPigeonEntity> getEntityType() {
        return entityType;
    }
}
