package com.github.tadukoo.bukkit.essentials.commands.moderator;

import java.util.logging.Level;

import com.github.tadukoo.bukkit.essentials.TE;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.github.tadukoo.bukkit.essentials.commands.CommandExec;

public class ModeratorCommandExecutor{

	public ModeratorCommandExecutor(TE plugin) {
		super();
	}
	public static boolean Run(CommandSender sender, Command cmd, String[] args, String playerType, TE plugin){
		if(plugin.getCommandsConfig().getString("moderator") == "true"){
			if(cmd.getName().equalsIgnoreCase("countdown")){
				if(plugin.getCommandsConfig().getString("countdown") == "true"){
					Countdown.Run(plugin);
					return true;
				}else if(plugin.getCommandsConfig().getString("countdown") == "false"){
					CommandExec.Disabled("countdown", sender);
					return true;
				}else{
					CommandExec.Error("countdown", sender, plugin);
					return true;
				}
			}else if(cmd.getName().equalsIgnoreCase("kill")){
				if(plugin.getCommandsConfig().getString("kill") == "true"){
					Kill.Run(sender, args);
					return true;
				}else if(plugin.getCommandsConfig().getString("kill") == "false"){
					CommandExec.Disabled("kill", sender);
					return true;
				}else{
					CommandExec.Error("kill", sender, plugin);
					return true;
				}
			}else if(cmd.getName().equalsIgnoreCase("killall")){
				if(plugin.getCommandsConfig().getString("killall") == "true"){
					Killall.Run(sender);
					return true;
				}else if(plugin.getCommandsConfig().getString("killall") == "false"){
					CommandExec.Disabled("killall", sender);
					return true;
				}else{
					CommandExec.Error("killall", sender, plugin);
					return true;
				}
			}else if(cmd.getName().equalsIgnoreCase("ping")){
				if(plugin.getCommandsConfig().getString("ping") == "true"){
					Ping.Run(sender, playerType);
					return true;
				}else if(plugin.getCommandsConfig().getString("ping") == "false"){
					CommandExec.Disabled("ping", sender);
					return true;
				}else{
					CommandExec.Error("ping", sender, plugin);
					return true;
				}
			}else if(cmd.getName().equalsIgnoreCase("rain")){
				if(plugin.getCommandsConfig().getString("rain") == "true"){
					Rain.Run(sender, args, playerType, plugin);
					return true;
				}else if(plugin.getCommandsConfig().getString("rain") == "false"){
					CommandExec.Disabled("rain", sender);
					return true;
				}else{
					CommandExec.Error("rain", sender, plugin);
				}
			}else if(cmd.getName().equalsIgnoreCase("storm")){
				if(plugin.getCommandsConfig().getString("storm") == "true"){
					Storm.Run(sender, args, playerType, plugin);
					return true;
				}else if(plugin.getCommandsConfig().getString("storm") == "false"){
					CommandExec.Disabled("storm", sender);
					return true;
				}else{
					CommandExec.Error("storm", sender, plugin);
				}
			}else if(cmd.getName().equalsIgnoreCase("sun")){
				if(plugin.getCommandsConfig().getString("sun") == "true"){
					Sun.Run(sender, args, playerType, plugin);
					return true;
				}else if(plugin.getCommandsConfig().getString("sun") == "false"){
					CommandExec.Disabled("sun", sender);
					return true;
				}else{
					CommandExec.Error("sun", sender, plugin);
					return true;
				}
			}else if(cmd.getName().equalsIgnoreCase("weather")){
				if(plugin.getCommandsConfig().getString("weather") == "true"){
					Weather.Run(sender, args, playerType, plugin);
					return true;
				}else if(plugin.getCommandsConfig().getString("weather") == "false"){
					CommandExec.Disabled("weather", sender);
					return true;
				}else{
					CommandExec.Error("weather", sender, plugin);
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

	public static void Error(String cmd, CommandSender sender, TE plugin){
		sender.sendMessage(ChatColor.RED + "Please inform an admin that they don't have " + cmd + " set " +
				"correctly in the commands.yml file.");
		plugin.logger.log(Level.WARNING, "You don't have " + cmd + " set correctly in the commands.yml file.");
	}
}