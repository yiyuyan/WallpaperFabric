package cn.ksmcbrigade.mixin;

import cn.ksmcbrigade.Config;
import cn.ksmcbrigade.renderer.WallpaperRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.world.CreateWorldScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CreateWorldScreen.class)
public class CreateWorldScreenMixin {
    @Inject(method = "renderBackgroundTexture",at = @At("HEAD"),cancellable = true)
    private void render(DrawContext DrawContext, CallbackInfo ci) throws Exception {
        if(Config.SPEC.isLoaded() && Config.ENABLED.get() && Config.check()){
            WallpaperRenderer.render(DrawContext);
            ci.cancel();
        }
    }
}
