package com.gmail.lucario77777777.tadukooplugin;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class tadukoopluginmain extends JavaPlugin {
    public final Logger logger = Logger.getLogger("Minecraft");
  public static tadukoopluginmain plugin;
	@Override
	public void onDisable () {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Has Been Disabled!");
	}
	@Override
	public void onEnable () {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Version " + pdfFile.getVersion() + " Has Been Enabled!");
		getCommand("ping").setExecutor(new TadukooPluginCommandExecutor(this));
		getCommand("tport").setExecutor(new TadukooPluginCommandExecutor(this));
		getCommand("heal").setExecutor(new TadukooPluginCommandExecutor(this));
		getCommand("kill").setExecutor(new TadukooPluginCommandExecutor(this));
		getCommand("feed").setExecutor(new TadukooPluginCommandExecutor(this));
		getCommand("starve").setExecutor(new TadukooPluginCommandExecutor(this));
		getCommand("suicide").setExecutor(new TadukooPluginCommandExecutor(this));
		getCommand("thelp").setExecutor(new TadukooPluginCommandExecutor(this));
		this.getServer().getPluginManager().registerEvents(new MyBlockListener(null), this);
		this.getServer().getPluginManager().registerEvents(new MyPlayerListener(null), this);
	}
}
