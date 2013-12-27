package com.gmail.lucario77777777.tadukooplugin.commands.moderator;

import java.util.logging.Level;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.gmail.lucario77777777.tadukooplugin.Main;
import com.gmail.lucario77777777.tadukooplugin.commands.MainCommandExecutor;

public class ModeratorCommandExecutor{

	public ModeratorCommandExecutor(Main plugin) {
		super();
	}
	public static boolean Run(CommandSender sender, Command cmd, String[] args, String playerType, Main plugin){
		if(plugin.getCommandsConfig().getString("moderator") == "true"){
			if(cmd.getName().equalsIgnoreCase("countdown")){
				if(plugin.getCommandsConfig().getString("countdown") == "true"){
					Countdown.Run(plugin);
					return true;
				}else if(plugin.getCommandsConfig().getString("countdown") == "false"){
					MainCommandExecutor.Disabled("countdown", sender);
					return true;
				}else{
					MainCommandExecutor.Error("countdown", sender, plugin);
					return true;
				}
			}else if(cmd.getName().equalsIgnoreCase("kill")){
				if(plugin.getCommandsConfig().getString("kill") == "true"){
					Kill.Run(sender, args);
					return true;
				}else if(plugin.getCommandsConfig().getString("kill") == "false"){
					MainCommandExecutor.Disabled("kill", sender);
					return true;
				}else{
					MainCommandExecutor.Error("kill", sender, plugin);
					return true;
				}
			}else if(cmd.getName().equalsIgnoreCase("killall")){
				if(plugin.getCommandsConfig().getString("killall") == "true"){
					Killall.Run(sender);
					return true;
				}else if(plugin.getCommandsConfig().getString("killall") == "false"){
					MainCommandExecutor.Disabled("killall", sender);
					return true;
				}else{
					MainCommandExecutor.Error("killall", sender, plugin);
					return true;
				}
			}else if(cmd.getName().equalsIgnoreCase("ping")){
				if(plugin.getCommandsConfig().getString("ping") == "true"){
					Ping.Run(sender, playerType);
					return true;
				}else if(plugin.getCommandsConfig().getString("ping") == "false"){
					MainCommandExecutor.Disabled("ping", sender);
					return true;
				}else{
					MainCommandExecutor.Error("ping", sender, plugin);
					return true;
				}
			}else if(cmd.getName().equalsIgnoreCase("rain")){
				if(plugin.getCommandsConfig().getString("rain") == "true"){
					Rain.Run(sender, args, playerType, plugin);
					return true;
				}else if(plugin.getCommandsConfig().getString("rain") == "false"){
					MainCommandExecutor.Disabled("rain", sender);
					return true;
				}else{
					MainCommandExecutor.Error("rain", sender, plugin);
				}
			}else if(cmd.getName().equalsIgnoreCase("storm")){
				if(plugin.getCommandsConfig().getString("storm") == "true"){
					Storm.Run(sender, args, playerType, plugin);
					return true;
				}else if(plugin.getCommandsConfig().getString("storm") == "false"){
					MainCommandExecutor.Disabled("storm", sender);
					return true;
				}else{
					MainCommandExecutor.Error("storm", sender, plugin);
				}
			}else if(cmd.getName().equalsIgnoreCase("sun")){
				if(plugin.getCommandsConfig().getString("sun") == "true"){
					Sun.Run(sender, args, playerType, plugin);
					return true;
				}else if(plugin.getCommandsConfig().getString("sun") == "false"){
					MainCommandExecutor.Disabled("sun", sender);
					return true;
				}else{
					MainCommandExecutor.Error("sun", sender, plugin);
					return true;
				}
			}
			return true;
		}else if(plugin.getCommandsConfig().getString("moderator") == "false"){
			Disabled("moderator", sender);
			return true;
		}else{
			Error("moderator", sender, plugin);
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