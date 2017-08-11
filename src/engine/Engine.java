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
    private static boolean gameIsPaused;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        testStructure();

        gameIsPaused = false;

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

                case L: toggleTextLog(); break;

                case ESCAPE: toggleConfig();
            }
        });
    }

    private void toggleTextLog() {
        gameIsPaused = !gameIsPaused;
        VNTextLogPane textLogPane = VNEngineUI.getTextLogPane();
        textLogPane.setVisible(gameIsPaused);
        if(gameIsPaused)
            textLogPane.getContentPane().requestFocus();
    }

    private void toggleConfig() {
        gameIsPaused = !gameIsPaused;
        VNConfigPane configPane = VNEngineUI.getConfigPane();
        configPane.setVisible(!configPane.isVisible());
    }

    private void requestNovelAdvance() {
        if(!gameIsPaused) novel.advance();
    }

    public static void pauseExecution() {
        novel.pauseExecution();
    }
}
