import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.animation.Transition;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class VNAnimator {

    public static void animateText(Label lbl, String speaker, String content) {
        final Animation animation = new Transition() {
            {
                setCycleDuration(Duration.millis(content.length()*40));
            }
            @Override
            protected void interpolate(double frac) {
                final int n = Math.round(content.length() * (float) frac);
                String speakerTag = speaker.length() > 0 ? "[ "+speaker+" ]\t" : "";
                lbl.setText(speakerTag+content.substring(0, n));
            }
        };
        animation.play();
    }

    public static void shakeImage(ImageView imageView) {
        final double x = imageView.getX()+imageView.getFitWidth()/2;
        final double y = imageView.getY()+imageView.getFitHeight()/2;
        MoveTo origin = new MoveTo(x,y);
        LineTo topRight = new LineTo(x+15,y-15);
        LineTo bottomLeft = new LineTo(x-15,y+15);
        LineTo backToOrigin = new LineTo(x,y);
        Path path = new Path(origin,topRight,bottomLeft,topRight,bottomLeft,backToOrigin);
        PathTransition pathTransition = new PathTransition(Duration.millis(400),path,imageView);
        pathTransition.play();
    }
}
