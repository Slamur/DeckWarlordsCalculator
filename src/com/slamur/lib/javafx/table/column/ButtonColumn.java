package com.slamur.lib.javafx.table.column;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.scene.control.TableColumn;

public class ButtonColumn<ValueType> extends TableColumn<ValueType, ValueType> {

    public ButtonColumn() {
        init();
    }

    public ButtonColumn(String text) {
        super(text);
        init();
    }

    private void init() {
        setCellValueFactory(
                column -> new ReadOnlyObjectWrapper<>(column.getValue())
        );
    }
}
