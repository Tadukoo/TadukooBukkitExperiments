package com.gmail.lucario77777777.tadukooplugin.commands.cheat;

import java.util.logging.Level;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.gmail.lucario77777777.tadukooplugin.Main;
import com.gmail.lucario77777777.tadukooplugin.commands.MainCommandExecutor;

public class CheatCommandExecutor{

	public CheatCommandExecutor(Main plugin) {
		super();
	}
	public static boolean Run(CommandSender sender, Command cmd, String[] args, String playerType, Main plugin){
		if(plugin.getCommandsConfig().getString("cheat") == "true"){
			if(cmd.getName().equalsIgnoreCase("feed")){
				if(plugin.getCommandsConfig().getString("cheat.feed") == "true"){
					Feed.Run(sender, args, playerType);
					return true;
				}else if(plugin.getCommandsConfig().getString("cheat.feed") == "false"){
					MainCommandExecutor.Disabled("feed", sender);
					return true;
				}else{
					MainCommandExecutor.Error("feed", sender, plugin);
					return true;
				}
			}else if(cmd.getName().equalsIgnoreCase("fly")){
				if(plugin.getCommandsConfig().getString("cheat.fly") == "true"){
					Fly.Run(sender, args, playerType);
					return true;
				}else if(plugin.getCommandsConfig().getString("cheat.fly") == "false"){
					MainCommandExecutor.Disabled("fly", sender);
					return true;
				}else{
					MainCommandExecutor.Error("fly", sender, plugin);
					return true;
				}
			}else if(cmd.getName().equalsIgnoreCase("adventure") || cmd.getName().equalsIgnoreCase("gma") ||
					cmd.getName().equalsIgnoreCase("creative") || cmd.getName().equalsIgnoreCase("gmc") ||
					cmd.getName().equalsIgnoreCase("survival") || cmd.getName().equalsIgnoreCase("gms") ||
					cmd.getName().equalsIgnoreCase("gamemode") || cmd.getName().equalsIgnoreCase("gm") ||
					cmd.getName().equalsIgnoreCase("gmt")){
				if(plugin.getCommandsConfig().getString("cheat.gamemode") == "true"){
					if(cmd.getName().equalsIgnoreCase("adventure") || cmd.getName().equalsIgnoreCase("gma")){
						if(plugin.getCommandsConfig().getString("cheat.gamemode.adventure") == "true"){
							Adventure.Run(sender, args, playerType);
							return true;
						}else if(plugin.getCommandsConfig().getString("cheat.gamemode.adventure") == "false"){
							MainCommandExecutor.Disabled("adventure", sender);
							return true;
						}else{
							MainCommandExecutor.Error("adventure", sender, plugin);
							return true;
						}
					}else if(cmd.getName().equalsIgnoreCase("creative") || 
							cmd.getName().equalsIgnoreCase("gmc")){
						if(plugin.getCommandsConfig().getString("cheat.gamemode.creative") == "true"){
							Creative.Run(sender, args, playerType);
							return true;
						}else if(plugin.getCommandsConfig().getString("cheat.gamemode.creative") == "false"){
							MainCommandExecutor.Disabled("creative", sender);
							return true;
						}else{
							MainCommandExecutor.Error("creative", sender, plugin);
							return true;
						}
					}else if(cmd.getName().equalsIgnoreCase("survival") || 
							cmd.getName().equalsIgnoreCase("gms")){
						if(plugin.getCommandsConfig().getString("cheat.gamemode.survival") == "true"){
							Survival.Run(sender, args, playerType);
							return true;
						}else if(plugin.getCommandsConfig().getString("cheat.gamemode.survival") == "false"){
							MainCommandExecutor.Disabled("survival", sender);
							return true;
						}else{
							MainCommandExecutor.Error("survival", sender, plugin);
							return true;
						}
					}else if(cmd.getName().equalsIgnoreCase("gamemode") || cmd.getName().equalsIgnoreCase("gm")||
							cmd.getName().equalsIgnoreCase("gmt")){
						Gamemode.Run(sender, args, playerType);
						return true;
					}
				}else if(plugin.getCommandsConfig().getString("cheat.gamemode") == "false"){
					Disabled("gamemode", sender);
					return true;
				}else{
					Error("gamemode", sender, plugin);
					return true;
				}
			}else if(cmd.getName().equalsIgnoreCase("heal")){
				if(plugin.getCommandsConfig().getString("cheat.heal") == "true"){
					Heal.Run(sender, args, playerType);
					return true;
				}else if(plugin.getCommandsConfig().getString("cheat.heal") == "false"){
					MainCommandExecutor.Disabled("heal", sender);
					return true;
				}else{
					MainCommandExecutor.Error("heal", sender, plugin);
					return true;
				}
			}else if(cmd.getName().equalsIgnoreCase("starve")){
				if(plugin.getCommandsConfig().getString("cheat.starve") == "true"){
					Starve.Run(sender, args);
					return true;
				}else if(plugin.getCommandsConfig().getString("cheat.starve") == "false"){
					MainCommandExecutor.Disabled("starve", sender);
					return true;
				}else{
					MainCommandExecutor.Error("starve", sender, plugin);
					return true;
				}
			}else if(cmd.getName().equalsIgnoreCase("time") || cmd.getName().equalsIgnoreCase("day") ||
					cmd.getName().equalsIgnoreCase("night")){
				if(plugin.getCommandsConfig().getString("cheat.time") == "true"){
					if(cmd.getName().equalsIgnoreCase("time")){
						Time.Run(sender, args, playerType);
						return true;
					}else if(cmd.getName().equalsIgnoreCase("day")){
						if(plugin.getCommandsConfig().getString("cheat.time.day") == "true"){
							Day.Run(sender, args, playerType);
							return true;
						}else if(plugin.getCommandsConfig().getString("cheat.time.day") == "false"){
							MainCommandExecutor.Disabled("day", sender);
							return true;
						}else{
							MainCommandExecutor.Error("day", sender, plugin);
							return true;
						}
					}else if(cmd.getName().equalsIgnoreCase("night")){
						if(plugin.getCommandsConfig().getString("cheat.time.night") == "true"){
							Night.Run(sender, args, playerType);
							return true;
						}else if(plugin.getCommandsConfig().getString("cheat.time.night") == "false"){
							MainCommandExecutor.Disabled("night", sender);
							return true;
						}else{
							MainCommandExecutor.Error("night", sender, plugin);
							return true;
						}
					}
				}else if(plugin.getCommandsConfig().getString("cheat.time") == "false"){
					Disabled("time", sender);
					return true;
				}else{
					Error("time", sender, plugin);
					return true;
				}
			}
			return true;
		}else if(plugin.getCommandsConfig().getString("cheat") == "false"){
			Disabled("cheat", sender);
			return true;
		}else{
			Error("cheat", sender, plugin);
			return true;
		}
	}
	
	public static void Disabled(String cmd, CommandSender sender){
		sender.sendMessage(ChatColor.RED + "An admin has set " + cmd + " commands to false in the commands.yml " +
				"file.");
	}
	
	public static void Error(String cmd, CommandSender sender, Main plugin){
		sender.sendMessage(ChatColor.RED + "Please inform an admin that they don't have " + cmd + " set " +
				"correctly in the commands.yml file.");
		plugin.logger.log(Level.WARNING, "You don't have " + cmd + " set correctly in the commands.yml file.");
	
	}
}
