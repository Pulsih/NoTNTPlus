package me.pulsi_.notntplus.NoPickup;

import me.pulsi_.notntplus.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;

public class NoPickupMinecart implements Listener {

    @EventHandler
    public void noPickupMinecart(EntityPickupItemEvent e) {
        if (Main.getInstance().getConfig().getBoolean("disable_tntminecart_pickup")) {
            Player p = (Player) e.getEntity();
            if (!(p.hasPermission("notntplus.pickup.tntminecart"))) {
                if(e.getItem().getItemStack().getType() == Material.TNT_MINECART) {
                    e.setCancelled(true);
                }
            }
        }
    }
}
