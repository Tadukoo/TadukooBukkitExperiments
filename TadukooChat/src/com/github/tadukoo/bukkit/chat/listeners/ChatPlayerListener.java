package com.github.tadukoo.bukkit.chat.listeners;

import com.github.tadukoo.bukkit.perms.TP;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import com.github.tadukoo.bukkit.chat.TCh;
import com.github.tadukoo.bukkit.chat.commands.ChatComExec;

public class ChatPlayerListener implements Listener{
	public TCh plugin;
	
	public ChatPlayerListener(TCh plugin){
		this.plugin = plugin;
	}
	
	@EventHandler(priority = EventPriority.LOW)
	public void onPlayerJoin(PlayerJoinEvent event){
		if(plugin.TPerms){
			String rank = TP.getRankPrefix(event.getPlayer());
			String world = event.getPlayer().getWorld().toString();
			event.getPlayer().setDisplayName("[" + world + "] " + rank + " " + event.getPlayer().getName());
		}
	}
	
	@EventHandler(priority = EventPriority.LOW)
	public void onPlayerChat(AsyncPlayerChatEvent event){
		String message = event.getMessage();
		Player player = event.getPlayer();
		if(message.contains("&")){
			if(message.contains("&0")){
				if(ChatComExec.checkPerm(player, "black")){
					message = message.replaceAll("&0", "§0");
				}
			}
			if(message.contains("&1")){
				if(ChatComExec.checkPerm(player, "darkblue")){
					message = message.replaceAll("&1", "§1");
				}
			}
			if(message.contains("&2")){
				if(ChatComExec.checkPerm(player, "darkgreen")){
					message = message.replaceAll("&2", "§2");
				}
			}
			if(message.contains("&3")){
				if(ChatComExec.checkPerm(player, "darkaqua")){
					message = message.replaceAll("&3", "§3");
				}
			}
			if(message.contains("&4")){
				if(ChatComExec.checkPerm(player, "darkred")){
					message = message.replaceAll("&4", "§4");
				}
			}
			if(message.contains("&5")){
				if(ChatComExec.checkPerm(player, "darkpurple")){
					message = message.replaceAll("&5", "§5");
				}
			}
			if(message.contains("&6")){
				if(ChatComExec.checkPerm(player, "gold")){
					message = message.replaceAll("&6", "§6");
				}
			}
			if(message.contains("&7")){
				if(ChatComExec.checkPerm(player, "lightgray")){
					message = message.replaceAll("&7", "§7");
				}
			}
			if(message.contains("&8")){
				if(ChatComExec.checkPerm(player, "darkgray")){
					message = message.replaceAll("&8", "§8");
				}
			}
			if(message.contains("&9")){
				if(ChatComExec.checkPerm(player, "blue")){
					message = message.replaceAll("&9", "§9");
				}
			}
			if(message.contains("&a")){
				if(ChatComExec.checkPerm(player, "green")){
					message = message.replaceAll("&a", "§a");
				}
			}
			if(message.contains("&b")){
				if(ChatComExec.checkPerm(player, "aqua")){
					message = message.replaceAll("&b", "§b");
				}
			}
			if(message.contains("&c")){
				if(ChatComExec.checkPerm(player, "red")){
					message = message.replaceAll("&c", "§c");
				}
			}
			if(message.contains("&d")){
				if(ChatComExec.checkPerm(player, "lightpurple")){
					message = message.replaceAll("&d", "§d");
				}
			}
			if(message.contains("&e")){
				if(ChatComExec.checkPerm(player, "yellow")){
					message = message.replaceAll("&e", "§e");
				}
			}
			if(message.contains("&f")){
				if(ChatComExec.checkPerm(player, "white")){
					message = message.replaceAll("&f", "§f");
				}
			}
			if(message.contains("&r")){
				message = message.replaceAll("&r", "§r");
			}
			if(message.contains("&k")){
				if(ChatComExec.checkPerm(player, "magic")){
					message = message.replaceAll("&k", "§k");
				}
			}
			if(message.contains("&l")){
				if(ChatComExec.checkPerm(player, "bold")){
					message = message.replaceAll("&l", "§l");
				}
			}
			if(message.contains("&m")){
				if(ChatComExec.checkPerm(player, "strike")){
					message = message.replaceAll("&m", "§m");
				}
			}
			if(message.contains("&n")){
				if(ChatComExec.checkPerm(player, "underline")){
					message = message.replaceAll("&n", "§n");
				}
			}
			if(message.contains("&o")){
				if(ChatComExec.checkPerm(player, "italic")){
					message = message.replaceAll("&o", "§o");
				}
			}
			if(message.contains("&w")){
				if(ChatComExec.checkPerm(player, "rainbowchanging")){
					message = message.replaceAll("&w", "");
					player.sendMessage(ChatColor.RED + "rainbow changing is not available yet.");
				}
			}
			if(message.contains("&x")){
				if(ChatComExec.checkPerm(player, "rainbow")){
					String[] msg = message.split("&x");
					message = rainbowify(msg[1]);
					for(int i = 2; i < msg.length; i++){
						message += rainbowify(msg[i]);
					}
				}
			}
		}
		event.setMessage(message);
	}
	
	public String rainbowify(String msg){
		char[] m = msg.toCharArray();
		int k = 1;
		StringBuilder newMsg = new StringBuilder();
		for(int i = 0; i < m.length; i++){
			if(m[i] == ' '){
				newMsg.append(m[i]);
			}else if(m[i] == '§'){
				newMsg.append(msg.substring(i));
				break;
			}else{
				newMsg.append(switch(k){
					case 1 -> ChatColor.RED;
					case 2 -> ChatColor.GOLD;
					case 3 -> ChatColor.YELLOW;
					case 4 -> ChatColor.GREEN;
					case 5 -> ChatColor.AQUA;
					case 6 -> ChatColor.BLUE;
					case 7 -> ChatColor.LIGHT_PURPLE;
					default -> throw new IllegalStateException("Unexpected value: " + k);
				});
				newMsg.append(m[i]);
				k++;
				if(k == 8){
					k = 1;
				}
			}
		}
		return newMsg.toString();
	}
}
