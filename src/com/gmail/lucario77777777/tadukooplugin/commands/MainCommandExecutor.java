package com.gmail.lucario77777777.tadukooplugin.commands;

import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.command.CommandExecutor;

import com.gmail.lucario77777777.tadukooplugin.Main;

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
		if(cmd.getName().equalsIgnoreCase("adventure") || cmd.getName().equalsIgnoreCase("gma")){
			Adventure.Run(sender, args, playerType);
			return true;
		}else if(cmd.getName().equalsIgnoreCase("countdown")){
			Countdown.Run(plugin);
			return true;
		}else if(cmd.getName().equalsIgnoreCase("creative") || cmd.getName().equalsIgnoreCase("gmc")){
			Creative.Run(sender, args, playerType);
			return true;
		}else if(cmd.getName().equalsIgnoreCase("day")){
			Day.Run(sender, args, playerType);
			return true;
		}else if(cmd.getName().equalsIgnoreCase("delwarp")){
			Delwarp.Run(sender, args, playerType, plugin);
			return true;
		}else if(cmd.getName().equalsIgnoreCase("feed")){
			Feed.Run(sender, args, playerType);
			return true;
		}else if(cmd.getName().equalsIgnoreCase("fly")){
			Fly.Run(sender, args, playerType);
			return true;
		}else if(cmd.getName().equalsIgnoreCase("gamemode") || cmd.getName().equalsIgnoreCase("gm") || cmd.getName().equalsIgnoreCase("gmt")){
			Gamemode.Run(sender, args, playerType);
			return true;
		}else if(cmd.getName().equalsIgnoreCase("heal")){
			Heal.Run(sender, args, playerType);
			return true;
		}else if(cmd.getName().equalsIgnoreCase("kill")){
			Kill.Run(sender, args);
			return true;
		}else if(cmd.getName().equalsIgnoreCase("killall")){
			Killall.Run(sender);
			return true;
		}else if(cmd.getName().equalsIgnoreCase("motd")){
			MOTD.Run(sender, plugin);
			return true;
		}else if(cmd.getName().equalsIgnoreCase("night")){
			Night.Run(sender, args, playerType);
			return true;
		}else if(cmd.getName().equalsIgnoreCase("ping")){
			if(plugin.getCommandsConfig().getString("Ping") == "true"){
				Ping.Run(sender, playerType);
				return true;
			}else if(plugin.getCommandsConfig().getString("Ping") == "bukkit" || plugin.getConfig().getString("Ping") == "false"){
				Ping.Disabled(sender);
				return true;
			}
		}else if(cmd.getName().equalsIgnoreCase("setwarp")){
			Setwarp.Run(sender, args, playerType, plugin);
			return true;
		}else if(cmd.getName().equalsIgnoreCase("starve")){
			Starve.Run(sender, args);
			return true;
		}else if(cmd.getName().equalsIgnoreCase("suicide")){
			Suicide.Run(sender, args, playerType);
			return true;
		}else if(cmd.getName().equalsIgnoreCase("sun")){
			Sun.Run(sender, args, playerType);
			return true;
		}else if(cmd.getName().equalsIgnoreCase("survival") || cmd.getName().equalsIgnoreCase("gms")){
			Survival.Run(sender, args, playerType);
			return true;
		}else if(cmd.getName().equalsIgnoreCase("thelp")){
			THelp.Run(sender, args);
			return true;
		}else if(cmd.getName().equalsIgnoreCase("time")){
			Time.Run(sender, args, playerType);
			return true;
		}else if(cmd.getName().equalsIgnoreCase("tp")){
			Tp.Run(sender, args, playerType);
			return true;
		}else if(cmd.getName().equalsIgnoreCase("warp")){
			Warp.Run(sender, args, playerType, plugin);
			return true;
		}
		return false;
	}
}