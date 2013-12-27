package com.gmail.lucario77777777.tadukooplugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.lucario77777777.tadukooplugin.commands.MainCommandExecutor;

public class Main extends JavaPlugin {
    public final Logger logger = Logger.getLogger("Minecraft");
	public static Main plugin;
	public final BukkitLogger blo = new BukkitLogger(this);
	public static boolean enabled = true;
	public FileConfiguration commands = null;
	public File commandsFile = null;
	public FileConfiguration warps = null;
	public File warpsFile = null;
	
	@Override
	public void onDisable () {
		blo.enabled(!enabled);
		saveConfig();
		saveCommandsConfig();
	}
	@Override
	public void onEnable () {
		/*
		 * Bukkit Logger
		 */
		blo.enabled(enabled);
		
		/*
		 * Config Files
		 */
		getConfig().options().copyDefaults(true);
		saveConfig();
		reloadCommandsConfig();
		getCommandsConfig().options().copyDefaults(true);
		saveCommandsConfig();
//		getConfig().getString("MOTD").replaceAll("&", "\u00A7");
		
		/*
		 * Cheat Commands
		 */
		getCommand("adventure").setExecutor(new MainCommandExecutor(this));
		getCommand("creative").setExecutor(new MainCommandExecutor(this));
		getCommand("day").setExecutor(new MainCommandExecutor(this));
		getCommand("feed").setExecutor(new MainCommandExecutor(this));
		getCommand("fly").setExecutor(new MainCommandExecutor(this));
		getCommand("gamemode").setExecutor(new MainCommandExecutor(this));
		getCommand("gm").setExecutor(new MainCommandExecutor(this));
		getCommand("gma").setExecutor(new MainCommandExecutor(this));
		getCommand("gmc").setExecutor(new MainCommandExecutor(this));
		getCommand("gms").setExecutor(new MainCommandExecutor(this));
		getCommand("gmt").setExecutor(new MainCommandExecutor(this));
		getCommand("heal").setExecutor(new MainCommandExecutor(this));
		getCommand("night").setExecutor(new MainCommandExecutor(this));
		getCommand("starve").setExecutor(new MainCommandExecutor(this));
		getCommand("survival").setExecutor(new MainCommandExecutor(this));
		getCommand("time").setExecutor(new MainCommandExecutor(this));
		
		/*
		 * General Commands
		 */
		getCommand("motd").setExecutor(new MainCommandExecutor(this));
		getCommand("suicide").setExecutor(new MainCommandExecutor(this));
		getCommand("thelp").setExecutor(new MainCommandExecutor(this));
		
		/*
		 * Moderator Commands
		 */
		getCommand("countdown").setExecutor(new MainCommandExecutor(this));
		getCommand("kill").setExecutor(new MainCommandExecutor(this));
		getCommand("killall").setExecutor(new MainCommandExecutor(this));
		getCommand("ping").setExecutor(new MainCommandExecutor(this));
		getCommand("rain").setExecutor(new MainCommandExecutor(this));
		getCommand("storm").setExecutor(new MainCommandExecutor(this));
		getCommand("sun").setExecutor(new MainCommandExecutor(this));
		
		/*
		 * Teleportation Commands
		 */
		getCommand("delwarp").setExecutor(new MainCommandExecutor(this));
		getCommand("setwarp").setExecutor(new MainCommandExecutor(this));
		getCommand("tp").setExecutor(new MainCommandExecutor(this));
		getCommand("warp").setExecutor(new MainCommandExecutor(this));
		
		/*
		 * Listeners
		 */
		this.getServer().getPluginManager().registerEvents(new BlockListener(null), this);
		this.getServer().getPluginManager().registerEvents(new PlayerListener(null), this);
	}
	
	public void reloadCommandsConfig() {
	    if (commandsFile == null) {
	    commandsFile = new File(getDataFolder(), "commands.yml");
	    }
	    commands = YamlConfiguration.loadConfiguration(commandsFile);
	 
	    // Look for defaults in the jar
	    InputStream defConfigStream = this.getResource("commands.yml");
	    if (defConfigStream != null) {
	        YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
	        commands.setDefaults(defConfig);
	    }
	}
	
	public FileConfiguration getCommandsConfig() {
	    if (commands == null) {
	        this.reloadCommandsConfig();
	    }
	    return commands;
	}
	
	public void saveCommandsConfig() {
	    if (commands == null || commandsFile == null) {
	    return;
	    }
	    try {
	        getCommandsConfig().save(commandsFile);
	    } catch (IOException ex) {
	        this.getLogger().log(Level.SEVERE, "Could not save config to " + commandsFile + ex);
	    }
	}
	public void reloadWarpsConfig() {
	    if (warpsFile == null) {
	    warpsFile = new File(getDataFolder(), "warps.yml");
	    }
	    warps = YamlConfiguration.loadConfiguration(warpsFile);
	 
	    // Look for defaults in the jar
	    InputStream defConfigStream = this.getResource("warps.yml");
	    if (defConfigStream != null) {
	        YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
	        warps.setDefaults(defConfig);
	    }
	}
	
	public FileConfiguration getWarpsConfig() {
	    if (warps == null) {
	        this.reloadWarpsConfig();
	    }
	    return warps;
	}
	
	public void saveWarpsConfig() {
	    if (warps == null || warpsFile == null) {
	    return;
	    }
	    try {
	        getWarpsConfig().save(warpsFile);
	    } catch (IOException ex) {
	        this.getLogger().log(Level.SEVERE, "Could not save config to " + warpsFile + ex);
	    }
	}
}
