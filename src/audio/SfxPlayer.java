package audio;

public class SfxPlayer extends VNAudioPlayer {

    private static SfxPlayer sfxPlayer;

    private SfxPlayer() {
        sfxPlayer = this;
    }

    @Override
    public void play(String path) {
        if(clip != null)
            clip.stop();
        clip = getClipFromPath(path);
        clip.start();
    }

    public static SfxPlayer getInstance() {
        if(sfxPlayer == null) {
            sfxPlayer = new SfxPlayer();
        }
        return sfxPlayer;
    }
}
