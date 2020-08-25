package me.elb1to.event.commands;

import me.elb1to.event.player.PlayerListener;
import me.elb1to.event.player.PlayerManager;
import me.elb1to.event.utils.CC;
import me.elb1to.event.utils.framework.BaseCommand;
import me.elb1to.event.utils.framework.Command;
import me.elb1to.event.utils.framework.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class ReviveCommand extends BaseCommand {
    @Command(name = "revive", permission = "frozed.event.revive")

    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();

        if (args.length == 0) {
            player.sendMessage(CC.translate("&cUsage: /revive <playerName>"));
            return;
        }

        Player target = Bukkit.getPlayer(args[0]);
        if (PlayerManager.getState(target.getUniqueId()) != PlayerManager.PlayerState.DEAD) {
            player.sendMessage(CC.translate("&c" + target.getName() + " is not dead!"));
        } else {
            target.setGameMode(GameMode.SURVIVAL);
            target.teleport(PlayerListener.deathLocation.get(target));
            PlayerManager.setState(target.getUniqueId(), PlayerManager.PlayerState.ALIVE);

            player.sendMessage(CC.translate("&aSuccessfully revived " + target.getName()));

            target.sendMessage(CC.translate(" "));
            target.sendMessage(CC.translate("&7&m------------------------------------"));
            target.sendMessage(CC.translate("&b&lFrozedEvent &7- &fYou have been revived!"));
            target.sendMessage(CC.translate("&7Revived by&f: &b" + player.getName()));
            target.sendMessage(CC.translate(" "));
            target.sendMessage(CC.translate("&7&oYou were teleported to your death location"));
            target.sendMessage(CC.translate("&7&m------------------------------------"));
            target.sendMessage(CC.translate(" "));

            Bukkit.broadcastMessage(CC.translate("&7&m------------------------------------"));
            Bukkit.broadcastMessage(CC.translate("&b" + target.getName() + " &7has been revived."));
            Bukkit.broadcastMessage(CC.translate("&7&m------------------------------------"));
        }
    }
}
