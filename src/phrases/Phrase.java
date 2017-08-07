package phrases;

import phrases.animation.*;
import phrases.animation.text.*;
import phrases.audio.*;
import phrases.audio.music.*;
import phrases.foreground_image.*;

import java.util.Arrays;
import java.util.List;

public abstract class Phrase {

    public abstract void execute();

    public static Phrase createPhrase(String line) {

        List<String> words = Arrays.asList(line.split("\\|"));
        String command = words.get(0);
        List<String> args = null;
        if(words.size() > 1)
            args = words.subList(1,words.size());

        switch (command) {
            case "pause": return new PauseExecutionPhrase();

            case "music": return new PlayMusicPhrase(args);

            case "sfx": return new SfxPhrase(args);

            case "place fg_image": return new PlaceImagePhrase(args);

            case "move fg_image": return new MoveImagePhrase(args);

            case "remove fg_image": return new RemoveImagePhrase(args);

            case "scale fg_image": return new ScaleImagePhrase(args);

            case "shake": return new ImageShakeAnimationPhrase();

            case "fade out music": return new FadeMusicPhrase();

            case "text": return new NarrationPhrase(args);

            case "speech": return new SpeechPhrase(args);

            case "bg": return new ChangeBackgroundPhrase(args);

            default: return null;
        }
    }
}
