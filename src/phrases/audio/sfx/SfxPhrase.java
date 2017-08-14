package phrases.audio.sfx;

import audio.SfxPlayer;
import engine.Directories;
import phrases.Phrase;

import java.util.List;

public class SfxPhrase extends Phrase {

    private String sfxDir, sfxFileName;

    public SfxPhrase(List<String> args) {
        sfxDir = Directories.getSfxDir();
        sfxFileName = args.get(0);
    }

    @Override
    public void execute() {
        SfxPlayer.getInstance().play(sfxDir + "/" + sfxFileName);
    }
}
