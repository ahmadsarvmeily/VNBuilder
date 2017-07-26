package animation;

import javafx.animation.Transition;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class TextAnimator extends VNAnimator {

    public void animate(Label lbl, String speaker, String content) {
        if(currentAnimation != null) currentAnimation.stop();

        currentAnimation = new Transition() {
            {
                setCycleDuration(Duration.millis(content.length()*20));
            }
            @Override
            protected void interpolate(double frac) {
                final int n = Math.round(content.length() * (float) frac);
                String speakerTag = speaker.length() > 0 ? "[ "+speaker+" ]\t" : "";
                lbl.setText(speakerTag+content.substring(0, n));
            }
        };
        currentAnimation.play();
    }
}
