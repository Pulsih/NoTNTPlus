package me.pulsi_.notntplus.gui;

import me.pulsi_.notntplus.utils.ChatUtils;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class ItemUtils {

    public static ItemStack createButton(boolean isActivated, List<String> lore) {
        ItemStack button;
        if (isActivated) {
            try {
                button = new ItemStack(Material.GREEN_CONCRETE);
            } catch (NoSuchFieldError err) {
                button = new ItemStack(Material.valueOf("STAINED_CLAY"), 1, (short) 13);
            }
            ItemMeta meta = button.getItemMeta();
            meta.setDisplayName(ChatUtils.c("&2&lEnabled"));
            meta.setLore(lore);
            button.setItemMeta(meta);
        } else {
            try {
                button = new ItemStack(Material.RED_CONCRETE);
            } catch (NoSuchFieldError err) {
                button = new ItemStack(Material.valueOf("STAINED_CLAY"), 1, (short) 14);
            }
            ItemMeta meta = button.getItemMeta();
            meta.setDisplayName(ChatUtils.c("&c&lDisabled"));
            meta.setLore(lore);
            button.setItemMeta(meta);
        }
        return button;
    }
}
