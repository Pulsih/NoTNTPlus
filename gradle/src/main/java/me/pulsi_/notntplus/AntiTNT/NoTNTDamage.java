package me.pulsi_.notntplus.AntiTNT;

import me.pulsi_.notntplus.Main;
import me.pulsi_.notntplus.Managers.ConfigManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class NoTNTDamage implements Listener {

    ConfigManager config = new ConfigManager(Main.getInstance(), "config.yml");

    @EventHandler
    public void disableTNTDamage(EntityDamageEvent e) {
        if (config.getConfig().getBoolean("noDamage.disable_explosions_damage")) {
            if (e.getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION) {
                e.setCancelled(true);
            }
        }
    }
}
