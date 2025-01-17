package cn.ksmcbrigade.mixin;

import cn.ksmcbrigade.Config;
import cn.ksmcbrigade.renderer.WallpaperRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class TitleScreenMixin {
    @Inject(method = "renderBackground",at = @At("HEAD"),cancellable = true)
    private void render(DrawContext DrawContext, int mouseX, int mouseY, float partialTick, CallbackInfo ci) throws Exception {
        if(Config.SPEC.isLoaded() && Config.ENABLED.get() && Config.check() && Config.TITLE_SCREEN_ENABLED.get()){
            WallpaperRenderer.render(DrawContext);
            ci.cancel();
        }
    }
}
