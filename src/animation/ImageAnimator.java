package animation;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.scene.image.ImageView;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class ImageAnimator extends VNAnimator {

    private static ImageAnimator imageAnimator;

    private ImageAnimator() {
        imageAnimator = this;
    }

    public void shake(ImageView imageView) {
        final double x = imageView.getX()+imageView.getFitWidth()/2;
        final double y = imageView.getY()+imageView.getFitHeight()/2;
        MoveTo origin = new MoveTo(x,y);
        LineTo topRight = new LineTo(x+15,y-15);
        LineTo bottomLeft = new LineTo(x-15,y+15);
        LineTo backToOrigin = new LineTo(x,y);
        Path path = new Path(origin,topRight,bottomLeft,topRight,bottomLeft,backToOrigin);
        currentAnimation = new PathTransition(Duration.millis(400),path,imageView);
        currentAnimation.play();
    }

    public void fadeIn(ImageView imageView) {
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(750),imageView);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
    }

    public FadeTransition fadeOut(ImageView imageView) {
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(750),imageView);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();
        return fadeTransition;
    }

    public static ImageAnimator getInstance() {
        if(imageAnimator == null) {
            imageAnimator = new ImageAnimator();
        }
        return imageAnimator;
    }
}
