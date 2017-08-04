package phrases.animation.text;

import animation.TextAnimator;
import audio.SfxPlayer;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import engine.Directories;
import engine.Engine;
import phrases.Phrase;

public abstract class TextAnimationPhrase extends Phrase {

    private TextAnimator textAnimator;
    private Label textLabel;
    String text, sfxFileName;
    boolean playAudio;
    private SfxPlayer sfxPlayer;
    private String sfxDir;
    Pane characterNamePane;
    private VBox textHistoryContentPane;
    Label textHistoryLabel;
    private ScrollPane textHistoryScrollPane;

    TextAnimationPhrase() {
        playAudio = false;
        textAnimator = TextAnimator.getInstance();
        sfxPlayer = SfxPlayer.getInstance();
        sfxDir = Directories.getSfxDir();
        characterNamePane = Engine.getCharacterNamePane();
        textLabel = Engine.getTextLabel();
        textHistoryContentPane = Engine.getTextLogContentPane();
        textHistoryScrollPane = Engine.getTextLogScrollPane();
    }

    @Override
    public void execute() {
        textAnimator.animate(textLabel,text);
        textHistoryLabel = new Label(text);
        textHistoryLabel.setMaxWidth(1400);
        textHistoryLabel.setWrapText(true);
        textHistoryLabel.setTextFill(Color.color(0.8,0.8,0.8));
        textHistoryLabel.setFont(Font.font("Arial Narrow",32));
        textHistoryContentPane.getChildren().add(textHistoryLabel);

        if(playAudio) {
            sfxPlayer.play(sfxDir + "/" + sfxFileName);
        }
    }
}
