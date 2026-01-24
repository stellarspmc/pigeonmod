package fun.spmc.pigeons.util;

import fun.spmc.pigeons.entity.AbstractPigeonEntity;
import fun.spmc.pigeons.init.PigeonEntities;
import fun.spmc.pigeons.init.PigeonSoundEvents;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;

public enum PigeonType {
    ARCHANGEL_PIGEON(PigeonEntities.ARCHANGEL_PIGEON.get(), PigeonSoundEvents.PIGEON_COO.get(), PigeonSoundEvents.PIGEON_DEATH.get()),
    DIAMOND_DOVE(PigeonEntities.DIAMOND_DOVE.get(), PigeonSoundEvents.DIAMOND_DOVE_COO.get(), PigeonSoundEvents.DIAMOND_DOVE_DEATH.get()),
    EMERALD_DOVE(PigeonEntities.EMERALD_DOVE.get(), PigeonSoundEvents.EMERALD_DOVE_COO.get(), PigeonSoundEvents.EMERALD_DOVE_DEATH.get()),
    ECD(PigeonEntities.EURASIAN_COLLARED_DOVE.get(), PigeonSoundEvents.ECD_COO.get(), PigeonSoundEvents.PIGEON_DEATH.get()),
    KERERU(PigeonEntities.KERERU.get(), PigeonSoundEvents.KERERU_COO.get(), PigeonSoundEvents.KERERU_DEATH.get()),
    MOURNING_DOVE(PigeonEntities.MOURNING_DOVE.get(), PigeonSoundEvents.MOURNING_DOVE_COO.get(), PigeonSoundEvents.MOURNING_DOVE_DEATH.get()),
    PIGEON(PigeonEntities.PIGEON.get(), PigeonSoundEvents.PIGEON_COO.get(), PigeonSoundEvents.PIGEON_DEATH.get()),
    SPECKLED_PIGEON(PigeonEntities.SPECKLED_PIGEON.get(), PigeonSoundEvents.SPECKLED_PIGEON_COO.get(), PigeonSoundEvents.SPECKLED_PIGEON_DEATH.get()),
    WCP(PigeonEntities.WESTERN_CROWNED_PIGEON.get(), PigeonSoundEvents.WCP_COO.get(), PigeonSoundEvents.WCP_DEATH.get()),
    WOOD_PIGEON(PigeonEntities.WOOD_PIGEON.get(), PigeonSoundEvents.WOOD_PIGEON_COO.get(), PigeonSoundEvents.PIGEON_DEATH.get());

    private final EntityType<? extends AbstractPigeonEntity> entityType;
    private final SoundEvent cooSound;
    private final SoundEvent deathSound;

    PigeonType(EntityType<? extends AbstractPigeonEntity> entityType, SoundEvent cooSound, SoundEvent deathSound) {
        this.entityType = entityType;
        this.cooSound = cooSound;
        this.deathSound = deathSound;
    }

    public EntityType<? extends AbstractPigeonEntity> getEntityType() {
        return entityType;
    }

    public SoundEvent getDeathSound() {
        return deathSound;
    }

    public SoundEvent getCooSound() {
        return cooSound;
    }
}
