package me.elb1to.event.commands;

import me.elb1to.event.player.PlayerManager;
import me.elb1to.event.utils.CC;
import me.elb1to.event.utils.framework.BaseCommand;
import me.elb1to.event.utils.framework.Command;
import me.elb1to.event.utils.framework.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class StartCommand extends BaseCommand {
    @Command(name = "start", permission = "frozed.event.start")

    public void onCommand(CommandArgs command) {
        Bukkit.broadcastMessage(CC.translate("&7&m------------------------------------"));
        Bukkit.broadcastMessage(CC.translate("&b&lFrozedEvent &7- &f&nThe event has started&f!"));
        Bukkit.broadcastMessage(CC.translate("&7&m------------------------------------"));

        for (Player players : Bukkit.getOnlinePlayers()) {
            players.setGameMode(GameMode.SURVIVAL);
            PlayerManager.setState(players.getUniqueId(), PlayerManager.PlayerState.ALIVE);
        }

        Bukkit.broadcastMessage(CC.translate("&b&lFrozedEvent &7- &fAll players were revived!"));
    }
}
