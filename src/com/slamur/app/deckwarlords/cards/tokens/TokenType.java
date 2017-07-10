package com.slamur.app.deckwarlords.cards.tokens;

public enum TokenType {

    NONE(""), ADDITIVE("+"), MULTIPLICATIVE("%");

    private String alias;

    TokenType(String alias) {
        this.alias = alias;
    }

    public String getAlias() {
        return alias;
    }
}
