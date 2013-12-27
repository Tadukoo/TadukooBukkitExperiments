package com.gmail.lucario77777777.tadukooplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
//import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent;

public class PlayerListener implements Listener {
	public Main plugin;
	public PlayerListener(Main parent){
		this.plugin = parent;
	}
	
	@EventHandler(priority = EventPriority.HIGH)
	//Still doesn't work.
	public void onPlayerLogin(final PlayerLoginEvent event){
	    if(!this.plugin.getConfig().getString("motd").isEmpty()){
	    	String motd = this.plugin.getConfig().getString("motd");
			(event.getPlayer()).sendMessage(motd);
		}
	}
	@EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerChat(final AsyncPlayerChatEvent event){
		Player player = event.getPlayer();
/*		if(event.getMessage().contains("&")){
			event.getMessage().replace("&", "\u00A7");
		}*/
		if(event.getMessage().toLowerCase().contains("heal")){
			player.setHealth(20);
			player.setFoodLevel(20);
			player.sendMessage(ChatColor.GREEN + "Healed!");
		}else if(event.getMessage().toLowerCase().contains("kill")){
			player.setHealth(0);
			player.sendMessage(ChatColor.DARK_RED + "You died!");
		}else if(event.getMessage().toLowerCase().contains("sendme")){
			player.sendMessage("Send You!");
		}
	}
	@EventHandler(priority = EventPriority.LOW)
	public void onPlayerInteract(PlayerInteractEvent event){
		Player player = event.getPlayer();
		Material blockId = player.getItemInHand().getType();
		if(blockId == Material.STICK){
			Block block = player.getTargetBlock(null, 50);
			Location location = block.getLocation();
			World world = player.getWorld();
			world.createExplosion(location, 5);
		}else if(blockId == Material.BONE){
			Block block = player.getTargetBlock(null, 50);
			Location location = block.getLocation();
			World world = player.getWorld();
			world.strikeLightning(location);
			Bukkit.broadcastMessage("Lightning strike!");
		}
	}
	
}
