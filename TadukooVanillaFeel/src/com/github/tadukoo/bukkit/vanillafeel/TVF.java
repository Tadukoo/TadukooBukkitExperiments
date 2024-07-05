package com.github.tadukoo.bukkit.vanillafeel;

import org.bukkit.plugin.java.JavaPlugin;

public class TVF extends JavaPlugin{
	
	@Override
	public void onDisable(){ }
	
	@Override
	public void onEnable(){
		this.getServer().getPluginManager().registerEvents(new CommandListener(this), this);
	}
}
