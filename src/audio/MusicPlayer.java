package audio;

import javax.sound.sampled.Clip;

public class MusicPlayer extends VNAudioPlayer {

    @Override
    public void play(String path) {
        if(clip != null)
            fadeInto(path,5000);
        else getClipFromPath(path).loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void fadeOut() {
        fadeOut(8000);
    }
}
