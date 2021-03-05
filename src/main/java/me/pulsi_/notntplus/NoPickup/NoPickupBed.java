package me.pulsi_.notntplus.NoPickup;

import me.pulsi_.notntplus.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class NoPickupBed implements Listener {

    @SuppressWarnings("deprecated")
    @EventHandler
    public void noPickupMinecart(PlayerPickupItemEvent e) {
        if (Main.getInstance().getConfig().getBoolean("disable_bed_pickup")) {
            Player p = (Player) e.getPlayer();
            if (!(p.hasPermission("pickup.notntplus.pickup.bed"))) {
                if (e.getItem() != null) {
                    if (e.getItem().getItemStack().getType().name().endsWith("_BED")) {
                        for (String worlds : Main.getInstance().getConfig().getStringList("pickup_worlds.pickup_bed_worlds")) {
                            if (worlds.contains(p.getWorld().getName())) {
                                e.setCancelled(true);
                            }
                        }
                    }
                }
            }
        }
    }
}