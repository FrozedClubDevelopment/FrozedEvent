package me.elb1to.event.commands;

import me.elb1to.event.FrozedEvent;
import me.elb1to.event.utils.CC;
import me.elb1to.event.utils.framework.BaseCommand;
import me.elb1to.event.utils.framework.Command;
import me.elb1to.event.utils.framework.CommandArgs;
import org.bukkit.entity.Player;

public class FrozedEventCommand extends BaseCommand {
    @Command(name = "frozedevent", aliases = {"event", "frozedeventplugin"})

    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        player.sendMessage(CC.translate("&7&m------------------------------------"));
        player.sendMessage(CC.translate("&b&lFrozedEvent"));
        player.sendMessage(CC.translate("&7Author&f: &b" + FrozedEvent.instance.getDescription().getAuthors()));
        player.sendMessage(CC.translate("&7Version&f: &b" + FrozedEvent.instance.getDescription().getVersion()));
        player.sendMessage(CC.translate("&7&m------------------------------------"));
    }
}
