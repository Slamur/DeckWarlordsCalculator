package com.slamur.app.deckwarlords.cards;

import java.util.Arrays;

public interface CreatureInfo extends CardInfo {

    int getMaxTokens(int stars);

    int getAttributeValue(Attribute attribute, int stars);

    CreatureInfo setAttributeValues(Attribute attribute, int... values);
    default CreatureInfo setAttributeValue(Attribute attribute, int value) {
        int[] values = new int[getMaxStars() + 1];
        Arrays.fill(values, value);

        return setAttributeValues(attribute, values);
    }

    @Override
    default int getMaxStars() {
        return 3;
    }
}
