package fun.spmc.pigeons.entity;

import fun.spmc.pigeons.init.PigeonsModEntities;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ArchangelPigeonEntity extends PigeonEntity {
    public ArchangelPigeonEntity(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(@NotNull ServerLevel serverWorld, @NotNull AgeableMob ageableMob) {
        PigeonEntity entity = (PigeonsModEntities.ARCHANGEL_PIGEON.get()).create(serverWorld);
        assert entity != null;
        entity.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(entity.getOnPos()), MobSpawnType.BREEDING, null);
        return entity;
    }
}
