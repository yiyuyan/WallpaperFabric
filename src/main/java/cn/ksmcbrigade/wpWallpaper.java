package cn.ksmcbrigade;

import com.mojang.logging.LogUtils;
import fuzs.forgeconfigapiport.impl.config.ForgeConfigRegistryImpl;
import net.fabricmc.api.ClientModInitializer;
import net.minecraftforge.fml.config.ModConfig;
import org.slf4j.Logger;

public class wpWallpaper implements ClientModInitializer {

    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    @Override
    public void onInitializeClient() {
        ForgeConfigRegistryImpl.INSTANCE.register("wp", ModConfig.Type.CLIENT,Config.SPEC);
        LOGGER.info("Wallpaper mod loaded.");
    }
}
