package com.gmail.lucario77777777.tadukooplugin;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public final Logger logger = Logger.getLogger("Minecraft");
	public static Main plugin;
	@Override
	public void onDisable () {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Has Been Disabled!");
	}
	@Override
	public void onEnable () {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Version " + pdfFile.getVersion() + " Has Been Enabled!");
		getCommand("ping").setExecutor(new MainCommandExecutor(this));
		getCommand("tport").setExecutor(new MainCommandExecutor(this));
		getCommand("heal").setExecutor(new MainCommandExecutor(this));
		getCommand("kill").setExecutor(new MainCommandExecutor(this));
		getCommand("feed").setExecutor(new MainCommandExecutor(this));
		getCommand("starve").setExecutor(new MainCommandExecutor(this));
		getCommand("suicide").setExecutor(new MainCommandExecutor(this));
		getCommand("gamemode").setExecutor(new MainCommandExecutor(this));
		getCommand("gm").setExecutor(new MainCommandExecutor(this));
		getCommand("gmt").setExecutor(new MainCommandExecutor(this));
		getCommand("adventure").setExecutor(new MainCommandExecutor(this));
		getCommand("gma").setExecutor(new MainCommandExecutor(this));
		getCommand("creative").setExecutor(new MainCommandExecutor(this));
		getCommand("gmc").setExecutor(new MainCommandExecutor(this));
		getCommand("survival").setExecutor(new MainCommandExecutor(this));
		getCommand("gms").setExecutor(new MainCommandExecutor(this));
		getCommand("fly").setExecutor(new MainCommandExecutor(this));
		getCommand("thelp").setExecutor(new MainCommandExecutor(this));
		this.getServer().getPluginManager().registerEvents(new BlockListener(null), this);
		this.getServer().getPluginManager().registerEvents(new PlayerListener(null), this);
	}
}
