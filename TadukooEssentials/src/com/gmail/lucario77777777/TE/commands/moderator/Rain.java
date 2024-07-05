package com.gmail.lucario77777777.TE.commands.moderator;

import com.gmail.lucario77777777.TE.TE;
import com.gmail.lucario77777777.TE.commands.CommandExec;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Rain extends CommandExec {
	public Rain(TE plugin) {
		super(plugin);
	}
	
	public static boolean Run(CommandSender sender, String[] args, String playerType, TE plugin)
	{
		if(args.length == 0){
			if(playerType == "player"){
				World world = ((Player) sender).getWorld();
				world.setStorm(true);
				world.setThundering(false);
				Bukkit.broadcastMessage("Weather set to rain in " + world.getName() + "!");
				return true;
			}else{
				sender.sendMessage(ChatColor.RED + "You must be a player!");
				return true;
			}
		}else if(args.length == 1){
			World world = plugin.getServer().getWorld(args[0]);
			world.setStorm(true);
			world.setThundering(false);
			Bukkit.broadcastMessage("Weather set to rain in " + world.getName() + "!");
			return true;
		}else{
			sender.sendMessage(ChatColor.RED + "TOO MANY ARGUMENTS!");
			return false;
		}
	}
}