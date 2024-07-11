package com.github.tadukoo.bukkit.mobspawning;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MainCommandExecutor implements CommandExecutor{
	@SuppressWarnings("unused")
	private TM plugin;
	
	public MainCommandExecutor(TM plugin){
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if(cmd.getName().equalsIgnoreCase("mobs")){
			sender.sendMessage(ChatColor.GREEN + "You typed /mobs!");
			return true;
		}
		return false;
	}
	
}
