package me.pulsi_.notntplus.Panel;

import me.pulsi_.notntplus.Main;
import me.pulsi_.notntplus.Managers.Translator;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ExplosionManagerListener implements Listener {

    @EventHandler
    public void clickEvent(InventoryClickEvent event) {
        if (event.getView().getTitle().equals(Translator.Colors("&9&lExplosion Manager"))) {
            if (event.getCurrentItem() != null) {
                Player p = (Player) event.getWhoClicked();
                event.setCancelled(true);

                GUI panel = new GUI(p);
                ExplosionManager panelExplosionManager = new ExplosionManager(p);

                if (event.getSlot() == 10)
                    if (Main.getInstance().getConfig().getBoolean("explosions.disable_tnt_explosion")) {
                        Main.getInstance().getConfig().set("disable_tnt_explosion", false);
                        Main.getInstance().reloadConfig();
                        p.sendMessage(Translator.Colors("&8[&a&lNo&c&lTNT&b&l+&8] &cDisabled the Anti-Explosion for TNTs"));
                        p.closeInventory();
                        panelExplosionManager.openGuiExplosionManager();
                    } else {
                        Main.getInstance().getConfig().set("explosions.disable_tnt_explosion", true);
                        Main.getInstance().reloadConfig();
                        p.sendMessage(Translator.Colors("&8[&a&lNo&c&lTNT&b&l+&8] &2Enabled the Anti-Explosion for TNTs"));
                        p.closeInventory();
                        panelExplosionManager.openGuiExplosionManager();
                    }

                if (event.getSlot() == 12)
                    if (Main.getInstance().getConfig().getBoolean("explosions.disable_tntminecart_explosion")) {
                        Main.getInstance().getConfig().set("disable_tntminecart_explosion", false);
                        Main.getInstance().reloadConfig();
                        p.sendMessage(Translator.Colors("&8[&a&lNo&c&lTNT&b&l+&8] &cDisabled the Anti-Explosion for TNT-Minecarts"));
                        p.closeInventory();
                        panelExplosionManager.openGuiExplosionManager();
                    } else {
                        Main.getInstance().getConfig().set("explosions.disable_tntminecart_explosion", true);
                        Main.getInstance().reloadConfig();
                        p.sendMessage(Translator.Colors("&8[&a&lNo&c&lTNT&b&l+&8] &2Enabled the Anti-Explosion for TNT-Minecarts"));
                        p.closeInventory();
                        panelExplosionManager.openGuiExplosionManager();
                    }

                if (event.getSlot() == 14)
                    if (Main.getInstance().getConfig().getBoolean("explosions.disable_creeper_explosion")) {
                        Main.getInstance().getConfig().set("disable_creeper_explosion", false);
                        Main.getInstance().reloadConfig();
                        p.sendMessage(Translator.Colors("&8[&a&lNo&c&lTNT&b&l+&8] &cDisabled the Anti-Explosion for Creepers"));
                        p.closeInventory();
                        panelExplosionManager.openGuiExplosionManager();
                    } else {
                        Main.getInstance().getConfig().set("explosions.disable_creeper_explosion", true);
                        Main.getInstance().reloadConfig();
                        p.sendMessage(Translator.Colors("&8[&a&lNo&c&lTNT&b&l+&8] &2Enabled the Anti-Explosion for Creepers"));
                        p.closeInventory();
                        panelExplosionManager.openGuiExplosionManager();
                    }

                if (event.getSlot() == 16)
                    if (Main.getInstance().getConfig().getBoolean("explosions.disable_bed_explosion")) {
                        Main.getInstance().getConfig().set("disable_bed_explosion", false);
                        Main.getInstance().reloadConfig();
                        p.sendMessage(Translator.Colors("&8[&a&lNo&c&lTNT&b&l+&8] &cDisabled the Anti-Explosion for Beds"));
                        p.closeInventory();
                        panelExplosionManager.openGuiExplosionManager();
                    } else {
                        Main.getInstance().getConfig().set("explosions.disable_bed_explosion", true);
                        Main.getInstance().reloadConfig();
                        p.sendMessage(Translator.Colors("&8[&a&lNo&c&lTNT&b&l+&8] &2Enabled the Anti-Explosion for Beds"));
                        p.closeInventory();
                        panelExplosionManager.openGuiExplosionManager();
                    }

                if (event.getSlot() == 31) {
                    panel.openPanel();
                }
            }
        }
    }
}
