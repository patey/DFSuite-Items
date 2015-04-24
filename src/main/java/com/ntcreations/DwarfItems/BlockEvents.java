package com.ntcreations.DwarfItems;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockEvents implements Listener {
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent bbreak){
		Block blockb = bbreak.getBlock();
		Player playerb = bbreak.getPlayer();
		Material materialb = blockb.getType();
		List<String> bannedbreak =  DwarfItems.getInstance().getConfig().getStringList("Restrictions.BannedBlocks.Break");
		if (bannedbreak.contains(materialb.toString())) {
			if (!(playerb.hasPermission("DwarfItems.allow.break."+materialb))){
			bbreak.setCancelled(true);
			playerb.sendMessage("You don't have permission to break " + materialb);
		    }
		}
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent place){
		Block blockp = place.getBlockPlaced();
		Player playerp = place.getPlayer();
		Material materialp = blockp.getType();
		List<String> bannedplace =  DwarfItems.getInstance().getConfig().getStringList("Restrictions.BannedBlocks.Place");
		if (bannedplace.contains(materialp.toString().toLowerCase())) {
			if (!(playerp.hasPermission("DwarfItems.allow.place."+materialp))){
			place.setCancelled(true);
			playerp.sendMessage("You don't have permission to place " + materialp);
		    }
		}
	}



}
