package com.devnemo.nemos.mending.platform;

import com.devnemo.nemos.mending.platform.services.IModLoaderHelper;
import net.fabricmc.loader.api.FabricLoader;

public class FabricModLoaderHelper implements IModLoaderHelper {

    @Override
    public boolean isModLoaded(String modId) {
        return FabricLoader.getInstance().isModLoaded(modId);
    }
}
