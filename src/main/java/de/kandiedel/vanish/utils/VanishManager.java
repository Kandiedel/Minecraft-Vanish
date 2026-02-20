package de.kandiedel.vanish.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class VanishManager {

    private final Set<UUID> vanishedPlayers = new HashSet<>();

    public boolean isVanished(UUID uuid) {
        return vanishedPlayers.contains(uuid);
    }

    public void vanishPlayer(UUID uuid) {
        Player player = Bukkit.getPlayer(uuid);
        if (player == null) return;

        vanishedPlayers.add(uuid);

        for (Player all : Bukkit.getOnlinePlayers()) {
            if (all.equals(player)) continue;

            if (!all.hasPermission("vanish.bypass.vanish")) {
                all.hidePlayer(player);
            }
        }
    }

    public void unvanishPlayer(UUID uuid) {
        Player player = Bukkit.getPlayer(uuid);
        if (player == null) return;

        if (vanishedPlayers.contains(uuid)) {
            vanishedPlayers.remove(uuid);
        }

        for (Player all : Bukkit.getOnlinePlayers()) {
            if (all.equals(player) || all.hasPermission("vanish.bypass.vanish")) continue;
            all.showPlayer(player);
        }
    }
}