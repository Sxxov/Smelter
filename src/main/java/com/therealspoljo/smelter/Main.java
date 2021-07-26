package com.therealspoljo.smelter;

import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import com.therealspoljo.smelter.commands.Smelt;
import com.therealspoljo.smelter.commands.SmeltAll;
import com.therealspoljo.smelter.commands.Smelter;
import com.therealspoljo.smelter.utilities.Config;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

public class Main extends JavaPlugin {

    private static Main instance;

    private Economy economy = null;
    private Permission permission = null;

    private Config config, langConfig;

    @Override
    public void onEnable() {
	instance = this;

	if (!setupEconomy()) {
	    getLogger().warning("You need to install Vault for this plugin to work.");
	    getServer().getPluginManager().disablePlugin(this);
	    return;
	}

	config = Config.createConfig(this, "config");
	langConfig = Config.createConfig(this, "lang");

	registerCommands();
	setupPermissions();
    }

    @Override
    public void onDisable() {
	instance = null;

	economy = null;
	permission = null;

	config = null;
	langConfig = null;
    }

    private boolean setupEconomy() {
	if (getServer().getPluginManager().getPlugin("Vault") == null) {
	    return false;
	}

	RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);

	if (rsp == null) {
	    return false;
	}

	economy = rsp.getProvider();

	return economy != null;
    }

    private boolean setupPermissions() {
	RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);

	permission = rsp.getProvider();

	return permission != null;
    }

    private void registerCommands() {
	getCommand("smelt").setExecutor(new Smelt());
	getCommand("smeltall").setExecutor(new SmeltAll());
	getCommand("smelter").setExecutor(new Smelter());
    }

    public Config getLangConfig() {
	return langConfig;
    }

    @Override
    public Config getConfig() {
	return config;
    }

    public static Main getInstance() {
	return instance;
    }

    public Economy getEconomy() {
	return economy;
    }

    public Permission getPermission() {
	return permission;
    }
}