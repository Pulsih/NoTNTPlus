package me.pulsi_.notntplus.NoExplosions;

import me.pulsi_.notntplus.Main;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class NoMinecartExplosion implements Listener {

    @EventHandler
    public void disableMineCartExplosion(EntityExplodeEvent e) {
        if (Main.getInstance().getConfig().getBoolean("explosions.disable_tntminecart_explosions")) {
            if (e.getEntityType() == EntityType.MINECART_TNT) {
                for (String worlds : Main.getInstance().getConfig().getStringList("explosions_worlds.explosions_tntminecart_worlds")) {
                    if (worlds.contains(e.getEntity().getWorld().getName())) {
                        e.setCancelled(true);
                    }
                }
            }
        }
    }
}