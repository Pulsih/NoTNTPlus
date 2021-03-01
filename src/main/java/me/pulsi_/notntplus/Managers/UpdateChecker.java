package me.pulsi_.notntplus.Managers;

import me.pulsi_.notntplus.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
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
                    p.sendMessage(Translator.Colors("&8&m-----------------------"));
                    p.sendMessage(Translator.Colors("&8"));
                    p.sendMessage(Translator.Colors("&8[&a&lNo&c&lTNT&b&l+&8]"));
                    p.sendMessage(Translator.Colors("&2&lThere are no updates available!"));
                    p.sendMessage(Translator.Colors("&8"));
                    p.sendMessage(Translator.Colors("&8&m-----------------------"));
                } else {
                    p.sendMessage(Translator.Colors("&8&m-----------------------"));
                    p.sendMessage(Translator.Colors("&8"));
                    p.sendMessage(Translator.Colors("&8[&a&lNo&c&lTNT&b&l+&8]"));
                    p.sendMessage(Translator.Colors("&2&lThere is a new update available!"));
                    p.sendMessage(Translator.Colors("&8"));
                    p.sendMessage(Translator.Colors("&7Download it at:"));
                    p.sendMessage(Translator.Colors("&bhttps://www.spigotmc.org/resources/%E2%9A%A1%EF%B8%8F-notnt-%E2%9A%A1%EF%B8%8F-anti-tnt-plugin-for-the-server-security.89432/"));
                    p.sendMessage(Translator.Colors("&8"));
                    p.sendMessage(Translator.Colors("&8&m-----------------------"));
                }
            });
        }
    }
}
