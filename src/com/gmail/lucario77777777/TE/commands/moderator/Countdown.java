package com.gmail.lucario77777777.TE.commands.moderator;

import com.gmail.lucario77777777.TE.TE;
import com.gmail.lucario77777777.TE.commands.MainCommandExecutor;

import org.bukkit.Bukkit;


public class Countdown extends MainCommandExecutor {
	public Countdown(TE plugin) {
		super(plugin);
	}

	public static int number = 3;

	@SuppressWarnings("deprecation")
	public static boolean Run(TE plugin) {
		plugin.getServer().getScheduler()
				.scheduleAsyncRepeatingTask(plugin, new Runnable() {
					public void run() {
						if (number != -1) {
							if (number != 0) {
								Bukkit.broadcastMessage("" + number);
								number--;
							} else {
								Bukkit.broadcastMessage("GO!!!!!");
								number--;
							}
						}
					}
				}, 0L, 20L);
		return false;
	}
}