package com.github.tadukoo.bukkit.essentials.commands.general;

import com.github.tadukoo.bukkit.essentials.TE;
import com.github.tadukoo.bukkit.essentials.commands.CommandExec;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class MOTD extends CommandExec {
	public MOTD(TE plugin) {
		super(plugin);
	}
	
	public static boolean Run(CommandSender sender, TE plugin)
	{
		Player player = (Player) sender;
		String MOTD = plugin.getConfig().getString("MOTD");
		MOTD = MOTD.replaceAll("%w", player.getWorld().getName());
		MOTD = MOTD.replaceAll("&", "§");
		sender.sendMessage(MOTD);
		return true;
	}
}