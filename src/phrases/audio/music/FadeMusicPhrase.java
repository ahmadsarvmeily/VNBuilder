package phrases.audio.music;

public class FadeMusicPhrase extends MusicPhrase {

    @Override
    public void execute() {
        musicPlayer.fadeOut();
    }
}
