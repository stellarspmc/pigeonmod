package fun.spmc.pigeons.entity;

import fun.spmc.pigeons.util.PigeonType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.level.Level;

public class ArchangelPigeonEntity extends AbstractPigeonEntity {
    public ArchangelPigeonEntity(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level, PigeonType.ARCHANGEL_PIGEON);
    }
}
