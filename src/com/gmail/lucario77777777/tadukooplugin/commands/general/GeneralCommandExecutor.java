package com.gmail.lucario77777777.tadukooplugin.commands.general;

import java.util.logging.Level;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.gmail.lucario77777777.tadukooplugin.Main;
import com.gmail.lucario77777777.tadukooplugin.commands.MainCommandExecutor;

public class GeneralCommandExecutor{

	public GeneralCommandExecutor(Main plugin) {
		super();
	}
	public static boolean Run(CommandSender sender, Command cmd, String[] args, String playerType, Main plugin){
		if(plugin.getCommandsConfig().getString("general") == "true"){
			if(cmd.getName().equalsIgnoreCase("motd")){
				if(plugin.getCommandsConfig().getString("general.motd") == "true"){
					MOTD.Run(sender, plugin);
					return true;
				}else if(plugin.getCommandsConfig().getString("general.motd") == "false"){
					MainCommandExecutor.Disabled("motd", sender);
					return true;
				}else{
					MainCommandExecutor.Error("motd", sender, plugin);
					return true;
				}
			}else if(cmd.getName().equalsIgnoreCase("suicide")){
				if(plugin.getCommandsConfig().getString("general.suicide") == "true"){
					Suicide.Run(sender, args, playerType);
					return true;
				}else if(plugin.getCommandsConfig().getString("general.suicide") == "false"){
					MainCommandExecutor.Disabled("suicide", sender);
					return true;
				}else{
					MainCommandExecutor.Error("suicide", sender, plugin);
					return true;
				}
			}else if(cmd.getName().equalsIgnoreCase("thelp")){
				if(plugin.getCommandsConfig().getString("general.thelp") == "true"){
					THelp.Run(sender, args);
					return true;
				}else if(plugin.getCommandsConfig().getString("general.thelp") == "false"){
					MainCommandExecutor.Disabled("thelp", sender);
					return true;
				}else{
					MainCommandExecutor.Error("thelp", sender, plugin);
					return true;
				}
			}
			return true;
		}else if(plugin.getCommandsConfig().getString("general") == "false"){
			Disabled("general", sender);
			return true;
		}else{
			Error("general", sender, plugin);
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
