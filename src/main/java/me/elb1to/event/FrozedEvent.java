package me.elb1to.event;

import lombok.Getter;
import lombok.Setter;
import me.elb1to.event.commands.FinishCommand;
import me.elb1to.event.commands.FrozedEventCommand;
import me.elb1to.event.commands.PlayerStateCommand;
import me.elb1to.event.commands.ReviveCommand;
import me.elb1to.event.commands.StartCommand;
import me.elb1to.event.layout.GameScoreboard;
import me.elb1to.event.player.PlayerListener;
import me.elb1to.event.utils.framework.CommandFramework;
import me.elb1to.event.utils.scoreboard.Assemble;
import me.elb1to.event.utils.scoreboard.AssembleStyle;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
@Setter
public class FrozedEvent extends JavaPlugin {

    public static FrozedEvent instance;
    private CommandFramework framework;

    @Override
    public void onEnable() {
        instance = this;

        framework = new CommandFramework(this);

        Assemble assemble = new Assemble(this, new GameScoreboard());
        assemble.setTicks(2);
        assemble.setAssembleStyle(AssembleStyle.MODERN);

        new FrozedEventCommand();
        new StartCommand();
        new FinishCommand();
        new ReviveCommand();
        new PlayerStateCommand();

        Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);
    }
}
