package com.slamur.app.deckwarlords.cards.creatures;

import com.slamur.app.deckwarlords.cards.Attribute;
import com.slamur.app.deckwarlords.cards.CreatureInfo;

public interface  Creatures {

    String[] RARITIES = {
        "Common", "Uncommon", "Rare",
        "Epic", "Legendary", "Mystic"
    };

    ///////////////// Common //////////////////////////////////////

    ///////////////// Uncommon //////////////////////////////////////

    ///////////////// Rare //////////////////////////////////////

    ///////////////// Epic //////////////////////////////////////

    ///////////////// Legendary //////////////////////////////////////

    CreatureInfo NECROMANCER = new CreatureImpl("Necro", 4, 5, 5, 6)
            .setAttributeValues(Attribute.DAMAGE, 7, 8, 9, 10)
            .setAttributeValues(Attribute.HEALTH, 40, 46, 52, 58)
            .setAttributeValue(Attribute.INITIATIVE, 35);

    CreatureInfo DEATHBRINGER = new CreatureImpl("Death", 4, 4, 5, 5)
            .setAttributeValues(Attribute.DAMAGE, 25, 25, 30, 30)
            .setAttributeValues(Attribute.HEALTH, 32, 36, 40, 44)
            .setAttributeValue(Attribute.INITIATIVE, 25)
            .setAttributeValues(Attribute.ARMOR, 2, 3, 3, 4);

    ///////////////// Mystic //////////////////////////////////////

    CreatureInfo[][] CREATURES = {
            // common
            {},
            // uncommon
            {},
            // rare
            {},
            // epic
            {},
            // legendary
            { NECROMANCER, DEATHBRINGER },
            // mystic
            {}
    };
}
