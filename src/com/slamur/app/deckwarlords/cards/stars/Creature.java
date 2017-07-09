package com.slamur.app.deckwarlords.cards.stars;

import java.util.*;
import com.slamur.app.deckwarlords.cards.*;

public class Creature extends CardImpl<CreatureInfo> implements Card<CreatureInfo> {

    private Map<Attribute, Integer> attributeMap;
    private List<Token> tokens;

    public Creature(CreatureInfo creature, int stars) {
        super(creature, stars);

        this.attributeMap = new HashMap<>();

        this.tokens = new ArrayList<>();
        for (int index = 0; index < getMaxTokens(); ++index) {
            tokens.add(null);
        }

        updateAttributes();
    }

    public int getMaxTokens() {
        return card.getMaxTokens(stars);
    }

    public int getAttributeValue(Attribute attribute) {
        return attributeMap.get(attribute);
    }

    private void updateAttributes() {
        for (Attribute attribute : Attribute.values()) {
            attributeMap.put(
                    attribute, card.getAttributeValue(attribute, stars)
            );
        }

        for (Token token : tokens) {
            if (null == token) continue;

            Attribute tokenAttribute = token.getCard().getAttribute();

            int oldAttributeValue = attributeMap.get(tokenAttribute);

            int nextAttributeValue = oldAttributeValue + token.getAdditionalPart();
            nextAttributeValue *= token.getMultiplier();

            attributeMap.put(tokenAttribute, nextAttributeValue);
        }
    }

    public Token getToken(int index) {
        return (index < tokens.size() ? tokens.get(index) : null);
    }

    public void setToken(int index, Token token) {
        if (index < tokens.size()) {
            tokens.set(index, token);
            updateAttributes();
        }
    }
}
