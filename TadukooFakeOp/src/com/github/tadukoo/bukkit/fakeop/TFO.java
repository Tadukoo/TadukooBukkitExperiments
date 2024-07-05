package com.github.tadukoo.bukkit.fakeop;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class TFO extends JavaPlugin {
	public static TFO plugin;
	PluginDescriptionFile pdfFile = this.getDescription();
	public static FileConfiguration config;
	
	@Override
	public void onDisable () {
		
	}
	@Override
	public void onEnable () {
		config = getConfig();
		saveDefaultConfig();
		this.getServer().getPluginManager().registerEvents(new CommandListener(this), this);
	}
}
