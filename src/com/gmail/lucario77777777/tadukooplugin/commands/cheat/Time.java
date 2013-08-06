package com.gmail.lucario77777777.tadukooplugin.commands.cheat;

import com.gmail.lucario77777777.tadukooplugin.commands.MainCommandExecutor;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gmail.lucario77777777.tadukooplugin.Main;

public class Time extends MainCommandExecutor {
	public Time(Main plugin) {
		super(plugin);
	}
	
	public static boolean Run(CommandSender sender, String[] args, String playerType)
	{
		if(playerType == "player"){
			if(args.length == 0){
				sender.sendMessage(ChatColor.RED + "NOT ENOUGH ARGUMENTS!");
				return true;
			}
		if(args.length == 1){
			World world = ((Player) sender).getWorld();
			if(args[0].equalsIgnoreCase("day")){
				world.setTime(0);
				Bukkit.broadcastMessage("Time Set to Day!");
				return true;
			}else if(args[0].equalsIgnoreCase("night")){
				world.setTime(13000);
				Bukkit.broadcastMessage("Time Set to Night!");
				return true;
			}else{
				sender.sendMessage(ChatColor.RED + "Available Times: Day and Night");
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