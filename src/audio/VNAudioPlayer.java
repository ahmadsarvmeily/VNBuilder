package audio;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

abstract public class VNAudioPlayer {

    // 0.0 = silent, 1.0 = full volume
    float volume = 0.5f;
    Clip clip;

    public void play(String path) {
        if(clip != null)
            clip.stop();
        clip = getClipFromPath(path);
        setVolume(volume);
        clip.start();
    }

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
        new FadeInto(clip,into,durationMillis,volume,Clip.LOOP_CONTINUOUSLY).start();
        clip = into;
    }

    void fadeIn(String path, int durationMillis) {
        Clip in = getClipFromPath(path);
        clip = in;
        new FadeIn(in,durationMillis,volume,Clip.LOOP_CONTINUOUSLY).start();
    }

    void fadeOut(int durationMillis) {
        new FadeOut(clip,durationMillis).start();
    }

    public void setVolume(float volume) {
        this.volume = volume;
        if(clip != null) {
            FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            volumeControl.setValue(20f * (float) Math.log10(volume));
        }
    }
}
