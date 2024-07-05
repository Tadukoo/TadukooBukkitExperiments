package com.github.tadukoo.bukkit.vanillafeel;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Commands{
	
	public static void plugins(Player player){
		player.sendMessage(ChatColor.WHITE + "Plugins (0): ");
	}
	
	public static void no(Player player){
		player.sendMessage(ChatColor.WHITE + "Unknown command. Type \"/help\" for help.");
	}
	
	public static void nonOp(Player player){
		player.sendMessage(ChatColor.RED + "I'm sorry, but you do not have permission to perform this " +
				"command. Please contact the server administrators if you believe that this in in error.");
	}
	
	public static void version(Player player){
		player.sendMessage(ChatColor.WHITE + "This server is not running any plugin by that name.");
		player.sendMessage(ChatColor.WHITE + "Use /plugins to get a list of plugins.");
	}
	
	public static void kill(TVF plugin, Player player){
		player.setHealth(0);
		plugin.getServer().broadcastMessage("Ouch. That look like it hurt.");
	}
	
	public static void tell(TVF plugin, Player player, String message){
		String[] args = message.split(" ");
		if(args.length < 3){
			player.sendMessage(ChatColor.RED + "Usage: /tell <player> <message>");
		}else{
			Player receiver = plugin.getServer().getPlayer(args[1]);
			if(receiver == null){
				player.sendMessage(ChatColor.WHITE + "There's no player by that name online.");
			}else{
				String pName = player.getName();
				String rName = receiver.getName();
				StringBuilder msg = new StringBuilder();
				for(int i = 2; i < args.length; i++){
					msg.append(args[i]).append(" ");
				}
				player.sendMessage(ChatColor.WHITE + "[" + pName + "->" + rName + "] " + msg);
				receiver.sendMessage(ChatColor.GRAY + pName + " whispers " + msg);
			}
		}
	}
	
	public static void me(TVF plugin, Player player, String message){
		String[] args = message.split(" ");
		if(args.length < 2){
			player.sendMessage(ChatColor.RED + "Usage: /me <action>");
		}else{
			StringBuilder msg = new StringBuilder();
			for(int i = 1; i < args.length; i++){
				msg.append(args[i]).append(" ");
			}
			plugin.getServer().broadcastMessage("* " + player.getName() + " " + msg);
		}
	}
	
	public static void help(Player player, String message){
		String[] args = message.split(" ");
		int argsL = args.length;
		if(argsL == 1 || args[1].equalsIgnoreCase("1")){
			player.sendMessage(ChatColor.YELLOW + "--------- " + ChatColor.WHITE + "Help: Index (1/2) " +
					ChatColor.YELLOW + "---------------------");
			player.sendMessage(ChatColor.GRAY + "Use /help [n] to get page n of help.");
			player.sendMessage(ChatColor.GOLD + "Aliases: " + ChatColor.WHITE + "Lists command aliases");
			player.sendMessage(ChatColor.GOLD + "Bukkit: " + ChatColor.WHITE + "All commands for Bukkit");
			player.sendMessage(ChatColor.GOLD + "Minecraft: " + ChatColor.WHITE + "All commands for " +
					"Minecraft");
			player.sendMessage(ChatColor.GOLD + "/help: " + ChatColor.WHITE + "Shows the help menu");
			player.sendMessage(ChatColor.GOLD + "/kill: " + ChatColor.WHITE + "Commits suicide, only usable " +
					"as a player");
			player.sendMessage(ChatColor.GOLD + "/me: " + ChatColor.WHITE + "Performs the specified action " +
					"in chat");
			player.sendMessage(ChatColor.GOLD + "/plugins: " + ChatColor.WHITE + "Gets a list of plugins " +
					"running on the ...");
			player.sendMessage(ChatColor.GOLD + "/tell: " + ChatColor.WHITE + "Sends a private message to " +
					"the given player");
		}else if(args[1].equalsIgnoreCase("2")){
			player.sendMessage(ChatColor.YELLOW + "--------- " + ChatColor.WHITE + "Help: Index (2/2) " +
					ChatColor.YELLOW + "---------------------");
			player.sendMessage(ChatColor.GOLD + "/version: " + ChatColor.WHITE + "Gets the version of this " +
					"server includ...");
		}else if(args[1].equalsIgnoreCase("aliases")){
			player.sendMessage(ChatColor.YELLOW + "--------- " + ChatColor.WHITE + "Help: Aliases " +
					ChatColor.YELLOW + "-------------------------");
			player.sendMessage(ChatColor.GOLD + "/?: " + ChatColor.YELLOW + "Alias for " + ChatColor.WHITE + 
					"/help");
			player.sendMessage(ChatColor.GOLD + "/about: " + ChatColor.YELLOW + "Alias for " + 
					ChatColor.WHITE + "/version");
			player.sendMessage(ChatColor.GOLD + "/msg: " + ChatColor.YELLOW + "Alias for " + 
					ChatColor.WHITE + "/tell");
			player.sendMessage(ChatColor.GOLD + "/pl: " + ChatColor.YELLOW + "Alias for " + 
					ChatColor.WHITE + "/plugins");
			player.sendMessage(ChatColor.GOLD + "/ver: " + ChatColor.YELLOW + "Alias for " + 
					ChatColor.WHITE + "/version");
			player.sendMessage(ChatColor.GOLD + "/w: " + ChatColor.YELLOW + "Alias for " + 
					ChatColor.WHITE + "/tell");
		}else if(args[1].equalsIgnoreCase("bukkit")){
			player.sendMessage(ChatColor.YELLOW + "--------- " + ChatColor.WHITE + "Help: Bukkit " +
					ChatColor.YELLOW + "--------------------------");
			player.sendMessage(ChatColor.GRAY + "Below is a list of all Bukkit commands:");
			player.sendMessage(ChatColor.GOLD + "/help: " + ChatColor.WHITE + "Shows the help menu");
			player.sendMessage(ChatColor.GOLD + "/kill: " + ChatColor.WHITE + "Commits suicide, only usable " +
					"as a player");
			player.sendMessage(ChatColor.GOLD + "/me: " + ChatColor.WHITE + "Performs the specified action " +
					"in chat");
			player.sendMessage(ChatColor.GOLD + "/plugins: " + ChatColor.WHITE + "Gets a list of plugins " +
					"running on the ...");
			player.sendMessage(ChatColor.GOLD + "/tell: " + ChatColor.WHITE + "Sends a private message to " +
					"the given player");
			player.sendMessage(ChatColor.GOLD + "/version: " + ChatColor.WHITE + "Gets the version of this " +
					"server includ...");
		}else if(args[1].equalsIgnoreCase("Minecraft")){
			player.sendMessage(ChatColor.YELLOW + "--------- " + ChatColor.WHITE + "Help: Minecraft " +
					ChatColor.YELLOW + "-----------------------");
			player.sendMessage(ChatColor.GRAY + "Below is a list of Minecraft commands:");
		}else if(args[1].equalsIgnoreCase("?") || args[1].equalsIgnoreCase("/?")){
			player.sendMessage(ChatColor.YELLOW + "--------- " + ChatColor.WHITE + "Help: /? " +
					ChatColor.YELLOW + "-------------------------------");
			player.sendMessage(ChatColor.YELLOW + "Alias for " + ChatColor.WHITE + "/help");
			player.sendMessage(ChatColor.GOLD + "Description: " + ChatColor.WHITE + "Shows the help menu");
			player.sendMessage(ChatColor.GOLD + "Usage: " + ChatColor.WHITE + "/help <pageNumber>");
			player.sendMessage(ChatColor.WHITE + "/help <topic>");
			player.sendMessage(ChatColor.WHITE + "/help <topic> <pageNumber>");
			player.sendMessage(ChatColor.GOLD + "Aliases: " + ChatColor.WHITE + "?");
		}else if(args[1].equalsIgnoreCase("help") || args[1].equalsIgnoreCase("/help")){
			player.sendMessage(ChatColor.YELLOW + "--------- " + ChatColor.WHITE + "Help: /help " +
					ChatColor.YELLOW + "---------------------------");
			player.sendMessage(ChatColor.GOLD + "Description: " + ChatColor.WHITE + "Shows the help menu");
			player.sendMessage(ChatColor.GOLD + "Usage: " + ChatColor.WHITE + "/help <pageNumber>");
			player.sendMessage(ChatColor.WHITE + "/help <topic>");
			player.sendMessage(ChatColor.WHITE + "/help <topic> <pageNumber>");
			player.sendMessage(ChatColor.GOLD + "Aliases: " + ChatColor.WHITE + "?");
		}else if(args[1].equalsIgnoreCase("kill") || args[1].equalsIgnoreCase("/kill")){
			player.sendMessage(ChatColor.YELLOW + "--------- " + ChatColor.WHITE + "Help: /kill " +
					ChatColor.YELLOW + "---------------------------");
			player.sendMessage(ChatColor.GOLD + "Description: " + ChatColor.WHITE + "Commits suicide, only " +
					"usable as a player.");
			player.sendMessage(ChatColor.GOLD + "Usage: " + ChatColor.WHITE + "/kill");
		}else if(args[1].equalsIgnoreCase("me") || args[1].equalsIgnoreCase("/me")){
			player.sendMessage(ChatColor.YELLOW + "--------- " + ChatColor.WHITE + "Help: /me " +
					ChatColor.YELLOW + "------------------------------");
			player.sendMessage(ChatColor.GOLD + "Description: " + ChatColor.WHITE + "Performs the " +
					"specified action in chat.");
			player.sendMessage(ChatColor.GOLD + "Usage: " + ChatColor.WHITE + "/me <action>");
		}else if(args[1].equalsIgnoreCase("pl") || args[1].equalsIgnoreCase("/pl")){
			player.sendMessage(ChatColor.YELLOW + "--------- " + ChatColor.WHITE + "Help: /pl " +
					ChatColor.YELLOW + "------------------------------");
			player.sendMessage(ChatColor.YELLOW + "Alias for " + "/plugins");
			player.sendMessage(ChatColor.GOLD + "Description: " + ChatColor.WHITE + "Gets a list of plugins " +
					"running on the server.");
			player.sendMessage(ChatColor.GOLD + "Usage: " + ChatColor.WHITE + "/plugins");
			player.sendMessage(ChatColor.GOLD + "Aliases: " + ChatColor.WHITE + "pl");
		}else if(args[1].equalsIgnoreCase("plugins") || args[1].equalsIgnoreCase("/plugins")){
			player.sendMessage(ChatColor.GOLD + "Description: " + ChatColor.WHITE + "Gets a list of plugins " +
					"running on the server.");
			player.sendMessage(ChatColor.GOLD + "Usage: " + ChatColor.WHITE + "/plugins");
			player.sendMessage(ChatColor.GOLD + "Aliases: " + ChatColor.WHITE + "pl");
		}else if(args[1].equalsIgnoreCase("tell") || args[1].equalsIgnoreCase("/tell")){
			player.sendMessage(ChatColor.YELLOW + "--------- " + ChatColor.WHITE + "Help: /tell " +
					ChatColor.YELLOW + "---------------------------");
			player.sendMessage(ChatColor.GOLD + "Description: " + ChatColor.WHITE + "Sends a private  " +
					"message to the givenplayer");
			player.sendMessage(ChatColor.GOLD + " ");
			player.sendMessage(ChatColor.GOLD + "Usage: " + ChatColor.WHITE + "/tell <player> <message>");
			player.sendMessage(ChatColor.GOLD + "Aliases: " + ChatColor.WHITE + "w, msg");
		}else if(args[1].equalsIgnoreCase("msg") || args[1].equalsIgnoreCase("/msg")){
			player.sendMessage(ChatColor.YELLOW + "--------- " + ChatColor.WHITE + "Help: /msg " +
					ChatColor.YELLOW + "----------------------------");
			player.sendMessage(ChatColor.YELLOW + "Alias for " + ChatColor.WHITE + "/tell");
			player.sendMessage(ChatColor.GOLD + "Description: " + ChatColor.WHITE + "Sends a private  " +
					"message to the given player");
			player.sendMessage(ChatColor.GOLD + "Usage: " + ChatColor.WHITE + "/tell <player> <message>");
			player.sendMessage(ChatColor.GOLD + "Aliases: " + ChatColor.WHITE + "w, msg");
		}else if(args[1].equalsIgnoreCase("w") || args[1].equalsIgnoreCase("/w")){
			player.sendMessage(ChatColor.YELLOW + "--------- " + ChatColor.WHITE + "Help: /w " +
					ChatColor.YELLOW + "------------------------------");
			player.sendMessage(ChatColor.YELLOW + "Alias for " + ChatColor.WHITE + "/tell");
			player.sendMessage(ChatColor.GOLD + "Description: " + ChatColor.WHITE + "Sends a private  " +
					"message to the given player");
			player.sendMessage(ChatColor.GOLD + "Usage: " + ChatColor.WHITE + "/tell <player> <message>");
			player.sendMessage(ChatColor.GOLD + "Aliases: " + ChatColor.WHITE + "w, msg");
		}else if(args[1].equalsIgnoreCase("version") || args[1].equalsIgnoreCase("/version")){
			player.sendMessage(ChatColor.YELLOW + "--------- " + ChatColor.WHITE + "Help: /version " +
					ChatColor.YELLOW + "------------------------");
			player.sendMessage(ChatColor.GOLD + "Description: " + ChatColor.WHITE + "Gets the version of " +
					"this server including");
			player.sendMessage(ChatColor.WHITE + "any plugins in use");
			player.sendMessage(ChatColor.GOLD + "Usage: " + ChatColor.WHITE + "/version [plugin name]");
			player.sendMessage(ChatColor.GOLD + "Aliases: " + ChatColor.WHITE + "ver, about");
		}else if(args[1].equalsIgnoreCase("ver") || args[1].equalsIgnoreCase("/ver")){
			player.sendMessage(ChatColor.YELLOW + "--------- " + ChatColor.WHITE + "Help: /ver " +
					ChatColor.YELLOW + "-----------------------------");
			player.sendMessage(ChatColor.YELLOW + "Alias for " + ChatColor.WHITE + "/version");
			player.sendMessage(ChatColor.GOLD + "Description: " + ChatColor.WHITE + "Gets the version of " +
					"this server including any");
			player.sendMessage(ChatColor.WHITE + "plugins in use");
			player.sendMessage(ChatColor.GOLD + "Usage: " + ChatColor.WHITE + "/version [plugin name]");
			player.sendMessage(ChatColor.GOLD + "Aliases: " + ChatColor.WHITE + "ver, about");
		}else if(args[1].equalsIgnoreCase("about") || args[1].equalsIgnoreCase("/about")){
			player.sendMessage(ChatColor.YELLOW + "--------- " + ChatColor.WHITE + "Help: /about " +
					ChatColor.YELLOW + "-------------------------------");
			player.sendMessage(ChatColor.YELLOW + "Alias for " + ChatColor.WHITE + "/version");
			player.sendMessage(ChatColor.GOLD + "Description: " + ChatColor.WHITE + "Gets the version of " +
					"this server including any");
			player.sendMessage(ChatColor.WHITE + "plugins in use");
			player.sendMessage(ChatColor.GOLD + "Usage: " + ChatColor.WHITE + "/version [plugin name]");
			player.sendMessage(ChatColor.GOLD + "Aliases: " + ChatColor.WHITE + "ver, about");
		}else{
			try{
				Integer.parseInt(args[1]);
				player.sendMessage(ChatColor.YELLOW + "--------- " + ChatColor.WHITE + "Help: Index (2/2) " +
						ChatColor.YELLOW + "---------------------");
				player.sendMessage(ChatColor.GOLD + "/version: " + ChatColor.WHITE + "Gets the version of " +
						"this server includ...");
			}catch(NumberFormatException e){
				StringBuilder msg = new StringBuilder("No help for ");
				for(int i = 1; i < args.length; i++){
					msg.append(args[i]).append(" ");
				}
				player.sendMessage(ChatColor.RED + msg.toString());
			}
		}
	}
}