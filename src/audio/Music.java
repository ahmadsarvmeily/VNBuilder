package audio;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public abstract class Music {

    private static Clip clip;

    public static void play(String path) {
        if(clip != null)
            fadeInto(path);
        else fadeIn(path);
    }

    private static void fadeInto(String path) {
        Clip into = getClipFromPath(path);
        new FadeInto(clip,into,10000,Clip.LOOP_CONTINUOUSLY).start();
        clip = into;
    }

    private static void fadeIn(String path) {
        Clip in = getClipFromPath(path);
        clip = in;
        new FadeIn(in,5000,Clip.LOOP_CONTINUOUSLY).start();
    }

    public static void fadeOut() {
        new FadeOut(clip,5000).start();
    }

    private static Clip getClipFromPath(String path) {
        Clip clip = null;
        try {
            clip = AudioSystem.getClip();
            File file = new File(path);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            clip.open(audioInputStream);
        } catch (LineUnavailableException|UnsupportedAudioFileException|IOException e) {
            e.printStackTrace();
        }
        return clip;
    }
}
