package me.pulsi_.notntplus.events;

import me.pulsi_.notntplus.NoTNTPlus;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class Damage implements Listener {

    private NoTNTPlus plugin;
    public Damage(NoTNTPlus plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void noEntityDamage(EntityDamageByEntityEvent e) {
        if (e.getCause() != EntityDamageEvent.DamageCause.ENTITY_EXPLOSION) return;
        if (plugin.config().getStringList("damage.disabled-worlds").contains(e.getEntity().getWorld().getName())) return;
        if (plugin.config().getBoolean("damage.disable-for-players")) {
            if (e.getEntity() instanceof Player) e.setCancelled(true);
        }
        if (plugin.config().getBoolean("damage.disable-for-mobs")) {
            for (String mobsWhitelist : plugin.config().getStringList("damage.mobs-list")) {
                if (!(e.getEntity() instanceof Player)) {
                    if (mobsWhitelist.contains(e.getEntityType().toString())) e.setCancelled(true);
                }
            }
        }
    }
}
