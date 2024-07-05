package com.gmail.lucario77777777.TE.cheat;

import com.gmail.lucario77777777.TE.TE;
import com.gmail.lucario77777777.TE.commands.MainCommandExecutor;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Feed extends MainCommandExecutor {
	public Feed(TE plugin) {
		super(plugin);
	}
	
	@SuppressWarnings("deprecation")
	public static boolean Run(CommandSender sender, String[] args, String playerType)
	{
		if(args.length == 0){
			if(playerType == "player"){
				((Player) sender).setFoodLevel(20);
				sender.sendMessage(ChatColor.GREEN + "You have eaten!");
				return true;
			}else{
				sender.sendMessage(ChatColor.RED + "You're the console, you can't eat!");
				return true;
			}
		}else if(args.length ==1){
			if(sender.getServer().getPlayer(args[0]) != null){
				Player targetPlayer = sender.getServer().getPlayer(args [0]);
					targetPlayer.setFoodLevel(20);
					sender.sendMessage(ChatColor.GREEN + "Fed " + targetPlayer.getDisplayName() + "!");
					if(playerType == "player"){
						targetPlayer.sendMessage(ChatColor.GREEN  + "You have been fed by " + ((Player) sender).getDisplayName() + "!");
						return true;
					}else{
						targetPlayer.sendMessage(ChatColor.GREEN + "You have been fed!");
						return true;
					}
			}else{
				sender.sendMessage(ChatColor.RED + "PLAYER NOT ONLINE!");
				return true;
			}
		}
		return false;
	}
}