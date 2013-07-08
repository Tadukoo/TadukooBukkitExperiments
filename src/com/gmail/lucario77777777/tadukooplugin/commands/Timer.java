package com.gmail.lucario77777777.tadukooplugin.commands;

import com.gmail.lucario77777777.tadukooplugin.commands.MainCommandExecutor;

import org.bukkit.Bukkit;

import com.gmail.lucario77777777.tadukooplugin.Main;

public class Timer extends MainCommandExecutor {
	public Timer(Main plugin) {
		super(plugin);
	}

	public static int number = 3;

	@SuppressWarnings("deprecation")
	public static boolean TimerRun(Main plugin) {
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