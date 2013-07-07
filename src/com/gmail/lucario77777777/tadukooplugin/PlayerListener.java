package com.gmail.lucario77777777.tadukooplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
//import org.bukkit.event.player.PlayerJoinEvent;

@SuppressWarnings("deprecation")
public class PlayerListener implements Listener {
	public static Main plugin;
	public PlayerListener(Main instance){
		plugin = instance;
	}
	
	@EventHandler
	/* Feature not working right. Temporarily disabled.
	public void onPlayerJoin(PlayerJoinEvent event){
		Player player = event.getPlayer();
		player.sendMessage(plugin.getConfig().getString("MOTD"));
	}
	*/
	public void onPlayerChat(PlayerChatEvent event){
		Player player = event.getPlayer();
		
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
	public void onPlayerInteract(PlayerInteractEvent event){
		Player player = event.getPlayer();
		int blockId = player.getItemInHand().getType().getId();
		if(blockId == 280){
			Block block = player.getTargetBlock(null, 50);
			Location location = block.getLocation();
			World world = player.getWorld();
			world.createExplosion(location, 5);
		}else if(blockId == 352){
			Block block = player.getTargetBlock(null, 50);
			Location location = block.getLocation();
			World world = player.getWorld();
			world.strikeLightning(location);
			Bukkit.broadcastMessage("Lightning strike!");
		}
	}
	
}
