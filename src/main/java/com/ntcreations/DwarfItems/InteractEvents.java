package com.ntcreations.DwarfItems;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class InteractEvents implements Listener{
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onClick(PlayerInteractEvent event){
		Player player = event.getPlayer();
			if (event.getAction() == Action.RIGHT_CLICK_BLOCK){
				String block = event.getClickedBlock().getType().toString();
				List<String> banned = DwarfItems.getInstance().getConfig().getStringList("Restrictions.BannedBlocks.Interact");
				if (banned.contains(block)){
					if (player.hasPermission("DwarfItems.deny.interact."+block)){
						event.setCancelled(true);
						player.sendMessage("You don't have permission to interact with " + block);
					}
				}
			}
		
	}
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onClick(PlayerInteractEntityEvent event){
		Player player = event.getPlayer();
		String entity = event.getRightClicked().toString();
		List<String> banned = DwarfItems.getInstance().getConfig().getStringList("Restrictions.BannedEntity.Interact");
			if (banned.contains(entity)){
				if (player.hasPermission("DwarfItems.deny.interact."+entity)){
					List<String> bannedinteract = DwarfItems.getInstance().getConfig().getStringList("Restrictions.BannedEntity.Interact");
					if (bannedinteract.contains(entity)){
						event.setCancelled(true);
						player.sendMessage("You don't have permission to interact with " + entity);
					}
				}
			}
		
	}
}
