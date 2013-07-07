package com.gmail.lucario77777777.tadukooplugin.commands;

import com.gmail.lucario77777777.tadukooplugin.commands.MainCommandExecutor;

import org.bukkit.command.CommandSender;

import com.gmail.lucario77777777.tadukooplugin.Main;

public class MOTD extends MainCommandExecutor {
	public MOTD(Main plugin) {
		super(plugin);
	}
	
	public static boolean MOTDRun(CommandSender sender, Main plugin)
	{
		sender.sendMessage(plugin.getConfig().getString("MOTD"));
		return true;
}
}