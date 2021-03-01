package me.pulsi_.notntplus.NoExplosions;

import me.pulsi_.notntplus.Main;
import org.bukkit.entity.Minecart;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class NoMinecartExplosion implements Listener {

    @EventHandler
    public void disableMineCartExplosion(EntityExplodeEvent e) {
        if (Main.getInstance().getConfig().getBoolean("disable_tntminecart_explosion")) {
            if (e.getEntity() instanceof Minecart) {
                e.setCancelled(true);
            }
        }
    }
}
