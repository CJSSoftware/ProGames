# ProGames

**ProGames** is a Minecraft plugin developed for Paper 1.21 using Java 21 and Maven. This plugin provides a suite of minigames like BedWars, SkyWars, Hunger Games, and Murder Mystery, allowing players to seamlessly engage in a variety of gameplay modes with simple commands and configuration options. ProGames is designed to bring a Hypixel-like experience to your server, including hub features, minigame selectors, and customizable game settings.

## Features
- **Minigames Included**:
  - BedWars (inspired by ProBedwars)
  - SkyWars
  - Hunger Games
  - Murder Mystery
- **Hub Features**:
  - Book Selector Menu for server information
  - Minigame Selector in slot 5 for easy access
- **Custom Commands**:
  - `/progames <minigame>` for game management
  - Minigame-specific commands, such as:
    - `/progames bedwars` – Manage and play BedWars
    - `/progames skywars` – Manage and play SkyWars
- **Configuration**:
  - Editable files for easy customization (`Commands.yml`, `config.yml`, `messages.yml`)
  - Supports per-minigame configurations with unique settings

## Installation

1. Download the latest release of **ProGames** from the [Releases](#) page.
2. Place the `ProGames.jar` file in your server's `plugins` folder.
3. Start the server to generate configuration files.
4. Configure minigame settings as needed in `config.yml`, `Commands.yml`, and `messages.yml`.
5. Restart the server to apply changes.

## Commands and Permissions

### General Commands
- `/progames bedwars` - Access BedWars commands.
- `/progames skywars` - Access SkyWars commands.
- `/progames hungergames` - Access Hunger Games commands.
- `/progames murdermystery` - Access Murder Mystery commands.
For full command details and permissions, check the [Commands](#) section.

## Configuration

**ProGames** provides various configuration options:
- **`config.yml`** - General plugin settings.
- **`Commands.yml`** - Define and customize commands.
- **`messages.yml`** - Customize in-game messages for each minigame.

Each minigame also has its own configuration folder to fine-tune settings specific to that game.

## Contributing

Feel free to fork the repository and make contributions to improve **ProGames**. We welcome any suggestions and contributions that can enhance gameplay, add features, or improve code quality.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

Enjoy bringing the ultimate minigame experience to your Minecraft server with **ProGames**!
