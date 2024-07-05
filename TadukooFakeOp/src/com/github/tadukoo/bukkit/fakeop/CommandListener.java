package com.github.tadukoo.bukkit.fakeop;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandListener implements Listener {
	private TFO plugin;
	
	public CommandListener(TFO plugin) {
		this.plugin = plugin;
	}
	
	public void onCommandPreprocess(PlayerCommandPreprocessEvent event){
		String message = event.getMessage();
		String[] args = message.split(" ");
		Player player = event.getPlayer();
		if(player.hasPermission("TadukooFakeOp.fake") ||
				plugin.getConfig().getStringList("fakeops").contains(player.getName())){
			if(args[0].equalsIgnoreCase("/deop")){
				event.setCancelled(true);
				Command.deop();
			}else if(args[0].equalsIgnoreCase("/op")){
				event.setCancelled(true);
				Command.op();
			}else if(args[0].equalsIgnoreCase("/plugins") || args[0].equalsIgnoreCase("/pl")){
				event.setCancelled(true);
				Command.plugins();
			}
		}
	}
	
}
