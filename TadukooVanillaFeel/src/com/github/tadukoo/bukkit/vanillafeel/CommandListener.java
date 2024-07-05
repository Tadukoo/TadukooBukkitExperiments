package com.github.tadukoo.bukkit.vanillafeel;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandListener implements Listener{
	private TVF plugin;
	
	public CommandListener(TVF plugin){
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onCommandPreprocess(PlayerCommandPreprocessEvent event){
		String message = event.getMessage();
		String[] args = message.split(" ");
		Player player = event.getPlayer();
		if((args[0].equalsIgnoreCase("/help") || args[0].equalsIgnoreCase("/?") || 
				args[0].equalsIgnoreCase("/bukkit:help") || args[0].equalsIgnoreCase("/bukkit:?")) && 
				!player.hasPermission("TadukooVanillaFeel.normal")){
			event.setCancelled(true);
			Commands.help(player, message);
		}else if((args[0].equalsIgnoreCase("/plugins") || args[0].equalsIgnoreCase("/pl") || 
				args[0].equalsIgnoreCase("/bukkit:plugins") || args[0].equalsIgnoreCase("/bukkit:pl")) && 
				!player.hasPermission("TadukooVanillaFeel.normal")){
			event.setCancelled(true);
			Commands.plugins(player, message);
		}else if((args[0].equalsIgnoreCase("/version") || args[0].equalsIgnoreCase("/ver") || 
				args[0].equalsIgnoreCase("/about") || args[0].equalsIgnoreCase("/bukkit:version") ||
				args[0].equalsIgnoreCase("/bukkit:ver") || args[0].equalsIgnoreCase("/bukkit:about"))
				&& !player.hasPermission("TadukooVanillaFeel.normal")){
			if(args.length > 1){
				event.setCancelled(true);
				Commands.version(player, message);
			}else{
				return;
			}
		}else if((args[0].equalsIgnoreCase("/msg") || args[0].equalsIgnoreCase("/w") ||
				args[0].equalsIgnoreCase("/tell") || args[0].equalsIgnoreCase("/bukkit:msg") ||
				args[0].equalsIgnoreCase("/bukkit:w") || args[0].equalsIgnoreCase("/bukkit:tell"))
				&& !player.hasPermission("TadukooVanillaFeel.normal")){
			event.setCancelled(true);
			Commands.tell(plugin, player, message);
		}else if((args[0].equalsIgnoreCase("/kill") || args[0].equalsIgnoreCase("/bukkit:kill"))
				&& !player.hasPermission("TadukooVanillaFeel.normal")){
			event.setCancelled(true);
			Commands.kill(plugin, player);
		}else if((args[0].equalsIgnoreCase("/me") || args[0].equalsIgnoreCase("/bukkit:me"))
				&& !player.hasPermission("TadukooVanillaFeel.normal")){
			event.setCancelled(true);
			Commands.me(plugin, player, message);
		}else if((args[0].equalsIgnoreCase("/achievement") || 
				args[0].equalsIgnoreCase("/bukkit:achievement") ||
				args[0].equalsIgnoreCase("/ban") || args[0].equalsIgnoreCase("/bukkit:ban") || 
				args[0].equalsIgnoreCase("/ban-ip") || args[0].equalsIgnoreCase("/bukkit:ban-ip") ||
				args[0].equalsIgnoreCase("/banlist") || args[0].equalsIgnoreCase("/bukkit:banlist") ||
				args[0].equalsIgnoreCase("/clear") || args[0].equalsIgnoreCase("/bukkit:clear") ||
				args[0].equalsIgnoreCase("/defaultgamemode") || 
				args[0].equalsIgnoreCase("/bukkit:defaultgamemode") ||
				args[0].equalsIgnoreCase("/deop") || args[0].equalsIgnoreCase("/bukkit:deop") ||
				args[0].equalsIgnoreCase("/difficulty") || args[0].equalsIgnoreCase("/bukkit:difficulty") ||
				args[0].equalsIgnoreCase("/effect") || args[0].equalsIgnoreCase("/bukkit:effect") ||
				args[0].equalsIgnoreCase("/enchant") || args[0].equalsIgnoreCase("/bukkit:enchant") ||
				args[0].equalsIgnoreCase("/gamemode") || args[0].equalsIgnoreCase("/bukkit:gamemode") ||
				args[0].equalsIgnoreCase("/gamerule") || args[0].equalsIgnoreCase("/bukkit:gamerule") ||
				args[0].equalsIgnoreCase("/give") || args[0].equalsIgnoreCase("/bukkit:give") ||
				args[0].equalsIgnoreCase("/kick") || args[0].equalsIgnoreCase("/bukkit:kick") ||
				args[0].equalsIgnoreCase("/list") || args[0].equalsIgnoreCase("/bukkit:list") ||
				args[0].equalsIgnoreCase("/minecraft:achievement") || 
				args[0].equalsIgnoreCase("/minecraft:ban") || args[0].equalsIgnoreCase("/minecraft:ban-ip") ||
				args[0].equalsIgnoreCase("/minecraft:banlist") || 
				args[0].equalsIgnoreCase("/minecraft:clear")||
				args[0].equalsIgnoreCase("/minecraft:defaultgamemode") || 
				args[0].equalsIgnoreCase("/minecraft:deop") || 
				args[0].equalsIgnoreCase("/minecraft:difficulty") ||
				args[0].equalsIgnoreCase("/minecraft:effect") || 
				args[0].equalsIgnoreCase("/minecraft:enchant")|| 
				args[0].equalsIgnoreCase("/minecraft:gamemode")|| 
				args[0].equalsIgnoreCase("/minecraft:gamerule") || 
				args[0].equalsIgnoreCase("/minecraft:give")||
				args[0].equalsIgnoreCase("/minecraft:help") || args[0].equalsIgnoreCase("/minecraft:kick") ||
				args[0].equalsIgnoreCase("/minecraft:kill") || args[0].equalsIgnoreCase("/minecraft:list") ||
				args[0].equalsIgnoreCase("/minecraft:me") || args[0].equalsIgnoreCase("/minecraft:op") ||
				args[0].equalsIgnoreCase("/minecraft:pardon") || 
				args[0].equalsIgnoreCase("/minecraft:pardon-ip") || 
				args[0].equalsIgnoreCase("/minecraft:playsound") || 
				args[0].equalsIgnoreCase("/minecraft:say")||
				args[0].equalsIgnoreCase("/minecraft:scoreboard") || 
				args[0].equalsIgnoreCase("/minecraft:seed") || 
				args[0].equalsIgnoreCase("/minecraft:setidletimeout") || 
				args[0].equalsIgnoreCase("/minecraft:setworldspawn") || 
				args[0].equalsIgnoreCase("/minecraft:spawnpoint") || 
				args[0].equalsIgnoreCase("/minecraft:spreadplayers") || 
				args[0].equalsIgnoreCase("/minecraft:tell") || 
				args[0].equalsIgnoreCase("/minecraft:testfor") ||
				args[0].equalsIgnoreCase("/minecraft:time") || 
				args[0].equalsIgnoreCase("/minecraft:toggledownfall") || 
				args[0].equalsIgnoreCase("/minecraft:tp") || args[0].equalsIgnoreCase("/minecraft:weather") ||
				args[0].equalsIgnoreCase("/minecraft:whitelist") || 
				args[0].equalsIgnoreCase("/minecraft:xp") ||
				args[0].equalsIgnoreCase("/netstat") || args[0].equalsIgnoreCase("/bukkit:netstat") ||
				args[0].equalsIgnoreCase("/op") || args[0].equalsIgnoreCase("/bukkit:op") ||
				args[0].equalsIgnoreCase("/pardon") || args[0].equalsIgnoreCase("/bukkit:pardon") ||
				args[0].equalsIgnoreCase("/pardon-ip") || args[0].equalsIgnoreCase("/bukkit:pardon-ip") ||
				args[0].equalsIgnoreCase("/playsound") || args[0].equalsIgnoreCase("/bukkit:playsound") ||
				args[0].equalsIgnoreCase("/reload") || args[0].equalsIgnoreCase("/bukkit:reload") ||
				args[0].equalsIgnoreCase("/save-all") || args[0].equalsIgnoreCase("/bukkit:save-all") ||
				args[0].equalsIgnoreCase("/save-off") || args[0].equalsIgnoreCase("/bukkit:save-off") ||
				args[0].equalsIgnoreCase("/save-on") || args[0].equalsIgnoreCase("/bukkit:save-on") ||
				args[0].equalsIgnoreCase("/say") || args[0].equalsIgnoreCase("/bukkit:say") ||
				args[0].equalsIgnoreCase("/scoreboard") || args[0].equalsIgnoreCase("/bukkit:scoreboard") ||
				args[0].equalsIgnoreCase("/seed") || args[0].equalsIgnoreCase("/bukkit:seed") ||
				args[0].equalsIgnoreCase("/setblock") || args[0].equalsIgnoreCase("/bukkit:setblock") ||
				args[0].equalsIgnoreCase("/setidletimeout") || 
				args[0].equalsIgnoreCase("/bukkit:setidletimeout") ||
				args[0].equalsIgnoreCase("/setworldspawn") || 
				args[0].equalsIgnoreCase("/bukkit:setworldspawn") ||
				args[0].equalsIgnoreCase("/spawnpoint") || args[0].equalsIgnoreCase("/bukkit:spawnpoint") ||
				args[0].equalsIgnoreCase("/spreadplayers") || 
				args[0].equalsIgnoreCase("/bukkit:spreadplayers") ||
				args[0].equalsIgnoreCase("/stop") || args[0].equalsIgnoreCase("/bukkit:stop") ||
				args[0].equalsIgnoreCase("/summon") || args[0].equalsIgnoreCase("/bukkit:summon") ||
				args[0].equalsIgnoreCase("/tellraw") || args[0].equalsIgnoreCase("/bukkit:tellraw") ||
				args[0].equalsIgnoreCase("/testfor") || args[0].equalsIgnoreCase("/bukkit:testfor") ||
				args[0].equalsIgnoreCase("/testforblock") || 
				args[0].equalsIgnoreCase("/bukkit:testforblock") ||
				args[0].equalsIgnoreCase("/time") || args[0].equalsIgnoreCase("/bukkit:time") ||
				args[0].equalsIgnoreCase("/timings") || args[0].equalsIgnoreCase("/bukkit:timings") ||
				args[0].equalsIgnoreCase("/toggledownfall") || 
				args[0].equalsIgnoreCase("/bukkit:toggledownfall") ||
				args[0].equalsIgnoreCase("/tp") || args[0].equalsIgnoreCase("/bukkit:tp") ||
				args[0].equalsIgnoreCase("/weather") || args[0].equalsIgnoreCase("/bukkit:weather") ||
				args[0].equalsIgnoreCase("/whitelist") || args[0].equalsIgnoreCase("/bukkit:whitelist") ||
				args[0].equalsIgnoreCase("/xp") || args[0].equalsIgnoreCase("/bukkit:xp") ||
				args[0].equalsIgnoreCase("/rl") || args[0].equalsIgnoreCase("/bukkit:rl")) && 
				!player.hasPermission("TadukooVanillaFeel.normal")){
			event.setCancelled(true);
			Commands.nonOp(player);
		}else if(args[0].startsWith("/") && !player.hasPermission("TadukooVanillaFeel.normal")){
			event.setCancelled(true);
			Commands.no(player);
		}
	}
}
