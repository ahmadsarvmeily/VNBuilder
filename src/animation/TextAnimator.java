package animation;

import javafx.animation.Transition;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class TextAnimator extends VNAnimator {

    private static TextAnimator textAnimator;

    private TextAnimator() {
        textAnimator = this;
    }

    public void animate(Label lbl, String content, float speed) {
        if(currentAnimation != null) currentAnimation.stop();

        currentAnimation = new Transition() {
            {
                setCycleDuration(Duration.millis(content.length()/speed));
            }
            @Override
            protected void interpolate(double frac) {
                final int n = Math.round(content.length() * (float) frac);
                lbl.setText(content.substring(0, n));
            }
        };
        currentAnimation.play();
    }

    public static TextAnimator getInstance() {
        if(textAnimator == null) {
            textAnimator = new TextAnimator();
        }
        return textAnimator;
    }
}
