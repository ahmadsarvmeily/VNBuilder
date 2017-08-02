package phrases.audio;

import audio.SfxPlayer;
import main.Directories;
import phrases.Phrase;

import java.util.List;

public class SfxPhrase extends Phrase {

    private SfxPlayer sfxPlayer;
    private String sfxDir, sfxFileName;

    public SfxPhrase(List<String> args) {
        sfxPlayer = SfxPlayer.getInstance();
        sfxDir = Directories.getSfxDir();
        sfxFileName = args.get(0);
    }

    @Override
    public void execute() {
        sfxPlayer.play(sfxDir + "/" + sfxFileName);
    }
}
