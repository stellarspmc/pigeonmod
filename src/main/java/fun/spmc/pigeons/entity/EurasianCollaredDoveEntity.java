package fun.spmc.pigeons.entity;

import fun.spmc.pigeons.init.PigeonsModEntities;
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

public class EurasianCollaredDoveEntity extends PigeonEntity {
    public EurasianCollaredDoveEntity(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(@NotNull ServerLevel serverWorld, @NotNull AgeableMob ageableMob) {
        PigeonEntity entity = (PigeonsModEntities.EURASIAN_COLLARED_DOVE.get()).create(serverWorld);
        assert entity != null;
        entity.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(entity.getOnPos()), MobSpawnType.BREEDING, null);
        return entity;
    }

    @Override
    public SoundEvent getAmbientSound() {
        return !this.isBaby() ? BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("pigeons:ecd_sound")) : BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("pigeons:chick_sound"));
    }
}
