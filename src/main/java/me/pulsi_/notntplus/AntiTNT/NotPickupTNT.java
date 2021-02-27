package me.pulsi_.notntplus.AntiTNT;

import me.pulsi_.notntplus.NoTNTPlus;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.inventory.ItemStack;

public class NotPickupTNT implements Listener {

    @EventHandler
    public void NoTNTPickup(EntityPickupItemEvent e) {
        if (NoTNTPlus.getInstance().getConfig().getBoolean("disable_tnt_pickup")) {
            Player p = (Player) e.getEntity();
            ItemStack item = e.getItem().getItemStack();
            Material itemType = item.getType();
            if (!(p.hasPermission("notntplus.pickup"))) {
                if (itemType == Material.TNT) ;
                e.setCancelled(true);
            }
        }
    }
}
