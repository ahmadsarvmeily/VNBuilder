package audio;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public abstract class Music {

    //TODO: Reduce music volume when sfx are playing, increase afterwards

    private static Clip clip;
    private static FloatControl gainControl;

    public static void play(String path) {

        try {
            if(clip != null)
                clip.stop();
            clip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(path));
            clip.open(inputStream);
            gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            changeVolume(-25.0f);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (LineUnavailableException|UnsupportedAudioFileException|IOException e) {
            e.printStackTrace();
        }
    }

    public static void changeVolume(float db) {
        if(clip != null) {
            gainControl.setValue(db);
        }
    }
}
