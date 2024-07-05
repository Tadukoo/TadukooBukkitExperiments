package com.github.tadukoo.bukkit.essentials.commands.moderator;

import java.util.Iterator;

import com.github.tadukoo.bukkit.essentials.TE;
import com.github.tadukoo.bukkit.essentials.commands.CommandExec;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Killall extends CommandExec{
	public Killall(TE plugin){
		super(plugin);
	}
	
	public static boolean Run(CommandSender sender){
		@SuppressWarnings("unchecked")
		Iterator<Player> itr = (Iterator<Player>) Bukkit.getOnlinePlayers().iterator();
		
		while(itr.hasNext()){
			Player player = itr.next();
			player.setHealth(0);
		return true;
		}
		return false;
	}
}