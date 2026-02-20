package de.kandiedel.vanish;

import de.kandiedel.vanish.commands.VanishCommand;
import de.kandiedel.vanish.listeners.PlayerConnectionListener;
import de.kandiedel.vanish.listeners.ServerPingListener;
import de.kandiedel.vanish.utils.VanishManager;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Vanish extends JavaPlugin {

    private VanishManager vanishManager;

    @Override
    public void onEnable() {

        vanishManager = new VanishManager();

        getCommand("vanish").setExecutor(new VanishCommand(vanishManager));

        getServer().getPluginManager().registerEvents(new ServerPingListener(vanishManager), this);
        getServer().getPluginManager().registerEvents(new PlayerConnectionListener(vanishManager), this);

        getServer().getConsoleSender().sendMessage("");
        getServer().getConsoleSender().sendMessage(ChatColor.GRAY + ChatColor.STRIKETHROUGH.toString() + "------------------------------------------");
        getServer().getConsoleSender().sendMessage("");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + " [ ✔ ] "
                + ChatColor.DARK_PURPLE + getDescription().getName()
                + ChatColor.GRAY + " successfully enabled!"
                + ChatColor.GREEN + " [ ✔ ]");
        getServer().getConsoleSender().sendMessage("         "
                + ChatColor.GRAY + "Developed By "
                + ChatColor.DARK_PURPLE + "Kandiedel " + ChatColor.GRAY + "⚒ ");
        getServer().getConsoleSender().sendMessage("");
        getServer().getConsoleSender().sendMessage(ChatColor.GRAY + ChatColor.STRIKETHROUGH.toString() + "------------------------------------------");
        getServer().getConsoleSender().sendMessage("");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage("");
        getServer().getConsoleSender().sendMessage(ChatColor.GRAY + ChatColor.STRIKETHROUGH.toString() + "-------------------------------------------");
        getServer().getConsoleSender().sendMessage("");
        getServer().getConsoleSender().sendMessage(ChatColor.RED + " [ ✖ ] "
                + ChatColor.DARK_PURPLE + getDescription().getName()
                + ChatColor.GRAY + " successfully disabled!"
                + ChatColor.RED + " [ ✖ ]");
        getServer().getConsoleSender().sendMessage("         "
                + ChatColor.GRAY + "Developed By "
                + ChatColor.DARK_PURPLE + "Kandiedel " + ChatColor.GRAY + "⚒ ");
        getServer().getConsoleSender().sendMessage("");
        getServer().getConsoleSender().sendMessage(ChatColor.GRAY + ChatColor.STRIKETHROUGH.toString() + "-------------------------------------------");
        getServer().getConsoleSender().sendMessage("");
    }
}
