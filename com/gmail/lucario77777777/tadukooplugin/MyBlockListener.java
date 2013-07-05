package com.gmail.lucario77777777.tadukooplugin;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class MyBlockListener implements Listener{
  public static tadukoopluginmain plugin;
	public static Material[] blacklist = {Material.TNT, Material.BEDROCK};
	
	public MyBlockListener(tadukoopluginmain instance) {
		plugin = instance;
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event){
		Material block = event.getBlock().getType();
		Player player = event.getPlayer();
		
		for(Material blocked : blacklist){
			if(blocked == block){
				if(player.isOp()){}else{
					event.getBlock().setType(Material.AIR);
					player.chat("I just placed " + ChatColor.DARK_RED + blocked);
				}
			}
		}
	}
}
