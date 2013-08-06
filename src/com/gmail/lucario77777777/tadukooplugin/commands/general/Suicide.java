package com.gmail.lucario77777777.tadukooplugin.commands.general;

import com.gmail.lucario77777777.tadukooplugin.commands.MainCommandExecutor;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gmail.lucario77777777.tadukooplugin.Main;

public class Suicide extends MainCommandExecutor {
	public Suicide(Main plugin) {
		super(plugin);
	}
	
	public static boolean Run(CommandSender sender, String[] args, String playerType)
	{
		if(args.length == 0){
			if(playerType == "player"){
				((Player) sender).setHealth(0);
				((Player) sender).chat("Goodbye world and all who inhabit it. :'(");
				return true;
			}else{
				sender.sendMessage(ChatColor.RED + "You're the console, you can't die!");
				return true;
			}
		}else{
			sender.sendMessage(ChatColor.RED + "Sorry, you can't make others commit suicide.");
			return true;
		}
}
}
