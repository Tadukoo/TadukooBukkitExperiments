package com.github.tadukoo.bukkit.essentials.commands.teleportation;

import com.github.tadukoo.bukkit.essentials.TE;
import com.github.tadukoo.bukkit.essentials.commands.CommandExec;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;


public class Delwarp extends CommandExec {
	public Delwarp(TE plugin) {
		super(plugin);
	}
	
	public static boolean Run(CommandSender sender, String[] args, String playerType, TE plugin)
	{
		if(args.length == 0){
			sender.sendMessage(ChatColor.DARK_RED + "TOO LITTLE ARGUMENTS!");
			return true;
		}else if(args.length == 1){
			int i = plugin.warpsList.getInt("warpsNum");
			int j = i;
			int k = i - 1;
			String warpName = args[0];
			if (plugin.warps.contains(warpName)){
				plugin.warps.set(warpName + ".x", null);
				plugin.warps.set(warpName + ".y", null);
				plugin.warps.set(warpName + ".z", null);
				plugin.warps.set(warpName, null);
				while(i > 0){
					if(plugin.warpsList.getString(i + ".name") == warpName){
						plugin.warpsList.set(i + ".name", null);
						while(i < j){
							i++;
							String t = plugin.warpsList.getString(i + ".name");
							int l = i - 1;
							plugin.warpsList.set(l + ".name", t);
							plugin.warpsList.set("warpsNum", k);
						}
					}
					i--;
				}
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