package com.gmail.lucario77777777.tadukooplugin;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.command.CommandExecutor;

public class TadukooPluginCommandExecutor implements CommandExecutor {

	private tadukoopluginmain plugin;
	
	public TadukooPluginCommandExecutor(tadukoopluginmain plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		String playerType;
		if (sender instanceof Player){
			playerType = "player";
		}else if(sender instanceof ConsoleCommandSender){
			playerType = "console";
		}else if(sender instanceof BlockCommandSender){
			playerType = "block";
		}else{
			playerType = "unknown";
		}
		if(cmd.getName().equalsIgnoreCase("ping")){
			if(playerType == "player"){
				sender.sendMessage(ChatColor.GOLD + "Pong!");
				return true;
			}else{
				sender.sendMessage(ChatColor.DARK_RED + "You must be a player!");
				return true;
			}
		}else if(cmd.getName().equalsIgnoreCase("tport")){
			if(playerType == "player"){
				if(args.length == 0){
					sender.sendMessage(ChatColor.DARK_RED + "TOO LITTLE ARGUMENTS!");
					return true;
			}else if(args.length == 1){
				Player targetPlayer = sender.getServer().getPlayer(args[0]);
				if(targetPlayer != null){
					Location targetPlayerLocation = targetPlayer.getLocation();
					((Player) sender).teleport(targetPlayerLocation);
					sender.sendMessage("You have teleported yourself to " + targetPlayer.getDisplayName());
					return true;
				}else{
					sender.sendMessage(ChatColor.DARK_RED + "PLAYER NOT ONLINE!");
					return true;
				}
			}else if(args.length == 2){
				Player targetPlayer = sender.getServer().getPlayer(args[0]);
				Player targetPlayer1 = sender.getServer().getPlayer(args[1]);
				Location targetPlayer1Location = targetPlayer1.getLocation();
				if(targetPlayer1Location != null){
					targetPlayer.teleport(targetPlayer1Location);
					targetPlayer.sendMessage("You have been teleported to " + targetPlayer1.getDisplayName());
					return true;
				}else{
					targetPlayer.sendMessage(ChatColor.DARK_RED + "PLAYER IS OFFLINE!");
					return true;
				}
				}
			}else{
				sender.sendMessage(ChatColor.RED + "You must be a player!");
				return true;
			}
		}else if(cmd.getName().equalsIgnoreCase("heal")){
			if(args.length == 0){
				if(playerType == "player"){
				((Player) sender).setHealth(20);
				((Player) sender).setFireTicks(0);
				sender.sendMessage(ChatColor.GREEN + "Healed!");
				return true;
				}else{
					sender.sendMessage(ChatColor.RED + "You're the console, you can't heal yourself!");
					return true;
				}
			}else if(args.length == 1){
				if(sender.getServer().getPlayer(args[0]) != null);
					Player targetPlayer = sender.getServer().getPlayer(args [0]);
					targetPlayer.setHealth(20);
					targetPlayer.setFireTicks(0);
					sender.sendMessage(ChatColor.GREEN + "Healed " + targetPlayer.getDisplayName() + "!");
					if(playerType == "player"){
						targetPlayer.sendMessage(ChatColor.GREEN + "You have been healed by" + ((Player) sender).getDisplayName()+ "!");
						return true;
					}else{
						targetPlayer.sendMessage(ChatColor.GREEN + "You have been healed.");
						return true;
					}
				}else{
					sender.sendMessage(ChatColor.RED + "PLAYER NOT ONLINE!");
					return true;
				}
			}else if(cmd.getName().equalsIgnoreCase("kill")){
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
			}else if(cmd.getName().equalsIgnoreCase("feed")){
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
			}else if(cmd.getName().equalsIgnoreCase("starve")){
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
			}else if(cmd.getName().equalsIgnoreCase("suicide")){
				if(args.length == 0){
					if(playerType == "player"){
						((Player) sender).setHealth(0);
						((Player) sender).chat("Goodbye world and all who inhabit it. :'(");
						return true;
					}else{
						sender.sendMessage("You're the console, you can't die!");
						return true;
					}
				}else{
					sender.sendMessage("Sorry, you can't make others commit suicide.");
					return true;
				}
			}else if(cmd.getName().equalsIgnoreCase("thelp")){
				if(args.length == 0){
					sender.sendMessage("----" + ChatColor.GREEN + "Tadukoo Plugin Help" + ChatColor.WHITE + "----");
					sender.sendMessage(ChatColor.AQUA + "/ping" + ChatColor.WHITE + " | " + ChatColor.GREEN + "A testing command.");
					sender.sendMessage(ChatColor.AQUA + "/tport" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Teleports players to other players.");
					sender.sendMessage(ChatColor.AQUA + "/heal" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Heals a player.");
					sender.sendMessage(ChatColor.AQUA + "/kill" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Kills a player.");
					sender.sendMessage(ChatColor.AQUA + "/feed" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Feeds a player.");
					sender.sendMessage(ChatColor.AQUA + "/starve" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Starves a player.");
					sender.sendMessage(ChatColor.AQUA + "/suicide" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Commit suicide.");
					sender.sendMessage(ChatColor.AQUA + "/thelp" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Shows this help.");
					return true;
				}else{
					sender.sendMessage(ChatColor.RED + "Sorry, we don't have search functionality yet.");
					return true;
				}
			}
		return false;
	}
}
