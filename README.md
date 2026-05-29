# DiscordBridge

Paper plugin for Discord-Minecraft bridge.

## Features

- **Chat Sync** — bidirectional chat synchronization between Minecraft and Discord
- **Join/Leave Announcements** — player join/leave with Discord embeds and player head thumbnails
- **Player List** — `list` command in Discord shows online players

## Requirements

- Paper 1.21.1+
- Java 21

## Installation

1. Download `DiscordBridge.jar` and place it in `plugins/`
2. Restart the server (config.yml will be created automatically)
3. Edit `plugins/DiscordBridge/config.yml` and set your bot token:
```yaml
bot-token: "YOUR_BOT_TOKEN_HERE"
```
4. Restart the server again

## Building from source

```bash
./gradlew build
```

The jar will be in `build/libs/`.

## Config

```yaml
bot-token: ""                    # Discord bot token
chat-channel-id: ""              # Channel ID for chat sync
bot-user-id: ""                  # Bot user ID
format:
  minecraft-to-discord: "**%s**: %s"
  discord-to-minecraft: "<gray>[Discord] <aqua>%s: <white>%s"
```

## License

MIT
