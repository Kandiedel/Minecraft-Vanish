package de.kandiedel.vanish.commands;

import de.kandiedel.vanish.utils.VanishManager;
import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

import java.util.UUID;

public class VanishCommand implements CommandExecutor {

    private final VanishManager vanishManager;

    public VanishCommand(VanishManager vanishManager) {
        this.vanishManager = vanishManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage(ChatColor.RED + "This command can only be used by players.");
            return true;
        }

        if (!player.hasPermission("vanish.cmd.vanish")) {
            player.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
            return true;
        }

        UUID uuid = player.getUniqueId();

        if (vanishManager.isVanished(uuid)) {

            vanishManager.unvanishPlayer(uuid);

            player.sendMessage(ChatColor.RED + "Vanish mode disabled.");
        } else {

            vanishManager.vanishPlayer(uuid);

            player.sendMessage(ChatColor.GREEN + "Vanish mode enabled.");
        }

        return true;
    }
}