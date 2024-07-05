package com.gmail.lucario77777777.TE.commands.moderator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.gmail.lucario77777777.TE.TE;
import com.gmail.lucario77777777.TE.commands.MainCommandExecutor;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Killall extends MainCommandExecutor{
	public Killall(TE plugin) {
		super(plugin);
	}
	
	public static boolean Run(CommandSender sender)
	{
		List<Player> onlinePlayerList = Arrays.asList(Bukkit.getServer().getOnlinePlayers());
		Iterator<Player> itr = onlinePlayerList.iterator();
		
		while(itr.hasNext()){
			Player player = itr.next();
			player.setHealth(0);
		return true;
}
		return false;
}
}