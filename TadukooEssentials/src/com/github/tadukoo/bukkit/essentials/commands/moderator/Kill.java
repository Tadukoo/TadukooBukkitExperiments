package com.github.tadukoo.bukkit.essentials.commands.moderator;

import com.github.tadukoo.bukkit.essentials.TE;
import com.github.tadukoo.bukkit.essentials.commands.CommandExec;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Kill extends CommandExec {
	public Kill(TE plugin) {
		super(plugin);
	}
	
	@SuppressWarnings("deprecation")
	public static boolean Run(CommandSender sender, String[] args)
	{
		if(args.length == 0){
			sender.sendMessage(ChatColor.DARK_RED + "NOT ENOUGH ARGUMENTS!");
			return true;
		}else if(args.length == 1){
			if(sender.getServer().getPlayer(args[0]) != null){
				Player targetPlayer = sender.getServer().getPlayer(args [0]);
				targetPlayer.setHealth(0);
				sender.sendMessage(ChatColor.GREEN + "Killed " + targetPlayer.getDisplayName() + "!");
				targetPlayer.sendMessage(ChatColor.RED + "You died!");
				return true;
		    }else{
		    	sender.sendMessage(ChatColor.RED + "PLAYER NOT ONLINE!");
		    	return true;
		    	}
		}
		return false;
}
}