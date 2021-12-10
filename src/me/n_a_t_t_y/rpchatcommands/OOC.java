package me.n_a_t_t_y.rpchatcommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Objects;

public class OOC implements CommandExecutor {

    @SuppressWarnings("NullableProblems")
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        StringBuilder textToOoc = new StringBuilder();
        for (String arg : args
        ) {
            textToOoc.append(" ").append(arg);
        }

        String nickname;
        try {
             nickname = Objects.requireNonNull(Bukkit.getPlayer(sender.getName())).getDisplayName();
        }
        catch (Exception NullPointerException) {
            nickname = sender.getName();
        }


        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&2~OOC " + nickname +"&r" + textToOoc));
        return true;
    }
}
