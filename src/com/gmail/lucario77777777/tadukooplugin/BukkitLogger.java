package com.gmail.lucario77777777.tadukooplugin;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;

public class BukkitLogger {

	public static Main plugin;
	
	public BukkitLogger(Main main){
		plugin = main;
	}
	
	public final Logger logger = Logger.getLogger("Minecraft");
	
	public void enabled(boolean enabled){
		if(enabled){
			PluginDescriptionFile pdfFile = ((Main) plugin).getDescription();
			this.logger.info(pdfFile.getName() + " Version" + pdfFile.getVersion() + " has been Enabled!");
		}else if(!enabled){
			PluginDescriptionFile pdfFile = ((Main) plugin).getDescription();
			this.logger.info(pdfFile.getName() + " Version" + pdfFile.getVersion() + " has been Disabled!");
		}
	}
}
