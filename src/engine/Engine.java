package engine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Engine extends Application {

    private static final String novelDir = "Novel";
    private static final String storyFile = novelDir + "/story.vnb";
    private static final String assetsDir = novelDir + "/assets";
    private static final String bgDir = assetsDir + "/bg";
    private static final String modelsDir = assetsDir + "/models";
    private static final String musicDir = assetsDir + "/music";
    private static final String sfxDir = assetsDir + "/sfx";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        testStructure();

        BorderPane borderPane = new BorderPane();

        Scene gameScene = new Scene(borderPane, 1600,900);

        //TODO: Load title from story.vnb
        primaryStage.setTitle("Engine");
        primaryStage.setScene(gameScene);
        primaryStage.show();
    }

    private void testStructure() {
        EngineTest.dirExists(novelDir);
        EngineTest.fileExists(storyFile);
        EngineTest.dirExists(assetsDir);
        EngineTest.dirExists(bgDir);
        EngineTest.dirExists(modelsDir);
        EngineTest.dirExists(musicDir);
        EngineTest.dirExists(sfxDir);
    }
}
