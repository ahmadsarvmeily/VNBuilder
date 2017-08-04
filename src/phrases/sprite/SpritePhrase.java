package phrases.sprite;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import engine.Engine;
import phrases.Phrase;

abstract class SpritePhrase extends Phrase {

    ImageView spriteView;
    Pane spritePane, textPane;

    SpritePhrase() {
        spritePane = Engine.getSpritePane();
        textPane = Engine.getTextPane();
    }
}
