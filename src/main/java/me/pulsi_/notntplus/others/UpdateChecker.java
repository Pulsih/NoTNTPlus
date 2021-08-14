package me.pulsi_.notntplus.others;

import me.pulsi_.notntplus.NoTNTPlus;
import me.pulsi_.notntplus.utils.ChatUtils;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class UpdateChecker implements Listener {

    private final boolean isUpToDate;
    private NoTNTPlus plugin;
    public UpdateChecker(NoTNTPlus plugin) {
        boolean isUpdated;
        this.plugin = plugin;
        try {
            isUpdated = isPluginUpdated();
        } catch (IOException e) {
            isUpdated = true;
        }
        this.isUpToDate = isUpdated;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if (!plugin.getConfig().getBoolean("update-checker")) return;
        if (!e.getPlayer().isOp() || !e.getPlayer().hasPermission("notntplus.notify")) return;
        if (isUpToDate) return;
        final TextComponent update = new TextComponent(ChatUtils.c("&8[&a&lNo&c&lTNT&b&l+&8] &aNew updated available! &7(CLICK HERE)"));
        update.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://www.spigotmc.org/resources/%E2%9A%A1%EF%B8%8F-notnt-%E2%9A%A1%EF%B8%8F-no-tnt-place-interact-explosion-damage-and-more.89432/"));
        update.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click here to download it!").color(ChatColor.GRAY).create()));
        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            e.getPlayer().sendMessage("");
            e.getPlayer().spigot().sendMessage(update);
            e.getPlayer().sendMessage("");
        }, 80);
    }

    private final boolean isPluginUpdated() throws IOException {
        final String currentVersion = new BufferedReader(new InputStreamReader(new URL("https://api.spigotmc.org/legacy/update.php?resource=89432").openConnection().getInputStream())).readLine();
        return plugin.getDescription().getVersion().equals(currentVersion);
    }
}