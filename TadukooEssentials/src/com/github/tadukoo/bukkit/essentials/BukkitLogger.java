package com.github.tadukoo.bukkit.essentials;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;

public class BukkitLogger {

	public static TE plugin;
	
	public BukkitLogger(TE main){
		plugin = main;
	}
	
	public final Logger logger = Logger.getLogger("Minecraft");
	
	public void enabled(boolean enabled){
		if(enabled){
			PluginDescriptionFile pdfFile = ((TE) plugin).getDescription();
			this.logger.info(pdfFile.getName() + " Version" + pdfFile.getVersion() + " has been Enabled!");
		}else if(!enabled){
			PluginDescriptionFile pdfFile = ((TE) plugin).getDescription();
			this.logger.info(pdfFile.getName() + " Version" + pdfFile.getVersion() + " has been Disabled!");
		}
	}
}
