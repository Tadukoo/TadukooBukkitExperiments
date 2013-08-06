package com.gmail.lucario77777777.tadukooplugin.commands.cheat;

import com.gmail.lucario77777777.tadukooplugin.commands.MainCommandExecutor;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gmail.lucario77777777.tadukooplugin.Main;

public class Creative extends MainCommandExecutor {
	public Creative(Main plugin) {
		super(plugin);
	}
	
	public static boolean Run(CommandSender sender, String[] args, String playerType)
	{
		if(args.length == 0){
			if(playerType != "player"){
				sender.sendMessage(ChatColor.RED + "Silly, you don't need a gamemode!");
				return true;
			}else{
				((Player) sender).setGameMode(GameMode.CREATIVE);
				return true;
			}
		}else if(args.length == 1){
			if(sender.getServer().getPlayer(args[0]) != null){
				Player targetPlayer = sender.getServer().getPlayer(args [0]);
				targetPlayer.setGameMode(GameMode.CREATIVE);
				sender.sendMessage(ChatColor.GREEN + "You changed " + targetPlayer.getDisplayName() + "'s gamemode to creative.");
				return true;
			}else{
				sender.sendMessage(ChatColor.RED + "Player not online!");
				return true;
			}
		}else{
			sender.sendMessage(ChatColor.RED + "Too many arguments!");
			return true;
		}
}
}
