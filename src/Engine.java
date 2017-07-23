import audio.Music;
import audio.Sfx;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import test.EngineTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Engine extends Application {

    private static final String novelDir = "Novel";
    private static final String novelFile = novelDir + "/novel.vnb";
    private static final String assetsDir = novelDir + "/assets";
    private static final String bgDir = assetsDir + "/bg";
    private static final String modelsDir = assetsDir + "/models";
    private static final String musicDir = assetsDir + "/music";
    private static final String sfxDir = assetsDir + "/sfx";

    private StackPane textPane, backgroundPane;
    private Label text;
    private ImageView background;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        testStructure();

        BorderPane borderPane = new BorderPane();

        Novel novel = new Novel(novelFile);

        Scene gameScene = new Scene(borderPane, 1600,900);

        setupTextPane();
        setupBackgroundPane();
        borderPane.setBottom(textPane);
        borderPane.setCenter(backgroundPane);

        primaryStage.setTitle(novel.getTitle());
        primaryStage.setScene(gameScene);
        primaryStage.show();

        gameScene.setOnMouseClicked(e -> {
            boolean advance = false;
            while(novel.hasPhrases() && !advance) {
                String phrase = novel.nextPhrase();
                String[] phraseArr = phrase.split("\\|");
                String keyword = phraseArr[0];

                switch (keyword) {
                    case "music": Music.play(musicDir + "/" + phraseArr[1]);
                        continue;

                    case "sfx": Sfx.play(sfxDir + "/" + phraseArr[1]);
                        continue;

                    case "text": VNAnimator.animateText(text,"", phraseArr[1]);
                        advance = true;
                        break;
                    case "speech": VNAnimator.animateText(text, phraseArr[1], phraseArr[2]);
                        advance = true;
                        break;
                    case "bg": try {
                            background.setImage(new Image(new FileInputStream(bgDir + "/" + phraseArr[1])));
                        } catch (FileNotFoundException ex) {
                            ex.printStackTrace();
                        }
                        advance = true;
                }
            }
        });
    }

    private void setupTextPane() {
        text = new Label("Start game");
        text.setFont(Font.font(40));
        text.setPadding(new Insets(0,0,40,40));
        textPane = new StackPane(text);
        textPane.setAlignment(Pos.TOP_LEFT);
    }

    private void setupBackgroundPane() {
        background = new ImageView();
        background.setFitHeight(750);
        background.setFitWidth(1600);
        backgroundPane = new StackPane(background);
        backgroundPane.setAlignment(Pos.TOP_CENTER);
    }

    private void testStructure() {
        EngineTest.dirExists(novelDir);
        EngineTest.fileExists(novelFile);
        EngineTest.dirExists(assetsDir);
        EngineTest.dirExists(bgDir);
        EngineTest.dirExists(modelsDir);
        EngineTest.dirExists(musicDir);
        EngineTest.dirExists(sfxDir);
    }
}
