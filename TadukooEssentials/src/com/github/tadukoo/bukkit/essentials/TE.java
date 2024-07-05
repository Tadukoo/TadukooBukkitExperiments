package com.github.tadukoo.bukkit.essentials;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.tadukoo.bukkit.essentials.commands.CommandExec;

public class TE extends JavaPlugin {
    public final Logger logger = Logger.getLogger("Minecraft");
	public static TE plugin;
	public static boolean enabled = true;
	public FileConfiguration commands = null;
	public File commandsFile = null;
	public FileConfiguration warps = null;
	public File warpsFile = null;
	public FileConfiguration warpsList = null;
	public File warpsListFile = null;
	
	@Override
	public void onDisable () {
		saveConfig();
		saveCommandsConfig();
	}
	@Override
	public void onEnable () {		
		/*
		 * Config Files
		 */
		getConfig().options().copyDefaults(true);
		saveConfig();
		reloadCommandsConfig();
		getCommandsConfig().options().copyDefaults(true);
		saveCommandsConfig();
		
		getCommand("t").setExecutor(new CommandExec (this));
		
		/*
		 * Cheat Commands
		 */
		getCommand("adventure").setExecutor(new CommandExec(this));
		getCommand("creative").setExecutor(new CommandExec(this));
		getCommand("day").setExecutor(new CommandExec(this));
		getCommand("feed").setExecutor(new CommandExec(this));
		getCommand("fly").setExecutor(new CommandExec(this));
		getCommand("gamemode").setExecutor(new CommandExec(this));
		getCommand("gm").setExecutor(new CommandExec(this));
		getCommand("gma").setExecutor(new CommandExec(this));
		getCommand("gmc").setExecutor(new CommandExec(this));
		getCommand("gms").setExecutor(new CommandExec(this));
		getCommand("gmt").setExecutor(new CommandExec(this));
		getCommand("heal").setExecutor(new CommandExec(this));
		getCommand("night").setExecutor(new CommandExec(this));
		getCommand("starve").setExecutor(new CommandExec(this));
		getCommand("survival").setExecutor(new CommandExec(this));
		getCommand("time").setExecutor(new CommandExec(this));
		
		/*
		 * General Commands
		 */
		getCommand("motd").setExecutor(new CommandExec(this));
		getCommand("suicide").setExecutor(new CommandExec(this));
		getCommand("thelp").setExecutor(new CommandExec(this));
		
		/*
		 * Moderator Commands
		 */
		getCommand("countdown").setExecutor(new CommandExec(this));
		getCommand("kill").setExecutor(new CommandExec(this));
		getCommand("killall").setExecutor(new CommandExec(this));
		getCommand("ping").setExecutor(new CommandExec(this));
		getCommand("rain").setExecutor(new CommandExec(this));
		getCommand("storm").setExecutor(new CommandExec(this));
		getCommand("sun").setExecutor(new CommandExec(this));
		getCommand("weather").setExecutor(new CommandExec(this));
		
		/*
		 * Teleportation Commands
		 */
		getCommand("delwarp").setExecutor(new CommandExec(this));
		getCommand("setwarp").setExecutor(new CommandExec(this));
		getCommand("tp").setExecutor(new CommandExec(this));
		getCommand("warp").setExecutor(new CommandExec(this));
		
		/*
		 * Listeners
		 */
		this.getServer().getPluginManager().registerEvents(new BlockListener(this), this);
		this.getServer().getPluginManager().registerEvents(new PlayerListener(this), this);
	}
	
	public void reloadCommandsConfig() {
	    if (commandsFile == null) {
	    commandsFile = new File(getDataFolder(), "commands.yml");
	    }
	    commands = YamlConfiguration.loadConfiguration(commandsFile);
	 
	    // Look for defaults in the jar
	    Reader defConfigFile = this.getTextResource("commands.yml");
	    if (defConfigFile != null) {
			YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigFile);
	        commands.setDefaults(defConfig);
	    }else{
	    	this.getLogger().log(Level.WARNING, "Couldn't find commands.yml!");
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
	    Reader defConfigFile = this.getTextResource("warps.yml");
	    if (defConfigFile != null) {
			YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigFile);
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
	public void reloadWarpsListConfig() {
	    if (warpsListFile == null) {
	    warpsListFile = new File(getDataFolder(), "warpslist.yml");
	    }
	    warpsList = YamlConfiguration.loadConfiguration(warpsListFile);
	 
	    // Look for defaults in the jar
	    Reader defConfigFile = this.getTextResource("warplist.yml");
	    if (defConfigFile != null) {
	        YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigFile);
	        warpsList.setDefaults(defConfig);
	    }
	}
	
	public FileConfiguration getWarpsListConfig() {
	    if (warpsList == null) {
	        this.reloadWarpsListConfig();
	    }
	    return warpsList;
	}
	
	public void saveWarpsListConfig() {
	    if (warpsList == null || warpsListFile == null) {
	    return;
	    }
	    try {
	        getWarpsListConfig().save(warpsListFile);
	    } catch (IOException ex) {
	        this.getLogger().log(Level.SEVERE, "Could not save config to " + warpsListFile + ex);
	    }
	}
}
