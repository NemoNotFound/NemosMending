package com.nemonotfound.nemos.mending.mixin;

import com.nemonotfound.nemos.mending.helper.ClumpsRepairGearsHelper;
import com.nemonotfound.nemos.mending.helper.RepairGearHelper;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ExperienceOrb.class)
public class ExperienceOrbMixin {

    @ModifyVariable(method = "playerTouch", at = @At("STORE"), ordinal = 0)
    private int init(int original, @Local(argsOnly = true) Player player) {
        int amount = original;

        if (!ClumpsRepairGearsHelper.isClumpsLoaded() && amount > 0) {
            final Inventory inventory = player.getInventory();

            for (int i = 0; i < inventory.getContainerSize(); i++) {
                final ItemStack itemStack = inventory.getItem(i);

                if (RepairGearHelper.isRepairable(itemStack)) {
                    amount = RepairGearHelper.repairPlayerGear(itemStack, amount);
                }
            }
        }

        return amount;
    }
}
