package com.slamur.app.deckwarlords.calculator.tokens;

import com.slamur.app.deckwarlords.cards.CreatureInfo;
import com.slamur.app.deckwarlords.cards.counters.CardCounter;
import com.slamur.app.deckwarlords.cards.creatures.Creatures;
import com.slamur.app.deckwarlords.cards.stars.Creature;
import com.slamur.app.deckwarlords.cards.stars.Token;
import com.slamur.lib.file.FileUtils;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

class FileTokenInfoService {

    private static final String TOKENS_FILE_NAME = "Free tokens",
            CREATURES_FILE_NAME = "Creatures with tokens";

    private interface Tsv {
        String EXTENSION = "tsv", DELIMITER = "\t";
    }

    static void saveTokenCounters(ObservableList<CardCounter> tokenCounters) {
        File tokensFile = FileUtils.getExistingFile(TOKENS_FILE_NAME, Tsv.EXTENSION);

        try (PrintWriter out = new PrintWriter(tokensFile)) {
            for (CardCounter tokenCounter : tokenCounters) {
                out.print(tokenCounter.getCard().toString());
                out.print(Tsv.DELIMITER + tokenCounter.getCount());

                out.println();
            }
        } catch (IOException e) {
            System.err.println("Problem with token counters saving:");
            e.printStackTrace();
        }
    }

    static void updateTokenCounters(ObservableList<CardCounter> tokenCounters) {
        File tokensFile = FileUtils.getExistingFile(TOKENS_FILE_NAME, Tsv.EXTENSION);

        try (BufferedReader in = new BufferedReader(new FileReader(tokensFile))) {
            for (String line; (line = in.readLine()) != null; ){
                StringTokenizer tok = new StringTokenizer(line, Tsv.DELIMITER);

                String fullName = tok.nextToken();
                int count = Integer.parseInt(tok.nextToken());

                tokenCounters.filtered(
                        counter -> counter.getCard().toString().equals(fullName)
                ).forEach(counter -> counter.setCount(count));
            }
        } catch (IOException e) {
            System.err.println("Problem with token counters reading:");
            e.printStackTrace();
        }
    }

    static void saveCreatures(ObservableList<Creature> creatures) {
        File creaturesFile = FileUtils.getExistingFile(CREATURES_FILE_NAME, Tsv.EXTENSION);

        try (PrintWriter out = new PrintWriter(creaturesFile)) {
            for (Creature creature : creatures) {
                out.print(creature.getName());
                out.print(Tsv.DELIMITER + creature.getStars());

                for (int tokenIndex = 0; tokenIndex < creature.getMaxTokens(); ++tokenIndex) {
                    Token token = creature.getToken(tokenIndex);

                    out.print(Tsv.DELIMITER);
                    if (null != token) {
                         out.print(token.toString());
                    }
                }

                out.println();
            }
        } catch (IOException e) {
            System.err.println("Problem with creatures saving:");
            e.printStackTrace();
        }
    }

    static List<Creature> loadCreatures() {
        File creaturesFile = FileUtils.getExistingFile(CREATURES_FILE_NAME, Tsv.EXTENSION);

        List<Creature> creatures = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(creaturesFile))) {
            List<Token> tokens = Token.generateTokens();

            for (String line; (line = in.readLine()) != null; ){
                StringTokenizer tok = new StringTokenizer(line, Tsv.DELIMITER);

                String name = tok.nextToken();
                int stars = Integer.parseInt(tok.nextToken());

                Creature creature = null;

                for (CreatureInfo[] creaturesArray : Creatures.CREATURES) {
                    for (CreatureInfo creatureInfo : creaturesArray) {
                        if (creatureInfo.getName().equals(name)) {
                            creature = new Creature(creatureInfo, stars);
                        }
                    }
                }

                if (creature == null) continue;

                for (int tokenIndex = 0; tokenIndex < creature.getMaxTokens(); ++tokenIndex) {
                    try {
                        String tokenName = tok.nextToken();
                        if (tokenName.isEmpty()) continue;

                        Token selectedToken = tokens.stream()
                                .filter(token -> token.toString().equals(tokenName))
                                .findFirst().get();

                        creature.setToken(tokenIndex, selectedToken);
                    } catch (NoSuchElementException ignored) {
                    }
                }

                creatures.add(creature);
            }
        } catch (IOException e) {
            System.err.println("Problem with creatures reading:");
            e.printStackTrace();
        }

        return creatures;
    }
}
