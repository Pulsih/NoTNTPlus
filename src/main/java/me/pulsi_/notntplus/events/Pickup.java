package me.pulsi_.notntplus.events;

import me.pulsi_.notntplus.NoTNTPlus;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class Pickup implements Listener {

    private NoTNTPlus plugin;
    public Pickup(NoTNTPlus plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void tntPickup(PlayerPickupItemEvent e) {
        Player p = e.getPlayer();
        if (!plugin.config().getBoolean("tnt.pickup.disable") || !p.hasPermission("notntplus.pickup.tnt") || e.getItem() == null ||
                e.getItem().getItemStack().getType() != Material.TNT) return;
        for (String blackList : plugin.config().getStringList("tnt.pickup.disabled-worlds")) {
            if (blackList.contains(p.getWorld().getName())) return;
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void tntMinecartPickup(PlayerPickupItemEvent e) {
        Player p = e.getPlayer();
        if (!plugin.config().getBoolean("tntminecart.pickup.disable") || !p.hasPermission("notntplus.pickup.tntminecart") || e.getItem() == null) return;
        try {
            if (e.getItem().getItemStack().getType() != Material.TNT_MINECART) return;
        } catch (NoSuchFieldError er) {
            if (!e.getItem().getType().name().contains("EXPLOSIVE_MINECART")) return;
        }
        for (String blackList : plugin.config().getStringList("tntminecart.pickup.disabled-worlds")) {
            if (blackList.contains(p.getWorld().getName())) return;
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void creeperEggPickup(PlayerPickupItemEvent e) {
        Player p = e.getPlayer();
        if (!plugin.config().getBoolean("creeperegg.pickup.disable") || !p.hasPermission("notntplus.pickup.creeperegg") || e.getItem() == null ||
                e.getItem().getItemStack().getType() != Material.TNT) return;
        for (String blackList : plugin.config().getStringList("tnt.pickup.disabled-worlds")) {
            if (blackList.contains(p.getWorld().getName())) return;
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void bedPickup(PlayerPickupItemEvent e) {
        Player p = e.getPlayer();
        if (!plugin.config().getBoolean("bed.pickup.disable") || !p.hasPermission("notntplus.pickup.bed") || e.getItem() == null ||
                !e.getItem().getItemStack().getType().name().contains("BED")) return;
        for (String blackList : plugin.config().getStringList("tnt.pickup.disabled-worlds")) {
            if (blackList.contains(p.getWorld().getName())) return;
            e.setCancelled(true);
        }
    }
}