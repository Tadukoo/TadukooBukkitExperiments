package com.github.tadukoo.bukkit.mobspawning;

import java.util.logging.Level;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class MobListener implements Listener{
	private TM plugin;
	
	public MobListener(TM plugin){
		this.plugin = plugin;
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onCreatureSpawn(CreatureSpawnEvent event){
		EntityType mob = event.getEntityType();
		String mobName = mob.getName().toUpperCase();
		if(plugin.getConfig().contains(mobName) && plugin.getConfig().getBoolean(mobName) == false){
			event.setCancelled(true);
			if(plugin.getConfig().getBoolean("debug")){
				plugin.getLogger().log(Level.INFO, "Prevented " + mobName + " from spawning.");
			}
		}
	}
}
