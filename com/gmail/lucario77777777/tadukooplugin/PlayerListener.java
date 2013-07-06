package com.gmail.lucario77777777.tadukooplugin;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

@SuppressWarnings("deprecation")
public class PlayerListener implements Listener {
	public static Main plugin;
	public PlayerListener(Main instance){
		plugin = instance;
	}
	
	@EventHandler
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
	
}
