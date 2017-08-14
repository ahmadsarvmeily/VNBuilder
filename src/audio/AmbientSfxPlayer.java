package audio;

public class AmbientSfxPlayer extends VNAudioPlayer {

    private static AmbientSfxPlayer ambientSfxPlayer;

    private AmbientSfxPlayer() {
        ambientSfxPlayer = this;
    }

    public static AmbientSfxPlayer getInstance() {
        if(ambientSfxPlayer == null) {
            ambientSfxPlayer = new AmbientSfxPlayer();
        }
        return ambientSfxPlayer;
    }
}
