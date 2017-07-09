package com.slamur.app.deckwarlords.calculator;

import com.slamur.app.deckwarlords.cards.Attribute;
import com.slamur.app.deckwarlords.cards.Card;
import com.slamur.app.deckwarlords.cards.CardInfo;
import com.slamur.app.deckwarlords.cards.CreatureInfo;
import com.slamur.app.deckwarlords.cards.counters.CardCounter;
import com.slamur.app.deckwarlords.cards.creatures.Creatures;
import com.slamur.app.deckwarlords.cards.stars.Creature;
import com.slamur.app.deckwarlords.cards.stars.Token;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.stream.IntStream;

public class TokensTableController implements Initializable {

    private static final int MAX_CREATURE_TOKENS = 6;

    @FXML
    private TableView<CardCounter> tokensTableView;

    @FXML
    private TableColumn<CardCounter, String> tokenNameColumn;

    @FXML
    private TableColumn<CardCounter, Integer> tokenCountColumn;

    @FXML
    private TableColumn<CardCounter, Button> tokenCountIncColumn;

    @FXML
    private TableColumn<CardCounter, Button> tokenCountDecColumn;

    @FXML
    private TableColumn<CardCounter, Button> tokenCountForgeColumn;

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
    }

    private void initTokensTableColumns() {
        initTokenNameColumn();
        initTokenCountColumn();
        initTokenControlColumns();
    }

    private void initTokenNameColumn() {
        tokenNameColumn.setCellValueFactory(
                new PropertyValueFactory<>("name")
        );
    }

    private void initTokenCountColumn() {
        tokenCountColumn.setCellValueFactory(
                new PropertyValueFactory<>("count")
        );
    }

    private void initTokenControlColumns() {
//        tokenCountIncColumn.setCellFactory(
//                column -> {
////                    new LisC
//                }
//        );
    }

    private void initCreaturesTable() {
//        Dimension screenSize = InterfaceUtils.getScreenSize();
//
//        tokensTableView.setPrefSize(
//                screenSize.width - InterfaceUtils.WINDOW_WIDTH_DELTA,
//                screenSize.height - InterfaceUtils.WINDOW_HEIGHT_DELTA - 150
//        );

        ObservableList<Creature> creatures = FXCollections.observableArrayList();
        creaturesTableView.setItems(creatures);

        creaturesTableView.setEditable(true);
    }

    private void initCreaturesTableColumns() {
        initIdColumn();
        initNameColumn();

        initAttributeColumns();
        initTokenColumns();
    }

    private void initIdColumn() {
        creatureIdColumn.setSortable(false);
        creatureIdColumn.setCellValueFactory(
                column -> new ReadOnlyObjectWrapper<>(
                        creaturesTableView.getItems().indexOf(column.getValue())
                )
        );
    }

    private void initNameColumn() {
        creatureNameColumn.setCellValueFactory(
                column -> {
                    Card creature = column.getValue();
                    return new ReadOnlyObjectWrapper<>(creature.toString());
                }
        );

        creatureNameColumn.setPrefWidth(150);
    }

    private void initAttributeColumns() {
        for (Attribute attribute : Attribute.values()) {
            TableColumn<Creature, Integer> attributeColumn = new TableColumn<>(attribute.getAlias());

            attributeColumn.setCellValueFactory(
                    column -> new ReadOnlyObjectWrapper<>(
                            column.getValue().getAttributeValue(attribute)
                    )
            );

            creaturesTableView.getColumns().add(attributeColumn);
        }
    }

    private void initTokenColumns() {
        ObservableList<Token> tokens = FXCollections.observableArrayList(
                Token.generateTokens()
        );

        for (int tokenIndex = 0; tokenIndex < MAX_CREATURE_TOKENS; ++tokenIndex) {
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

            tokenColumn.setCellFactory(
                    ComboBoxTableCell.forTableColumn(tokens)
            );

            tokenColumn.setCellValueFactory(
                    column -> new ReadOnlyObjectWrapper<>(
                            column.getValue().getToken(finalTokenIndex)
                    )
            );

            tokenColumn.setOnEditCommit(edit -> {
                edit.getRowValue().setToken(finalTokenIndex, edit.getNewValue());
                creaturesTableView.refresh();
            });

            tokenColumn.setEditable(true);
            tokenColumn.setPrefWidth(100);

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
                }
        );

        removeCreatureButton.setOnAction(
                event -> {
                    int selectedIndex = creaturesTableView.getSelectionModel().getSelectedIndex();
                    if (selectedIndex >= 0) {
                        creatures.remove(selectedIndex);
                    }
                }
        );
    }
}
