package com.gmail.lucario77777777.tadukooplugin;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.lucario77777777.tadukooplugin.commands.MainCommandExecutor;

public class Main extends JavaPlugin {
    public final Logger logger = Logger.getLogger("Minecraft");
	public static Main plugin;
	public final BukkitLogger blo = new BukkitLogger(this);
	
	@Override
	public void onDisable () {
		blo.enabled(false);
		saveConfig();
	}
	@Override
	public void onEnable () {
		blo.enabled(true);
		getConfig().options().copyDefaults(true);
		saveConfig();
//		getConfig().getString("MOTD").replaceAll("&", "\u00A7");
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
		getCommand("killall").setExecutor(new MainCommandExecutor(this));
		getCommand("motd").setExecutor(new MainCommandExecutor(this));
		getCommand("time").setExecutor(new MainCommandExecutor(this));
		getCommand("timer").setExecutor(new MainCommandExecutor(this));
		getCommand("day").setExecutor(new MainCommandExecutor(this));
		getCommand("night").setExecutor(new MainCommandExecutor(this));
		//getCommand("setwarp").setExecutor(new MainCommandExecutor(this)); Removed until a later version.
		getCommand("thelp").setExecutor(new MainCommandExecutor(this));
		this.getServer().getPluginManager().registerEvents(new BlockListener(null), this);
		this.getServer().getPluginManager().registerEvents(new PlayerListener(null), this);
	}
}
