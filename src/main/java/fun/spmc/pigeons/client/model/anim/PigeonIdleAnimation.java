package fun.spmc.pigeons.client.model.anim;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class PigeonIdleAnimation {
    public static final AnimationDefinition idle;

    static {
        idle = AnimationDefinition.Builder.withLength(2.9583F).looping().addAnimation("HeadBeak", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, -52.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.4167F, KeyframeAnimations.degreeVec(0.0F, -52.66F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.5417F, KeyframeAnimations.degreeVec(0.0F, 53.01F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.8333F, KeyframeAnimations.degreeVec(0.0F, 54.45F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.9583F, KeyframeAnimations.degreeVec(0.0F, -0.4F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.625F, KeyframeAnimations.degreeVec(132.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.7083F, KeyframeAnimations.degreeVec(65.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.8333F, KeyframeAnimations.degreeVec(115.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.9583F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR))).build();
    }
}
