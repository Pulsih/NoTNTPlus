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
                    if (Main.getInstance().getConfig().getBoolean("disable_tnt_explosion")) {
                        Main.getInstance().getConfig().set("disable_tnt_explosion", false);
                        Main.getInstance().saveConfig();
                        p.closeInventory();
                        panelExplosionManager.openGuiExplosionManager();
                    } else {
                        Main.getInstance().getConfig().set("disable_tnt_explosion", true);
                        Main.getInstance().saveConfig();
                        p.closeInventory();
                        panelExplosionManager.openGuiExplosionManager();
                    }

                if (event.getSlot() == 13)
                    if (Main.getInstance().getConfig().getBoolean("disable_tntminecart_explosion")) {
                        Main.getInstance().getConfig().set("disable_tntminecart_explosion", false);
                        Main.getInstance().saveConfig();
                        p.closeInventory();
                        panelExplosionManager.openGuiExplosionManager();
                    } else {
                        Main.getInstance().getConfig().set("disable_tntminecart_explosion", true);
                        Main.getInstance().saveConfig();
                        p.closeInventory();
                        panelExplosionManager.openGuiExplosionManager();
                    }

                if (event.getSlot() == 16)
                    if (Main.getInstance().getConfig().getBoolean("disable_creeper_explosion")) {
                        Main.getInstance().getConfig().set("disable_creeper_explosion", false);
                        Main.getInstance().saveConfig();
                        p.closeInventory();
                        panelExplosionManager.openGuiExplosionManager();
                    } else {
                        Main.getInstance().getConfig().set("disable_creeper_explosion", true);
                        Main.getInstance().saveConfig();
                        p.closeInventory();
                        panelExplosionManager.openGuiExplosionManager();
                    }

                if (event.getSlot() == 26) {
                    panel.openPanel();
                }
            }
        }
    }
}
