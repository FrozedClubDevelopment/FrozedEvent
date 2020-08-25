package me.elb1to.event.utils.framework;

import me.elb1to.event.FrozedEvent;

public abstract class BaseCommand {

    public FrozedEvent main = FrozedEvent.instance;

    public BaseCommand() {
        main.getFramework().registerCommands(this);
    }

    public abstract void onCommand(CommandArgs command);

}
