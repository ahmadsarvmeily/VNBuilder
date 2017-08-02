package phrases.animation.text;

import main.Engine;

import java.util.List;

public class NarrationPhrase extends TextAnimationPhrase {

    public NarrationPhrase(List<String> args) {
        text = args.get(0);
        if(args.size() == 2) {
            sfxFileName = args.get(1);
            playAudio = true;
        }
    }

    @Override
    public void execute() {
        super.execute();
        characterNamePane.setVisible(false);
        Engine.advance();
    }
}
