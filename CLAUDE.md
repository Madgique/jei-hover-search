# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a Minecraft mod called "JEI Hover Search" that integrates with JEI (Just Enough Items) to provide enhanced search functionality. The mod is built using the Architectury framework to support multiple mod loaders, currently targeting Forge for Minecraft 1.18.2.

## Build System & Commands

This project uses Gradle with the Architectury plugin for multi-platform mod development.

### Essential Commands
- `./gradlew build` - Build all modules (common + forge)
- `./gradlew :forge:build` - Build only the Forge version
- `./gradlew :common:build` - Build only the common module
- `./gradlew :forge:runClient` - Run Minecraft client with the mod for testing
- `./gradlew clean` - Clean build artifacts
- `./gradlew publishToMavenLocal` - Publish to local Maven repository

### Development Setup
- Java 17 required (configured via toolchain)
- Uses official Mojang mappings
- Mod version: 1.0 (defined in gradle.properties)
- Target Minecraft: 1.18.2
- Forge version: 40.2.0

## Architecture

### Multi-Platform Structure
The project follows Architectury's multi-platform pattern:

- **`common/`** - Platform-agnostic code shared between mod loaders
  - Contains core mod logic, configuration, and client-side functionality
  - Main classes: `JEIHoverSearchMod`, `JEIHoverSearchClient`, `JEIHoverSearchConfig`
  
- **`forge/`** - Forge-specific implementation
  - Platform-specific mod initialization and event handling
  - Contains `JEIHoverSearchModForge` which bootstraps the common code
  - Includes `mods.toml` for Forge mod metadata

### Key Components
- **Configuration System**: JSON-based config stored in `.minecraft/config/jeihoversearch.json`
  - Client settings: container tracking, highlight colors, timing
  - Common settings: search radius, item damage handling
- **Key Bindings**: Registered key mapping for search functionality (default: Y key)
- **Block Interaction**: Custom block interaction checking system for Forge

### Dependencies
- Architectury API for cross-platform compatibility
- JEI integration (required dependency)
- Minecraft Forge as the target loader

## Development Notes

### Adding New Features
- Add cross-platform code to `common/src/main/java/com/madgique/jeihoversearch/`
- Platform-specific implementations go in `forge/src/main/java/com/madgique/jeihoversearch/forge/`
- Configuration changes should update `JEIHoverSearchConfig` and may require config migration logic

### Testing
- Use `./gradlew :forge:runClient` to launch a development instance
- Test configuration changes by modifying the generated config file
- The `forge/run/` directory contains the development environment with logs, saves, and config

### Resource Management
- Language files: `common/src/main/resources/jeihoversearch/lang/en_us.json`
- Forge metadata: `forge/src/resources/META-INF/mods.toml`
- Both contain mod display information and translations