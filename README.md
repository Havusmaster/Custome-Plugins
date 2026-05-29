# DiscordBridge

[![Paper](https://img.shields.io/badge/Paper-1.21.1+-blue)](https://papermc.io)
[![Java](https://img.shields.io/badge/Java-21-orange)](https://adoptium.net)
[![License](https://img.shields.io/badge/License-MIT-green)](LICENSE)

A Paper plugin that synchronizes Minecraft chat with Discord. Replaces dDiscordBot + Denizen scripts with a single lightweight plugin.

## Features

- **Bidirectional Chat Sync** — messages from Minecraft appear in Discord and vice versa
- **Join/Leave Announcements** — embeds with player head and random messages
- **Player List** — type `list` in Discord to see online players
- **Customizable** — all IDs, formats and colors in `config.yml`

## Installation

1. Download `DiscordBridge.jar` from [Releases](https://github.com/Havusmaster/Custome-Plugins/releases)
2. Place it in your server's `plugins/` folder
3. Restart the server
4. Edit `plugins/DiscordBridge/config.yml` and set your bot token:
   ```yaml
   bot-token: "YOUR_BOT_TOKEN"
   ```
5. Restart the server again

## Color Configuration

Edit `config.yml` to change Discord → Minecraft chat colors:

```yaml
colors:
  discord-prefix: "gray"    # [Discord] tag color
  discord-name: "aqua"      # player name color
  discord-message: "white"  # message text color
```

Available colors: `black`, `dark_blue`, `dark_green`, `dark_aqua`, `dark_red`, `dark_purple`, `gold`, `gray`, `dark_gray`, `blue`, `green`, `aqua`, `red`, `light_purple`, `yellow`, `white`.

## Building

```bash
./gradlew build
```

Output: `build/libs/DiscordBridge-1.0.0.jar`

## Requirements

- Paper 1.21.1+
- Java 21

## Full Config

```yaml
bot-token: ""
chat-channel-id: ""
bot-user-id: ""
format:
  minecraft-to-discord: "**%s**: %s"
  discord-to-minecraft: "<{prefix}>[Discord] <{name}>%s: <{message}>%s"
colors:
  discord-prefix: "gray"
  discord-name: "aqua"
  discord-message: "white"
```

## Bugs

Found a bug? Contact:
- Discord: **hanter_mine**
- Telegram: **@wa2nder**

## License

MIT
