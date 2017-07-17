package com.slamur.app.deckwarlords.cards;

public abstract class CardInfoImpl implements CardInfo {

    private final String name;

    protected CardInfoImpl(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public String toUserString(int stars) {
        return toString();
    }
}
