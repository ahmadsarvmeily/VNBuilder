package audio;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public abstract class Music {

    private static Clip clip;

    public static void play(String path) {

        try {
            if(clip != null)
                clip.stop();
            clip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(path));
            clip.open(inputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (LineUnavailableException|UnsupportedAudioFileException|IOException e) {
            e.printStackTrace();
        }

    }
}