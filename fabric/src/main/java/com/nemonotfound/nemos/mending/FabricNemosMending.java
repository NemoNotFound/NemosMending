package com.nemonotfound.nemos.mending;

import com.blamejared.clumps.api.events.ClumpsEvents;
import net.fabricmc.api.ModInitializer;

import static com.nemonotfound.nemos.mending.helper.ClumpsRepairGearsHelper.isClumpsLoaded;
import static com.nemonotfound.nemos.mending.helper.ClumpsRepairGearsHelper.repairDamagedMendingGears;

public class FabricNemosMending implements ModInitializer {
    
    @Override
    public void onInitialize() {
        Common.init();

        if (isClumpsLoaded()) {
            ClumpsEvents.REPAIR_EVENT.register(event -> {
                var xpValue = repairDamagedMendingGears(event.getPlayer(), event.getValue());
                event.setValue(xpValue);

                return null;
            });
        }
    }
}
