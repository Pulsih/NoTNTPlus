package me.pulsi_.notntplus.NoPickup;

import me.pulsi_.notntplus.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class NoPickupMinecart implements Listener {

    @SuppressWarnings("deprecated")
    @EventHandler
    public void noPickupMinecart(PlayerPickupItemEvent e) {
        if (Main.getInstance().getConfig().getBoolean("pickup.disable_tntminecart_pickup")) {
            Player p = (Player) e.getPlayer();
            if (!(p.hasPermission("pickup.notntplus.pickup.tntminecart"))) {
                if (e.getItem() != null) {
                    if (e.getItem().getItemStack().getType() == Material.TNT_MINECART) {
                        for (String worlds : Main.getInstance().getConfig().getStringList("pickup_worlds.pickup_tntminecart_worlds")) {
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