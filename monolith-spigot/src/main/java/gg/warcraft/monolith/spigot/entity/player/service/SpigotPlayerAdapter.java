package gg.warcraft.monolith.spigot.entity.player.service;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.entity.player.PlayerServerData;
import gg.warcraft.monolith.api.entity.player.service.PlayerServerAdapter;
import gg.warcraft.monolith.spigot.entity.player.SpigotPlayerDataFactory;
import org.bukkit.Server;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

public class SpigotPlayerAdapter implements PlayerServerAdapter {
    private final Server server;
    private final SpigotPlayerDataFactory playerDataFactory;

    @Inject
    public SpigotPlayerAdapter(Server server, SpigotPlayerDataFactory playerDataFactory) {
        this.server = server;
        this.playerDataFactory = playerDataFactory;
    }

    @Override
    public PlayerServerData getPlayerServerData(UUID playerId) {
        Player player = server.getPlayer(playerId);
        if (player == null) {
            return null;
        }
        return playerDataFactory.create(player);
    }

    @Override
    public Collection<UUID> getOnlinePlayers() {
        return server.getOnlinePlayers().stream()
                .map(Player::getUniqueId)
                .collect(Collectors.toList());
    }

    @Override
    public UUID resolvePlayerId(String minecraftName) {
        Player player = server.getPlayerExact(minecraftName);
        return player != null ? player.getUniqueId() : null;
    }

    @Override
    public void sendMessage(UUID playerId, String message) {
        Player player = server.getPlayer(playerId);
        if (player != null) {
            player.sendMessage(message);
        }
    }
}
