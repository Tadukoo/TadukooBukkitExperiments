package com.gmail.lucario77777777.TE.teleportation;

import com.gmail.lucario77777777.TE.TE;
import com.gmail.lucario77777777.TE.commands.MainCommandExecutor;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Warp extends MainCommandExecutor{
	public Warp(TE plugin) {
		super(plugin);
	}
	
	public static boolean Run(CommandSender sender, String[] args, String playerType, TE plugin)
	{

		if(playerType == "player"){
			if(args.length == 0){
				sender.sendMessage(ChatColor.DARK_RED + "Not enough arguments!");
				return true;
			}else if(args.length == 1){
				if(args[0].equalsIgnoreCase("list")){
					
					return true;
				}else if(plugin.warps.contains(args[0])){
					String warpName = args[0];
					Location warpLocation = ((Player) sender).getLocation();
					warpLocation.setX(plugin.warps.getDouble(warpName + ".x"));
					warpLocation.setY(plugin.warps.getDouble(warpName + ".y"));
					warpLocation.setZ(plugin.warps.getDouble(warpName + ".z"));
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