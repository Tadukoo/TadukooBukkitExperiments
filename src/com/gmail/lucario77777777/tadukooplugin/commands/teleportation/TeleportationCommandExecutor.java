package com.gmail.lucario77777777.tadukooplugin.commands.teleportation;

import java.util.logging.Level;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.gmail.lucario77777777.tadukooplugin.Main;
import com.gmail.lucario77777777.tadukooplugin.commands.MainCommandExecutor;

public class TeleportationCommandExecutor{

	public TeleportationCommandExecutor(Main plugin) {
		super();
	}
	public static boolean Run(CommandSender sender, Command cmd, String[] args, String playerType, Main plugin){
		if(plugin.getCommandsConfig().getString("teleportation") == "true"){
			if(cmd.getName().equalsIgnoreCase("tp")){
				if(plugin.getCommandsConfig().getString("teleportation.tp") == "true"){
					Tp.Run(sender, args, playerType);
					return true;
				}else if(plugin.getCommandsConfig().getString("teleportation.tp") == "false"){
					MainCommandExecutor.Disabled("tp", sender);
					return true;
				}else{
					MainCommandExecutor.Error("tp", sender, plugin);
					return true;
				}
			}else if(cmd.getName().equalsIgnoreCase("setwarp") || cmd.getName().equalsIgnoreCase("delwarp") ||
					cmd.getName().equalsIgnoreCase("warp")){
				if(plugin.getCommandsConfig().getString("teleportation.warp") == "true"){
					if(cmd.getName().equalsIgnoreCase("delwarp")){
						if(plugin.getCommandsConfig().getString("teleportation.warp.delwarp") == "true"){
							Delwarp.Run(sender, args, playerType, plugin);
							return true;
						}else if(plugin.getCommandsConfig().getString("teleportation.warp.delwarp") == "false"){
							MainCommandExecutor.Disabled("delwarp", sender);
							return true;
						}else{
							MainCommandExecutor.Error("delwarp", sender, plugin);
							return true;
						}
					}else if(cmd.getName().equalsIgnoreCase("setwarp")){
						if(plugin.getCommandsConfig().getString("teleportation.setwarp") == "true"){
							Setwarp.Run(sender, args, playerType, plugin);
							return true;
						}else if(plugin.getCommandsConfig().getString("teleportation.setwarp") == "false"){
							MainCommandExecutor.Disabled("setwarp", sender);
							return true;
						}else{
							MainCommandExecutor.Error("setwarp", sender, plugin);
							return true;
						}
					}else if(cmd.getName().equalsIgnoreCase("warp")){
						Warp.Run(sender, args, playerType, plugin);
						return true;
					}
				}else if(plugin.getCommandsConfig().getString("teleportation.warp") == "false"){
					Disabled("warp", sender);
					return true;
				}else{
					Error("warp", sender, plugin);
					return true;
				}
			}
			return true;
		}else if(plugin.getCommandsConfig().getString("teleportation") == "false"){
			Disabled("teleportation", sender);
			return true;
		}else{
			Error("teleportation", sender, plugin);
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