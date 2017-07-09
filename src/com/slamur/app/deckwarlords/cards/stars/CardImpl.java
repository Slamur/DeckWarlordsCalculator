package com.slamur.app.deckwarlords.cards.stars;

import com.slamur.app.deckwarlords.cards.Card;
import com.slamur.app.deckwarlords.cards.CardInfo;

public abstract class CardImpl<CardType extends CardInfo> implements Card<CardType> {

    protected final CardType card;
    protected final int stars;

    protected CardImpl(CardType card, int stars) {
        this.card = card;
        this.stars = stars;
    }

    @Override
    public CardType getCard() {
        return card;
    }

    @Override
    public int getStars() {
        return stars;
    }

    @Override
    public String getName() {
        return card.getName();
    }

    @Override
    public String toString() {
        return getName() + " (" + getStars() + "*)";
    }
}
