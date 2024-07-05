package com.gmail.lucario77777777.TE.commands.moderator;

import com.gmail.lucario77777777.TE.TE;
import com.gmail.lucario77777777.TE.commands.MainCommandExecutor;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Weather extends MainCommandExecutor{
	public Weather(TE plugin) {
		super(plugin);
	}
	
	public static boolean Run(CommandSender sender, String[] args, String playerType, TE plugin)
	{
		if(args.length == 0){
			sender.sendMessage("Not enough arguments!");
			return false;
		}else if(args.length >= 1){
			if(playerType == "player"){
				World world;
				Boolean storm;
				Boolean thunder;
				if(args[0].equalsIgnoreCase("sun")){
					storm = false;
					thunder = false;
				}else if(args[0].equalsIgnoreCase("rain")){
					storm = true;
					thunder = false;
				}else if(args[0].equalsIgnoreCase("storm")){
					storm = true;
					thunder = true;
				}else{
					sender.sendMessage(ChatColor.RED + "You must use sun, rain, or storm.");
					return false;
				}
				if(args.length >= 2){
					world = plugin.getServer().getWorld(args[1]);
				}else{
					world = ((Player) sender).getWorld();
				}
				world.setStorm(storm);
				world.setThundering(thunder);
				Bukkit.broadcastMessage(ChatColor.GREEN + "Weather set to " + args[0] + " in " + 
						world.getName() + "!");
				return true;
			}else{
				sender.sendMessage(ChatColor.RED + "You must be a player!");
				return true;
			}
		}else{
			sender.sendMessage(ChatColor.RED + "TOO MANY ARGUMENTS!");
			return false;
		}
	}
}