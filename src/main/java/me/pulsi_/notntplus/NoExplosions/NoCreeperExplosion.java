package me.pulsi_.notntplus.NoExplosions;

import me.pulsi_.notntplus.Main;
import org.bukkit.entity.Creeper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class NoCreeperExplosion implements Listener {

    @EventHandler
    public void onEntityExplode(EntityExplodeEvent e) {
        if (Main.getInstance().getConfig().getBoolean("explosions.disable_creeper_explosion")) {
            if (e.getEntity() instanceof Creeper) {
                e.setCancelled(true);
            }
        }
    }
}