package com.slamur.app.deckwarlords.cards;

public interface Card <CardType extends CardInfo> {

    CardType getCard();

    String getName();
    int getStars();

    boolean isParent(Card<?> other);
}
