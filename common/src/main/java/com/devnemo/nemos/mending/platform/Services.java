package com.devnemo.nemos.mending.platform;

import com.devnemo.nemos.mending.Constants;
import com.devnemo.nemos.mending.platform.services.IModLoaderHelper;

import java.util.ServiceLoader;

public class Services {

    public static final IModLoaderHelper MOD_LOADER_HELPER = load(IModLoaderHelper.class);

    public static <T> T load(Class<T> clazz) {
        final T loadedService = ServiceLoader.load(clazz)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Failed to load service for " + clazz.getName()));

        Constants.LOG.debug("Loaded {} for service {}", loadedService, clazz);

        return loadedService;
    }
}