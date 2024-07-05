package com.gmail.lucario77777777.TE.commands.cheat;

import com.gmail.lucario77777777.TE.TE;
import com.gmail.lucario77777777.TE.commands.CommandExec;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Gamemode extends CommandExec {
	public Gamemode(TE plugin) {
		super(plugin);
	}
	
	@SuppressWarnings("deprecation")
	public static boolean Run(CommandSender sender, String[] args, String playerType)
	{
		if(args.length <= 1){
			if(playerType != "player"){
				sender.sendMessage(ChatColor.RED + "Silly, you don't need a gamemode!");
				return true;
			}else{
				if(args.length == 1){
					if(args[0].equalsIgnoreCase("creative") || args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("c")){
					((Player) sender).setGameMode(GameMode.CREATIVE);
					return true;
				}else if(args[0].equalsIgnoreCase("survival") || args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("s")){
					((Player) sender).setGameMode(GameMode.SURVIVAL);
					return true;
				}else if(args[0].equalsIgnoreCase("adventure") || args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("a")){
					((Player) sender).setGameMode(GameMode.ADVENTURE);
					return true;
				}else{
					sender.sendMessage(ChatColor.RED + "That's not a gamemode!");
					return true;
				}
			}else if(args.length == 0){
				if(((Player) sender).getGameMode() == GameMode.CREATIVE){
					((Player) sender).setGameMode(GameMode.SURVIVAL);
					return true;
				}else if(((Player) sender).getGameMode() == GameMode.SURVIVAL){
					((Player) sender).setGameMode(GameMode.CREATIVE);
					return true;
				}else if(((Player) sender).getGameMode() == GameMode.ADVENTURE){
					((Player) sender).setGameMode(GameMode.SURVIVAL);
					return true;
				}
			}
			}
			}else if(args.length == 2){
				if(sender.getServer().getPlayer(args[0]) != null){
					Player targetPlayer = sender.getServer().getPlayer(args [0]);
					if(args[1].equalsIgnoreCase("creative") || args[1].equalsIgnoreCase("1") || args[1].equalsIgnoreCase("c")){
						targetPlayer.setGameMode(GameMode.CREATIVE);
						sender.sendMessage(ChatColor.GREEN + "" + targetPlayer.getDisplayName() + "'s gamemode has been changed!");
						return true;
					}else if(args[1].equalsIgnoreCase("survival") || args[1].equalsIgnoreCase("0") || args[1].equalsIgnoreCase("s")){
						targetPlayer.setGameMode(GameMode.SURVIVAL);
						sender.sendMessage(ChatColor.GREEN + "" + targetPlayer.getDisplayName() + "'s gamemode has been changed!");
						return true;
					}else if(args[1].equalsIgnoreCase("adventure") || args[1].equalsIgnoreCase("2") || args[1].equalsIgnoreCase("a")){
						targetPlayer.setGameMode(GameMode.ADVENTURE);
						sender.sendMessage(ChatColor.GREEN + "" + targetPlayer.getDisplayName() + "'s gamemode has been changed!");
						return true;
					}else{
						sender.sendMessage(ChatColor.RED + "That is not a gamemode!");
						return true;
					}
				}else{
					sender.sendMessage(ChatColor.RED + "Player not online!");
					return true;
				}
			}else{
				sender.sendMessage(ChatColor.RED + "Too many arguments!");
				return true;
			}
		return false;
}
}
