package phrases.animation;

import animation.ImageAnimator;
import javafx.scene.image.ImageView;
import engine.Engine;
import phrases.Phrase;

public class ImageShakeAnimationPhrase extends Phrase {

    private ImageView backgroundView;
    private ImageAnimator imageAnimator;

    public ImageShakeAnimationPhrase() {
        backgroundView = Engine.getBackgroundView();
        imageAnimator = ImageAnimator.getInstance();
    }

    @Override
    public void execute() {
        imageAnimator.shake(backgroundView);
    }
}
