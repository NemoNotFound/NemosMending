package com.devnemo.nemos.mending.helper;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.enchantment.EnchantmentHelper;

public class RepairGearHelper {

    public static int repairPlayerGear(ItemStack itemStack, int xpValue) {
        if (itemStack.isDamaged()) {
            var repairAmount = Math.min(getMendingRepairAmount(xpValue), itemStack.getDamageValue());
            itemStack.setDamageValue(itemStack.getDamageValue() - repairAmount);
            var newXpValue = xpValue - getMendingRepairCost(repairAmount);

            return newXpValue > 0 ? repairPlayerGear(itemStack, newXpValue) : 0;
        }

        return xpValue;
    }

    public static boolean isRepairable(ItemStack itemStack) {
        return itemStack.isDamaged() && EnchantmentHelper.has(itemStack, EnchantmentEffectComponents.REPAIR_WITH_XP);
    }

    private static int getMendingRepairCost(int repairAmount) {
        return repairAmount / 2;
    }

    private static int getMendingRepairAmount(int experienceAmount) {
        return experienceAmount * 2;
    }

}
