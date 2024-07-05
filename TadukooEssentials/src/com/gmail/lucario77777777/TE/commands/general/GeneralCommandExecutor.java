package com.gmail.lucario77777777.TE.commands.general;

import java.util.logging.Level;

import com.gmail.lucario77777777.TE.TE;
import com.gmail.lucario77777777.TE.commands.MainCommandExecutor;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class GeneralCommandExecutor{

	public GeneralCommandExecutor(TE plugin) {
		super();
	}
	public static boolean Run(CommandSender sender, Command cmd, String[] args, String playerType, TE plugin){
		if(plugin.getCommandsConfig().getString("com/gmail/lucario77777777/TE/commands/general") == "true"){
			if(cmd.getName().equalsIgnoreCase("motd")){
				if(plugin.getCommandsConfig().getString("motd") == "true"){
					MOTD.Run(sender, plugin);
					return true;
				}else if(plugin.getCommandsConfig().getString("motd") == "false"){
					MainCommandExecutor.Disabled("motd", sender);
					return true;
				}else{
					MainCommandExecutor.Error("motd", sender, plugin);
					return true;
				}
			}else if(cmd.getName().equalsIgnoreCase("suicide")){
				if(plugin.getCommandsConfig().getString("suicide") == "true"){
					Suicide.Run(sender, args, playerType);
					return true;
				}else if(plugin.getCommandsConfig().getString("suicide") == "false"){
					MainCommandExecutor.Disabled("suicide", sender);
					return true;
				}else{
					MainCommandExecutor.Error("suicide", sender, plugin);
					return true;
				}
			}else if(cmd.getName().equalsIgnoreCase("thelp")){
				if(plugin.getCommandsConfig().getString("thelp") == "true"){
					THelp.Run(sender, args);
					return true;
				}else if(plugin.getCommandsConfig().getString("thelp") == "false"){
					MainCommandExecutor.Disabled("thelp", sender);
					return true;
				}else{
					MainCommandExecutor.Error("thelp", sender, plugin);
					return true;
				}
			}
			return true;
		}else if(plugin.getCommandsConfig().getString("com/gmail/lucario77777777/TE/commands/general") == "false"){
			Disabled("com/gmail/lucario77777777/TE/commands/general", sender);
			return true;
		}else{
			Error("com/gmail/lucario77777777/TE/commands/general", sender, plugin);
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
