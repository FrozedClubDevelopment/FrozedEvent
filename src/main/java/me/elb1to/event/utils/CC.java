package me.elb1to.event.utils;

import org.bukkit.ChatColor;

import java.util.List;
import java.util.stream.Collectors;

public class CC {

    public static String translate(String text) {
        String output = text;
        return ChatColor.translateAlternateColorCodes('&', output);
    }

    public static List<String> translate(List<String> list) {
        return list.stream().map(CC::translate).collect(Collectors.toList());
    }
}
