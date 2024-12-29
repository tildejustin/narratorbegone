package me.tori.narratorbegone.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.*;
import com.mojang.text2speech.NarratorWindows;
import com.sun.jna.NativeLibrary;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = NarratorWindows.class, remap = false)
public abstract class NarratorWindowsMixin {
    @WrapOperation(method = "<clinit>", at = @At(value = "INVOKE", target = "Lcom/sun/jna/Native;register(Ljava/lang/Class;Lcom/sun/jna/NativeLibrary;)V"))
    private static void doNotRegisterLibrary(Class<?> m, NativeLibrary rtype, Operation<Void> original) {
        throw new UnsatisfiedLinkError();
    }
}
