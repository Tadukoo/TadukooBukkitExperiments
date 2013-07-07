package com.gmail.lucario77777777.tadukooplugin.commands;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.gmail.lucario77777777.tadukooplugin.commands.MainCommandExecutor;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gmail.lucario77777777.tadukooplugin.Main;

public class Killall extends MainCommandExecutor {
	public Killall(Main plugin) {
		super(plugin);
	}
	
	public static boolean KillallRun(CommandSender sender)
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