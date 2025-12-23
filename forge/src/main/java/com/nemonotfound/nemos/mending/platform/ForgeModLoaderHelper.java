package com.nemonotfound.nemos.mending.platform;

import com.nemonotfound.nemos.mending.platform.services.IModLoaderHelper;
import net.minecraftforge.fml.ModList;

public class ForgeModLoaderHelper implements IModLoaderHelper {

    @Override
    public boolean isModLoaded(String modId) {
        return ModList.get().isLoaded(modId);
    }
}