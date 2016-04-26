package me.z609.pointsapi2;

import me.z609.pointsapi2.command.PointsCommand;
import me.z609.pointsapi2.currency.CurrencyManager;
import me.z609.pointsapi2.player.ChatFormatterListener;
import me.z609.pointsapi2.player.PointsPlayer;
import me.z609.pointsapi2.player.PointsPlayerManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

/**
 * This code is by Z609, and is copyright (C) 2016 Z609. Don't share this
 * code with the public! Thanks!
 */
public class PointsAPI extends JavaPlugin {

    private CurrencyManager currencyManager;
    private PointsPlayerManager pointsPlayerManager;
    private boolean fullInit = false;

    @Override
    public void onEnable(){
        if(getServer().getPluginManager().isPluginEnabled("ChatFormatter")){
            getServer().getLogger().log(Level.INFO, "Dependency ChatFormatter was found...enabling!");
            getServer().getPluginManager().registerEvents(new ChatFormatterListener(this), this);
        }
        getConfig().options().copyDefaults(true);
        save();
        currencyManager = new CurrencyManager(this);
        pointsPlayerManager = new PointsPlayerManager(this);
        new PointsCommand(this);
        fullInit = true;
    }

    @Override
    public void onDisable(){
        if(!fullInit)return;
        for(PointsPlayer player : pointsPlayerManager.getPlayers()){
            player.save();
        }
    }

    public void reload(){
        reloadConfig();
    }

    public void save(){
        saveConfig();
        reload();
    }

    public CurrencyManager getCurrencyManager() {
        return currencyManager;
    }

    public PointsPlayerManager getPointsPlayerManager() {
        return pointsPlayerManager;
    }
}
