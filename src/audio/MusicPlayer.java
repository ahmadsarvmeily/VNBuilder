package audio;

public class MusicPlayer extends VNAudioPlayer {

    private static MusicPlayer musicPlayer;

    private MusicPlayer() {
        musicPlayer = this;
    }

    public void fadeOut() {
        fadeOut(8000);
    }

    public static MusicPlayer getInstance() {
        if(musicPlayer == null) {
            musicPlayer = new MusicPlayer();
        }
        return musicPlayer;
    }
}
