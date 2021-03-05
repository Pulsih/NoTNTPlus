package me.pulsi_.notntplus.NoDamage;

import me.pulsi_.notntplus.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class NoTNTDamageMobs implements Listener {

    @EventHandler
    public void disableTNTDamage(EntityDamageEvent e) {
        if (Main.getInstance().getConfig().getBoolean("damage.mobs")) {
            if (e.getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION) {
                for (String entityList : Main.getInstance().getConfig().getStringList("damage.mobs_list")) {
                    if (entityList.contains(e.getEntityType().toString())) {
                        for (String worlds : Main.getInstance().getConfig().getStringList("damage_worlds.mobs_worlds")) {
                            if (worlds.contains(e.getEntity().getWorld().getName())) {
                                e.setCancelled(true);
                            }
                        }
                    }
                }
            }
        }
    }
}