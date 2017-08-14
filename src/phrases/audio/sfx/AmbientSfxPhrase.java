package phrases.audio.sfx;

import audio.AmbientSfxPlayer;
import engine.Directories;
import phrases.Phrase;

import java.util.List;

public class AmbientSfxPhrase extends Phrase {

    private String ambientSfxDir, ambientSfxFileName;

    public AmbientSfxPhrase(List<String> args) {
        ambientSfxDir = Directories.getAmbientSfxDir();
        ambientSfxFileName = args.get(0);
    }

    @Override
    public void execute() {
        AmbientSfxPlayer.getInstance().loopContinuously(ambientSfxDir + "/" + ambientSfxFileName);
    }
}
