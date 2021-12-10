package me.n_a_t_t_y.rpchatcommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Tweet implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (RPChatCommands.getModConfig(sender.getName()) == null)
        {
            RPChatCommands.togglePlayerConfig(sender.getName());
        }

        if (RPChatCommands.getModConfig(sender.getName()).toString() == "false")
        {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bYou have tweets turned off. Type /tweets to enable."));
        }
        else {
            StringBuilder textToTweet = new StringBuilder();
            for (String arg : args
            ) {
                textToTweet.append(" ").append(arg);
            }

            String nickname = Bukkit.getPlayer(sender.getName()).getDisplayName();
            String tweet = ChatColor.translateAlternateColorCodes('&', "&b*Tweet from " + nickname + "*&r" + textToTweet);

            for (Player player : Bukkit.getOnlinePlayers())
            {
                if (RPChatCommands.getModConfig(player.getName()) == null)
                {
                    RPChatCommands.togglePlayerConfig(player.getName());
                }
                if (RPChatCommands.getModConfig(player.getName()).toString() == "true")
                {
                    player.sendMessage(tweet);
                }
            }
        }
        return true;
    }
}
