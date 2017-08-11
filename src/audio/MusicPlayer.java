package audio;

import javax.sound.sampled.Clip;

public class MusicPlayer extends VNAudioPlayer {

    private static MusicPlayer musicPlayer;

    private MusicPlayer() {
        musicPlayer = this;
    }

    @Override
    public void play(String path) {
        if(clip != null)
            fadeInto(path,5000);
        else {
            clip = getClipFromPath(path);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }

    public void fadeOut() {
        fadeOut(8000);
    }

    public static MusicPlayer getInstance() {
        if(musicPlayer == null) {
            musicPlayer = new MusicPlayer();
        }
        return musicPlayer;
    }
}
