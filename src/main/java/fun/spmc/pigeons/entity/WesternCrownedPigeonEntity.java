package fun.spmc.pigeons.entity;

import fun.spmc.pigeons.util.PigeonType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.level.Level;

public class WesternCrownedPigeonEntity extends AbstractPigeonEntity {
    public WesternCrownedPigeonEntity(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level, "wcp_death", "wcp_coo", PigeonType.WCPIGEON);
    }
}
