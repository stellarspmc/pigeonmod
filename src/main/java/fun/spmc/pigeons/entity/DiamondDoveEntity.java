package fun.spmc.pigeons.entity;

import fun.spmc.pigeons.util.PigeonType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.level.Level;

public class DiamondDoveEntity extends AbstractPigeonEntity {
    public DiamondDoveEntity(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level, PigeonType.DIAMOND_DOVE);
    }
}