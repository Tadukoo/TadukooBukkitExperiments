package com.gmail.lucario77777777.tadukooplugin.commands;

import com.gmail.lucario77777777.tadukooplugin.commands.MainCommandExecutor;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gmail.lucario77777777.tadukooplugin.Main;

public class Sun extends MainCommandExecutor {
	public Sun(Main plugin) {
		super(plugin);
	}
	
	public static boolean Run(CommandSender sender, String[] args, String playerType)
	{
		if(playerType == "player"){
			if(args.length >= 1){
				sender.sendMessage(ChatColor.RED + "TOO MANY ARGUMENTS!");
				return true;
			}
			if(args.length == 0){
				World world = ((Player) sender).getWorld();
				world.setWeatherDuration(0);
				Bukkit.broadcastMessage("Weather set to Sun!");
				return true;
			}
		}else{
			sender.sendMessage(ChatColor.RED + "You must be a player!");
			return true;
		}
		return false;
}
}