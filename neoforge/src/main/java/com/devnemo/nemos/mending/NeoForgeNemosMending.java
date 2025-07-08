package com.devnemo.nemos.mending;


import com.blamejared.clumps.api.events.RepairEvent;
import com.devnemo.nemos.mending.helper.ClumpsRepairGearsHelper;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;

import static com.devnemo.nemos.mending.Constants.MOD_ID;

@Mod(MOD_ID)
public class NeoForgeNemosMending {

    public NeoForgeNemosMending() {
        Common.init();

        if (ClumpsRepairGearsHelper.isClumpsLoaded()) {
            NeoForge.EVENT_BUS.addListener(this::onRepairEvent);
        }
    }

    private void onRepairEvent(RepairEvent event) {
        var xpValue = ClumpsRepairGearsHelper.repairDamagedMendingGears(event.getPlayer(), event.getValue());
        event.setValue(xpValue);
    }
}