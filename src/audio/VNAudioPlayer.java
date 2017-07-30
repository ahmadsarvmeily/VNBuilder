package audio;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

abstract class VNAudioPlayer {

    Clip clip;

    public abstract void play(String path);

    static Clip getClipFromPath(String path) {
        Clip clip = null;
        try {
            clip = AudioSystem.getClip();
            File file = new File(path);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            clip.open(audioInputStream);
        } catch (LineUnavailableException |UnsupportedAudioFileException |IOException e) {
            e.printStackTrace();
        }
        return clip;
    }

    void fadeInto(String path, int durationMillis) {
        Clip into = getClipFromPath(path);
        new FadeInto(clip,into,durationMillis,Clip.LOOP_CONTINUOUSLY).start();
        clip = into;
    }

    void fadeIn(String path, int durationMillis) {
        Clip in = getClipFromPath(path);
        clip = in;
        new FadeIn(in,durationMillis,Clip.LOOP_CONTINUOUSLY).start();
    }

    void fadeOut(int durationMillis) {
        new FadeOut(clip,durationMillis).start();
    }

    void setVolume(float db) {
        FloatControl gainControl = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(db);
    }
}
