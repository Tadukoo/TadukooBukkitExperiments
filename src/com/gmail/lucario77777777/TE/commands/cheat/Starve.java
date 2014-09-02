package com.gmail.lucario77777777.TE.commands.cheat;

import com.gmail.lucario77777777.TE.TE;
import com.gmail.lucario77777777.TE.commands.MainCommandExecutor;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Starve extends MainCommandExecutor {
	public Starve(TE plugin) {
		super(plugin);
	}
	
	@SuppressWarnings("deprecation")
	public static boolean Run(CommandSender sender, String[] args)
	{
		if(args.length == 0){
			sender.sendMessage(ChatColor.DARK_RED + "NOT ENOUGH ARGUMENTS!");
			return true;
		}else if(args.length == 1){
			if(sender.getServer().getPlayer(args[0]) != null){
				Player targetPlayer = sender.getServer().getPlayer(args [0]);
				targetPlayer.setFoodLevel(0);
				sender.sendMessage(ChatColor.GREEN + "You have starved " + targetPlayer.getDisplayName());
				targetPlayer.sendMessage(ChatColor.RED + "You have been starved!");
				return true;
			}else{
				sender.sendMessage(ChatColor.DARK_RED + "PLAYER IS OFFLINE!");
				return true;
			}
		}
		return false;
	}
}