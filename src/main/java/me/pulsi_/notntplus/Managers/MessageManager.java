package me.pulsi_.notntplus.Managers;

import me.pulsi_.notntplus.Main;
import org.bukkit.entity.Player;

public class MessageManager {

    ConfigManager messages = new ConfigManager(Main.getInstance(), "messages.yml");

        private Player player;

        public MessageManager(Player player){
            this.player = player;
        }

        public void reloadMessage(){
            player.sendMessage(Translator.Colors(messages.getConfig().getString("reload_message")));
        }

        public void noPermission(){
            player.sendMessage(Translator.Colors(messages.getConfig().getString("nopermission_message")));
        }

        public void unknownCommand() {
            player.sendMessage(Translator.Colors(messages.getConfig().getString("unknown_command")));
        }
}
