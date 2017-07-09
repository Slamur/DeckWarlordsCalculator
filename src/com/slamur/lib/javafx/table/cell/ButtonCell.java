package com.slamur.lib.javafx.table.cell;

import javafx.scene.control.Button;
import javafx.scene.control.TableCell;

import java.util.function.Consumer;

public class ButtonCell<ValueType> extends TableCell<ValueType, ValueType> {
    private final Button cellButton;
    private final Consumer<ValueType> consumer;

    public ButtonCell(String text, Consumer<ValueType> consumer){
        super();

        this.cellButton = new Button(text);
        this.consumer = consumer;
    }

    //Display button if the row is not empty
    @Override
    protected void updateItem(ValueType value, boolean empty) {
        super.updateItem(value, empty);

        if(!empty){
            setGraphic(cellButton);
            if (value != null) {
                cellButton.setOnAction(event -> {
                    consumer.accept(value);
                    getTableView().refresh();
                });
            }
        }
    }
}
