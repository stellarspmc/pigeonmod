package fun.spmc.pigeons.entity;

import fun.spmc.pigeons.util.PigeonType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.level.Level;

public class KereruEntity extends AbstractPigeonEntity {
    public KereruEntity(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level, "kereru_death", "kereru_coo", PigeonType.KERERU);
    }
}
