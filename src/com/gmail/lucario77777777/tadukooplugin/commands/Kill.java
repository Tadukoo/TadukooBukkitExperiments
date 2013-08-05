package com.gmail.lucario77777777.tadukooplugin.commands;

import com.gmail.lucario77777777.tadukooplugin.commands.MainCommandExecutor;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gmail.lucario77777777.tadukooplugin.Main;

public class Kill extends MainCommandExecutor {
	public Kill(Main plugin) {
		super(plugin);
	}
	
	public static boolean Run(CommandSender sender, String[] args)
	{
		if(args.length == 0){
			sender.sendMessage(ChatColor.DARK_RED + "NOT ENOUGH ARGUMENTS!");
			return true;
		}else if(args.length == 1){
			if(sender.getServer().getPlayer(args[0]) != null){
				Player targetPlayer = sender.getServer().getPlayer(args [0]);
				targetPlayer.setHealth(0);
				sender.sendMessage(ChatColor.GREEN + "Killed " + targetPlayer.getDisplayName() + "!");
				targetPlayer.sendMessage(ChatColor.RED + "You died!");
				return true;
		    }else{
		    	sender.sendMessage(ChatColor.RED + "PLAYER NOT ONLINE!");
		    	return true;
		    	}
		}
		return false;
}
}