package com.slamur.app.deckwarlords.cards.tokens;

import com.slamur.app.deckwarlords.cards.Attribute;
import com.slamur.app.deckwarlords.cards.CardInfoImpl;
import com.slamur.app.deckwarlords.cards.TokenInfo;

public class TokenImpl extends CardInfoImpl implements TokenInfo {

    private final Attribute attribute;
    private final TokenType type;

    private final int[] coefficients;

    TokenImpl(Attribute attribute, TokenType type, int... coefficients) {
        super(attribute.getAlias() + type.getAlias());

        this.attribute = attribute;
        this.type = type;

        this.coefficients = coefficients;
    }

    @Override
    public Attribute getAttribute() {
        return attribute;
    }

    private int getPart(TokenType partType, int stars) {
        if (type.equals(partType)) return coefficients[stars];
        return 0;
    }

    @Override
    public int getAdditionalPart(int stars) {
        return getPart(TokenType.ADDITIVE, stars);
    }

    @Override
    public int getMultiplicativePart(int stars) {
        return getPart(TokenType.MULTIPLICATIVE, stars);
    }

    @Override
    public int getMaxStars() {
        return coefficients.length;
    }
}
