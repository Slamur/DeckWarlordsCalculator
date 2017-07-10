package com.slamur.app.deckwarlords.calculator.tokens;

import com.slamur.app.deckwarlords.cards.counters.CardCounter;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.StringTokenizer;

class FileTokenInfoService {

    private static final String TOKENS_FILE_NAME = "Free tokens",
            CREATURES_FILE_NAME = "Creatures with tokens";

    private interface Tsv {
        String EXTENSION = "tsv", DELIMITER = "\t";
    }

    private static File getExistingFile(String fileName) {
        File file = null;

        try {
            file = new File(fileName);
            if (!file.exists()) file.createNewFile();
        } catch (IOException e) {
            System.err.println("File " + fileName + " can't be created:");
            e.printStackTrace();
        }

        return file;
    }

    private static File getExistingFile(String fileName, String extension) {
        return getExistingFile(fileName + "." + extension);
    }

    static void saveTokenCounters(ObservableList<CardCounter> tokenCounters) {
        File tokensFile = getExistingFile(TOKENS_FILE_NAME, Tsv.EXTENSION);

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
        File tokensFile = getExistingFile(TOKENS_FILE_NAME, Tsv.EXTENSION);

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
}
