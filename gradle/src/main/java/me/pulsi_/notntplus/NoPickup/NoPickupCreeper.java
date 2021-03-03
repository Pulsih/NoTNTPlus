package me.pulsi_.notntplus.NoPickup;

import me.pulsi_.notntplus.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class NoPickupCreeper implements Listener {

    @SuppressWarnings("deprecated")
    @EventHandler
    public void noPickupCreeper(PlayerPickupItemEvent e) {
        if (Main.getInstance().getConfig().getBoolean("disable_creeperegg_pickup")) {
            Player p = (Player) e.getPlayer();
            if (!(p.hasPermission("notntplus.pickup.creeperegg"))) {
                if(e.getItem().getItemStack().getType() == Material.CREEPER_SPAWN_EGG) {
                    e.setCancelled(true);
                }
            }
        }
    }
}
