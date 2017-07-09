package com.slamur.app.deckwarlords.calculator;

import com.slamur.app.deckwarlords.cards.Attribute;
import com.slamur.app.deckwarlords.cards.Card;
import com.slamur.app.deckwarlords.cards.CardInfo;
import com.slamur.app.deckwarlords.cards.CreatureInfo;
import com.slamur.app.deckwarlords.cards.creatures.Creatures;
import com.slamur.app.deckwarlords.cards.stars.Creature;
import com.slamur.app.deckwarlords.cards.stars.Token;
import com.slamur.app.deckwarlords.cards.tokens.Tokens;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.cell.ComboBoxTableCell;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.IntStream;

public class TokensTableController implements Initializable {

    private static final int MAX_TOKENS = 6;

    @FXML
    private TableView<Creature> tokensTableView;

    @FXML
    private TableColumn<Creature, Integer> creatureIdColumn;

    @FXML
    private TableColumn<Creature, String> creatureNameColumn;

    @FXML
    private Button addCreatureButton;

    @FXML
    private Button removeCreatureButton;

    @FXML
    private ComboBox<CreatureInfo> creatureTypesComboBox;

    @FXML
    private ComboBox<Integer> creatureStarsComboBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTable();
        initTableColumns();
        initButtons();
    }

    private void initTable() {
        Dimension screenSize = InterfaceUtils.getScreenSize();

        tokensTableView.setPrefSize(
                screenSize.width - InterfaceUtils.WINDOW_WIDTH_DELTA,
                screenSize.height - InterfaceUtils.WINDOW_HEIGHT_DELTA - 150
        );

        ObservableList<Creature> creatures = FXCollections.observableArrayList();
        tokensTableView.setItems(creatures);

        tokensTableView.setEditable(true);
    }

    private void initTableColumns() {
        initIdColumn();
        initNameColumn();

        initAttributeColumns();
        initTokenColumns();
    }

    private void initIdColumn() {
        creatureIdColumn.setSortable(false);
        creatureIdColumn.setCellValueFactory(
                column -> new ReadOnlyObjectWrapper<>(
                        tokensTableView.getItems().indexOf(column.getValue())
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
    }

    private void initAttributeColumns() {
        for (Attribute attribute : Attribute.values()) {
            TableColumn<Creature, Integer> attributeColumn = new TableColumn<>(attribute.getAlias());

            attributeColumn.setCellValueFactory(
                    column -> new ReadOnlyObjectWrapper<>(
                            column.getValue().getAttributeValue(attribute)
                    )
            );

            tokensTableView.getColumns().add(attributeColumn);
        }
    }

    private void initTokenColumns() {
        ObservableList<Token> tokens = FXCollections.observableArrayList(
                Token.generateTokens()
        );

        for (int tokenIndex = 0; tokenIndex < MAX_TOKENS; ++tokenIndex) {
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
                tokensTableView.refresh();
            });

            tokenColumn.setEditable(true);
            tokenColumn.setPrefWidth(100);

            tokensTableView.getColumns().add(tokenColumn);
        }
    }

    private void initButtons() {
        ObservableList<Creature> creatures = tokensTableView.getItems();

        creatureTypesComboBox.setItems(
                FXCollections.observableArrayList(Creatures.CREATURES)
        );

        creatureTypesComboBox.getSelectionModel().selectFirst();

        creatureStarsComboBox.setItems(
                FXCollections.observableArrayList(
                        IntStream.range(0, CardInfo.DEFAULT_MAX_STARS).
                                mapToObj(Integer::valueOf).
                                toArray(Integer[]::new)
                )
        );

        creatureStarsComboBox.getSelectionModel().selectFirst();

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
                    int selectedIndex = tokensTableView.getSelectionModel().getSelectedIndex();
                    if (selectedIndex >= 0) {
                        creatures.remove(selectedIndex);
                    }
                }
        );
    }
}
