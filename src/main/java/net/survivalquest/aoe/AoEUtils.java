package net.survivalquest.aoe;

import org.bukkit.ChatColor;
import org.bukkit.Color;

public class AoEUtils {

    public static String Colour(String str){
        return ChatColor.translateAlternateColorCodes('&', str);
    }

    public static Color getColorFromString(String str){
        if (str.equalsIgnoreCase("black")) return Color.BLACK;
        if (str.equalsIgnoreCase("white")) return Color.WHITE;
        if (str.equalsIgnoreCase("aqua")) return Color.AQUA;
        if (str.equalsIgnoreCase("blue")) return Color.BLUE;
        if (str.equalsIgnoreCase("yellow")) return Color.YELLOW;
        if (str.equalsIgnoreCase("gray")) return Color.GRAY;
        if (str.equalsIgnoreCase("green")) return Color.GREEN;
        if (str.equalsIgnoreCase("orange")) return Color.ORANGE;
        if (str.equalsIgnoreCase("lime")) return Color.LIME;
        if (str.equalsIgnoreCase("red")) return Color.RED;
        return null;
    }
}
