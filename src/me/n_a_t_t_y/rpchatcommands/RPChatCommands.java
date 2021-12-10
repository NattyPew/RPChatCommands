package me.n_a_t_t_y.rpchatcommands;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;


public class RPChatCommands extends JavaPlugin {

    private static RPChatCommands instance;

    @Override
    public void onEnable()
    {
        this.saveDefaultConfig();
        getCommand("tweet").setExecutor(new Tweet());
        getCommand("tw").setExecutor(new Tweet());
        getCommand("ooc").setExecutor(new OOC());
        getCommand("toggletweets").setExecutor(new ToggleTweets());

        instance = this;
        getLogger().info("RPChatCommands has been enabled!");
    }

    @Override
    public void onDisable()
    {

    }

    public static RPChatCommands getInstance()
    {
        return instance;
    }

    public static UUID getPlayerUUID(String playerName)
    {
        return Bukkit.getPlayer(playerName).getUniqueId();
    }

    public static Object getModConfig(String playerName)
    {
        String playerSettings = "players." + getPlayerUUID(playerName) + ".showTweets";
        return getInstance().getConfig().get(playerSettings);
    }

    public static void setModConfig(String playerName, Boolean value)
    {
        String playerSettings = "players." + getPlayerUUID(playerName) + ".showTweets";
        getInstance().getConfig().set(playerSettings, value);
        getInstance().saveConfig();
    }

    public static Boolean togglePlayerConfig(String playerName)
    {
        boolean toggle = true;

        if (getModConfig(playerName) == null)
        {
            setModConfig(playerName, true);
        }
        else {
            if (getModConfig(playerName).toString() == "true")
            {
                toggle = false;
            }
            setModConfig(playerName, toggle);
        }
        return toggle;
    }
}
