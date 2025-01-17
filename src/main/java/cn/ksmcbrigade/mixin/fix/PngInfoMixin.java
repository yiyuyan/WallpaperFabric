package cn.ksmcbrigade.mixin.fix;

import net.minecraft.util.PngMetadata;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.nio.ByteBuffer;

@Mixin(PngMetadata.class)
public class PngInfoMixin {

    @Inject(method = "validate",at = @At("HEAD"),cancellable = true)
    private static void v(ByteBuffer buffer, CallbackInfo ci){
        ci.cancel();
    }
}
