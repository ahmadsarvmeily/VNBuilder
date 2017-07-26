package audio;

public class SfxPlayer extends VNAudioPlayer {

    @Override
    public void play(String path) {
        if(clip != null)
            clip.stop();
        clip = getClipFromPath(path);
        clip.start();
    }
}
