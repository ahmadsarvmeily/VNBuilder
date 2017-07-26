package audio;

public abstract class Sfx extends VNAudioPlayer {

    public static void play(String path) {
        if(clip != null)
            clip.stop();
        clip = getClipFromPath(path);
        clip.start();
    }
}
