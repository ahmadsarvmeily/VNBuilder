package engine;

import engine.ui.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import novel.Novel;

import static engine.Directories.testStructure;

public class Engine extends Application {

    private static Novel novel;
    private static boolean gameIsPaused, gameIsRunning, textAnimationEnabled, configMenuIsOpen, textLogIsOpen;
    private static float textAnimationSpeed = 0.03f;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        testStructure();

        gameIsPaused = false;
        gameIsRunning = false;
        textAnimationEnabled = true;
        configMenuIsOpen = false;
        textLogIsOpen = false;

        StackPane rootPane = new StackPane();
        VNEngineUI.setup(rootPane);
        Scene gameScene = new Scene(rootPane,1600,900);

        novel = new Novel(Directories.getNovelFile());

        primaryStage.setTitle(novel.getTitle());
        primaryStage.setScene(gameScene);
        primaryStage.setOnCloseRequest(e -> System.exit(0));
        primaryStage.show();

        gameScene.setOnMouseClicked(event -> requestNovelAdvance());

        gameScene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case DOWN: requestNovelAdvance(); break;

                case L: requestToggleTextLog(); break;

                case ESCAPE: toggleConfig();
            }
        });
    }

    private void requestToggleTextLog() {
        if(gameIsRunning && !configMenuIsOpen) {
            textLogIsOpen = !textLogIsOpen;
            VNTextLogPane textLogPane = VNEngineUI.getTextLogPane();
            textLogPane.setVisible(textLogIsOpen);
            gameIsPaused = textLogIsOpen;
            if (textLogIsOpen)
                textLogPane.getContentPane().requestFocus();
        }
    }

    private void toggleConfig() {
        if(gameIsRunning) {
            configMenuIsOpen = !configMenuIsOpen;
            VNEngineUI.getConfigPane().setVisible(configMenuIsOpen);
            gameIsPaused = configMenuIsOpen || textLogIsOpen;
        }
    }

    private static void requestNovelAdvance() {
        if(!gameIsPaused && gameIsRunning) novel.advance();
    }

    public static void startGame() {
        gameIsRunning = true;
        requestNovelAdvance();
    }

    public static void pauseExecution() {
        novel.pauseExecution();
    }

    public static void toggleTextAnimationEnabled() {
        textAnimationEnabled = !textAnimationEnabled;
    }

    public static boolean getTextAnimationEnabled() {
        return textAnimationEnabled;
    }

    public static void setTextAnimationSpeed(float speed) {
        textAnimationSpeed = speed;
    }

    public static float getTextAnimationSpeed() {
        return textAnimationSpeed;
    }
}
