package com.ntcreations.DwarfItems;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class DwarfItems extends JavaPlugin{
	private static DwarfItems instance = null;
	
	public void onEnable() {
		instance = this;
		registerEvents(this,new BlockEvents(),new ItemEvents(),new CraftEvents());
	    getCommand("DI").setExecutor(new Commands());
	    getCommand("bans").setExecutor(new Commands());
	    initconfig();
	    getLogger().info("DwarfItems Initialized");
	}
	
	public void onDisable() {
		getLogger().info("DwarfItems Unloaded");
	}
	
	private void initconfig(){
	    FileConfiguration config = getConfig();
	    
	    List<String> banbreak = config.getStringList("Restrictions.BannedBlocks.Break");
	    banbreak.add("CHANGE");
	    banbreak.add("ME");
	    List<String> banplace = config.getStringList("Restrictions.BannedBlocks.Place");
	    banplace.add("CHANGE");
	    banplace.add("ME");
	    List<String> banpickup = config.getStringList("Restrictions.BannedItems.Pickup");
	    banpickup.add("CHANGE");
	    banpickup.add("ME");
	    List<String> bandrop = config.getStringList("Restrictions.BannedItems.Drop");
	    bandrop.add("CHANGE");
	    bandrop.add("ME");
	    List<String> bancraft = config.getStringList("Restrictions.BannedItems.Craft");
	    bancraft.add("CHANGE");
	    bancraft.add("ME");
	    List<String> baninteract = config.getStringList("Restrictions.BannedBlocks.Interact");
	    baninteract.add("CHANGE");
	    baninteract.add("ME");
	    List<String> baneinteract = config.getStringList("Restrictions.BannedEntity.Interact");
	    baneinteract.add("CHANGE");
	    baneinteract.add("ME");
	    config.addDefault("Restrictions.BannedBlocks.Break", banbreak);
	    config.addDefault("Restrictions.BannedBlocks.Place", banplace);
	    config.addDefault("Restrictions.BannedItems.Pickup", banpickup);
	    config.addDefault("Restrictions.BannedItems.Drop", bandrop);
	    config.addDefault("Restrictions.BannedItems.Craft", bancraft);
	    config.addDefault("Restrictions.BannedBlocks.Interact", baninteract);
	    config.addDefault("Restrictions.BannedEntity.Interact", baneinteract);
	    
	    config.options().copyDefaults(true);
	    saveConfig();
	}
	 public static DwarfItems getInstance() {
		 return instance;
	}
	 
	public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
		for (Listener listener : listeners) {
		Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
		}
		}
}