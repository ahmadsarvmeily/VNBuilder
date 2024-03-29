package phrases.audio.music;

import engine.Directories;

import java.util.List;

public class PlayMusicPhrase extends MusicPhrase {

    private String musicDir, musicFileName;

    public PlayMusicPhrase(List<String> args) {
        musicDir = Directories.getMusicDir();
        musicFileName = args.get(0);
    }

    @Override
    public void execute() {
        musicPlayer.loopContinuously(musicDir + "/" + musicFileName);
    }
}
