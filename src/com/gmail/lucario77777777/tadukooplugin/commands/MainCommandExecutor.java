package com.gmail.lucario77777777.tadukooplugin.commands;

import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.command.CommandExecutor;

import com.gmail.lucario77777777.tadukooplugin.Main;
import com.gmail.lucario77777777.tadukooplugin.commands.Ping;

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
		if(cmd.getName().equalsIgnoreCase("ping")){
			if(plugin.getConfig().getString("Ping") == "true"){
				Ping.Run(sender, playerType);
				return true;
			}else if(plugin.getConfig().getString("Ping") == "bukkit" || plugin.getConfig().getString("Ping") == "false"){
				Ping.Disabled(sender);
				return true;
			}
		}else if(cmd.getName().equalsIgnoreCase("tport")){
			Tport.TportRun(sender, args, playerType);
			return true;
		}else if(cmd.getName().equalsIgnoreCase("heal")){
			Heal.HealRun(sender, args, playerType);
			return true;
		}else if(cmd.getName().equalsIgnoreCase("kill")){
			Kill.KillRun(sender, args);
			return true;
		}else if(cmd.getName().equalsIgnoreCase("feed")){
			Feed.FeedRun(sender, args, playerType);
			return true;
		}else if(cmd.getName().equalsIgnoreCase("starve")){
			Starve.StarveRun(sender, args);
			return true;
		}else if(cmd.getName().equalsIgnoreCase("suicide")){
			Suicide.SuicideRun(sender, args, playerType);
			return true;
		}else if(cmd.getName().equalsIgnoreCase("gamemode") || cmd.getName().equalsIgnoreCase("gm") || cmd.getName().equalsIgnoreCase("gmt")){
			Gamemode.GamemodeRun(sender, args, playerType);
			return true;
		}else if(cmd.getName().equalsIgnoreCase("adventure") || cmd.getName().equalsIgnoreCase("gma")){
			Adventure.AdventureRun(sender, args, playerType);
			return true;
		}else if(cmd.getName().equalsIgnoreCase("creative") || cmd.getName().equalsIgnoreCase("gmc")){
			Creative.CreativeRun(sender, args, playerType);
			return true;
		}else if(cmd.getName().equalsIgnoreCase("survival") || cmd.getName().equalsIgnoreCase("gms")){
			Survival.SurvivalRun(sender, args, playerType);
			return true;
		}else if(cmd.getName().equalsIgnoreCase("fly")){
			Fly.FlyRun(sender, args, playerType);
			return true;
		}else if(cmd.getName().equalsIgnoreCase("killall")){
			Killall.KillallRun(sender);
			return true;
		}else if(cmd.getName().equalsIgnoreCase("motd")){
			MOTD.MOTDRun(sender, plugin);
			return true;
		}else if(cmd.getName().equalsIgnoreCase("time")){
			Time.TimeRun(sender, args, playerType);
			return true;
		}else if(cmd.getName().equalsIgnoreCase("timer")){
			Timer.TimerRun(plugin);
			return true;
		}else if(cmd.getName().equalsIgnoreCase("day")){
			Day.Run(sender, args, playerType);
			return true;
		}else if(cmd.getName().equalsIgnoreCase("night")){
			Night.Run(sender, args, playerType);
			return true;
		}/*else if(cmd.getName().equalsIgnoreCase("setwarp")){
			Setwarp.SetwarpRun(sender, args, playerType, plugin);
			return true;
		*** Removed until a later version. ***
		}*/else if(cmd.getName().equalsIgnoreCase("thelp")){
			THelp.THelpRun(sender, args);
			return true;
		}
		return false;
	}
}