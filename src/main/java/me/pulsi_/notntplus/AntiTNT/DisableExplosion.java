package me.pulsi_.notntplus.AntiTNT;

import me.pulsi_.notntplus.NoTNTPlus;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class DisableExplosion implements Listener {

    @EventHandler
    public void onEntityExplode(EntityExplodeEvent e) {
        if (NoTNTPlus.getInstance().getConfig().getBoolean("disable_tnt_explosion")) {
            if (e.getEntityType() == EntityType.PRIMED_TNT) {
                e.setCancelled(true);
            }
        }
    }
}
