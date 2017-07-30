package animation;

import javafx.animation.Transition;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class TextAnimator extends VNAnimator {

    public void animate(Label lbl, String content) {
        if(currentAnimation != null) currentAnimation.stop();

        currentAnimation = new Transition() {
            {
                setCycleDuration(Duration.millis(content.length()*20));
            }
            @Override
            protected void interpolate(double frac) {
                final int n = Math.round(content.length() * (float) frac);
                lbl.setText(content.substring(0, n));
            }
        };
        currentAnimation.play();
    }
}
