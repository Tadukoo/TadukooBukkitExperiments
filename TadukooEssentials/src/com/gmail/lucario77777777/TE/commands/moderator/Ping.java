package com.gmail.lucario77777777.TE.commands.moderator;

import com.gmail.lucario77777777.TE.TE;
import com.gmail.lucario77777777.TE.commands.MainCommandExecutor;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;


public class Ping extends MainCommandExecutor{
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
