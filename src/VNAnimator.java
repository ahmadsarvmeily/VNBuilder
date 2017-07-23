import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class VNAnimator {

    public static void animateText(Label lbl, String speaker, String content) {
        final Animation animation = new Transition() {
            {
                setCycleDuration(Duration.millis(content.length()*40));
            }

            protected void interpolate(double frac) {
                final int length = content.length();
                final int n = Math.round(length * (float) frac);
                String speakerTag = speaker.length() > 0 ? "[ "+speaker+" ]\t" : "";
                lbl.setText(speakerTag+content.substring(0, n));
            }
        };
        animation.play();
    }
}
