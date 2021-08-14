package me.pulsi_.notntplus.events;

import me.pulsi_.notntplus.NoTNTPlus;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.entity.EntityExplodeEvent;

public class Explosions implements Listener {

    private NoTNTPlus plugin;
    public Explosions(NoTNTPlus plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void tntExplosion(EntityExplodeEvent e) {
        if (!plugin.config().getBoolean("tnt.explosion.disable")) return;
        if (e.getEntity().getType() != EntityType.PRIMED_TNT) return;
        for (String blackList : plugin.config().getStringList("tnt.explosion.disabled-worlds")) {
            if (blackList.contains(e.getEntity().getWorld().toString())) return;
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void tntminecartExplosion(EntityExplodeEvent e) {
        if (!plugin.config().getBoolean("tntminecart.explosion.disable")) return;
        try {
            if (e.getEntity().getType() != EntityType.MINECART_TNT) return;
        } catch (NoSuchFieldError er) {
            if (!e.getEntity().getType().name().contains("EXPLOSIVE_MINECART")) return;
        }
        if (e.getEntity().getType() != EntityType.MINECART_TNT) return;
        for (String blackList : plugin.config().getStringList("tntminecart.explosion.disabled-worlds")) {
            if (blackList.contains(e.getEntity().getWorld().toString())) return;
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void creeperExplosion(EntityExplodeEvent e) {
        if (!plugin.config().getBoolean("creeperegg.explosion.disable")) return;
        if (e.getEntity().getType() != EntityType.CREEPER) return;
        for (String blackList : plugin.config().getStringList("creeperegg.explosion.disabled-worlds")) {
            if (blackList.contains(e.getEntity().getWorld().toString())) return;
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void bedExplosion(BlockExplodeEvent e) {
        if (!plugin.config().getBoolean("bed.explosion.disable")) return;
        if (!(e.getBlock().getType().name().contains("BED"))) return;
        for (String blackList : plugin.config().getStringList("bed.explosion.disabled-worlds")) {
            if (blackList.contains(e.getBlock().getWorld().toString())) return;
            e.setCancelled(true);
        }
    }
}
