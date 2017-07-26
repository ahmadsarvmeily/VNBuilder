package audio;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

abstract class VNAudioPlayer {

    static Clip clip;

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

    static void fadeInto(String path, int durationMillis) {
        Clip into = getClipFromPath(path);
        new FadeInto(clip,into,durationMillis,Clip.LOOP_CONTINUOUSLY).start();
        clip = into;
    }

    static void fadeIn(String path, int durationMillis) {
        Clip in = getClipFromPath(path);
        clip = in;
        new FadeIn(in,durationMillis,Clip.LOOP_CONTINUOUSLY).start();
    }

    public static void fadeOut(int durationMillis) {
        new FadeOut(clip,durationMillis).start();
    }
}
