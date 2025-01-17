package cn.ksmcbrigade.renderer;

import cn.ksmcbrigade.Config;
import cn.ksmcbrigade.utils.ImageUtils;
import net.minecraft.client.gui.DrawContext;

import java.io.IOException;

public class WallpaperRenderer {

    public static void render(DrawContext DrawContext) throws IOException {
        DrawContext.drawTexture(ImageUtils.load(Config.PATH.get()),0,0,0,0,DrawContext.getScaledWindowWidth(),DrawContext.getScaledWindowHeight(),DrawContext.getScaledWindowWidth(),DrawContext.getScaledWindowHeight());
    }
}
