package com.slamur.app.deckwarlords.cards.counters;

import com.slamur.app.deckwarlords.cards.Card;

public class CardCounter {

    private Card<?> card;
    private int count;

    public CardCounter(Card card) {
        this(card, 0);
    }

    public CardCounter(Card card, int count) {
        this.card = card;
        this.count = count;
    }

    public Card<?> getCard() {
        return card;
    }

    public int getCount() {
        return count;
    }

    public int update(int delta) {
        this.count += delta;
        return getCount();
    }

    public int inc() {
        return update(1);
    }

    public int dec() {
        return update(-1);
    }
}
