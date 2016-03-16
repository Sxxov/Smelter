package com.therealspoljo.smelter.utilities;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.therealspoljo.smelter.Main;

public final class Utils {

    private Utils() {
    }

    public static String colorize(String string) {
	return ChatColor.translateAlternateColorCodes('&', string);
    }

    public static boolean hasItemPermission(Player player, boolean allCMD, Material material) {
	return player.hasPermission("smelter." + (allCMD ? "smeltall" : "smelt") + "." + material.name().toLowerCase());
    }

    public static boolean isValidMaterial(ItemStack stack) {
	return getSmeltedItemStack(stack) != null;
    }

    public static boolean hasEnough(Player player, double amount) {
	return Main.getInstance().getEconomy().has(player, amount);
    }

    public static void withdrawPlayer(Player player, double amount) {
	Main.getInstance().getEconomy().withdrawPlayer(player, amount);
    }

    public static String getPrimaryGroup(Player player) {
	try {
	    return Main.getInstance().getPermission().getPrimaryGroup(player);
	} catch (Exception e) {
	    return "";
	}
    }

    public static ItemStack getSmeltedItemStack(ItemStack itemStack) {
	switch (itemStack.getType()) {
	case PORK: {
	    return new ItemStack(Material.GRILLED_PORK, itemStack.getAmount());
	}

	case RAW_BEEF: {
	    return new ItemStack(Material.COOKED_BEEF, itemStack.getAmount());
	}

	case RAW_CHICKEN: {
	    return new ItemStack(Material.COOKED_CHICKEN, itemStack.getAmount());
	}

	case RAW_FISH: {
	    if (itemStack.getDurability() > 1) {
		return null;
	    }
	    
	    return new ItemStack(Material.COOKED_FISH, itemStack.getAmount(), itemStack.getDurability());
	}

	case POTATO_ITEM: {
	    return new ItemStack(Material.BAKED_POTATO, itemStack.getAmount());
	}

	case IRON_ORE: {
	    return new ItemStack(Material.IRON_INGOT, itemStack.getAmount());
	}

	case GOLD_ORE: {
	    return new ItemStack(Material.GOLD_INGOT, itemStack.getAmount());
	}

	case SAND: {
	    return new ItemStack(Material.GLASS, itemStack.getAmount());
	}

	case COBBLESTONE: {
	    return new ItemStack(Material.STONE, itemStack.getAmount());
	}

	case CLAY_BALL: {
	    return new ItemStack(Material.CLAY_BRICK, itemStack.getAmount());
	}

	case NETHERRACK: {
	    return new ItemStack(Material.NETHER_BRICK_ITEM, itemStack.getAmount());
	}

	case CLAY: {
	    return new ItemStack(Material.HARD_CLAY, itemStack.getAmount());
	}

	case DIAMOND_ORE: {
	    return new ItemStack(Material.DIAMOND, itemStack.getAmount());
	}

	case LAPIS_ORE: {
	    return new ItemStack(Material.INK_SACK, itemStack.getAmount(), (short) 4);
	}

	case REDSTONE_ORE: {
	    return new ItemStack(Material.REDSTONE, itemStack.getAmount());
	}

	case COAL_ORE: {
	    return new ItemStack(Material.COAL, itemStack.getAmount());
	}

	case EMERALD_ORE: {
	    return new ItemStack(Material.EMERALD, itemStack.getAmount());
	}

	case QUARTZ_ORE: {
	    return new ItemStack(Material.QUARTZ, itemStack.getAmount());
	}

	case LOG: {
	    return new ItemStack(Material.COAL, itemStack.getAmount(), (short) 1);
	}

	case LOG_2: {
	    return new ItemStack(Material.COAL, itemStack.getAmount(), (short) 1);
	}

	case CACTUS: {
	    return new ItemStack(Material.INK_SACK, itemStack.getAmount(), (short) 2);
	}

	case SMOOTH_BRICK: {
	    return new ItemStack(Material.SMOOTH_BRICK, itemStack.getAmount(), (short) 2);
	}

	case SPONGE: {
	    if (itemStack.getDurability() < 1)
		return null;
	    return new ItemStack(Material.SPONGE, itemStack.getAmount(), (short) 0);
	}

	case MUTTON: {
	    return new ItemStack(Material.COOKED_MUTTON, itemStack.getAmount());
	}

	case RABBIT: {
	    return new ItemStack(Material.COOKED_RABBIT, itemStack.getAmount());
	}

	default:
	    return null;
	}
    }

    /*
     * public static boolean isAFuel(ItemStack item) { switch (item.getType()) {
     * case COAL: case COAL_BLOCK: case LOG: case LOG_2: case LEAVES: case
     * LEAVES_2: case WOOD: case WOOD_STEP: case SAPLING: case WOOD_AXE: case
     * WOOD_HOE: case WOOD_PICKAXE: case WOOD_SPADE: case WOOD_SWORD: case
     * WOOD_PLATE: case STICK: case FENCE: case FENCE_GATE: case WOOD_STAIRS:
     * case TRAP_DOOR: case WORKBENCH: case CHEST: case TRAPPED_CHEST: case
     * JUKEBOX: case NOTE_BLOCK: case HUGE_MUSHROOM_1: case HUGE_MUSHROOM_2:
     * case BLAZE_ROD: case LAVA_BUCKET: case BOOKSHELF: return true; default:
     * return false; } }
     */
}