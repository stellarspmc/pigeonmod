package fun.spmc.pigeons.entity;

import fun.spmc.pigeons.util.PigeonType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class PigeonEntity extends AbstractPigeonEntity {
    public PigeonEntity(EntityType<? extends AbstractPigeonEntity> entityType, Level level) {
        super(entityType, level, PigeonType.PIGEON);
    }
}
