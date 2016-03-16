package com.therealspoljo.smelter.utilities;

import org.bukkit.Material;

import com.therealspoljo.smelter.Main;

public final class ConfigUtils {

    private ConfigUtils() {
    }

    public static boolean isPerItemPermission() {
	return Main.getInstance().getConfig().getBoolean("per-item-permissions", false);
    }

    public static Material getMaterialForSmelting() {
	Material material = Material.getMaterial(Main.getInstance().getConfig().getString("items-required-for-smelting.item", "COAL"));

	if (material == null) {
	    return Material.COAL;
	}

	return material;
    }

    public static boolean isEconomy() {
	return !Main.getInstance().getConfig().getBoolean("items-required-for-smelting.enabled", false);
    }

    public static double getSmeltPerRankCost(String rank) {
	return Main.getInstance().getConfig().getDouble("ranks." + rank + ".cost", 0);
    }

    public static long getSmeltPerRankCooldown(String rank, boolean all) {
	String key = all ? "all" : "one";

	return Main.getInstance().getConfig().getLong("ranks." + rank + ".cooldown." + key, 0);
    }

    public static String getMessage(String value) {
	return Main.getInstance().getConfig().getString("messages." + value, "null");
    }

    public static String getPrefix() {
	return getMessage("prefix");
    }
}