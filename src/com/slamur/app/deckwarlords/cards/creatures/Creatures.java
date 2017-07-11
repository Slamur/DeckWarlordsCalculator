package com.slamur.app.deckwarlords.cards.creatures;

import com.slamur.app.deckwarlords.cards.Attribute;
import com.slamur.app.deckwarlords.cards.CreatureInfo;

public interface  Creatures {

    String[] RARITIES = {
        "Common", "Uncommon", "Rare",
        "Epic", "Legendary", "Mythical"
    };

    ///////////////// Common //////////////////////////////////////

    CreatureInfo GARGOYLE = new CreatureImpl("Gargoyle", 1, 1, 2, 2)
            .setAttributeValues(Attribute.DAMAGE, 5, 5, 8, 8)
            .setAttributeValues(Attribute.HEALTH, 14, 16, 20, 25)
            .setAttributeValue(Attribute.INITIATIVE, 15);

    CreatureInfo GOBLIN = new CreatureImpl("Goblin", 1, 1, 1, 2)
            .setAttributeValues(Attribute.DAMAGE, 2, 3, 4, 5)
            .setAttributeValues(Attribute.HEALTH, 12, 12, 16, 16)
            .setAttributeValue(Attribute.INITIATIVE, 35);

    CreatureInfo RAT = new CreatureImpl("Rat", 1, 1, 1, 1)
            .setAttributeValues(Attribute.DAMAGE, 3, 3, 4, 4)
            .setAttributeValues(Attribute.HEALTH, 8, 10, 12, 14)
            .setAttributeValue(Attribute.INITIATIVE, 30)
            .setAttributeValues(Attribute.ARMOR, 0, 0, 0, 1);

    CreatureInfo SPIDER = new CreatureImpl("Spider", 1, 1, 1, 2)
            .setAttributeValues(Attribute.DAMAGE, 2, 2, 3, 3)
            .setAttributeValues(Attribute.HEALTH, 14, 16, 18, 20)
            .setAttributeValue(Attribute.INITIATIVE, 35);

    CreatureInfo WARRIOR = new CreatureImpl("Warrior", 1, 1, 1, 2)
            .setAttributeValues(Attribute.DAMAGE, 4, 4, 6, 7)
            .setAttributeValues(Attribute.HEALTH, 12, 15, 17, 20)
            .setAttributeValue(Attribute.INITIATIVE, 25)
            .setAttributeValues(Attribute.ARMOR, 1, 2, 2, 3);

    CreatureInfo WORM = new CreatureImpl("Worm", 1, 1, 1, 2)
            .setAttributeValues(Attribute.DAMAGE, 2, 3, 3, 4)
            .setAttributeValues(Attribute.HEALTH, 10, 10, 15, 15)
            .setAttributeValue(Attribute.INITIATIVE, 30);

    ///////////////// Uncommon //////////////////////////////////////

    CreatureInfo COUGAR = new CreatureImpl("Cougar", 2, 2, 2, 3)
            .setAttributeValues(Attribute.DAMAGE, 8, 10, 12, 14)
            .setAttributeValues(Attribute.HEALTH, 15, 15, 22, 22)
            .setAttributeValue(Attribute.INITIATIVE, 45)
            .setAttributeValues(Attribute.ARMOR, 0, 0, 1, 1);

    CreatureInfo GREMLIN = new CreatureImpl("Gremlin", 1, 2, 2, 3)
            .setAttributeValue(Attribute.DAMAGE, 3)
            .setAttributeValues(Attribute.HEALTH, 20, 20, 24, 24)
            .setAttributeValue(Attribute.INITIATIVE, 15)
            .setAttributeValues(Attribute.ARMOR, 2, 3, 3, 4);

    CreatureInfo LIZARD = new CreatureImpl("Lizard", 1, 2, 2, 3)
            .setAttributeValues(Attribute.DAMAGE, 4, 4, 5, 5)
            .setAttributeValues(Attribute.HEALTH, 14, 14, 18, 18)
            .setAttributeValue(Attribute.INITIATIVE, 15)
            .setAttributeValues(Attribute.ARMOR, 0, 1, 1, 1);

    CreatureInfo ROGUE = new CreatureImpl("Rogue", 2, 2, 3, 3)
            .setAttributeValues(Attribute.DAMAGE, 4, 5, 6, 7)
            .setAttributeValues(Attribute.HEALTH, 14, 16, 18, 20)
            .setAttributeValue(Attribute.INITIATIVE, 50);

    CreatureInfo SKELETON = new CreatureImpl("Skeleton", 1, 2, 2, 3)
            .setAttributeValues(Attribute.DAMAGE, 6, 7, 8, 9)
            .setAttributeValues(Attribute.HEALTH, 16, 20, 24, 28)
            .setAttributeValue(Attribute.INITIATIVE, 30)
            .setAttributeValues(Attribute.ARMOR, 1, 1, 2, 3);

    CreatureInfo WISP = new CreatureImpl("Wisp", 3, 3, 3, 3)
            .setAttributeValues(Attribute.DAMAGE, 2, 3, 4, 5)
            .setAttributeValues(Attribute.HEALTH, 10, 14, 18, 22)
            .setAttributeValue(Attribute.INITIATIVE, 25);

    ///////////////// Rare //////////////////////////////////////

    CreatureInfo BLACKSMITH = new CreatureImpl("Blacksmith", 3, 3, 3, 3)
            .setAttributeValues(Attribute.DAMAGE, 7, 7, 9, 9)
            .setAttributeValues(Attribute.HEALTH, 15, 20, 20, 25)
            .setAttributeValue(Attribute.INITIATIVE, 20)
            .setAttributeValue(Attribute.ARMOR, 1);

    CreatureInfo CYCLOPS = new CreatureImpl("Cyclops", 2, 3, 3, 4)
            .setAttributeValues(Attribute.DAMAGE, 12, 12, 18, 18)
            .setAttributeValues(Attribute.HEALTH, 15, 20, 25, 30)
            .setAttributeValue(Attribute.INITIATIVE, 15)
            .setAttributeValue(Attribute.ARMOR, 2);

    CreatureInfo ENT = new CreatureImpl("Ent", 3, 3, 3, 3)
            .setAttributeValue(Attribute.DAMAGE, 3)
            .setAttributeValues(Attribute.HEALTH, 30, 35, 40, 45)
            .setAttributeValue(Attribute.INITIATIVE, 10);

    CreatureInfo HELLHOUND = new CreatureImpl("Hellhound", 3, 3, 3, 4)
            .setAttributeValues(Attribute.DAMAGE, 3, 3, 4, 4)
            .setAttributeValues(Attribute.HEALTH, 14, 16, 16, 18)
            .setAttributeValue(Attribute.INITIATIVE, 40);

    CreatureInfo KNIGHT = new CreatureImpl("Knight", 2, 3, 3, 3)
            .setAttributeValues(Attribute.DAMAGE, 8, 10, 12, 14)
            .setAttributeValues(Attribute.HEALTH, 24, 28, 32, 36)
            .setAttributeValue(Attribute.INITIATIVE, 30)
            .setAttributeValues(Attribute.ARMOR, 2, 2, 3, 3);

    CreatureInfo PHOENIX = new CreatureImpl("Phoenix", 3, 3, 4, 4)
            .setAttributeValues(Attribute.DAMAGE, 5, 6, 7, 8)
            .setAttributeValues(Attribute.HEALTH, 15, 17, 19, 21)
            .setAttributeValue(Attribute.INITIATIVE, 35);

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

    CreatureInfo GIANT = new CreatureImpl("Giant", 5, 6, 6, 6)
            .setAttributeValues(Attribute.DAMAGE, 5, 5, 7, 7)
            .setAttributeValues(Attribute.HEALTH, 180, 210, 210, 240)
            .setAttributeValue(Attribute.INITIATIVE, 15)
            .setAttributeValues(Attribute.ARMOR, 4, 4, 5, 5);

    CreatureInfo MYSTIC = new CreatureImpl("Mystic", 6, 6, 6, 6)
            .setAttributeValues(Attribute.DAMAGE, 30, 35, 35, 40)
            .setAttributeValues(Attribute.HEALTH, 29, 32, 32, 36)
            .setAttributeValue(Attribute.INITIATIVE, 25)
            .setAttributeValues(Attribute.ARMOR, 7, 8, 9, 10);

    CreatureInfo FLAMING_DEATH = new CreatureImpl("Flaming Death", 5, 6, 6, 6)
            .setAttributeValues(Attribute.DAMAGE, 14, 14, 17, 17)
            .setAttributeValues(Attribute.HEALTH, 30, 34, 38, 42)
            .setAttributeValue(Attribute.INITIATIVE, 45);

    /////////////////////////////////////////////////////////////////

    CreatureInfo[][] CREATURES = {
            // common
            { RAT, WARRIOR, WORM, GARGOYLE, GOBLIN, SPIDER },
            // uncommon
            { COUGAR, GREMLIN, LIZARD, ROGUE, SKELETON, WISP },
            // rare
            { KNIGHT, PHOENIX, BLACKSMITH, HELLHOUND, CYCLOPS, ENT },
            // epic
            { ANGEL, WITCH_DOCTOR, SKELETON_KING, MINOTAUR, BLOOD_KNIGHT, DRAKE, WEREWOLF },
            // legendary
            { NECROMANCER, DEATHBRINGER, WIZARD, GOLEM, URUK, VAMPIRE, OGRE, WHITE_WALKER },
            // mythical
            { GIANT, MYSTIC, FLAMING_DEATH }
    };
}
