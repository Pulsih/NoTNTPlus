package me.pulsi_.notntplus.AntiTNT;

import me.pulsi_.notntplus.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class NoTNTDamage implements Listener {

    @EventHandler
    public void disableTNTDamage(EntityDamageEvent e) {
        if (Main.getInstance().getConfig().getBoolean("disable_tnt_damage")) {
            if (e.getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION) {
                e.setCancelled(true);
            }
        }
    }
}
