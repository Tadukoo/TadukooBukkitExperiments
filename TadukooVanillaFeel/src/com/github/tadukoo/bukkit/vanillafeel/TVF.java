package com.github.tadukoo.bukkit.vanillafeel;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class TVF extends JavaPlugin {
	public static TVF plugin;
	PluginDescriptionFile pdfFile = this.getDescription();
	public static FileConfiguration config;
	
	@Override
	public void onDisable () {
		
	}
	@Override
	public void onEnable () {
		this.getServer().getPluginManager().registerEvents(new CommandListener(this), this);
	}
}
