package com.gmail.lucario77777777.tadukooplugin.commands;

import com.gmail.lucario77777777.tadukooplugin.commands.MainCommandExecutor;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gmail.lucario77777777.tadukooplugin.Main;

public class Fly extends MainCommandExecutor {
	public Fly(Main plugin) {
		super(plugin);
	}
	
	public static boolean Run(CommandSender sender, String[] args, String playerType)
	{
		if(args.length == 0){
			if(playerType != "player"){
				sender.sendMessage(ChatColor.RED + "You can't fly, silly!");
				return true;
			}else{
				if(((Player) sender).getAllowFlight() == false){
				((Player) sender).setAllowFlight(true);
				sender.sendMessage(ChatColor.GREEN + "You can now fly!");
				return true;
			}else if(((Player) sender).getAllowFlight() == true){
				((Player) sender).setAllowFlight(false);
				sender.sendMessage(ChatColor.GREEN +"You can no longer fly!");
				return true;
			}
			}
		}else if(args.length == 1){
			if(sender.getServer().getPlayer(args[0]) != null){
				Player targetPlayer = sender.getServer().getPlayer(args [0]);
				if (targetPlayer.getAllowFlight() == true){
					targetPlayer.setAllowFlight(false);
					sender.sendMessage(ChatColor.GREEN + "" + targetPlayer.getDisplayName() + " can no longer fly.");
					return true;
				}else if (targetPlayer.getAllowFlight() == false){
					targetPlayer.setAllowFlight(true);
					sender.sendMessage(ChatColor.GREEN + "" + targetPlayer.getDisplayName() + " can now fly.");
					return true;
			}else{
				sender.sendMessage(ChatColor.RED + "Player not online!");
				return true;
			}
		}
		}
		return false;
}
}