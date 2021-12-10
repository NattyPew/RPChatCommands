package me.n_a_t_t_y.rpchatcommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Objects;
import java.util.UUID;

public class ToggleTweets implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Boolean result = RPChatCommands.togglePlayerConfig(sender.getName());
        String message = "You are no longer receiving Tweets.";;

        if (result) {
            message = "You are now receiving Tweets.";
        }

        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b" + message));
        return true;
    }
}