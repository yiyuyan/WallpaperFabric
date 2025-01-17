package cn.ksmcbrigade.mixin;

import cn.ksmcbrigade.Config;
import cn.ksmcbrigade.renderer.WallpaperRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.RotatingCubeMapRenderer;
import net.minecraft.client.gui.screen.AccessibilityOnboardingScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AccessibilityOnboardingScreen.class)
public class AccessibilityOnboardingScreenMixin {

    @Unique
    private DrawContext drawContext;

    @Inject(method = "render",at = @At("HEAD"))
    private void draw(DrawContext context, int mouseX, int mouseY, float delta, CallbackInfo ci){
        this.drawContext = context;
    }

    @Redirect(method = "render",at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/RotatingCubeMapRenderer;render(FF)V"))
    private void render(RotatingCubeMapRenderer instance, float delta, float alpha) throws Exception {
        if(Config.SPEC.isLoaded() && Config.ENABLED.get() && Config.check()){
            if(Config.TITLE_SCREEN_ENABLED.get()){
                WallpaperRenderer.render(this.drawContext);
            }
            else{
                instance.render(delta,alpha);
            }
        }
    }
}
