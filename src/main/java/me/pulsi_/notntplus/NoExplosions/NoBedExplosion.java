package me.pulsi_.notntplus.NoExplosions;

import me.pulsi_.notntplus.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class NoBedExplosion implements Listener {

    @EventHandler
    public void disableBedExplosion(EntityExplodeEvent e) {
        if (Main.getInstance().getConfig().getBoolean("explosions.disable_bed_explosion")) {
            if (e.getEntityType().name().contains("BED")) {
                e.setCancelled(true);
            }
        }
    }
}