package com.github.tadukoo.bukkit.essentials.commands;

import java.util.logging.Level;

import com.github.tadukoo.bukkit.essentials.TE;
import com.github.tadukoo.bukkit.essentials.commands.cheat.CheatCommandExecutor;
import com.github.tadukoo.bukkit.essentials.commands.general.GeneralCommandExecutor;
import com.github.tadukoo.bukkit.essentials.commands.moderator.ModeratorCommandExecutor;
import com.github.tadukoo.bukkit.essentials.commands.teleportation.TeleportationCommandExecutor;
import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.command.CommandExecutor;

public class CommandExec implements CommandExecutor{

	private final TE plugin;
	
	public CommandExec(TE plugin){
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		final String playerType;
		if(sender instanceof Player){
			playerType = "player";
		}else if(sender instanceof ConsoleCommandSender){
			playerType = "console";
		}else if(sender instanceof BlockCommandSender){
			playerType = "block";
		}else{
			playerType = "unknown";
		}
		if(cmd.getName().equalsIgnoreCase("t")){
			
		}else if(cmd.getName().equalsIgnoreCase(plugin.getCommandsConfig().getString("feed-name")) ||
				cmd.getName().equalsIgnoreCase("fly") ||
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
				cmd.getName().equalsIgnoreCase("killall") || cmd.getName().equalsIgnoreCase("ping") ||
				cmd.getName().equalsIgnoreCase("rain") || cmd.getName().equalsIgnoreCase("storm") || 
				cmd.getName().equalsIgnoreCase("sun") || cmd.getName().equalsIgnoreCase("weather")){
			ModeratorCommandExecutor.Run(sender, cmd, args, playerType, plugin);
			return true;
		}else if(cmd.getName().equalsIgnoreCase("delwarp") || cmd.getName().equalsIgnoreCase("setwarp") ||
				cmd.getName().equalsIgnoreCase("warp") || cmd.getName().equalsIgnoreCase("tp")){
			TeleportationCommandExecutor.Run(sender, cmd, args, playerType, plugin);
			return true;
		}
		return false;
	}

	public static void Disabled(String cmd, CommandSender sender){
		sender.sendMessage(ChatColor.RED + "/" + cmd + " is disabled.");
	}
	
	public static void Error(String cmd, CommandSender sender, TE plugin){
		plugin.logger.log(Level.WARNING, "You don't have " + cmd + " in commands.yml set correctly!");
		sender.sendMessage(ChatColor.RED + "Please let an admin know that they don't have " + cmd +
						" set correctly in the commands.yml file.");

	}
}