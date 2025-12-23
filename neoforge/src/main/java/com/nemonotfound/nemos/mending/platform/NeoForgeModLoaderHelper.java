package com.nemonotfound.nemos.mending.platform;

import com.nemonotfound.nemos.mending.platform.services.IModLoaderHelper;
import net.neoforged.fml.ModList;

public class NeoForgeModLoaderHelper implements IModLoaderHelper {

    @Override
    public boolean isModLoaded(String modId) {
        return ModList.get().isLoaded(modId);
    }
}