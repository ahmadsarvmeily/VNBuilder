package phrases.audio.music;

import audio.MusicPlayer;
import phrases.Phrase;

abstract class MusicPhrase extends Phrase {

    MusicPlayer musicPlayer;

    MusicPhrase() {
        musicPlayer = MusicPlayer.getInstance();
    }
}
