package engine.ui;

import animation.FadeAnimator;
import engine.Engine;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

class VNMainMenuPane extends StackPane {

    VNMainMenuPane() {
        Font buttonFont = Font.font("Arial Narrow", FontWeight.BOLD,36);
        Insets buttonInsets = new Insets(25);
        this.setPrefHeight(900);
        this.setPrefWidth(1600);
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        //gridPane.setGridLinesVisible(true);
        gridPane.setVgap(200);
        gridPane.setHgap(100);
        this.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        Button newGameButton = new Button("New game");
        newGameButton.setOnMouseClicked(event -> newGame());
        Button loadGameButton = new Button("Load game");
        Button settingsButton = new Button("Settings");
        newGameButton.setPadding(buttonInsets);
        loadGameButton.setPadding(buttonInsets);
        settingsButton.setPadding(buttonInsets);
        newGameButton.setFont(buttonFont);
        loadGameButton.setFont(buttonFont);
        settingsButton.setFont(buttonFont);
        loadGameButton.setDisable(true);
        settingsButton.setDisable(true);
        gridPane.add(newGameButton,0,0);
        gridPane.add(loadGameButton,1,0);
        gridPane.add(settingsButton,2,0);
        GridPane.setHalignment(newGameButton, HPos.CENTER);
        GridPane.setHalignment(loadGameButton, HPos.CENTER);
        GridPane.setHalignment(settingsButton, HPos.CENTER);
        this.getChildren().add(gridPane);
    }

    private void newGame() {
        FadeAnimator.getInstance().fadeOut(this);
        Engine.startGame();
    }
}
