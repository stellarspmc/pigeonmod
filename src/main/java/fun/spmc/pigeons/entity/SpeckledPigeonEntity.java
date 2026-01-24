package fun.spmc.pigeons.entity;

import fun.spmc.pigeons.util.PigeonType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.level.Level;

public class SpeckledPigeonEntity extends AbstractPigeonEntity {
    public SpeckledPigeonEntity(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level, "speckled_pigeon_death", "speckled_pigeon_coo", PigeonType.SPECKLED_PIGEON);
    }
}
