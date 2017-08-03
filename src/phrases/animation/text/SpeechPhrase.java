package phrases.animation.text;

import javafx.scene.control.Label;
import main.Engine;

import java.util.List;

public class SpeechPhrase extends TextAnimationPhrase {

    private String speaker;
    private Label characterNameLabel;

    public SpeechPhrase(List<String> args) {
        speaker = args.get(0);
        text = args.get(1);
        characterNameLabel = Engine.getCharacterNameLabel();
        if(args.size() == 3) {
            sfxFileName = args.get(2);
            playAudio = true;
        }
    }

    @Override
    public void execute() {
        super.execute();
        characterNameLabel.setText(speaker);
        characterNamePane.setVisible(true);
        Engine.pauseExecution();
    }
}
