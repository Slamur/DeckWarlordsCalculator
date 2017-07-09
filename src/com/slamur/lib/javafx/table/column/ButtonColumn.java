package com.slamur.lib.javafx.table.column;

import javafx.scene.control.TableColumn;

public class ButtonColumn<ValueType> extends TableColumn<ValueType, ValueType> {

    public ButtonColumn() {

    }

    public ButtonColumn(String text) {
        super(text);
    }
}
