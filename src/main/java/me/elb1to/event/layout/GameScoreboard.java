package me.elb1to.event.layout;

import me.elb1to.event.utils.CC;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import me.elb1to.event.player.PlayerManager;
import me.elb1to.event.utils.scoreboard.AssembleAdapter;

import java.util.ArrayList;
import java.util.List;

public class GameScoreboard implements AssembleAdapter {

    @Override
    public String getTitle(Player player) {
        return CC.translate("&b&lFrozed &7| &fEvent");
    }

    @Override
    public List<String> getLines(Player player) {
        List<String> toReturn = new ArrayList<>();

        toReturn.add("&7&m----------------");
        toReturn.add("&fRemaining&7: &b" + PlayerManager.getAlivePlayers());
        toReturn.add("&7&m----------------");

        return toReturn;
    }
}
