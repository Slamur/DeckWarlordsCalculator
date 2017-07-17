package com.slamur.app.deckwarlords.cards.tokens;

import com.slamur.app.deckwarlords.cards.Attribute;
import com.slamur.app.deckwarlords.cards.CardInfoImpl;
import com.slamur.app.deckwarlords.cards.TokenInfo;

public class TokenImpl extends CardInfoImpl implements TokenInfo {

    private final Attribute attribute;
    private final TokenType type;

    private final int[] coefficients;

    private static String getTokenName(Attribute attribute, TokenType type) {
        return type.equals(TokenType.NONE)
                ? ""
                : attribute.getAlias() + type.getAlias();
    }

    TokenImpl(Attribute attribute, TokenType type, int... coefficients) {
        super(getTokenName(attribute, type));

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

    @Override
    public String toUserString(int stars) {
        if (!getName().isEmpty()) {
            return attribute.getAlias() + " " + coefficients[stars] + type.getAlias();
        } else {
            return getName();
        }
    }
}
