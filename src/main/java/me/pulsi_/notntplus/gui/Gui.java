package me.pulsi_.notntplus.gui;

import me.pulsi_.notntplus.NoTNTPlus;
import me.pulsi_.notntplus.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Gui {

    private static NoTNTPlus plugin;
    public Gui(NoTNTPlus plugin) {
        this.plugin = plugin;
    }

    private static Inventory gui = Bukkit.createInventory(null, 54, ChatUtils.c("&aNo&cTNT&b+ &aControl Panel"));

    public void openGui(Player p) {
        setTNTButtons();
        setTNTMinecartButtons();
        setCreeperEggButtons();
        setBedButtons();
        setDamageButtons();
        p.openInventory(gui);
    }
    
    public static void changeItem(int slot, String path, List<String> lore) {
        ItemStack button;
        if (plugin.config().getBoolean(path)) {
            try {
                button = new ItemStack(Material.RED_CONCRETE);
                gui.setItem(slot, button);
            } catch (NoSuchFieldError err) {
                button = new ItemStack(Material.valueOf("STAINED_CLAY"), 1, (short) 14);
                gui.setItem(slot, button);
            }
            ItemMeta meta = gui.getItem(slot).getItemMeta();
            meta.setDisplayName(ChatUtils.c("&c&lDisabled"));
            meta.setLore(lore);
            gui.getItem(slot).setItemMeta(meta);
            plugin.config().set(path, false);
        } else {
            try {
                button = new ItemStack(Material.GREEN_CONCRETE);
                gui.setItem(slot, button);
            } catch (NoSuchFieldError err) {
                button = new ItemStack(Material.valueOf("STAINED_CLAY"), 1, (short) 13);
                gui.setItem(slot, button);
            }
            ItemMeta meta = gui.getItem(slot).getItemMeta();
            meta.setDisplayName(ChatUtils.c("&2&lEnabled"));
            meta.setLore(lore);
            gui.getItem(slot).setItemMeta(meta);
            plugin.config().set(path, true);
        }
        plugin.saveConfig();
    }

    private void setTNTButtons() {
        {
            gui.setItem(10, new ItemStack(Material.TNT));
            ItemStack tnt = gui.getItem(10);
            ItemMeta meta = tnt.getItemMeta();
            meta.setDisplayName(ChatUtils.c("&7&l(&c&l!&7&l) &a&lALL TNT OPTIONS."));
            List<String> tntLore = new ArrayList<>();
            tntLore.add(ChatUtils.c("&8&l* &7Disable TNT Place."));
            tntLore.add(ChatUtils.c("&8&l* &7Disable TNT Interact."));
            tntLore.add(ChatUtils.c("&8&l* &7Disable TNT Explosion."));
            tntLore.add(ChatUtils.c("&8&l* &7Disable TNT Pickup."));
            meta.setLore(tntLore);
            meta.addEnchant(Enchantment.DURABILITY, 1, true);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            tnt.setItemMeta(meta);
        }
        {
            List<String> lore11 = new ArrayList<>();
            lore11.add(ChatUtils.c("&7&l(&c&l!&7&l) &aDisable TNT Place."));
            lore11.add("");
            lore11.add(ChatUtils.c("&7Disabled Worlds:"));
            for (String s : plugin.config().getStringList("tnt.place.disabled-worlds")) {
                lore11.add(ChatUtils.c("&8&l* &7" + s));
            }
            lore11.add("");
            lore11.add(ChatUtils.c("&7(CLICK HERE) To toggle."));
            gui.setItem(11, ItemUtils.createButton(plugin.config().getBoolean("tnt.place.disable"), lore11));
        }
        {
            List<String> lore12 = new ArrayList<>();
            lore12.add(ChatUtils.c("&7&l(&c&l!&7&l) &aDisable TNT Interact."));
            lore12.add("");
            lore12.add(ChatUtils.c("&7Disabled Worlds:"));
            for (String s : plugin.config().getStringList("tnt.interact.disabled-worlds")) {
                lore12.add(ChatUtils.c("&8&l* &7" + s));
            }
            lore12.add("");
            lore12.add(ChatUtils.c("&7(CLICK HERE) To toggle."));
            gui.setItem(12, ItemUtils.createButton(plugin.config().getBoolean("tnt.interact.disable"), lore12));
        }
        {
            List<String> lore13 = new ArrayList<>();
            lore13.add(ChatUtils.c("&7&l(&c&l!&7&l) &aDisable TNT Explosion."));
            lore13.add("");
            lore13.add(ChatUtils.c("&7Disabled Worlds:"));
            for (String s : plugin.config().getStringList("tnt.explosion.disabled-worlds")) {
                lore13.add(ChatUtils.c("&8&l* &7" + s));
            }
            lore13.add("");
            lore13.add(ChatUtils.c("&7(CLICK HERE) To toggle."));
            gui.setItem(13, ItemUtils.createButton(plugin.config().getBoolean("tnt.explosion.disable"), lore13));
        }
        {
            List<String> lore14 = new ArrayList<>();
            lore14.add(ChatUtils.c("&7&l(&c&l!&7&l) &aDisable TNT Pickup."));
            lore14.add("");
            lore14.add(ChatUtils.c("&7Disabled Worlds:"));
            for (String s : plugin.config().getStringList("tnt.pickup.disabled-worlds")) {
                lore14.add(ChatUtils.c("&8&l* &7" + s));
            }
            lore14.add("");
            lore14.add(ChatUtils.c("&7(CLICK HERE) To toggle."));
            gui.setItem(14, ItemUtils.createButton(plugin.config().getBoolean("tnt.pickup.disable"), lore14));
        }
    }

    private void setTNTMinecartButtons() {
        {
            try {
                gui.setItem(19, new ItemStack(Material.TNT_MINECART));
            } catch (NoSuchFieldError err) {
                gui.setItem(19, new ItemStack(Material.valueOf("EXPLOSIVE_MINECART")));
            }
            ItemStack tntMinecart = gui.getItem(19);
            ItemMeta meta = tntMinecart.getItemMeta();
            meta.setDisplayName(ChatUtils.c("&7&l(&c&l!&7&l) &a&lALL TNT-MINECART OPTIONS."));
            List<String> tntMinecartLore = new ArrayList<>();
            tntMinecartLore.add(ChatUtils.c("&8&l* &7Disable TNT-Minecart Place."));
            tntMinecartLore.add(ChatUtils.c("&8&l* &7Disable TNT-Minecart Interact."));
            tntMinecartLore.add(ChatUtils.c("&8&l* &7Disable TNT-Minecart Explosion."));
            tntMinecartLore.add(ChatUtils.c("&8&l* &7Disable TNT-Minecart Pickup."));
            meta.setLore(tntMinecartLore);
            meta.addEnchant(Enchantment.DURABILITY, 1, true);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            tntMinecart.setItemMeta(meta);
        }
        {
            List<String> lore20 = new ArrayList<>();
            lore20.add(ChatUtils.c("&7&l(&c&l!&7&l) &aDisable TNT-Minecart Place."));
            lore20.add("");
            lore20.add(ChatUtils.c("&7Disabled Worlds:"));
            for (String s : plugin.config().getStringList("tntminecart.place.disabled-worlds")) {
                lore20.add(ChatUtils.c("&8&l* &7" + s));
            }
            lore20.add("");
            lore20.add(ChatUtils.c("&7(CLICK HERE) To toggle."));
            gui.setItem(20, ItemUtils.createButton(plugin.config().getBoolean("tntminecart.place.disable"), lore20));
        }
        {
            List<String> lore21 = new ArrayList<>();
            lore21.add(ChatUtils.c("&7&l(&c&l!&7&l) &aDisable TNT-Minecart Interact."));
            lore21.add("");
            lore21.add(ChatUtils.c("&7Disabled Worlds:"));
            for (String s : plugin.config().getStringList("tntminecart.interact.disabled-worlds")) {
                lore21.add(ChatUtils.c("&8&l* &7" + s));
            }
            lore21.add("");
            lore21.add(ChatUtils.c("&7(CLICK HERE) To toggle."));
            gui.setItem(21, ItemUtils.createButton(plugin.config().getBoolean("tntminecart.interact.disable"), lore21));
        }
        {
            List<String> lore22 = new ArrayList<>();
            lore22.add(ChatUtils.c("&7&l(&c&l!&7&l) &aDisable TNT-Minecart Explosion."));
            lore22.add("");
            lore22.add(ChatUtils.c("&7Disabled Worlds:"));
            for (String s : plugin.config().getStringList("tntminecart.explosion.disabled-worlds")) {
                lore22.add(ChatUtils.c("&8&l* &7" + s));
            }
            lore22.add("");
            lore22.add(ChatUtils.c("&7(CLICK HERE) To toggle."));
            gui.setItem(22, ItemUtils.createButton(plugin.config().getBoolean("tntminecart.explosion.disable"), lore22));
        }
        {
            List<String> lore23 = new ArrayList<>();
            lore23.add(ChatUtils.c("&7&l(&c&l!&7&l) &aDisable TNT-Minecart Pickup."));
            lore23.add("");
            lore23.add(ChatUtils.c("&7Disabled Worlds:"));
            for (String s : plugin.config().getStringList("tntminecart.pickup.disabled-worlds")) {
                lore23.add(ChatUtils.c("&8&l* &7" + s));
            }
            lore23.add("");
            lore23.add(ChatUtils.c("&7(CLICK HERE) To toggle."));
            gui.setItem(23, ItemUtils.createButton(plugin.config().getBoolean("tntminecart.pickup.disable"), lore23));
        }
    }

    private void setCreeperEggButtons() {
        {
            try {
                gui.setItem(28, new ItemStack(Material.CREEPER_SPAWN_EGG));
            } catch (NoSuchFieldError err) {
                ItemStack creeperHead = new ItemStack(Material.valueOf("MONSTER_EGG"), 1, (short) 50);
                gui.setItem(28, creeperHead);
            }
            ItemStack creeperEgg = gui.getItem(28);
            ItemMeta meta = creeperEgg.getItemMeta();
            meta.setDisplayName(ChatUtils.c("&7&l(&c&l!&7&l) &a&lALL CREEPEREGG OPTIONS."));
            List<String> creeperEggLore = new ArrayList<>();
            creeperEggLore.add(ChatUtils.c("&8&l* &7Disable CreeperEgg Place."));
            creeperEggLore.add(ChatUtils.c("&8&l* &7Disable CreeperEgg Interact."));
            creeperEggLore.add(ChatUtils.c("&8&l* &7Disable CreeperEgg Explosion."));
            creeperEggLore.add(ChatUtils.c("&8&l* &7Disable CreeperEgg Pickup."));
            meta.setLore(creeperEggLore);
            meta.addEnchant(Enchantment.DURABILITY, 1, true);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            creeperEgg.setItemMeta(meta);
        }
        {
            List<String> lore29 = new ArrayList<>();
            lore29.add(ChatUtils.c("&7&l(&c&l!&7&l) &aDisable CreeperEgg Place."));
            lore29.add("");
            lore29.add(ChatUtils.c("&7Disabled Worlds:"));
            for (String s : plugin.config().getStringList("creeperegg.place.disabled-worlds")) {
                lore29.add(ChatUtils.c("&8&l* &7" + s));
            }
            lore29.add("");
            lore29.add(ChatUtils.c("&7(CLICK HERE) To toggle."));
            gui.setItem(29, ItemUtils.createButton(plugin.config().getBoolean("creeperegg.place.disable"), lore29));
        }
        {
            List<String> lore30 = new ArrayList<>();
            lore30.add(ChatUtils.c("&7&l(&c&l!&7&l) &aDisable CreeperEgg Interact."));
            lore30.add("");
            lore30.add(ChatUtils.c("&7Disabled Worlds:"));
            for (String s : plugin.config().getStringList("creeperegg.interact.disabled-worlds")) {
                lore30.add(ChatUtils.c("&8&l* &7" + s));
            }
            lore30.add("");
            lore30.add(ChatUtils.c("&7(CLICK HERE) To toggle."));
            gui.setItem(30, ItemUtils.createButton(plugin.config().getBoolean("creeperegg.interact.disable"), lore30));
        }
        {
            List<String> lore31 = new ArrayList<>();
            lore31.add(ChatUtils.c("&7&l(&c&l!&7&l) &aDisable CreeperEgg Explosion."));
            lore31.add("");
            lore31.add(ChatUtils.c("&7Disabled Worlds:"));
            for (String s : plugin.config().getStringList("creeperegg.explosion.disabled-worlds")) {
                lore31.add(ChatUtils.c("&8&l* &7" + s));
            }
            lore31.add("");
            lore31.add(ChatUtils.c("&7(CLICK HERE) To toggle."));
            gui.setItem(31, ItemUtils.createButton(plugin.config().getBoolean("creeperegg.explosion.disable"), lore31));
        }
        {
            List<String> lore32 = new ArrayList<>();
            lore32.add(ChatUtils.c("&7&l(&c&l!&7&l) &aDisable CreeperEgg Pickup."));
            lore32.add("");
            lore32.add(ChatUtils.c("&7Disabled Worlds:"));
            for (String s : plugin.config().getStringList("creeperegg.pickup.disabled-worlds")) {
                lore32.add(ChatUtils.c("&8&l* &7" + s));
            }
            lore32.add("");
            lore32.add(ChatUtils.c("&7(CLICK HERE) To toggle."));
            gui.setItem(32, ItemUtils.createButton(plugin.config().getBoolean("creeperegg.pickup.disable"), lore32));
        }
    }

    private void setBedButtons() {
        {
            try {
                gui.setItem(37, new ItemStack(Material.RED_BED));
            } catch (NoSuchFieldError err) {
                ItemStack creeperHead = new ItemStack(Material.valueOf("BED"));
                gui.setItem(37, creeperHead);
            }
            ItemStack bed = gui.getItem(37);
            ItemMeta meta = bed.getItemMeta();
            meta.setDisplayName(ChatUtils.c("&7&l(&c&l!&7&l) &a&lALL BED OPTIONS."));
            List<String> tntLore = new ArrayList<>();
            tntLore.add(ChatUtils.c("&8&l* &7Disable Bed Place."));
            tntLore.add(ChatUtils.c("&8&l* &7Disable Bed Interact."));
            tntLore.add(ChatUtils.c("&8&l* &7Disable Bed Explosion."));
            tntLore.add(ChatUtils.c("&8&l* &7Disable Bed Pickup."));
            meta.setLore(tntLore);
            meta.addEnchant(Enchantment.DURABILITY, 1, true);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            bed.setItemMeta(meta);
        }
        {
            List<String> lore38 = new ArrayList<>();
            lore38.add(ChatUtils.c("&7&l(&c&l!&7&l) &aDisable Bed Place."));
            lore38.add("");
            lore38.add(ChatUtils.c("&7Disabled Worlds:"));
            for (String s : plugin.config().getStringList("bed.place.disabled-worlds")) {
                lore38.add(ChatUtils.c("&8&l* &7" + s));
            }
            lore38.add("");
            lore38.add(ChatUtils.c("&7(CLICK HERE) To toggle."));
            gui.setItem(38, ItemUtils.createButton(plugin.config().getBoolean("bed.place.disable"), lore38));
        }
        {
            List<String> lore39 = new ArrayList<>();
            lore39.add(ChatUtils.c("&7&l(&c&l!&7&l) &aDisable Bed Interact."));
            lore39.add("");
            lore39.add(ChatUtils.c("&7Disabled Worlds:"));
            for (String s : plugin.config().getStringList("bed.interact.disabled-worlds")) {
                lore39.add(ChatUtils.c("&8&l* &7" + s));
            }
            lore39.add("");
            lore39.add(ChatUtils.c("&7(CLICK HERE) To toggle."));
            gui.setItem(39, ItemUtils.createButton(plugin.config().getBoolean("bed.interact.disable"), lore39));
        }
        {
            List<String> lore40 = new ArrayList<>();
            lore40.add(ChatUtils.c("&7&l(&c&l!&7&l) &aDisable Bed Explosion."));
            lore40.add("");
            lore40.add(ChatUtils.c("&7Disabled Worlds:"));
            for (String s : plugin.config().getStringList("bed.explosion.disabled-worlds")) {
                lore40.add(ChatUtils.c("&8&l* &7" + s));
            }
            lore40.add("");
            lore40.add(ChatUtils.c("&7(CLICK HERE) To toggle."));
            gui.setItem(40, ItemUtils.createButton(plugin.config().getBoolean("bed.explosion.disable"), lore40));
        }
        {
            List<String> lore41 = new ArrayList<>();
            lore41.add(ChatUtils.c("&7&l(&c&l!&7&l) &aDisable CreeperEgg Pickup."));
            lore41.add("");
            lore41.add(ChatUtils.c("&7Disabled Worlds:"));
            for (String s : plugin.config().getStringList("bed.pickup.disabled-worlds")) {
                lore41.add(ChatUtils.c("&8&l* &7" + s));
            }
            lore41.add("");
            lore41.add(ChatUtils.c("&7(CLICK HERE) To toggle."));
            gui.setItem(41, ItemUtils.createButton(plugin.config().getBoolean("bed.pickup.disable"), lore41));
        }
    }

    private void setDamageButtons() {
        {
            try {
                gui.setItem(16, new ItemStack(Material.DIAMOND_CHESTPLATE));
            } catch (NoSuchFieldError err) {
                ItemStack creeperHead = new ItemStack(Material.valueOf("BED"));
                gui.setItem(16, creeperHead);
            }
            ItemStack diamondChestplate = gui.getItem(16);
            ItemMeta meta = diamondChestplate.getItemMeta();
            meta.setDisplayName(ChatUtils.c("&7&l(&c&l!&7&l) &a&lALL DAMAGE OPTIONS."));
            List<String> diamondChestplateLore = new ArrayList<>();
            diamondChestplateLore.add(ChatUtils.c("&8&l* &7Disable Explosions Damage (Players / Mobs)."));
            meta.setLore(diamondChestplateLore);
            meta.addEnchant(Enchantment.DURABILITY, 1, true);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            diamondChestplate.setItemMeta(meta);
        }
        {
            List<String> lore25 = new ArrayList<>();
            lore25.add(ChatUtils.c("&7&l(&c&l!&7&l) &aDisable Explosions Damage &8(Players)&7."));
            lore25.add("");
            lore25.add(ChatUtils.c("&7(CLICK HERE) To toggle."));
            gui.setItem(25, ItemUtils.createButton(plugin.config().getBoolean("damage.disable-for-players"), lore25));
        }
        {
            List<String> lore34 = new ArrayList<>();
            lore34.add(ChatUtils.c("&7&l(&c&l!&7&l) &aDisable Explosions Damage &8(Mobs)."));
            lore34.add("");
            lore34.add(ChatUtils.c("&7Mobs Affected:"));
            for (String s : plugin.config().getStringList("damage.mobs-list")) {
                lore34.add(ChatUtils.c("&8&l* &7" + s));
            }
            lore34.add("");
            lore34.add(ChatUtils.c("&7(CLICK HERE) To toggle."));
            gui.setItem(34, ItemUtils.createButton(plugin.config().getBoolean("damage.disable-for-mobs"), lore34));
        }
        {
            try {
                gui.setItem(43, new ItemStack(Material.OAK_SAPLING));
            } catch (NoSuchFieldError err) {
                ItemStack creeperHead = new ItemStack(Material.valueOf("SAPLING"));
                gui.setItem(43, creeperHead);
            }
            ItemStack oakSapling = gui.getItem(43);
            ItemMeta meta = oakSapling.getItemMeta();
            meta.setDisplayName(ChatUtils.c("&7&l(&c&l!&7&l) &a&lALL EXPLOSIONS DISABLED WORLDS."));
            List<String> oakSaplingLore = new ArrayList<>();
            oakSaplingLore.add(ChatUtils.c("&7Worlds:"));
            for (String s : plugin.config().getStringList("damage.disabled-worlds")) {
                oakSaplingLore.add(ChatUtils.c("&8&l* &7" + s));
            }
            meta.setLore(oakSaplingLore);
            oakSapling.setItemMeta(meta);
        }
    }
}