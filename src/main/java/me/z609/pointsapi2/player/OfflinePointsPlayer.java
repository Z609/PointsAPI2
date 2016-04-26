package me.z609.pointsapi2.player;

import me.z609.pointsapi2.currency.Currency;
import org.bukkit.Bukkit;

import java.util.UUID;

/**
 * This code is by Z609, and is copyright (C) 2016 Z609. Don't share this
 * code with the public! Thanks!
 */
public class OfflinePointsPlayer {

    protected PointsPlayerManager parent;
    protected UUID uniqueId;

    public OfflinePointsPlayer(PointsPlayerManager parent, UUID uniqueId) {
        this.parent = parent;
        this.uniqueId = uniqueId;
    }

    public String getName(){
        return Bukkit.getOfflinePlayer(uniqueId).getName();
    }

    public void set(Currency currency, int value){
        parent.getParent().getConfig().set("values." + getUniqueId().toString() + "." + currency.getId(), value);
        parent.getParent().save();
    }

    public int get(Currency currency){
        return parent.getParent().getConfig().getInt("values." + getUniqueId().toString() + "." + currency.getId());
    }

    public UUID getUniqueId() {
        return uniqueId;
    }

    public PointsPlayerManager getParent() {
        return parent;
    }
}
