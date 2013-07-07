package com.gmail.lucario77777777.tadukooplugin.commands;

import com.gmail.lucario77777777.tadukooplugin.commands.MainCommandExecutor;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import com.gmail.lucario77777777.tadukooplugin.Main;

public class Ping extends MainCommandExecutor {
	public Ping(Main plugin) {
		super(plugin);
	}
	
	public static boolean PingRun(CommandSender sender, String playerType)
	{
	if(playerType == "player"){
		sender.sendMessage(ChatColor.GOLD + "Pong!");
		return true;
	}else{
		sender.sendMessage(ChatColor.DARK_RED + "You must be a player!");
		return true;
	}
}
}
