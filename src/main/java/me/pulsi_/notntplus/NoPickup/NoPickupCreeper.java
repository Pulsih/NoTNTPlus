package me.pulsi_.notntplus.NoPickup;

import me.pulsi_.notntplus.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;

public class NoPickupCreeper implements Listener {

    @EventHandler
    public void noPickupCreeper(EntityPickupItemEvent e) {
        if (Main.getInstance().getConfig().getBoolean("disable_creeperegg_pickup")) {
            Player p = (Player) e.getEntity();
            if (!(p.hasPermission("notntplus.pickup.creeperegg"))) {
                if(e.getItem().getItemStack().getType() == Material.CREEPER_SPAWN_EGG) {
                    e.setCancelled(true);
                }
            }
        }
    }
}
