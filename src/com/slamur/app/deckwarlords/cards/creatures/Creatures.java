package com.slamur.app.deckwarlords.cards.creatures;

import com.slamur.app.deckwarlords.cards.Attribute;
import com.slamur.app.deckwarlords.cards.CreatureInfo;

public interface  Creatures {

    String[] RARITIES = {
        "Common", "Uncommon", "Rare",
        "Epic", "Legendary", "Mythical"
    };

    ///////////////// Common //////////////////////////////////////

    ///////////////// Uncommon //////////////////////////////////////

    ///////////////// Rare //////////////////////////////////////

    ///////////////// Epic //////////////////////////////////////

    CreatureInfo ANGEL = new CreatureImpl("Angel", 3, 3, 4, 4)
            .setAttributeValues(Attribute.DAMAGE, 2, 3, 4, 4)
            .setAttributeValues(Attribute.HEALTH, 38, 44, 50, 50)
            .setAttributeValue(Attribute.INITIATIVE, 35)
            .setAttributeValue(Attribute.ARMOR, 1);

    CreatureInfo WITCH_DOCTOR = new CreatureImpl("Witch Doctor", 4, 4, 5, 5)
            .setAttributeValues(Attribute.DAMAGE, 3, 4, 4, 4)
            .setAttributeValues(Attribute.HEALTH, 20, 20, 28, 28)
            .setAttributeValue(Attribute.INITIATIVE, 45);

    CreatureInfo SKELETON_KING = new CreatureImpl("Skeleton King", 3, 4, 5, 5)
            .setAttributeValues(Attribute.DAMAGE, 6, 8, 10, 12)
            .setAttributeValues(Attribute.HEALTH, 20, 24, 28, 34)
            .setAttributeValue(Attribute.INITIATIVE, 30)
            .setAttributeValues(Attribute.ARMOR, 2, 2, 3, 4);

    CreatureInfo WEREWOLF = new CreatureImpl("Werewolf", 3, 3, 4, 4)
            .setAttributeValues(Attribute.DAMAGE, 9, 10, 11, 12)
            .setAttributeValues(Attribute.HEALTH, 20, 24, 28, 32)
            .setAttributeValue(Attribute.INITIATIVE, 20)
            .setAttributeValue(Attribute.ARMOR, 2);

    CreatureInfo DRAKE = new CreatureImpl("Drake", 4, 4, 5, 5)
            .setAttributeValues(Attribute.DAMAGE, 3, 4, 5, 6)
            .setAttributeValues(Attribute.HEALTH, 26, 28, 30, 32)
            .setAttributeValue(Attribute.INITIATIVE, 25)
            .setAttributeValue(Attribute.ARMOR, 2);

    CreatureInfo MINOTAUR = new CreatureImpl("Minotaur", 3, 3, 4, 4)
            .setAttributeValues(Attribute.DAMAGE, 10, 13, 13, 15)
            .setAttributeValues(Attribute.HEALTH, 35, 35, 45, 45)
            .setAttributeValue(Attribute.INITIATIVE, 25)
            .setAttributeValues(Attribute.ARMOR, 2, 2, 3, 3);

    CreatureInfo BLOOD_KNIGHT = new CreatureImpl("Blood Knight", 3, 3, 4, 4)
            .setAttributeValues(Attribute.DAMAGE, 10, 12, 14, 16)
            .setAttributeValues(Attribute.HEALTH, 30, 35, 40, 45)
            .setAttributeValue(Attribute.INITIATIVE, 30)
            .setAttributeValues(Attribute.ARMOR, 3, 3, 4, 4);

    ///////////////// Legendary //////////////////////////////////////

    CreatureInfo NECROMANCER = new CreatureImpl("Necromancer", 4, 5, 5, 6)
            .setAttributeValues(Attribute.DAMAGE, 7, 8, 9, 10)
            .setAttributeValues(Attribute.HEALTH, 40, 46, 52, 58)
            .setAttributeValue(Attribute.INITIATIVE, 35);

    CreatureInfo DEATHBRINGER = new CreatureImpl("Deathbringer", 4, 4, 5, 5)
            .setAttributeValues(Attribute.DAMAGE, 25, 25, 30, 30)
            .setAttributeValues(Attribute.HEALTH, 32, 36, 40, 44)
            .setAttributeValue(Attribute.INITIATIVE, 25)
            .setAttributeValues(Attribute.ARMOR, 2, 3, 3, 4);

    CreatureInfo WIZARD = new CreatureImpl("Wizard", 5, 5, 6, 6)
            .setAttributeValues(Attribute.DAMAGE, 6, 6, 7, 8)
            .setAttributeValues(Attribute.HEALTH, 22, 26, 30, 34)
            .setAttributeValue(Attribute.INITIATIVE, 35)
            .setAttributeValue(Attribute.ARMOR, 1);

    CreatureInfo URUK = new CreatureImpl("Uruk", 4, 4, 5, 5)
            .setAttributeValues(Attribute.DAMAGE, 11, 13, 11, 13)
            .setAttributeValues(Attribute.HEALTH, 25, 30, 35, 40)
            .setAttributeValue(Attribute.INITIATIVE, 40)
            .setAttributeValue(Attribute.ARMOR, 2);

    CreatureInfo VAMPIRE = new CreatureImpl("Vampire", 4, 4, 5, 5)
            .setAttributeValues(Attribute.DAMAGE, 14, 18, 18, 22)
            .setAttributeValues(Attribute.HEALTH, 30, 30, 40, 40)
            .setAttributeValue(Attribute.INITIATIVE, 40)
            .setAttributeValue(Attribute.ARMOR, 1);

    CreatureInfo OGRE = new CreatureImpl("Ogre", 4, 4, 5, 5)
            .setAttributeValues(Attribute.DAMAGE, 8, 10, 10, 12)
            .setAttributeValues(Attribute.HEALTH, 60, 65, 75, 80)
            .setAttributeValue(Attribute.INITIATIVE, 15);

    CreatureInfo WHITE_WALKER = new CreatureImpl("White Walker", 3, 4, 4, 5)
            .setAttributeValues(Attribute.DAMAGE, 16, 16, 24, 24)
            .setAttributeValues(Attribute.HEALTH, 35, 40, 45, 50)
            .setAttributeValue(Attribute.INITIATIVE, 20)
            .setAttributeValues(Attribute.ARMOR, 8, 9, 9, 10);

    CreatureInfo GOLEM = new CreatureImpl("Golem", 3, 4, 5, 5)
            .setAttributeValue(Attribute.DAMAGE, 6)
            .setAttributeValues(Attribute.HEALTH, 80, 80, 100, 100)
            .setAttributeValue(Attribute.INITIATIVE, 10)
            .setAttributeValue(Attribute.ARMOR, 3);

    ///////////////// Mythical //////////////////////////////////////

    CreatureInfo[][] CREATURES = {
            // common
            {},
            // uncommon
            {},
            // rare
            {},
            // epic
            { ANGEL, WITCH_DOCTOR, SKELETON_KING, MINOTAUR, BLOOD_KNIGHT, DRAKE, WEREWOLF },
            // legendary
            { NECROMANCER, DEATHBRINGER, WIZARD, GOLEM, URUK, VAMPIRE, OGRE, WHITE_WALKER },
            // mythical
            {}
    };
}
