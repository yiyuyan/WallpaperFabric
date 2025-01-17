package cn.ksmcbrigade.mixin;

import cn.ksmcbrigade.Config;
import cn.ksmcbrigade.renderer.WallpaperRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.CreditsScreen;
import net.minecraft.client.gui.screen.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Screen.class)
public class ScreenMixin {
    @Inject(method = "renderBackgroundTexture",at = @At("HEAD"),cancellable = true)
    private void render(DrawContext context, CallbackInfo ci) throws Exception {
        if(Config.SPEC.isLoaded() && Config.ENABLED.get() && Config.check()){
            if(((Screen)((Object)this)) instanceof CreditsScreen && !Config.WIN_SCREEN_ENABLED.get()) return;
            WallpaperRenderer.render(context);
            ci.cancel();
        }
    }
}
