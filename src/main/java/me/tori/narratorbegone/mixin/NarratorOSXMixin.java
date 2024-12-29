package me.tori.narratorbegone.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.*;
import com.mojang.text2speech.NarratorOSX;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;

@Mixin(value = NarratorOSX.class, remap = false)
public abstract class NarratorOSXMixin {
    // TODO: check if this mixin works
    @SuppressWarnings("InvalidInjectorMethodSignature")
    @WrapOperation(method = "startSpeaking", at = @At(value = "INVOKE", target = "Lca/weblite/objc/Proxy;send(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;"))
    private @Coerce Object avoidProxySend(@Coerce Object instance, String s, Object[] objects, Operation<Object> original) {
        return null;
    }
}
