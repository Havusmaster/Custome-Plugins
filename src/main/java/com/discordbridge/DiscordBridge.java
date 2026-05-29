package com.discordbridge;

import com.discordbridge.listeners.ChatListener;
import com.discordbridge.listeners.JoinLeaveListener;
import org.bukkit.plugin.java.JavaPlugin;

public class DiscordBridge extends JavaPlugin {

    private static DiscordBridge instance;
    private DiscordBot discordBot;

    @Override
    public void onEnable() {
        instance = this;

        saveDefaultConfig();
        reloadConfig();

        String token = getConfig().getString("bot-token", "");
        String channelId = getConfig().getString("chat-channel-id", "");
        String botUserId = getConfig().getString("bot-user-id", "");

        if (!token.isEmpty()) {
            discordBot = new DiscordBot(token, channelId, botUserId);
            DiscordCommandListener commandListener = new DiscordCommandListener(this, channelId);
            discordBot.setCommandListener(commandListener);

            if (discordBot.connect()) {
                getLogger().info("Discord bot connected successfully!");
                discordBot.sendMessage("\u2705 **Minecraft \u0441\u0435\u0440\u0432\u0435\u0440 \u0437\u0430\u043F\u0443\u0449\u0435\u043D!**");
            } else {
                getLogger().warning("Failed to connect Discord bot. Chat sync disabled.");
            }
        } else {
            getLogger().info("No bot token set. Discord features disabled.");
        }

        getServer().getPluginManager().registerEvents(new ChatListener(this), this);
        getServer().getPluginManager().registerEvents(new JoinLeaveListener(this), this);

        getLogger().info("DiscordBridge enabled!");
    }

    @Override
    public void onDisable() {
        if (discordBot != null) {
            if (discordBot.isConnected()) {
                discordBot.sendMessage("\u274C **Minecraft \u0441\u0435\u0440\u0432\u0435\u0440 \u043E\u0441\u0442\u0430\u043D\u043E\u0432\u043B\u0435\u043D!**");
            }
            discordBot.disconnect();
        }
        getLogger().info("DiscordBridge disabled!");
    }

    public static DiscordBridge getInstance() {
        return instance;
    }

    public DiscordBot getDiscordBot() {
        return discordBot;
    }
}
