package fun.spmc.pigeons.entity;

import fun.spmc.pigeons.init.PigeonsModEntities;
import fun.spmc.pigeons.util.PigeonType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class EurasianCollaredDoveEntity extends AbstractPigeonEntity {
    public EurasianCollaredDoveEntity(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level, "pigeon_death", "ecd_coo", PigeonType.ECDOVE);
    }
}
