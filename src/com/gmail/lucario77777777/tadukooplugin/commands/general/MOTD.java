package com.gmail.lucario77777777.tadukooplugin.commands.general;

import com.gmail.lucario77777777.tadukooplugin.commands.MainCommandExecutor;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gmail.lucario77777777.tadukooplugin.Main;

public class MOTD extends MainCommandExecutor {
	public MOTD(Main plugin) {
		super(plugin);
	}
	
	public static boolean Run(CommandSender sender, Main plugin)
	{
		sender.sendMessage(plugin.getConfig().getString("MOTD").replace("%w", ((Player) sender).getWorld().getName()));
		return true;
	}
}