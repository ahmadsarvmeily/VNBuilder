package main;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

import static main.Directories.testStructure;

public class Engine extends Application {

    private static Map<String,ImageView> spriteMap;
    private static Pane backgroundPane, spritePane, characterNamePane;
    private static StackPane textPane;
    private static Label textLabel, characterNameLabel;
    private static ImageView backgroundView;
    private static Novel novel;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        testStructure();

        spriteMap = new HashMap<>();

        StackPane rootPane = new StackPane();
        rootPane.setBackground(new Background(new BackgroundFill(Color.BLACK,CornerRadii.EMPTY,Insets.EMPTY)));

        setupBackgroundPane();
        setupSpritePane();
        setupTextPane();
        setupCharacterNamePane();
        rootPane.getChildren().add(backgroundPane);

        Scene gameScene = new Scene(rootPane, 1600,900);

        novel = new Novel(Directories.getNovelFile());

        primaryStage.setTitle(novel.getTitle());
        primaryStage.setScene(gameScene);
        primaryStage.setOnCloseRequest(e -> System.exit(0));
        primaryStage.show();

        gameScene.setOnMouseClicked(event -> novel.advance());

        gameScene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case DOWN: novel.advance(); break;

                case UP: //TODO: show text history
            }
        });
    }

    private void setupTextPane() {
        textLabel = new Label("Start game");
        textLabel.setFont(Font.font(32));
        textLabel.setWrapText(true);
        textLabel.setPadding(new Insets(10,0,40,40));
        textLabel.setTextFill(Color.WHITE);
        textPane = new StackPane(textLabel);
        textPane.setBackground(new Background(new BackgroundFill(Color.color(0,0,0,0.7), new CornerRadii(10), new Insets(0,0,0,0))));
        textPane.setLayoutY(750);
        textPane.setPrefSize(1600,150);
        textPane.setAlignment(Pos.TOP_LEFT);
        spritePane.getChildren().add(textPane);
    }

    private void setupCharacterNamePane() {
        characterNameLabel = new Label();
        characterNameLabel.setFont(Font.font("Arial", FontWeight.SEMI_BOLD,36));
        characterNameLabel.setPadding(new Insets(0,25,0,25));
        characterNameLabel.setTextFill(Color.WHITE);
        characterNamePane = new Pane(characterNameLabel);
        characterNamePane.setBackground(new Background(new BackgroundFill(Color.color(0,0,0,0.7), new CornerRadii(10), new Insets(0,0,0,0))));
        characterNamePane.setLayoutX(5);
        characterNamePane.setLayoutY(705);
        characterNamePane.setVisible(false);
        spritePane.getChildren().add(characterNamePane);
    }

    private void setupBackgroundPane() {
        backgroundView = new ImageView();
        backgroundView.setFitHeight(900);
        backgroundView.setFitWidth(1600);
        backgroundPane = new Pane(backgroundView);
    }

    private void setupSpritePane() {
        spritePane = new Pane();
        backgroundPane.getChildren().add(spritePane);
    }

    public static ImageView getBackgroundView() {
        return backgroundView;
    }

    public static Pane getSpritePane() {
        return spritePane;
    }

    public static Pane getCharacterNamePane() {
        return characterNamePane;
    }

    public static StackPane getTextPane() {
        return textPane;
    }

    public static ImageView getSprite(String spriteName) {
        return spriteMap.get(spriteName);
    }

    public static Map<String,ImageView> getSpriteMap() {
        return spriteMap;
    }

    public static Label getCharacterNameLabel() {
        return characterNameLabel;
    }

    public static Label getTextLabel() {
        return textLabel;
    }

    public static void pauseExecution() {
        novel.pauseExecution();
    }
}
