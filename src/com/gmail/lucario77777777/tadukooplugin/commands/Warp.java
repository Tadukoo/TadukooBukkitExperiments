package com.gmail.lucario77777777.tadukooplugin.commands;

import com.gmail.lucario77777777.tadukooplugin.commands.MainCommandExecutor;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gmail.lucario77777777.tadukooplugin.Main;

public class Warp extends MainCommandExecutor {
	public Warp(Main plugin) {
		super(plugin);
	}
	
	public static boolean Run(CommandSender sender, String[] args, String playerType, Main plugin)
	{

		if(playerType == "player"){
			if(args.length == 0){
				sender.sendMessage(ChatColor.DARK_RED + "Not enough arguments!");
				return true;
			}else if(args.length == 1){
				String warpName = args[0];
				Location warpLocation = ((Player) sender).getLocation();
				if(plugin.getConfig().contains(warpName + ".x") && plugin.getConfig().contains(warpName + ".y") && plugin.getConfig().contains(warpName + ".z")){
					warpLocation.setX(plugin.getConfig().getDouble(warpName + ".x"));
					warpLocation.setY(plugin.getConfig().getDouble(warpName + ".y"));
					warpLocation.setZ(plugin.getConfig().getDouble(warpName + ".z"));
					((Player) sender).teleport(warpLocation);
					sender.sendMessage(ChatColor.GREEN + "You are now at warp " + warpName + "!");
					return true;
				}else{
					sender.sendMessage(ChatColor.RED + "That warp does not exist!");
					return true;
				}
			}else{
				sender.sendMessage(ChatColor.RED + "Too many arguments!");
				return true;
			}
		}else{
			sender.sendMessage(ChatColor.RED + "You must be a player!");
			return true;
		}
}
}