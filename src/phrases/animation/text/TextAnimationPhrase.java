package phrases.animation.text;

import animation.TextAnimator;
import audio.SfxPlayer;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import main.Directories;
import main.Engine;
import phrases.Phrase;

import java.util.List;

public abstract class TextAnimationPhrase extends Phrase {

    private TextAnimator textAnimator;
    private Label textLabel;
    String text, sfxFileName;
    boolean playAudio;
    private SfxPlayer sfxPlayer;
    private String sfxDir;
    Pane characterNamePane;

    TextAnimationPhrase() {
        playAudio = false;
        textAnimator = TextAnimator.getInstance();
        sfxPlayer = SfxPlayer.getInstance();
        sfxDir = Directories.getSfxDir();
        characterNamePane = Engine.getCharacterNamePane();
        textLabel = Engine.getTextLabel();
    }

    @Override
    public void execute() {
        textAnimator.animate(textLabel,text);

        if(playAudio) {
            sfxPlayer.play(sfxDir + "/" + sfxFileName);
        }
    }
}
