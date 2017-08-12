package phrases.animation.text;

import animation.TextAnimator;
import engine.Engine;
import engine.ui.VNEngineUI;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import engine.Directories;
import phrases.Phrase;

public abstract class TextAnimationPhrase extends Phrase {

    private TextAnimator textAnimator;
    private Label textLabel;
    String text, sfxFileName, sfxDir;
    boolean playAudio;
    Pane characterNamePane;
    private VBox textLogContentPane;
    Label textHistoryLabel;

    TextAnimationPhrase() {
        playAudio = false;
        textAnimator = TextAnimator.getInstance();
        sfxDir = Directories.getSfxDir();
        characterNamePane = VNEngineUI.getSpeakerNamePane();
        textLabel = VNEngineUI.getTextPane().getLabel();
        textLogContentPane = VNEngineUI.getTextLogPane().getContentPane();
    }

    @Override
    public void execute() {
        if(Engine.getTextAnimationEnabled()) {
            textAnimator.animate(textLabel, text);
        } else textLabel.setText(text);

        textHistoryLabel = new Label(text);
        textHistoryLabel.setMaxWidth(1400);
        textHistoryLabel.setWrapText(true);
        textHistoryLabel.setTextFill(Color.color(0.8,0.8,0.8));
        textHistoryLabel.setFont(Font.font("Arial Narrow",32));
        textLogContentPane.getChildren().add(textHistoryLabel);
    }
}
