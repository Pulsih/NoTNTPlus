package me.pulsi_.notntplus.NoPickup;

import me.pulsi_.notntplus.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;

public class NoPickupTNT implements Listener {

    @EventHandler
    public void noPickupMinecart(EntityPickupItemEvent e) {
        if (Main.getInstance().getConfig().getBoolean("disable_tnt_pickup")) {
            Player p = (Player) e.getEntity();
            if (!(p.hasPermission("notntplus.pickup.tnt"))) {
                if(e.getItem().getItemStack().getType() == Material.TNT) {
                    e.setCancelled(true);
                }
            }
        }
    }
}
