package audio;

public class MusicPlayer extends VNAudioPlayer {

    @Override
    public void play(String path) {
        if(clip != null)
            fadeInto(path,5000);
        else fadeIn(path,4000);
    }

    public void fadeOut() {
        fadeOut(8000);
    }
}
