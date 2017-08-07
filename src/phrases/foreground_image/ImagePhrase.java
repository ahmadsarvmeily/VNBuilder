package phrases.foreground_image;

import engine.ui.VNEngineUI;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import phrases.Phrase;

abstract class ImagePhrase extends Phrase {

    ImageView imageView;
    Pane foregroundPane, textPane;

    ImagePhrase() {
        foregroundPane = VNEngineUI.getForegroundPane();
        textPane = VNEngineUI.getTextPane();
    }
}
