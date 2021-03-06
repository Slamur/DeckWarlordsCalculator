 package com.slamur.app.deckwarlords.calculator.tokens;

import com.slamur.app.deckwarlords.cards.Attribute;
import com.slamur.app.deckwarlords.cards.Card;
import com.slamur.app.deckwarlords.cards.CardInfo;
import com.slamur.app.deckwarlords.cards.CreatureInfo;
import com.slamur.app.deckwarlords.cards.counters.CardCounter;
import com.slamur.app.deckwarlords.cards.creatures.Creatures;
import com.slamur.app.deckwarlords.cards.stars.Creature;
import com.slamur.app.deckwarlords.cards.stars.Token;

import com.slamur.lib.javafx.InterfaceUtils;
import com.slamur.lib.javafx.table.cell.*;
import com.slamur.lib.javafx.table.column.ButtonColumn;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.fxml.*;
import javafx.collections.*;
import javafx.scene.control.*;
import javafx.util.*;

import java.net.URL;
import java.util.*;
import java.util.function.Function;
import java.util.stream.IntStream;

public class TokensTableController implements Initializable {

    private static final int PREF_NUMBER_WIDTH = 45,
            PREF_BUTTON_WIDTH = 65,
            PREF_CREATURE_NAME_WIDTH = 110,
            PREF_TOKEN_NAME_WIDTH = 76;

    @FXML
    private TableView<CardCounter> tokensTableView;

    @FXML
    private TableColumn<CardCounter, String> tokenNameColumn;

    @FXML
    private TableColumn<CardCounter, Integer> tokenCountColumn;

    @FXML
    private ButtonColumn<CardCounter> tokenCountIncColumn;

    @FXML
    private ButtonColumn<CardCounter> tokenCountDecColumn;

    @FXML
    private ButtonColumn<CardCounter> tokenCountForgeColumn;

    @FXML
    private TableView<Creature> creaturesTableView;

    @FXML
    private TableColumn<Creature, Integer> creatureIdColumn;

    @FXML
    private TableColumn<Creature, String> creatureNameColumn;

    @FXML
    private ComboBox<Integer> creatureRarityComboBox;

    @FXML
    private ComboBox<CreatureInfo> creatureTypesComboBox;

    @FXML
    private ComboBox<Integer> creatureStarsComboBox;

    @FXML
    private Button addCreatureButton;

    @FXML
    private Button removeCreatureButton;

    private void initTablePrefWidth(TableView<?> table) {
        int prefTableWidth = 0;
        for (TableColumn<?, ?> column : table.getColumns()) {
            prefTableWidth += column.getPrefWidth();
        }

        table.setPrefWidth(prefTableWidth);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTokensTable();
        initTokensTableColumns();

        initCreaturesTable();
        initCreaturesTableColumns();
        initCreaturesControls();
    }

    private void initTokensTable() {
        ObservableList<CardCounter> tokenCounters = FXCollections.observableArrayList(
                Token.generateTokens().stream()
                .map(CardCounter::new)
                .toArray(CardCounter[]::new)
        );

        tokensTableView.setItems(tokenCounters);
        tokensTableView.setPrefWidth(InterfaceUtils.getScreenSize().width / 4);
    }

    private void saveTokenCounters() {
        FileTokenInfoService.saveTokenCounters(
                tokensTableView.getItems()
        );
    }

    private void updateToken(Token token, int delta) {
        if (token != null) {
            tokensTableView.getItems().filtered(
                    tokenCounter -> tokenCounter.getCard().equals(token)
            ).forEach(tokenCounter -> tokenCounter.update(delta));

            tokensTableView.refresh();
            saveTokenCounters();
        }
    }

    private void initTokensTableColumns() {
        initTokenNameColumn();
        initTokenCountColumn();
        initTokenControlColumns();

        initTablePrefWidth(tokensTableView);

        FileTokenInfoService.updateTokenCounters(
                tokensTableView.getItems()
        );
    }

    private void initTokenNameColumn() {
        tokenNameColumn.setCellValueFactory(
                column -> new ReadOnlyObjectWrapper<>(column.getValue().getCard().toUserString())
        );

        tokenNameColumn.setPrefWidth(PREF_TOKEN_NAME_WIDTH);
    }

    private void initTokenCountColumn() {
        tokenCountColumn.setCellValueFactory(
                column -> new ReadOnlyObjectWrapper<>(column.getValue().getCount())
        );
    }

    private void initTokenControlColumns() {
        tokenCountIncColumn.setCellFactory(
                column -> new ButtonCell<>("+",
                        counter -> {
                            counter.inc();
                            saveTokenCounters();
                        }
                )
        );

        tokenCountDecColumn.setCellFactory(
                column -> new ButtonCell<>("-",
                        counter -> {
                            counter.dec();
                            saveTokenCounters();
                        }
                )
        );

        tokenCountForgeColumn.setCellFactory(
                column -> new ButtonCell<>("3 -> 1",
                        counter -> {
                            if (counter.getCard().getStars() == 0) return;

                            tokensTableView.getItems().filtered(
                                    other -> counter.getCard().isParent(other.getCard())
                                    )
                                    .forEach(other -> other.update(-3));

                            counter.inc();
                            saveTokenCounters();
                        }
                )
        );

        tokenCountIncColumn.setPrefWidth(PREF_NUMBER_WIDTH);
        tokenCountDecColumn.setPrefWidth(PREF_NUMBER_WIDTH);
        tokenCountForgeColumn.setPrefWidth(PREF_BUTTON_WIDTH);
    }

    private void saveCreatures() {
        FileTokenInfoService.saveCreatures(
                creaturesTableView.getItems()
        );
    }

    private void initCreaturesTable() {
        ObservableList<Creature> creatures = FXCollections.observableArrayList(
                FileTokenInfoService.loadCreatures()
        );

        creaturesTableView.setItems(creatures);
        creaturesTableView.setEditable(true);
    }

    private void initCreaturesTableColumns() {
        initCreatureIdColumn();
        initCreatureNameColumn();

        initCreatureAttributeColumns();
        initCreatureTokenColumns();

        initTablePrefWidth(creaturesTableView);
    }

    private void initCreatureIdColumn() {
        creatureIdColumn.setSortable(false);
        creatureIdColumn.setCellValueFactory(
                column -> new ReadOnlyObjectWrapper<>(
                        creaturesTableView.getItems().indexOf(column.getValue())
                )
        );

        creatureIdColumn.setPrefWidth(PREF_NUMBER_WIDTH);
    }

    private void initCreatureNameColumn() {
        creatureNameColumn.setCellValueFactory(
                column -> {
                    Card creature = column.getValue();
                    return new ReadOnlyObjectWrapper<>(creature.toString());
                }
        );

        creatureNameColumn.setPrefWidth(PREF_CREATURE_NAME_WIDTH);
    }

    private void initCreatureAttributeColumns() {
        for (Attribute attribute : Attribute.values()) {
            TableColumn<Creature, Integer> attributeColumn = new TableColumn<>(attribute.getAlias());

            attributeColumn.setCellValueFactory(
                    column -> new ReadOnlyObjectWrapper<>(
                            column.getValue().getAttributeValue(attribute)
                    )
            );

            attributeColumn.setPrefWidth(PREF_NUMBER_WIDTH);

            creaturesTableView.getColumns().add(attributeColumn);
        }
    }

    private void initCreatureTokenColumns() {
        ObservableList<Token> tokens = FXCollections.observableArrayList();

        tokens.add(Token.NO_TOKEN);
        tokens.addAll(Token.generateTokens());

        int maxCreatureTokens = 0;
        for (CreatureInfo[] creatureInfos : Creatures.CREATURES) {
            for (CreatureInfo creatureInfo : creatureInfos) {
                int creatureMaxStars = creatureInfo.getMaxStars();
                int creatureMaxTokens = creatureInfo.getMaxTokens(creatureMaxStars);

                maxCreatureTokens = Math.max(maxCreatureTokens, creatureMaxTokens);
            }
        }

        for (int tokenIndex = 0; tokenIndex < maxCreatureTokens; ++tokenIndex) {
            TableColumn<Creature, Token> tokenColumn = new TableColumn<>((tokenIndex + 1) + "");

            int finalTokenIndex = tokenIndex;
            tokenColumn.setCellValueFactory(
                    column -> {
                        Creature creature = column.getValue();
                        return new ReadOnlyObjectWrapper<>(
                                creature.getToken(finalTokenIndex)
                        );
                    }
            );

            Function<Creature, Boolean> activatingTokenCondition =
                    creature -> (finalTokenIndex < creature.getMaxTokens());

            StringConverter<Token> tokenStringConverter = new StringConverter<Token>() {
                @Override
                public String toString(Token token) {
                    return (token == null ? "" : token.toUserString());
                }

                @Override
                public Token fromString(String string) {
                    for (Token token : tokens) if (token.toUserString().equals(string)) return token;
                    return null;
                }
            };

            tokenColumn.setCellFactory(
                    column -> new ActivatingComboboxCell<Creature, Token>(
                            tokenStringConverter,
                            tokens,
                            activatingTokenCondition
                    )
            );

            tokenColumn.setCellValueFactory(
                    column -> new ReadOnlyObjectWrapper<>(
                            column.getValue().getToken(finalTokenIndex)
                    )
            );

            tokenColumn.setOnEditCommit(edit -> {
                Token oldToken = edit.getOldValue();
                updateToken(oldToken, 1);

                Token newToken = edit.getNewValue();
                updateToken(newToken, -1);

                edit.getRowValue().setToken(finalTokenIndex,
                        newToken.equals(Token.NO_TOKEN) ? null : newToken
                );

                saveCreatures();
                creaturesTableView.refresh();
            });

            tokenColumn.setEditable(true);
            tokenColumn.setPrefWidth(PREF_TOKEN_NAME_WIDTH);

            creaturesTableView.getColumns().add(tokenColumn);
        }
    }

    private void initCreaturesControls() {
        initComboboxes();
        initButtons();
    }

    private void initComboboxes() {
        ObservableList<CreatureInfo>[] creaturesByRarity = Arrays.stream(Creatures.CREATURES)
                .map(creatures -> {
                    Arrays.sort(creatures, (a, b) -> a.getName().compareTo(b.getName()));
                    return creatures;
                })
                .map(FXCollections::observableArrayList)
                .toArray(ObservableList[]::new);

        creatureRarityComboBox.setItems(
                FXCollections.observableArrayList(
                        IntStream.range(0, Creatures.RARITIES.length)
                        .mapToObj(Integer::valueOf)
                        .toArray(Integer[]::new)
                )
        );

        creatureRarityComboBox.setConverter(new StringConverter<Integer>() {
            @Override
            public String toString(Integer index) {
                return Creatures.RARITIES[index];
            }

            @Override
            public Integer fromString(String string) {
                for (int index = 0; index < Creatures.RARITIES.length; ++index) {
                    if (Creatures.RARITIES[index].equals(string)) return index;
                }

                return -1;
            }
        });

        creatureRarityComboBox.valueProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue.equals(oldValue)) return;

                    creatureTypesComboBox.setItems(creaturesByRarity[newValue]);
                    creatureTypesComboBox.getSelectionModel().selectFirst();
                }
        );

        creatureRarityComboBox.getSelectionModel().selectFirst();

        creatureTypesComboBox.getSelectionModel().selectFirst();

        creatureStarsComboBox.setItems(
                FXCollections.observableArrayList(
                        IntStream.range(0, CardInfo.DEFAULT_MAX_STARS).
                                mapToObj(Integer::valueOf).
                                toArray(Integer[]::new)
                )
        );

        creatureStarsComboBox.getSelectionModel().selectFirst();
    }

    private void initButtons() {
        ObservableList<Creature> creatures = creaturesTableView.getItems();

        addCreatureButton.setOnAction(
                event -> {
                    Creature creature = new Creature(
                            creatureTypesComboBox.getValue(),
                            creatureStarsComboBox.getValue()
                    );

                    creatures.add(creature);
                    saveCreatures();
                }
        );

        removeCreatureButton.setOnAction(
                event -> {
                    int selectedIndex = creaturesTableView.getSelectionModel().getSelectedIndex();
                    if (selectedIndex >= 0) {
                        Creature creature = creatures.remove(selectedIndex);
                        saveCreatures();

                        for (int tokenIndex = 0; tokenIndex < creature.getMaxTokens(); ++tokenIndex) {
                            updateToken(creature.getToken(tokenIndex), 1);
                        }
                    }
                }
        );
    }
}
