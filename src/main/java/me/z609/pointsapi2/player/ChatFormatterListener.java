package me.z609.pointsapi2.player;

import me.z609.chatformatter.ChatEvent;
import me.z609.pointsapi2.PointsAPI;
import me.z609.pointsapi2.currency.Currency;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/**
 * This code is by Z609, and is copyright (C) 2016 Z609. Don't share this
 * code with the public! Thanks!
 */
public class ChatFormatterListener implements Listener {

    private PointsAPI parent;

    public ChatFormatterListener(PointsAPI parent) {
        this.parent = parent;
    }

    @EventHandler
    public void onChat(ChatEvent event){
        PointsPlayer player = parent.getPointsPlayerManager().getPlayer(event.getPlayer());
        for(int i = 0; i < parent.getCurrencyManager().getCurrencies().size(); i++){
            Currency currency = parent.getCurrencyManager().getCurrencies().get(i);
            event.format("POINTSAPI." + currency.getId().toLowerCase(), String.valueOf(player.get(currency)));
        }
    }

    public PointsAPI getParent() {
        return parent;
    }
}
