package com.gmail.lucario77777777.tadukooplugin.commands;

import com.gmail.lucario77777777.tadukooplugin.commands.MainCommandExecutor;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gmail.lucario77777777.tadukooplugin.Main;

public class Setwarp extends MainCommandExecutor {
	public Setwarp(Main plugin) {
		super(plugin);
	}
	
	public static boolean Run(CommandSender sender, String[] args, String playerType, Main plugin)
	{

		if(playerType == "player"){
			if(args.length == 0){
				sender.sendMessage(ChatColor.DARK_RED + "TOO LITTLE ARGUMENTS!");
				return true;
		}else if(args.length == 1){
			Location location = ((Player) sender).getLocation();
			String warpName = args[0];
			double targetX = (double) location.getBlockX();
			double targetY = (double) location.getBlockY();
			double targetZ = (double) location.getBlockZ();
			plugin.getConfig().set(warpName, location);
			plugin.getConfig().set(warpName + ".x", targetX);
			plugin.getConfig().set(warpName + ".y", targetY);
			plugin.getConfig().set(warpName + ".z", targetZ);
			plugin.saveConfig();
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
}
}