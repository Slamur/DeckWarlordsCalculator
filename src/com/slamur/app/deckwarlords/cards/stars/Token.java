package com.slamur.app.deckwarlords.cards.stars;

import com.slamur.app.deckwarlords.cards.Card;
import com.slamur.app.deckwarlords.cards.TokenInfo;
import com.slamur.app.deckwarlords.cards.tokens.Tokens;

import java.util.ArrayList;
import java.util.List;

public class Token extends CardImpl<TokenInfo> implements Card<TokenInfo>, Tokens {

    public static final Token NO_TOKEN = new Token(Tokens.NO_TOKEN, 0);

    public static List<Token> generateTokens() {
        List<Token> tokens = new ArrayList<>();
        for (TokenInfo tokenInfo : TOKENS) {
            for (int stars = 0; stars < tokenInfo.getMaxStars(); ++stars) {
                tokens.add(new Token(tokenInfo, stars));
            }
        }

        return tokens;
    }

    private Token(TokenInfo token, int stars) {
        super(token, stars);
    }

    int getAdditionalPart() {
        return getCard().getAdditionalPart(stars);
    }

    double getMultiplier() {
        return getCard().getMultiplier(stars);
    }
}
