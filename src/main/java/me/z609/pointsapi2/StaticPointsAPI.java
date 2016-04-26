package me.z609.pointsapi2;

/**
 * This code is by Z609, and is copyright (C) 2016 Z609. Don't share this
 * code with the public! Thanks!
 */

import org.bukkit.Bukkit;

/**
 * For those who don't want to use getPlugin() in Bukkit
 */
public class StaticPointsAPI {

    public static PointsAPI getPointsAPI(){
        return (PointsAPI)Bukkit.getPluginManager().getPlugin("PointsAPI");
    }

    public static boolean isInteger(String s){
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ignored) {
            return false;
        }
    }

}
