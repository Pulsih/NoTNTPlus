package me.pulsi_.notntplus.Managers;

import me.pulsi_.notntplus.Main;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Consumer;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class UpdateChecker implements Listener {

    private JavaPlugin plugin;
    private int resourceId;

    public UpdateChecker(JavaPlugin plugin, int resourceId) {
        this.plugin = plugin;
        this.resourceId = resourceId;
    }

    public UpdateChecker() {

    }

    public void getVersion(final Consumer<String> consumer) {
        Bukkit.getScheduler().runTaskAsynchronously(this.plugin, () -> {
            try (InputStream inputStream = new URL("https://api.spigotmc.org/legacy/update.php?resource=" + this.resourceId).openStream(); Scanner scanner = new Scanner(inputStream)) {
                if (scanner.hasNext()) {
                    consumer.accept(scanner.next());
                }
            } catch (IOException exception) {
                this.plugin.getLogger().info(Translator.Colors("&8&m-----------------------"));
                this.plugin.getLogger().info(Translator.Colors("&8"));
                this.plugin.getLogger().info(Translator.Colors("&8[&a&lNo&c&lTNT&b&l+&8]"));
                this.plugin.getLogger().info(Translator.Colors("&c&lCannot look for updates! " + exception.getMessage()));
                this.plugin.getLogger().info(Translator.Colors("&8"));
                this.plugin.getLogger().info(Translator.Colors("&8&m-----------------------"));
            }
        });
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if (Main.getInstance().getConfig().getBoolean("update_checker")) {
            Player p = e.getPlayer();
            new UpdateChecker(Main.getInstance(), 89432).getVersion(version -> {
                if (Main.getInstance().getDescription().getVersion().equalsIgnoreCase(version)) {
                    if (p.isOp()) {

                        new BukkitRunnable() {
                            @Override
                            public void run() {

                                p.sendMessage(Translator.Colors("&8[&a&lNo&c&lTNT&b&l+&8] &2There are no updates available!"));

                            }
                        }.runTaskLater(Main.getInstance(), 60);
                    } else {

                        TextComponent update = new TextComponent(Translator.Colors("&b&nClick here!"));
                        update.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://www.spigotmc.org/resources/%E2%9A%A1%EF%B8%8F-notnt-%E2%9A%A1%EF%B8%8F-anti-tnt-plugin-for-the-server-security.89432/"));
                        update.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click here to download it!").color(ChatColor.LIGHT_PURPLE).create()));

                        new BukkitRunnable() {
                            @Override
                            public void run() {

                                p.sendMessage(Translator.Colors("&8&m----------------------------"));
                                p.sendMessage(Translator.Colors("&8"));
                                p.sendMessage(Translator.Colors("&8[&a&lNo&c&lTNT&b&l+&8]"));
                                p.sendMessage(Translator.Colors("&8"));
                                p.sendMessage(Translator.Colors("&2&lThere is a new update available!"));
                                p.spigot().sendMessage(update);
                                p.sendMessage(Translator.Colors("&8"));
                                p.sendMessage(Translator.Colors("&8&m----------------------------"));

                            }
                        }.runTaskLater(Main.getInstance(), 60);
                    }
                }
            });
        }
    }
}