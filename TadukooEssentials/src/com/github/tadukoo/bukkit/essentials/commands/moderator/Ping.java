package com.github.tadukoo.bukkit.essentials.commands.moderator;

import com.github.tadukoo.bukkit.essentials.TE;
import com.github.tadukoo.bukkit.essentials.commands.CommandExec;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;


public class Ping extends CommandExec {
	public Ping(TE plugin) {
		super(plugin);
	}
	
	public static boolean Run(CommandSender sender, String playerType)
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
