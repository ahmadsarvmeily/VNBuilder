package audio;

public abstract class Music extends VNAudioPlayer {

    public static void play(String path) {
        if(clip != null)
            fadeInto(path,10000);
        else fadeIn(path,5000);
    }
}
