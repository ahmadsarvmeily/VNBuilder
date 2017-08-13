package phrases.animation.text;

import audio.SpeechPlayer;
import engine.ui.VNEngineUI;
import javafx.scene.control.Label;
import engine.Engine;

import java.util.List;

public class SpeechPhrase extends TextPhrase {

    private String speaker;
    private Label speakerNameLabel;

    public SpeechPhrase(List<String> args) {
        speaker = args.get(0);
        text = args.get(1);
        speakerNameLabel = VNEngineUI.getSpeakerNamePane().getLabel();
        if(args.size() == 3) {
            sfxFileName = args.get(2);
            playAudio = true;
        }
    }

    @Override
    public void execute() {
        super.execute();
        textHistoryLabel.setText(speaker+": "+textHistoryLabel.getText());
        speakerNameLabel.setText(speaker);
        characterNamePane.setVisible(true);

        if(playAudio) {
            SpeechPlayer.getInstance().play(sfxDir + "/" + sfxFileName);
        }

        Engine.pauseExecution();
    }
}
