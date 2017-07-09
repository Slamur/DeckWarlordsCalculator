package com.slamur.app.deckwarlords.calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class MainApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        initScene(primaryStage);

        primaryStage.show();
    }

    private void initScene(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(
                getClass().getResource("TokensCalculator.fxml")
        );

        primaryStage.setTitle("Deck Warlords calculator");

        Dimension screenSize = InterfaceUtils.getScreenSize();
        primaryStage.setScene(
                new Scene(root,
                        screenSize.width - InterfaceUtils.WINDOW_WIDTH_DELTA,
                        screenSize.height - InterfaceUtils.WINDOW_HEIGHT_DELTA
                )
        );
    }

    public static void main(String[] args) {
        launch(args);
    }
}