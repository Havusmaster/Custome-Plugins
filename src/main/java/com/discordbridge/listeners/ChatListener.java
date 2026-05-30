package com.discordbridge.listeners;

import com.discordbridge.DiscordBridge;
import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class ChatListener implements Listener {

    private final DiscordBridge plugin;
    private static final int LOCAL_RADIUS = 100;

    public ChatListener(DiscordBridge plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerChat(AsyncChatEvent event) {
        Player player = event.getPlayer();
        String message = PlainTextComponentSerializer.plainText().serialize(event.message());

        if (message.isEmpty()) return;

        boolean isGlobal = message.startsWith("!");
        if (isGlobal) {
            message = message.substring(1).trim();
            if (message.isEmpty()) return;
        }

        event.setCancelled(true);

        String playerName = player.getName();
        Component component;

        if (isGlobal) {
            String format = plugin.getConfig().getString("format.global", "<bold><gold>G</bold> <gray>%s: <white>%s");
            component = MiniMessage.miniMessage().deserialize(format.formatted(playerName, message));
            Bukkit.broadcast(component);

            if (plugin.isBotConnected()) {
                String discordFormat = plugin.getConfig().getString("format.minecraft-to-discord", "**%s**: %s");
                plugin.getDiscordBot().sendMessage(discordFormat.formatted(playerName, message));
            }
        } else {
            String format = plugin.getConfig().getString("format.local", "<bold><green>L</bold> <gray>%s: <white>%s");
            component = MiniMessage.miniMessage().deserialize(format.formatted(playerName, message));

            Location playerLoc = player.getLocation();
            for (Player recipient : Bukkit.getOnlinePlayers()) {
                if (recipient.getWorld().equals(player.getWorld())
                        && recipient.getLocation().distance(playerLoc) <= LOCAL_RADIUS) {
                    recipient.sendMessage(component);
                }
            }
        }
    }
}
