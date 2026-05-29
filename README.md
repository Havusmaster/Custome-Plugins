# DiscordBridge

[![Paper](https://img.shields.io/badge/Paper-1.21.1+-blue)](https://papermc.io)
[![Java](https://img.shields.io/badge/Java-21-orange)](https://adoptium.net)
[![License](https://img.shields.io/badge/License-MIT-green)](LICENSE)

---

## 🇬🇧 English

**DiscordBridge** is a Paper plugin that synchronizes Minecraft chat with Discord. It replaces dDiscordBot + Denizen scripts with a single lightweight plugin.

### Features

- **Bidirectional Chat Sync** — messages from Minecraft appear in Discord and vice versa
- **Join/Leave Announcements** — embeds with player head and random Russian messages
- **Player List** — type `list` in Discord to see online players
- **Configurable** — all IDs and formats are in `config.yml`

### Installation

1. Download `DiscordBridge.jar` from [Releases](https://github.com/Havusmaster/Custome-Plugins/releases)
2. Place it in your server's `plugins/` folder
3. Restart the server
4. Edit `plugins/DiscordBridge/config.yml` and set your bot token:
   ```yaml
   bot-token: "YOUR_BOT_TOKEN"
   ```
5. Restart the server again

### Building

```bash
./gradlew build
```

Output: `build/libs/DiscordBridge-1.0.0.jar`

### Requirements

- Paper 1.21.1+
- Java 21

---

## 🇷🇺 Русский

**DiscordBridge** — это Paper плагин для синхронизации чата Minecraft с Discord. Заменяет связку dDiscordBot + Denizen скрипты одним лёгким плагином.

### Возможности

- **Двусторонняя синхронизация чата** — сообщения из Minecraft появляются в Discord и наоборот
- **Уведомления о входе/выходе** — embed с головой игрока и случайными сообщениями на русском
- **Список игроков** — напишите `list` в Discord, чтобы увидеть онлайн
- **Настраивается** — все ID и форматы в `config.yml`

### Установка

1. Скачайте `DiscordBridge.jar` из [Releases](https://github.com/Havusmaster/Custome-Plugins/releases)
2. Поместите в папку `plugins/` вашего сервера
3. Перезапустите сервер
4. Отредактируйте `plugins/DiscordBridge/config.yml` и укажите токен бота:
   ```yaml
   bot-token: "ТОКЕН_БОТА"
   ```
5. Снова перезапустите сервер

### Сборка

```bash
./gradlew build
```

Результат: `build/libs/DiscordBridge-1.0.0.jar`

### Настройка цветов

Цвета для Discord → Minecraft чата меняются в `config.yml`:

```yaml
colors:
  discord-prefix: "gray"    # цвет тега [Discord]
  discord-name: "aqua"      # цвет ника игрока
  discord-message: "white"  # цвет текста сообщения
```

Доступные цвета: `black`, `dark_blue`, `dark_green`, `dark_aqua`, `dark_red`, `dark_purple`, `gold`, `gray`, `dark_gray`, `blue`, `green`, `aqua`, `red`, `light_purple`, `yellow`, `white`.

Просто меняешь название цвета и перезапускаешь сервер.

### Требования

- Paper 1.21.1+
- Java 21

---

## Config / Настройка

```yaml
# Discord Bot Token
bot-token: ""

# Channel ID for chat sync / ID канала для синхронизации
chat-channel-id: ""

# Bot user ID (to ignore own messages) / ID бота
bot-user-id: ""

# Message formats / Форматы сообщений
format:
  minecraft-to-discord: "**%s**: %s"
  discord-to-minecraft: "<{prefix}>[Discord] <{name}>%s: <{message}>%s"

# Colors for Discord-to-Minecraft chat / Цвета для Discord -> Minecraft чата
# Available colors / Доступные цвета:
#   black, dark_blue, dark_green, dark_aqua, dark_red, dark_purple,
#   gold, gray, dark_gray, blue, green, aqua, red, light_purple, yellow, white
colors:
  discord-prefix: "gray"
  discord-name: "aqua"
  discord-message: "white"
```

## Bugs / Ошибки

Нашли баг? Пишите:
- Discord: **hanter_mine**
- Telegram: **@wa2nder**

## License / Лицензия

MIT
