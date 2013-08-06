package com.gmail.lucario77777777.tadukooplugin.commands.teleportation;

import com.gmail.lucario77777777.tadukooplugin.commands.MainCommandExecutor;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import com.gmail.lucario77777777.tadukooplugin.Main;

public class Delwarp extends MainCommandExecutor {
	public Delwarp(Main plugin) {
		super(plugin);
	}
	
	public static boolean Run(CommandSender sender, String[] args, String playerType, Main plugin)
	{
		if(args.length == 0){
			sender.sendMessage(ChatColor.DARK_RED + "TOO LITTLE ARGUMENTS!");
			return true;
		}else if(args.length == 1){
			String warpName = args[0];
			if (plugin.warps.contains(warpName)){
				plugin.warps.set(warpName + ".x", null);
				plugin.warps.set(warpName + ".y", null);
				plugin.warps.set(warpName + ".z", null);
				plugin.warps.set(warpName, null);
				sender.sendMessage(ChatColor.GREEN + "Warp " + warpName + " has been deleted.");
				return true;
			}else{
				sender.sendMessage(ChatColor.RED + "Warp " + warpName + " doesn't exist!");
				return true;
			}
		}else{
			sender.sendMessage(ChatColor.RED + "Too many arguments!");
			return true;
		}
	}
}