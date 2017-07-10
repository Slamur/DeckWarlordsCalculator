package com.slamur.app.deckwarlords.cards.tokens;

import com.slamur.app.deckwarlords.cards.Attribute;
import com.slamur.app.deckwarlords.cards.TokenInfo;

public interface Tokens {

    TokenInfo HEALTH_PLUS = new TokenImpl(Attribute.HEALTH, TokenType.ADDITIVE, 4, 6, 8, 10);
    TokenInfo HEALTH_MULT = new TokenImpl(Attribute.HEALTH, TokenType.MULTIPLICATIVE, 10, 15, 20, 25);

    TokenInfo DAMAGE_PLUS = new TokenImpl(Attribute.DAMAGE, TokenType.ADDITIVE, 1, 2, 3, 4);
    TokenInfo DAMAGE_MULT = new TokenImpl(Attribute.DAMAGE, TokenType.MULTIPLICATIVE, 7, 13, 20, 25);

    TokenInfo INITIATIVE_PLUS = new TokenImpl(Attribute.INITIATIVE, TokenType.ADDITIVE, 7, 10, 12, 15);
    TokenInfo INITIATIVE_MULT = new TokenImpl(Attribute.INITIATIVE, TokenType.MULTIPLICATIVE, 20, 30, 40, 50);

    TokenInfo ARMOR_PLUS = new TokenImpl(Attribute.ARMOR, TokenType.ADDITIVE, 1, 2);
    TokenInfo THORNS_PLUS = new TokenImpl(Attribute.THORNS, TokenType.ADDITIVE, 1, 2, 3);

    TokenInfo NO_TOKEN = new TokenImpl(Attribute.INITIATIVE, TokenType.NONE, 0);

    TokenInfo[] TOKENS = {
            HEALTH_PLUS, HEALTH_MULT,
            DAMAGE_PLUS, DAMAGE_MULT,
            INITIATIVE_PLUS, INITIATIVE_MULT,
            ARMOR_PLUS, THORNS_PLUS
    };
}
