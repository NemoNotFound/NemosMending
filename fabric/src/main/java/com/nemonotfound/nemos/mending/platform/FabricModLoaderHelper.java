package com.nemonotfound.nemos.mending.platform;

import com.nemonotfound.nemos.mending.platform.services.IModLoaderHelper;
import net.fabricmc.loader.api.FabricLoader;

public class FabricModLoaderHelper implements IModLoaderHelper {

    @Override
    public boolean isModLoaded(String modId) {
        return FabricLoader.getInstance().isModLoaded(modId);
    }
}
