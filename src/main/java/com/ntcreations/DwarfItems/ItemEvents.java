package com.ntcreations.DwarfItems;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class ItemEvents implements Listener{
	
	public List<String> bannedpickup = new ArrayList<String>();
	public List<String> banneddrop = new ArrayList<String>();

	@EventHandler
	public void onpickup(PlayerPickupItemEvent pickup){
		Item rawitemp = pickup.getItem();
		Material itemp = rawitemp.getItemStack().getType();
		Player playerp = pickup.getPlayer();
		List<String> bannedpickup =  DwarfItems.getInstance().getConfig().getStringList("Restrictions.BannedItems.Pickup");
		if (bannedpickup.contains(itemp.toString())) {
			if (!(playerp.hasPermission("DwarfItems.allow.pickup."+itemp))){
				pickup.setCancelled(true);
				playerp.sendMessage("You don't have permission to pickup " + itemp);
			}
		}
	}
	
	@EventHandler
	public void ondrop(PlayerDropItemEvent drop){
		Item rawitemd = drop.getItemDrop();
		Material itemd = rawitemd.getItemStack().getType();
		Player playerd = drop.getPlayer();
		List<String> banneddrop =  DwarfItems.getInstance().getConfig().getStringList("Restrictions.BannedItems.Drop");
		if (banneddrop.contains(itemd.toString())) {
			if (!(playerd.hasPermission("DwarfItems.allow.drop."+itemd))){
				drop.setCancelled(true);
				playerd.sendMessage("You don't have permission to drop " + itemd);
			}
		}
	}
}
