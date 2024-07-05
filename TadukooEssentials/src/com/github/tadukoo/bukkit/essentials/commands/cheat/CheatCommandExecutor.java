package com.github.tadukoo.bukkit.essentials.commands.cheat;

import java.util.logging.Level;

import com.github.tadukoo.bukkit.essentials.TE;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.github.tadukoo.bukkit.essentials.commands.CommandExec;

public class CheatCommandExecutor{

	public CheatCommandExecutor(TE plugin) {
		super();
	}
	public static boolean Run(CommandSender sender, Command cmd, String[] args, String playerType, TE plugin){
		if(plugin.getCommandsConfig().getString("cheat") == "true"){
			if(cmd.getName().equalsIgnoreCase(plugin.getCommandsConfig().getString("feed-name"))){
				if(plugin.getCommandsConfig().getString("feed") == "true"){
					Feed.Run(sender, args, playerType);
					return true;
				}else if(plugin.getCommandsConfig().getString("feed") == "false"){
					CommandExec.Disabled(plugin.getCommandsConfig().getString("feed-name"), sender);
					return true;
				}else{
					CommandExec.Error(plugin.getCommandsConfig().getString("feed-name"), sender, plugin);
					return true;
				}
			}else if(cmd.getName().equalsIgnoreCase("fly")){
				if(plugin.getCommandsConfig().getString("fly") == "true"){
					Fly.Run(sender, args, playerType);
					return true;
				}else if(plugin.getCommandsConfig().getString("fly") == "false"){
					CommandExec.Disabled("fly", sender);
					return true;
				}else{
					CommandExec.Error("fly", sender, plugin);
					return true;
				}
			}else if(cmd.getName().equalsIgnoreCase("adventure") || cmd.getName().equalsIgnoreCase("gma") ||
					cmd.getName().equalsIgnoreCase("creative") || cmd.getName().equalsIgnoreCase("gmc") ||
					cmd.getName().equalsIgnoreCase("survival") || cmd.getName().equalsIgnoreCase("gms") ||
					cmd.getName().equalsIgnoreCase("gamemode") || cmd.getName().equalsIgnoreCase("gm") ||
					cmd.getName().equalsIgnoreCase("gmt")){
				if(plugin.getCommandsConfig().getString("gamemode") == "true"){
					if(cmd.getName().equalsIgnoreCase("adventure") || cmd.getName().equalsIgnoreCase("gma")){
						if(plugin.getCommandsConfig().getString("adventure") == "true"){
							Adventure.run(sender, args, playerType);
							return true;
						}else if(plugin.getCommandsConfig().getString("adventure") == "false"){
							CommandExec.Disabled("adventure", sender);
							return true;
						}else{
							CommandExec.Error("adventure", sender, plugin);
							return true;
						}
					}else if(cmd.getName().equalsIgnoreCase("creative") || 
							cmd.getName().equalsIgnoreCase("gmc")){
						if(plugin.getCommandsConfig().getString("creative") == "true"){
							Creative.Run(sender, args, playerType);
							return true;
						}else if(plugin.getCommandsConfig().getString("creative") == "false"){
							CommandExec.Disabled("creative", sender);
							return true;
						}else{
							CommandExec.Error("creative", sender, plugin);
							return true;
						}
					}else if(cmd.getName().equalsIgnoreCase("survival") || 
							cmd.getName().equalsIgnoreCase("gms")){
						if(plugin.getCommandsConfig().getString("survival") == "true"){
							Survival.Run(sender, args, playerType);
							return true;
						}else if(plugin.getCommandsConfig().getString("survival") == "false"){
							CommandExec.Disabled("survival", sender);
							return true;
						}else{
							CommandExec.Error("survival", sender, plugin);
							return true;
						}
					}else if(cmd.getName().equalsIgnoreCase("gamemode") || cmd.getName().equalsIgnoreCase("gm")||
							cmd.getName().equalsIgnoreCase("gmt")){
						Gamemode.Run(sender, args, playerType);
						return true;
					}
				}else if(plugin.getCommandsConfig().getString("gamemode") == "false"){
					Disabled("gamemode", sender);
					return true;
				}else{
					Error("gamemode", sender, plugin);
					return true;
				}
			}else if(cmd.getName().equalsIgnoreCase("heal")){
				if(plugin.getCommandsConfig().getString("heal") == "true"){
					Heal.Run(sender, args, playerType);
					return true;
				}else if(plugin.getCommandsConfig().getString("heal") == "false"){
					CommandExec.Disabled("heal", sender);
					return true;
				}else{
					CommandExec.Error("heal", sender, plugin);
					return true;
				}
			}else if(cmd.getName().equalsIgnoreCase("starve")){
				if(plugin.getCommandsConfig().getString("starve") == "true"){
					Starve.Run(sender, args);
					return true;
				}else if(plugin.getCommandsConfig().getString("starve") == "false"){
					CommandExec.Disabled("starve", sender);
					return true;
				}else{
					CommandExec.Error("starve", sender, plugin);
					return true;
				}
			}else if(cmd.getName().equalsIgnoreCase("time") || cmd.getName().equalsIgnoreCase("day") ||
					cmd.getName().equalsIgnoreCase("night")){
				if(plugin.getCommandsConfig().getString("time") == "true"){
					if(cmd.getName().equalsIgnoreCase("time")){
						Time.Run(sender, args, playerType);
						return true;
					}else if(cmd.getName().equalsIgnoreCase("day")){
						if(plugin.getCommandsConfig().getString("day") == "true"){
							Day.Run(sender, args, playerType);
							return true;
						}else if(plugin.getCommandsConfig().getString("day") == "false"){
							CommandExec.Disabled("day", sender);
							return true;
						}else{
							CommandExec.Error("day", sender, plugin);
							return true;
						}
					}else if(cmd.getName().equalsIgnoreCase("night")){
						if(plugin.getCommandsConfig().getString("night") == "true"){
							Night.Run(sender, args, playerType);
							return true;
						}else if(plugin.getCommandsConfig().getString("night") == "false"){
							CommandExec.Disabled("night", sender);
							return true;
						}else{
							CommandExec.Error("night", sender, plugin);
							return true;
						}
					}
				}else if(plugin.getCommandsConfig().getString("time") == "false"){
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
	
	public static void Error(String cmd, CommandSender sender, TE plugin){
		sender.sendMessage(ChatColor.RED + "Please inform an admin that they don't have " + cmd + " set " +
				"correctly in the commands.yml file.");
		plugin.logger.log(Level.WARNING, "You don't have " + cmd + " set correctly in the commands.yml file.");
	
	}
}
