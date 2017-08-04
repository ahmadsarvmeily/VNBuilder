package phrases.animation;

import animation.ImageAnimator;
import engine.ui.VNEngineUI;
import javafx.scene.image.ImageView;
import engine.Engine;
import phrases.Phrase;

public class ImageShakeAnimationPhrase extends Phrase {

    private ImageView backgroundView;
    private ImageAnimator imageAnimator;

    public ImageShakeAnimationPhrase() {
        backgroundView = VNEngineUI.getBackgroundView();
        imageAnimator = ImageAnimator.getInstance();
    }

    @Override
    public void execute() {
        imageAnimator.shake(backgroundView);
    }
}
