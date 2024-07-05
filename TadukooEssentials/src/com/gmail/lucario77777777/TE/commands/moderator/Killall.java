package com.gmail.lucario77777777.TE.commands.moderator;

import java.util.Iterator;

import com.gmail.lucario77777777.TE.TE;
import com.gmail.lucario77777777.TE.commands.CommandExec;

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