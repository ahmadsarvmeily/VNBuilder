package audio;

public class SfxPlayer extends VNAudioPlayer {

    private static SfxPlayer sfxPlayer;

    private SfxPlayer() {
        sfxPlayer = this;
    }

    public static SfxPlayer getInstance() {
        if(sfxPlayer == null) {
            sfxPlayer = new SfxPlayer();
        }
        return sfxPlayer;
    }
}
