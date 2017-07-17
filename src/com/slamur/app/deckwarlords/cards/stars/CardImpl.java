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

    private String toStringWithStars(String base) {
        if (!base.isEmpty()) base += " (" + getStars() + "*)";
        return base;
    }

    @Override
    public String toString() {
        return toStringWithStars(getName());
    }

    @Override
    public String toUserString() {
        return toStringWithStars(card.toUserString(stars));
    }

    @Override
    public boolean isParent(Card<?> other) {
        String thisName = this.getCard().getName(),
                otherName = other.getCard().getName();

        return thisName.equals(otherName)
                && this.getStars() == other.getStars() + 1;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Card)) return false;

        Card other = (Card)obj;

        return this.toString().equals(other.toString());
    }
}
