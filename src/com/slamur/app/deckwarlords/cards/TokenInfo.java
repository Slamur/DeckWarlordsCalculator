package com.slamur.app.deckwarlords.cards;

public interface TokenInfo extends CardInfo {

    Attribute getAttribute();

    int getAdditionalPart(int stars);
    int getMultiplicativePart(int stars);

    default double getMultiplier(int stars) {
        return 1 + getMultiplicativePart(stars) / 100.0;
    }

    int getMaxStars();
}
