package audio;

public class SpeechPlayer extends VNAudioPlayer {

    private static SpeechPlayer speechPlayer;

    private SpeechPlayer() {
        speechPlayer = this;
    }

    public static SpeechPlayer getInstance() {
        if(speechPlayer == null) {
            speechPlayer = new SpeechPlayer();
        }
        return speechPlayer;
    }
}
