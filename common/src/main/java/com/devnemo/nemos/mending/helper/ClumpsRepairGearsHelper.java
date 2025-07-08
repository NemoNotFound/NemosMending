package com.devnemo.nemos.mending.helper;

import com.devnemo.nemos.mending.platform.Services;
import net.minecraft.world.entity.player.Player;

public class ClumpsRepairGearsHelper {

    public static boolean isClumpsLoaded() {
        return Services.MOD_LOADER_HELPER.isModLoaded("clumps");
    }

    public static int repairDamagedMendingGears(Player player, int xpValue) {
        final var inventory = player.getInventory();

        for(var i = 0; i < inventory.getContainerSize(); i++) {
            final var itemStack = inventory.getItem(i);

            if(RepairGearHelper.isRepairable(itemStack)) {
                xpValue = RepairGearHelper.repairPlayerGear(itemStack, xpValue);
            }
        }

        return xpValue;
    }
}
