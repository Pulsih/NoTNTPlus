package me.pulsi_.notntplus.NoExplosions;

import me.pulsi_.notntplus.Main;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class NoTNTExplosion implements Listener {

    @EventHandler
    public void disableTNTExplosion(EntityExplodeEvent e) {
        if (Main.getInstance().getConfig().getBoolean("explosions.disable_tnt_explosions")) {
            if (e.getEntityType() == EntityType.PRIMED_TNT) {
                for (String worlds : Main.getInstance().getConfig().getStringList("explosions_worlds.explosions_tnt_worlds")) {
                    if (worlds.contains(e.getEntity().getWorld().getName())) {
                        e.setCancelled(true);
                    }
                }
            }
        }
    }
}