package com.gmail.lucario77777777.tadukooplugin.commands;

import java.util.logging.Level;

import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.command.CommandExecutor;

import com.gmail.lucario77777777.tadukooplugin.Main;
import com.gmail.lucario77777777.tadukooplugin.commands.cheat.CheatCommandExecutor;
import com.gmail.lucario77777777.tadukooplugin.commands.general.GeneralCommandExecutor;
import com.gmail.lucario77777777.tadukooplugin.commands.moderator.ModeratorCommandExecutor;
import com.gmail.lucario77777777.tadukooplugin.commands.teleportation.TeleportationCommandExecutor;

public class MainCommandExecutor implements CommandExecutor {

	private Main plugin;
	
	public MainCommandExecutor(Main plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		final String playerType;
		if (sender instanceof Player){
			playerType = "player";
		}else if(sender instanceof ConsoleCommandSender){
			playerType = "console";
		}else if(sender instanceof BlockCommandSender){
			playerType = "block";
		}else{
			playerType = "unknown";
		}
		if(cmd.getName().equalsIgnoreCase("feed") || cmd.getName().equalsIgnoreCase("fly") ||
				cmd.getName().equalsIgnoreCase("adventure") || cmd.getName().equalsIgnoreCase("gma") || 
				cmd.getName().equalsIgnoreCase("creative") || cmd.getName().equalsIgnoreCase("gmc") || 
				cmd.getName().equalsIgnoreCase("survival") || cmd.getName().equalsIgnoreCase("gms") || 
				cmd.getName().equalsIgnoreCase("gm") || cmd.getName().equalsIgnoreCase("gmt") || 
				cmd.getName().equalsIgnoreCase("gamemode") || cmd.getName().equalsIgnoreCase("heal") ||
				cmd.getName().equalsIgnoreCase("starve") || cmd.getName().equalsIgnoreCase("time") ||
				cmd.getName().equalsIgnoreCase("day") || cmd.getName().equalsIgnoreCase("night")){
			CheatCommandExecutor.Run(sender, cmd, args, playerType, plugin);
			return true;
		}else if(cmd.getName().equalsIgnoreCase("motd") || cmd.getName().equalsIgnoreCase("suicide") ||
				cmd.getName().equalsIgnoreCase("thelp")){
			GeneralCommandExecutor.Run(sender, cmd, args, playerType, plugin);
			return true;
		}else if(cmd.getName().equalsIgnoreCase("countdown") || cmd.getName().equalsIgnoreCase("kill") ||
				cmd.getName().equalsIgnoreCase("killall") || cmd.getName().equalsIgnoreCase("ping")){
			ModeratorCommandExecutor.Run(sender, cmd, args, playerType, plugin);
			return true;
		}else if(cmd.getName().equalsIgnoreCase("delwarp") || cmd.getName().equalsIgnoreCase("setwarp") ||
				cmd.getName().equalsIgnoreCase("warp") || cmd.getName().equalsIgnoreCase("tp")){
			TeleportationCommandExecutor.Run(sender, cmd, args, playerType, plugin);
			return true;
		}else if(cmd.getName().equalsIgnoreCase("sun")){
			Sun.Run(sender, args, playerType);
			return true;
		}
		return false;
	}

	public static void Disabled(String cmd, CommandSender sender)
	{
		sender.sendMessage(ChatColor.RED + "/" + cmd + " is disabled.");
	}
	
	public static void Error(String cmd, CommandSender sender, Main plugin)
	{
		plugin.logger.log(Level.WARNING, "You don't have " + cmd + " in commands.yml set correctly!");
		sender.sendMessage(ChatColor.RED + "Please let an admin know that they don't have " + cmd +
						" set correctly in the commands.yml file.");

	}
}