package com.gmail.lucario77777777.TE.teleportation;

import java.util.logging.Level;

import com.gmail.lucario77777777.TE.TE;
import com.gmail.lucario77777777.TE.commands.MainCommandExecutor;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class TeleportationCommandExecutor{

	public TeleportationCommandExecutor(TE plugin) {
		super();
	}
	public static boolean Run(CommandSender sender, Command cmd, String[] args, String playerType, TE plugin){
		if(plugin.getCommandsConfig().getString("com/gmail/lucario77777777/TE/teleportation") == "true"){
			if(cmd.getName().equalsIgnoreCase("tp")){
				if(plugin.getCommandsConfig().getString("tp") == "true"){
					Tp.Run(sender, args, playerType);
					return true;
				}else if(plugin.getCommandsConfig().getString("tp") == "false"){
					MainCommandExecutor.Disabled("tp", sender);
					return true;
				}else{
					MainCommandExecutor.Error("tp", sender, plugin);
					return true;
				}
			}else if(cmd.getName().equalsIgnoreCase("setwarp") || cmd.getName().equalsIgnoreCase("delwarp") ||
					cmd.getName().equalsIgnoreCase("warp")){
				if(plugin.getCommandsConfig().getString("warp") == "true"){
					if(cmd.getName().equalsIgnoreCase("delwarp")){
						if(plugin.getCommandsConfig().getString("delwarp") == "true"){
							Delwarp.Run(sender, args, playerType, plugin);
							return true;
						}else if(plugin.getCommandsConfig().getString("delwarp") == "false"){
							MainCommandExecutor.Disabled("delwarp", sender);
							return true;
						}else{
							MainCommandExecutor.Error("delwarp", sender, plugin);
							return true;
						}
					}else if(cmd.getName().equalsIgnoreCase("setwarp")){
						if(plugin.getCommandsConfig().getString("setwarp") == "true"){
							Setwarp.Run(sender, args, playerType, plugin);
							return true;
						}else if(plugin.getCommandsConfig().getString("setwarp") == "false"){
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
				}else if(plugin.getCommandsConfig().getString("warp") == "false"){
					Disabled("warp", sender);
					return true;
				}else{
					Error("warp", sender, plugin);
					return true;
				}
			}
			return true;
		}else if(plugin.getCommandsConfig().getString("com/gmail/lucario77777777/TE/teleportation") == "false"){
			Disabled("com/gmail/lucario77777777/TE/teleportation", sender);
			return true;
		}else{
			Error("com/gmail/lucario77777777/TE/teleportation", sender, plugin);
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