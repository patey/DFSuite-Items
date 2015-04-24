package com.ntcreations.DwarfItems;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("DI")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("This command can only be run by a player.");
				return true;
			} else {
				if (args.length == 1){
					if (args[0].equals("reload")){
						DwarfItems.getInstance().reloadConfig();
						sender.sendMessage("DwarfItems reloaded");
					}
				}
				if (args.length == 0){
					sender.sendMessage("DwarfItems v0.1.0");
					sender.sendMessage("Designed by Patey for the DFRP community");
				}
				return true;
			}
		}
		
		if (cmd.getName().equalsIgnoreCase("bans")) {
			if (args.length == 0){
				sender.sendMessage("Edit item restrictions and bans.");
			}
			if (args.length == 3){
				if (args[0].equalsIgnoreCase("break")){
					if (args[1].equalsIgnoreCase("add")){
						List<String> banbreak =  DwarfItems.getInstance().getConfig().getStringList("Restrictions.BannedBlocks.Break");
						banbreak.add(args[2].toLowerCase());
						DwarfItems.getInstance().getConfig().set("Restrictions.BannedBlocks.Break",banbreak);
						DwarfItems.getInstance().saveConfig();
						DwarfItems.getInstance().reloadConfig();
						sender.sendMessage("Block added to break ban list.");
						return true;
					}
					
					if (args[1].equalsIgnoreCase("remove")){
						List<String> listar = DwarfItems.getInstance().getConfig().getStringList("Restrictions.BannedBlocks.Break");
						for(String key : listar){
							if(args[2].equalsIgnoreCase(key)){
								listar.remove(key);
								DwarfItems.getInstance().getConfig().set("Restrictions.BannedBlocks.Break",listar);
								DwarfItems.getInstance().saveConfig();
								DwarfItems.getInstance().reloadConfig();
								sender.sendMessage("Block removed from the break ban list.");
								return true;
							}
						}

					}
				}
			
				if (args[0].equalsIgnoreCase("place")){
					if (args[1].equalsIgnoreCase("add")){
						List<String> banplace =  DwarfItems.getInstance().getConfig().getStringList("Restrictions.BannedBlocks.Place");
						banplace.add(args[2].toLowerCase());
						DwarfItems.getInstance().getConfig().set("Restrictions.BannedBlocks.Place",banplace);
						DwarfItems.getInstance().saveConfig();
						DwarfItems.getInstance().reloadConfig();
						sender.sendMessage("Block added to placement ban list.");
						return true;
					}
					
					if (args[1].equalsIgnoreCase("remove")){
						List<String> listar = DwarfItems.getInstance().getConfig().getStringList("Restrictions.BannedBlocks.Place");
						for(String key : listar){
							if(args[2].equalsIgnoreCase(key)){
								listar.remove(key);
								DwarfItems.getInstance().getConfig().set("Restrictions.BannedBlocks.Place",listar);
								DwarfItems.getInstance().saveConfig();
								DwarfItems.getInstance().reloadConfig();
								sender.sendMessage("Block removed from the placement ban list.");
								return true;
							}
						}
					}
				}
				
				if (args[0].equalsIgnoreCase("pickup")){
					if (args[1].equalsIgnoreCase("add")){
						List<String> banpickup =  DwarfItems.getInstance().getConfig().getStringList("Restrictions.BannedItems.Pickup");
						banpickup.add(args[2].toLowerCase());
						DwarfItems.getInstance().getConfig().set("Restrictions.BannedItems.Pickup",banpickup);
						DwarfItems.getInstance().saveConfig();
						DwarfItems.getInstance().reloadConfig();
						sender.sendMessage("Block added to item pickup ban list.");
						return true;
					}
					
					if (args[1].equalsIgnoreCase("remove")){
						List<String> listar = DwarfItems.getInstance().getConfig().getStringList("Restrictions.BannedItems.Pickup");
						for(String key : listar){
							if(args[2].equalsIgnoreCase(key)){
								listar.remove(key);
								DwarfItems.getInstance().getConfig().set("Restrictions.BannedItems.Pickup",listar);
								DwarfItems.getInstance().saveConfig();
								DwarfItems.getInstance().reloadConfig();
								sender.sendMessage("Block removed from the item pickup ban list.");
								return true;
							}
						}
					}
				}
				
				if (args[0].equalsIgnoreCase("drop")){
					if (args[1].equalsIgnoreCase("add")){
						List<String> bandrop =  DwarfItems.getInstance().getConfig().getStringList("Restrictions.BannedItems.Drop");
						bandrop.add(args[2].toLowerCase());
						DwarfItems.getInstance().getConfig().set("Restrictions.BannedItems.Drop",bandrop);
						DwarfItems.getInstance().saveConfig();
						DwarfItems.getInstance().reloadConfig();
						sender.sendMessage("Block added to item drop ban list.");
						return true;
					}
					
					if (args[1].equalsIgnoreCase("remove")){
						List<String> listar = DwarfItems.getInstance().getConfig().getStringList("Restrictions.BannedItems.Drop");
						for(String key : listar){
							if(args[2].equalsIgnoreCase(key)){
								listar.remove(key);
								DwarfItems.getInstance().getConfig().set("Restrictions.BannedItems.Drop",listar);
								DwarfItems.getInstance().saveConfig();
								DwarfItems.getInstance().reloadConfig();
								sender.sendMessage("Block removed from the item drop ban list.");
								return true;
							}
						}
					}
				}
				
				if (args[0].equalsIgnoreCase("craft")){
					if (args[1].equalsIgnoreCase("add")){
						List<String> bancraft =  DwarfItems.getInstance().getConfig().getStringList("Restrictions.BannedItems.Craft");
						bancraft.add(args[2].toLowerCase());
						DwarfItems.getInstance().getConfig().set("Restrictions.BannedItems.Craft",bancraft);
						DwarfItems.getInstance().saveConfig();
						DwarfItems.getInstance().reloadConfig();
						sender.sendMessage("Block added to crafting ban list.");
						return true;
					}
					
					if (args[1].equalsIgnoreCase("remove")){
						List<String> listar = DwarfItems.getInstance().getConfig().getStringList("Restrictions.BannedItems.Craft");
						for(String key : listar){
							if(args[2].equalsIgnoreCase(key)){
								listar.remove(key);
								DwarfItems.getInstance().getConfig().set("Restrictions.BannedItems.Craft",listar);
								DwarfItems.getInstance().saveConfig();
								DwarfItems.getInstance().reloadConfig();
								sender.sendMessage("Block removed from the crafting ban list.");
								return true;
							}
						}
					}
				}
				
				if (args[0].equalsIgnoreCase("interact")){
					if (args[1].equalsIgnoreCase("add")){
						List<String> bancraft =  DwarfItems.getInstance().getConfig().getStringList("Restrictions.BannedBlocks.Interact");
						bancraft.add(args[2].toLowerCase());
						DwarfItems.getInstance().getConfig().set("Restrictions.BannedBlocks.Interact",bancraft);
						DwarfItems.getInstance().saveConfig();
						DwarfItems.getInstance().reloadConfig();
						sender.sendMessage("Block added to crafting ban list.");
						return true;
					}
					
					if (args[1].equalsIgnoreCase("remove")){
						List<String> listar = DwarfItems.getInstance().getConfig().getStringList("Restrictions.BannedBlocks.Interact");
						for(String key : listar){
							if(args[2].equalsIgnoreCase(key)){
								listar.remove(key);
								DwarfItems.getInstance().getConfig().set("Restrictions.BannedBlocks.Interact",listar);
								DwarfItems.getInstance().saveConfig();
								DwarfItems.getInstance().reloadConfig();
								sender.sendMessage("Block removed from the crafting ban list.");
								return true;
							}
						}
					}
				}
			}
			return false;
		}
		return false;
	}
}
