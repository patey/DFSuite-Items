package com.ntcreations.DwarfItems;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;


public class CraftEvents implements Listener{
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void oncraft(PrepareItemCraftEvent event){
		 Player playerc = (Player) event.getView().getPlayer();
		 Material type = event.getInventory().getResult().getType();
		 
		List<String> bannedcraft =  DwarfItems.getInstance().getConfig().getStringList("Restrictions.BannedItems.Craft");
		if (bannedcraft.contains(type.toString())) {
			if (!(playerc.hasPermission("DwarfItems.allow.craft."+type))){
				event.getInventory().setResult(null);
				playerc.sendMessage("You don't have permission to craft " + type);
			}
		}
	}
}
