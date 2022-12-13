package net.survivalquest.aoe;

import org.bukkit.ChatColor;
import org.bukkit.Color;

public class AoEUtils {

    public static String Colour(String str){
        return ChatColor.translateAlternateColorCodes('&', str);
    }

    public static Color getColorFromString(String str){
        str.toLowerCase();
        if (str == "black") return Color.BLACK;
        if (str == "white") return Color.WHITE;
        if (str == "aqua") return Color.AQUA;
        if (str == "blue") return Color.BLUE;
        if (str == "yellow") return Color.YELLOW;
        if (str == "gray") return Color.GRAY;
        if (str == "green") return Color.GREEN;
        if (str == "orange") return Color.ORANGE;
        if (str == "lime") return Color.LIME;
        if (str == "red") return Color.RED;
        else return Color.LIME;
    }
}
