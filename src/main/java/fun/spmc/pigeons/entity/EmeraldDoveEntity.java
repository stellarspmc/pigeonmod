package fun.spmc.pigeons.entity;

import fun.spmc.pigeons.util.PigeonType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.level.Level;

public class EmeraldDoveEntity extends AbstractPigeonEntity {
    public EmeraldDoveEntity(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level, PigeonType.EMERALD_DOVE);
    }
}