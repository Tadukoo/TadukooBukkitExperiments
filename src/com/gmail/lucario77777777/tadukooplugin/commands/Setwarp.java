package com.gmail.lucario77777777.tadukooplugin.commands;

import com.gmail.lucario77777777.tadukooplugin.commands.MainCommandExecutor;

/*
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
*/

import com.gmail.lucario77777777.tadukooplugin.Main;

public class Setwarp extends MainCommandExecutor {
	public Setwarp(Main plugin) {
		super(plugin);
	}
	
	/*public static boolean SetwarpRun(CommandSender sender, String[] args, String playerType, Main plugin)
	{

		if(playerType == "player"){
			if(args.length == 0){
				sender.sendMessage(ChatColor.DARK_RED + "TOO LITTLE ARGUMENTS!");
				return true;
		}else if(args.length == 1){
			Location targetWarpLocation = ((Player) sender).getLocation();
			String warpName = args[1];
			int targetX = targetWarpLocation.getBlockX();
			int targetY = targetWarpLocation.getBlockY();
			int targetZ = targetWarpLocation.getBlockZ();
			plugin.getConfig().set("X", targetX);
			plugin.getConfig().set("Y", targetY);
			plugin.getConfig().set("Z", targetZ);
			sender.sendMessage(ChatColor.GREEN + "Warp " + warpName + " set!");
			return true;
		}else if(args.length > 1){
			sender.sendMessage(ChatColor.RED + "You must name the warp!");
			return true;
			}
		}else{
			sender.sendMessage(ChatColor.RED + "You must be a player!");
			return true;
		}
		return false;
}*/
}