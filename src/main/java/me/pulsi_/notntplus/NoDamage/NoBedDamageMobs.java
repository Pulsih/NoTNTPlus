package me.pulsi_.notntplus.NoDamage;

import me.pulsi_.notntplus.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class NoBedDamageMobs implements Listener {

    @EventHandler
    public void noBedDamage(EntityDamageEvent e) {
        if (e.getCause() == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION) {
            for (String entityListBed : Main.getInstance().getConfig().getStringList("damage.mobs_list")) {
                if (entityListBed.contains(e.getEntityType().toString())) {
                    for (String worldsBed : Main.getInstance().getConfig().getStringList("damage_worlds.mobs_worlds")) {
                        if (worldsBed.contains(e.getEntity().getWorld().getName())) {
                            e.setCancelled(true);
                        }
                    }
                }
            }
        }
    }
}