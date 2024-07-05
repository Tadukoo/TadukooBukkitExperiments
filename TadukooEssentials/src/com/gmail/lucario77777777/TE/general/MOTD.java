package com.gmail.lucario77777777.TE.general;

import com.gmail.lucario77777777.TE.TE;
import com.gmail.lucario77777777.TE.commands.MainCommandExecutor;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class MOTD extends MainCommandExecutor{
	public MOTD(TE plugin) {
		super(plugin);
	}
	
	public static boolean Run(CommandSender sender, TE plugin)
	{
		sender.sendMessage(plugin.getConfig().getString("MOTD").replace("%w", ((Player) sender).getWorld().getName()));
		return true;
	}
}