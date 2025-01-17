package cn.ksmcbrigade;

import net.minecraftforge.common.ForgeConfigSpec;

import java.io.File;

public class Config {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    public static final ForgeConfigSpec.BooleanValue ENABLED = BUILDER.comment("The enable of the wallpaper module.").comment("Default: false").define("enable",false);
    public static final ForgeConfigSpec.BooleanValue BLUR_ENABLED = BUILDER.comment("The enable of the background blur when the wallpaper working.").comment("Default: false").define("blur_enable",false);
    public static final ForgeConfigSpec.BooleanValue WIN_SCREEN_ENABLED = BUILDER.comment("The enable of the wallpaper if work on the title screen.").comment("Default: true").define("title_screen_enable",true);
    public static final ForgeConfigSpec.BooleanValue TITLE_SCREEN_ENABLED = BUILDER.comment("The enable of the wallpaper if work on the win screen.").comment("Default: true").define("win_screen_enable",true);
    public static final ForgeConfigSpec.ConfigValue<String> PATH = BUILDER.comment("The file path of the wallpaper.").define("path","");

    public static final ForgeConfigSpec SPEC = BUILDER.build();

    public static boolean exists(){
        return new File(PATH.get()).exists();
    }

    public static boolean check(){
        if(!exists()) return false;
        return PATH.get().toLowerCase().endsWith(".png") || PATH.get().toLowerCase().endsWith(".jpg") || PATH.get().toLowerCase().endsWith(".jpeg") || PATH.get().toLowerCase().endsWith(".bmp");
    }
}
