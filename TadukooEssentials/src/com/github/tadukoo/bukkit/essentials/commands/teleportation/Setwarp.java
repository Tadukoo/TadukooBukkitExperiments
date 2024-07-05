package com.github.tadukoo.bukkit.essentials.commands.teleportation;

import com.github.tadukoo.bukkit.essentials.TE;
import com.github.tadukoo.bukkit.essentials.commands.CommandExec;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Setwarp extends CommandExec{
	public Setwarp(TE plugin) {
		super(plugin);
	}
	
	public static boolean Run(CommandSender sender, String[] args, String playerType, TE plugin)
	{
		int i = plugin.warpsList.getInt("warpsNum") + 1;
		if(playerType == "player"){
			if(args.length == 0){
				sender.sendMessage(ChatColor.DARK_RED + "You must name the warp!");
				return false;
			}else if(args.length == 1){
				plugin.reloadWarpsConfig();
				Location location = ((Player) sender).getLocation();
				String warpName = args[0];
				double targetX = (double) location.getBlockX();
				double targetY = (double) location.getBlockY();
				double targetZ = (double) location.getBlockZ();
				plugin.warps.set(warpName, location);
				plugin.warps.set(warpName + ".x", targetX);
				plugin.warps.set(warpName + ".y", targetY);
				plugin.warps.set(warpName + ".z", targetZ);
				plugin.saveWarpsConfig();
				plugin.warpsList.set(i + ".name", warpName);
				plugin.warpsList.set("warpsNum", i);
				sender.sendMessage(ChatColor.GREEN + "Warp " + warpName + " set!");
				return true;
			}else if(args.length > 1){
				sender.sendMessage(ChatColor.RED + "TOO MANY ARGUMENTS!");
				return false;
			}
		}else{
			sender.sendMessage(ChatColor.RED + "You must be a player!");
			return true;
		}
		return false;
}
}