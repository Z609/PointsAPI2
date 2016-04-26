package me.z609.pointsapi2.player;

import me.z609.pointsapi2.currency.Currency;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * This code is by Z609, and is copyright (C) 2016 Z609. Don't share this
 * code with the public! Thanks!
 */
public class PointsPlayer extends OfflinePointsPlayer {
    private Player bukkitPlayer;
    private Map<Currency, Integer> currencyValues = new HashMap<Currency, Integer>();

    public PointsPlayer(PointsPlayerManager parent, Player bukkitPlayer) {
        super(parent, bukkitPlayer.getUniqueId());
        this.bukkitPlayer = bukkitPlayer;
        FileConfiguration configuration = parent.getParent().getConfig();
        for(int i = 0; i < parent.getParent().getCurrencyManager().getCurrencies().size(); i++){
            Currency currency = parent.getParent().getCurrencyManager().getCurrencies().get(i);
            try {
                int value = configuration.getInt("values." + getUniqueId().toString() + "." + currency.getId());
                currencyValues.put(currency, value);
            } catch (NullPointerException ignored) {

            }
        }
    }

    @Override
    public String getName(){
        return bukkitPlayer.getName();
    }

    @Override
    public void set(Currency currency, int value){
        if(currencyValues.containsKey(currency))
            currencyValues.remove(currency);
        currencyValues.put(currency, value);
    }

    @Override
    public int get(Currency currency){
        if(!currencyValues.containsKey(currency))
            currencyValues.put(currency, currency.getDefaultValue());
        return currencyValues.get(currency);
    }

    public void save(){
        Iterator<Map.Entry<Currency, Integer>> entries = currencyValues.entrySet().iterator();
        while(entries.hasNext()){
            Map.Entry<Currency, Integer> entry = entries.next();
            Currency currency = entry.getKey();
            int value = entry.getValue();
            parent.getParent().getConfig().set("values." + getUniqueId().toString() + "." + currency.getId(), value);
            parent.getParent().save();
        }
    }

    public Player getBukkitPlayer() {
        return bukkitPlayer;
    }

    public Map<Currency, Integer> getCurrencyValues() {
        return currencyValues;
    }
}
