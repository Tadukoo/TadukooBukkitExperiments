package com.gmail.lucario77777777.TE.cheat;

import com.gmail.lucario77777777.TE.TE;
import com.gmail.lucario77777777.TE.commands.MainCommandExecutor;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Adventure extends MainCommandExecutor{
	public Adventure(TE plugin) {
		super(plugin);
	}
	
	@SuppressWarnings("deprecation")
	public static boolean run(CommandSender sender, String[] args, String playerType)
	{
		if(args.length == 0){
			if(playerType != "player"){
				sender.sendMessage(ChatColor.RED + "Silly, you don't need a gamemode!");
				return true;
			}else{
				((Player) sender).setGameMode(GameMode.ADVENTURE);
				return true;
			}
		}else if(args.length == 1){
			if(sender.getServer().getPlayer(args[0]) != null){
				Player targetPlayer = sender.getServer().getPlayer(args [0]);
				targetPlayer.setGameMode(GameMode.ADVENTURE);
				sender.sendMessage(ChatColor.GREEN + "You changed " + targetPlayer.getDisplayName() + "'s gamemode to adventure.");
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
