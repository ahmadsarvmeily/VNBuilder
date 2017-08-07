package phrases.foreground_image;

import animation.ImageAnimator;
import engine.ui.VNEngineUI;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import engine.Directories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class PlaceImagePhrase extends ImagePhrase {

    private String imageName;
    private double x, y, scale;

    public PlaceImagePhrase(List<String> args) {
        String imageDir = Directories.getForegroundImageDir();
        String imageFileName = args.get(0);
        Image image = null;
        try {
            image = new Image(new FileInputStream(imageDir + "/" + imageFileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        imageView = new ImageView(image);
        imageName = args.get(1);
        x = Double.valueOf(args.get(2));
        y = Double.valueOf(args.get(3));
        scale = Double.valueOf(args.get(4));
    }

    @Override
    public void execute() {
        imageView.setX(x);
        imageView.setY(y);
        imageView.setScaleX(scale);
        imageView.setScaleY(scale);
        int index = foregroundPane.getChildren().indexOf(textPane);
        foregroundPane.getChildren().add(index, imageView);
        VNEngineUI.getForegroundPane().getImage(imageName, imageView);
        ImageAnimator animator = ImageAnimator.getInstance();
        animator.fadeIn(imageView);
    }
}
