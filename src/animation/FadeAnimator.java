package animation;

import javafx.animation.FadeTransition;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class FadeAnimator extends VNAnimator {

    private static FadeAnimator fadeAnimator;

    private FadeAnimator() {
        fadeAnimator = this;
    }

    public void fadeIn(Node node) {
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(750),node);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
    }

    public FadeTransition fadeOut(Node node) {
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(750),node);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.setOnFinished(event -> node.setVisible(false));
        fadeTransition.play();
        return fadeTransition;
    }

    public static FadeAnimator getInstance() {
        if(fadeAnimator == null) {
            fadeAnimator = new FadeAnimator();
        }
        return fadeAnimator;
    }
}
