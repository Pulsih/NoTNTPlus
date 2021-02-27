package me.pulsi_.notntplus.AntiTNT;

import me.pulsi_.notntplus.NoTNTPlus;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;

public class TNTDrop implements Listener {

    @EventHandler
    public void DropTNT(PlayerItemHeldEvent e) {
        if (NoTNTPlus.getInstance().getConfig().getBoolean("drop_tnt")) {
            Player p = (Player) e.getPlayer();
            if (!(p.hasPermission("notntplus.drop"))) {
                ItemStack tnt = new ItemStack(Material.TNT);
                if (p.getInventory().containsAtLeast(new ItemStack(tnt), 1)) {
                    Bukkit.getServer().getWorld(String.valueOf(p.getWorld())).dropItem(p.getLocation(), tnt);
                }
            }
        }
    }
}
