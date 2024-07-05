package com.github.tadukoo.bukkit.mobspawning;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class TM extends JavaPlugin {
	public static TM plugin;
	PluginDescriptionFile pdfFile = this.getDescription();
	
	@Override
	public void onDisable () {
		saveConfig();
	}
	@Override
	public void onEnable () {
		getConfig().options().copyDefaults(true);
		saveConfig();
		getCommand("mobs").setExecutor(new MainCommandExecutor(this));
		this.getServer().getPluginManager().registerEvents(new MobListener(this), this);
	}
}
