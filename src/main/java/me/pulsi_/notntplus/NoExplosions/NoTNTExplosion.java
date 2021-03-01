package me.pulsi_.notntplus.NoExplosions;

import me.pulsi_.notntplus.Main;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class NoTNTExplosion implements Listener {

    @EventHandler
    public void disableTNTExplosion(EntityExplodeEvent e) {
        if (Main.getInstance().getConfig().getBoolean("disable_tnt_explosion")) {
            if (e.getEntityType() == EntityType.PRIMED_TNT) {
                e.setCancelled(true);
            }
        }
    }
}
