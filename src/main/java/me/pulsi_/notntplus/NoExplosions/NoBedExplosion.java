package me.pulsi_.notntplus.NoExplosions;

import me.pulsi_.notntplus.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockExplodeEvent;

public class NoBedExplosion implements Listener {

    @EventHandler
    public void disableBedExplosion(BlockExplodeEvent e) {
        if (Main.getInstance().getConfig().getBoolean("explosions.disable_bed_explosions")) {
            if (e.getBlock().getType().name().contains("BED")) {
                for (String worlds : Main.getInstance().getConfig().getStringList("explosions_worlds.explosions_bed_worlds")) {
                    if (worlds.contains(e.getBlock().getWorld().toString())) {
                        e.setCancelled(true);
                    }
                }
            }
        }
    }
}