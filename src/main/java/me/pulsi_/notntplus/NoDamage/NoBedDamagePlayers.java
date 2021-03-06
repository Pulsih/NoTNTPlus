package me.pulsi_.notntplus.NoDamage;

import me.pulsi_.notntplus.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class NoBedDamagePlayers implements Listener {

    @EventHandler
    public void noBedDamage(EntityDamageEvent e) {
        if (Main.getInstance().getConfig().getBoolean("damage.players")) {
            if (e.getCause() == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION) {
                if (e.getEntity() instanceof Player) {
                    for (String worlds : Main.getInstance().getConfig().getStringList("damage_worlds.players_worlds")) {
                        if (worlds.contains(e.getEntity().getWorld().getName())) {
                            e.setCancelled(true);
                        }
                    }
                }
            }
        }
    }
}