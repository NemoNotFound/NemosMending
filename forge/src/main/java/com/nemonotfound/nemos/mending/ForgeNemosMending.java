package com.nemonotfound.nemos.mending;

import com.blamejared.clumps.api.events.RepairEvent;
import com.nemonotfound.nemos.mending.helper.ClumpsRepairGearsHelper;
import net.minecraftforge.eventbus.api.bus.EventBus;
import net.minecraftforge.fml.common.Mod;

import static com.nemonotfound.nemos.mending.Constants.MOD_ID;

@Mod(MOD_ID)
public class ForgeNemosMending {

    public ForgeNemosMending() {
        Common.init();

        if (ClumpsRepairGearsHelper.isClumpsLoaded()) {
            EventBus.create(RepairEvent.class).addListener(this::onRepairEvent);
        }
    }

    private void onRepairEvent(RepairEvent event) {
        var xpValue = ClumpsRepairGearsHelper.repairDamagedMendingGears(event.getPlayer(), event.getValue());
        event.setValue(xpValue);
    }
}
