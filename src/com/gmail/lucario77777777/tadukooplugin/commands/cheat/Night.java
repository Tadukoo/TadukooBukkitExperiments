package com.gmail.lucario77777777.tadukooplugin.commands.cheat;

import com.gmail.lucario77777777.tadukooplugin.commands.MainCommandExecutor;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gmail.lucario77777777.tadukooplugin.Main;

public class Night extends MainCommandExecutor {
	public Night(Main plugin) {
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
				world.setTime(13000);
				Bukkit.broadcastMessage("Time Set to Night!");
				return true;
			}
		}else{
			sender.sendMessage(ChatColor.RED + "You must be a player!");
			return true;
		}
		return false;
}
}