package me.pulsi_.notntplus.NoPickup;

import me.pulsi_.notntplus.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class NoPickupTNT implements Listener {

    @SuppressWarnings("deprecated")
    @EventHandler
    public void noPickupMinecart(PlayerPickupItemEvent e) {
        if (Main.getInstance().getConfig().getBoolean("pickup.disable_tnt_pickup")) {
            Player p = (Player) e.getPlayer();
            if (!(p.hasPermission("notntplus.pickup.tnt"))) {
                if (e.getItem() != null) {
                    if (e.getItem().getItemStack().getType() == Material.TNT) {
                        for (String worlds : Main.getInstance().getConfig().getStringList("pickup_worlds.pickup_tnt_worlds")) {
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