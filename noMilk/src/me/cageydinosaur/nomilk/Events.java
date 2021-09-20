package me.cageydinosaur.nomilk;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.inventory.ItemStack;

public class Events implements Listener {

	Main plugin;

	public Events(Main plugin) {
		this.plugin = plugin;
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onMilk(PlayerBucketFillEvent e) {
		if (!plugin.toggleMilk) {
			if (e.getItemStack().getType() == Material.MILK_BUCKET) {
				e.setItemStack(new ItemStack(Material.BUCKET));
				e.getPlayer().updateInventory();
			}
		} else {
			e.setItemStack(new ItemStack(Material.MILK_BUCKET));
			e.getPlayer().updateInventory();
		}
	}
}