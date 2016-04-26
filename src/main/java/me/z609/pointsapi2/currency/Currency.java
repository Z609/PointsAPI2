package me.z609.pointsapi2.currency;

/**
 * This code is by Z609, and is copyright (C) 2016 Z609. Don't share this
 * code with the public! Thanks!
 */
public class Currency {

    private CurrencyManager parent;
    private String id;
    private String nameSingular;
    private String namePlural;
    private int defaultValue = 0;

    public Currency(CurrencyManager parent, String id, String nameSingular, String namePlural, int defaultValue) {
        this.parent = parent;
        this.id = id;
        this.nameSingular = nameSingular;
        this.namePlural = namePlural;
        this.defaultValue = defaultValue;
    }

    public String getId() {
        return id;
    }

    public CurrencyManager getParent() {
        return parent;
    }

    public String getNameSingular() {
        return nameSingular;
    }

    public String getNamePlural() {
        return namePlural;
    }

    public int getDefaultValue() {
        return defaultValue;
    }

}
