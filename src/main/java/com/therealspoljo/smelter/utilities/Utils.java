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
		return new ItemStack(Utils.getSmeltedMaterial(itemStack.getType()), itemStack.getAmount());
    }

	public static Material getSmeltedMaterial(Material material) {
		switch (material) {
			case PORKCHOP: return Material.COOKED_PORKCHOP;
			case BEEF: return Material.COOKED_BEEF;
			case CHICKEN: return Material.COOKED_CHICKEN;
			case COD: return Material.COOKED_COD;	
			case SALMON: return Material.COOKED_SALMON;			
			case RABBIT: return Material.COOKED_RABBIT;			
			case MUTTON: return Material.COOKED_MUTTON;	
			case POTATO: return Material.BAKED_POTATO;	
			case RAW_IRON:
			case IRON_ORE:
				return Material.IRON_INGOT;	
			case RAW_GOLD:
			case NETHER_GOLD_ORE:
			case GOLD_ORE: 
				return Material.GOLD_INGOT;	
			case RAW_COPPER:
			case COPPER_ORE:
				return Material.COPPER_INGOT;	
			case ANCIENT_DEBRIS: return Material.NETHERITE_SCRAP;
			case SAND: return Material.GLASS;
			case SANDSTONE: return Material.SMOOTH_SANDSTONE;
			case RED_SANDSTONE: return Material.SMOOTH_RED_SANDSTONE;
			case COBBLESTONE: return Material.STONE;	
			case CLAY_BALL: return Material.BRICK;	
			case NETHERRACK: return Material.NETHER_BRICK;	
			case NETHER_BRICKS: return Material.CRACKED_NETHER_BRICKS;
			case STONE_BRICKS: return Material.CRACKED_STONE_BRICKS;
			case POLISHED_BLACKSTONE_BRICKS: return Material.CRACKED_POLISHED_BLACKSTONE_BRICKS;
			case COBBLED_DEEPSLATE: return Material.DEEPSLATE;
			case DEEPSLATE_BRICKS: return Material.CRACKED_DEEPSLATE_BRICKS;
			case DEEPSLATE_TILES: return Material.CRACKED_DEEPSLATE_TILES;
			case WHITE_TERRACOTTA: return Material.WHITE_GLAZED_TERRACOTTA;
			case ORANGE_TERRACOTTA: return Material.ORANGE_GLAZED_TERRACOTTA;
			case MAGENTA_TERRACOTTA: return Material.MAGENTA_GLAZED_TERRACOTTA;
			case LIGHT_BLUE_TERRACOTTA: return Material.LIGHT_BLUE_GLAZED_TERRACOTTA;
			case YELLOW_TERRACOTTA: return Material.YELLOW_GLAZED_TERRACOTTA;
			case LIME_TERRACOTTA: return Material.LIME_GLAZED_TERRACOTTA;
			case PINK_TERRACOTTA: return Material.PINK_GLAZED_TERRACOTTA;
			case GRAY_TERRACOTTA: return Material.GRAY_GLAZED_TERRACOTTA;
			case LIGHT_GRAY_TERRACOTTA: return Material.LIGHT_GRAY_GLAZED_TERRACOTTA;
			case CYAN_TERRACOTTA: return Material.CYAN_GLAZED_TERRACOTTA;
			case PURPLE_TERRACOTTA: return Material.PURPLE_GLAZED_TERRACOTTA;
			case BLUE_TERRACOTTA: return Material.BLUE_GLAZED_TERRACOTTA;
			case BROWN_TERRACOTTA: return Material.BROWN_GLAZED_TERRACOTTA;
			case GREEN_TERRACOTTA: return Material.GREEN_GLAZED_TERRACOTTA;
			case RED_TERRACOTTA: return Material.RED_GLAZED_TERRACOTTA;
			case BLACK_TERRACOTTA: return Material.BLACK_GLAZED_TERRACOTTA;
			case BASALT: return Material.SMOOTH_BASALT;
			case CLAY: return Material.TERRACOTTA;	
			case STONE: return Material.SMOOTH_STONE;
			case QUARTZ_BLOCK: return Material.SMOOTH_QUARTZ;
			case DIAMOND_ORE: return Material.DIAMOND;	
			case LAPIS_ORE: return Material.LAPIS_LAZULI;	
			case REDSTONE_ORE: return Material.REDSTONE;	
			case COAL_ORE: return Material.COAL;	
			case EMERALD_ORE: return Material.EMERALD;	
			case NETHER_QUARTZ_ORE: return Material.QUARTZ;
			case OAK_LOG:
			case SPRUCE_LOG:
			case BIRCH_LOG:
			case JUNGLE_LOG:
			case ACACIA_LOG:
			case DARK_OAK_LOG:
			case STRIPPED_ACACIA_LOG:
            case STRIPPED_BIRCH_LOG:
            case STRIPPED_DARK_OAK_LOG:
            case STRIPPED_JUNGLE_LOG:
            case STRIPPED_OAK_LOG:
            case STRIPPED_SPRUCE_LOG:
			case OAK_WOOD:
			case SPRUCE_WOOD:
			case BIRCH_WOOD:
			case JUNGLE_WOOD:
			case ACACIA_WOOD:
			case DARK_OAK_WOOD:
			case STRIPPED_OAK_WOOD:
			case STRIPPED_SPRUCE_WOOD:
			case STRIPPED_BIRCH_WOOD:
			case STRIPPED_JUNGLE_WOOD:
			case STRIPPED_ACACIA_WOOD:
			case STRIPPED_DARK_OAK_WOOD:
				return Material.CHARCOAL;	
			case CACTUS: return Material.GREEN_DYE;	
			case WET_SPONGE: return Material.SPONGE;	
			case CHORUS_FRUIT: return Material.POPPED_CHORUS_FRUIT;	
			case KELP: return Material.DRIED_KELP;
			case SEA_PICKLE: return Material.LIME_DYE;
			default: return null;
		}
	}

    public static boolean hasItemPerm(Player player, Material material) {
	player.hasPermission("smelter.item." + material.name().toLowerCase());
	return false;
    }

    // public static boolean isAFuel(ItemStack item) {
    // switch (item.getType()) {
    // case LAVA_BUCKET:
    // case COAL_BLOCK:
    // case BLAZE_ROD:
    // case COAL:
    // case LOG:
    // case LOG_2:
    // case WOOD:
    // case WOOD_PLATE:
    // case FENCE:
    // case ACACIA_FENCE:
    // case BIRCH_FENCE:
    // case DARK_OAK_FENCE:
    // case JUNGLE_FENCE:
    // case SPRUCE_FENCE:
    // case FENCE_GATE:
    // case ACACIA_FENCE_GATE:
    // case BIRCH_FENCE_GATE:
    // case DARK_OAK_FENCE_GATE:
    // case JUNGLE_FENCE_GATE:
    // case SPRUCE_FENCE_GATE:
    // case WOOD_STAIRS:
    // case ACACIA_STAIRS:
    // case BIRCH_WOOD_STAIRS:
    // case DARK_OAK_STAIRS:
    // case JUNGLE_WOOD_STAIRS:
    // case SPRUCE_WOOD_STAIRS:
    // case TRAP_DOOR:
    // case WORKBENCH:
    // case BOOKSHELF:
    // case CHEST:
    // case TRAPPED_CHEST:
    // case DAYLIGHT_DETECTOR:
    // case DAYLIGHT_DETECTOR_INVERTED:
    // case JUKEBOX:
    // case NOTE_BLOCK:
    // case HUGE_MUSHROOM_1:
    // case HUGE_MUSHROOM_2:
    // case BANNER:
    // case STANDING_BANNER:
    // case WALL_BANNER:
    // case WOOD_AXE:
    // case WOOD_HOE:
    // case WOOD_PICKAXE:
    // case WOOD_SPADE:
    // case WOOD_SWORD:
    // case DOUBLE_STEP:
    // case WOOD_DOUBLE_STEP:
    // case WOOD_STEP:
    // case SAPLING:
    // case STICK:
    // return true;
    // default:
    // return false;
    // }
    // }
}