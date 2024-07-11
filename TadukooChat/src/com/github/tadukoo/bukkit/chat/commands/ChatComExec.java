package com.github.tadukoo.bukkit.chat.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatComExec implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args){
		return false;
	}
	
	public static boolean checkPerm(Player player, String perm){
		if(player.hasPermission("TadukooChat." + perm)){
			return true;
		}else{
			return false;
		}
	}
}
