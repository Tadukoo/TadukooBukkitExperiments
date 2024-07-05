package com.github.tadukoo.bukkit.essentials.commands;

public enum EnumCmds {
	//Cheat Commands
	ADVENTURE("adventure", "cheat.adventure", true),
	CREATIVE("creative", "cheat.creative", true),
	DAY("day", "cheat.day", true),
	FEED("feed", "cheat.feed", true),
	FLY("fly", "cheat.fly", true),
	GAMEMODE("gamemode", "cheat.gamemode", true),
	HEAL("heal", "cheat.heal", true),
	NIGHT("night", "cheat.night", true),
	STARVE("starve", "cheat.starve", true),
	SURVIVAL("survival", "cheat.survival", true),
	TIME("time", "cheat.time", true),
	
	//General Commands
	HELP("help", "general.help", true),
	MOTD("motd", "general.motd", true),
	SUICIDE("suicide", "general.suicide", true),
	
	//Moderator Commands
	COUNTDOWN("countdown", "moderator.countdown", true),
	KILL("kill", "moderator.kill", true),
	KILLALL("killall", "moderator.killall", true),
	PING("ping", "moderator.ping", true),
	RAIN("rain", "moderator.rain", true),
	STORM("storm", "moderator.storm", true),
	SUN("sun", "moderator.sun", true),
	WEATHER("weather", "moderator.weather", true),
	
	//Teleportation Commands
	DELWARP("delwarp", "teleportation.delwarp", true),
	SETWARP("setwarp", "teleportation.setwarp", true),
	TP("tp", "teleportation.tp", true),
	WARP("warp", "teleportation.warp", true);
	
	private String cmd;
	
	private String perm;
	
	private String alias;
	
	private String alias2;
	
	private String alias3;
	
	private String alias4;
	
	private String alias5;
	
	private boolean available;
	
	private EnumCmds(String cmd, String perm, boolean available){
		this.cmd = cmd;
		this.perm = perm;
		this.available = available;
	}
	
	private EnumCmds(String cmd, String perm, String alias, boolean available){
		this.cmd = cmd;
		this.perm = perm;
		this.alias = alias;
		this.available = available;
	}
	
	private EnumCmds(String cmd, String perm, String alias, String alias2, boolean available){
		this.cmd = cmd;
		this.perm = perm;
		this.alias = alias;
		this.alias2 = alias2;
		this.available = available;
	}
	
	private EnumCmds(String cmd, String perm, String alias, String alias2, String alias3, boolean available){
		this.cmd = cmd;
		this.perm = perm;
		this.alias = alias;
		this.alias2 = alias2;
		this.alias3 = alias3;
		this.available = available;
	}
	
	private EnumCmds(String cmd, String perm, String alias, String alias2, String alias3, String alias4, 
			boolean available){
		this.cmd = cmd;
		this.perm = perm;
		this.alias = alias;
		this.alias2 = alias2;
		this.alias3 = alias3;
		this.alias4 = alias4;
		this.available = available;
	}
	
	private EnumCmds(String cmd, String perm, String alias, String alias2, String alias3, String alias4, 
			String alias5, boolean available){
		this.cmd = cmd;
		this.perm = perm;
		this.alias = alias;
		this.alias2 = alias2;
		this.alias3 = alias3;
		this.alias4 = alias4;
		this.alias5 = alias5;
		this.available = available;
	}
	
	public boolean isAvailable(){
		return available;
	}
	
	public String getCmd(){
		return cmd;
	}
	
	public String getPerm(){
		return perm;
	}
	
	public String getAlias(){
		return alias;
	}
	
	public String getAlias2(){
		return alias2;
	}
	
	public String getAlias3(){
		return alias3;
	}
	
	public String getAlias4(){
		return alias4;
	}
	
	public String getAlias5(){
		return alias5;
	}
	
	public EnumCmds fromString(String command) {
	    if (command != null) {
	      for (EnumCmds c : EnumCmds.values()) {
	        if (command.equalsIgnoreCase(c.getCmd()) || command.equalsIgnoreCase(c.getAlias()) ||
	        		command.equalsIgnoreCase(c.getAlias2()) || command.equalsIgnoreCase(c.getAlias3()) || 
	        		command.equalsIgnoreCase(c.getAlias4()) || command.equalsIgnoreCase(c.getAlias5())) {
	          return c;
	        }
	      }
	    }
	    return null;
	  }
}
