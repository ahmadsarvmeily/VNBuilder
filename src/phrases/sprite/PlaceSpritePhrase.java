package phrases.sprite;

import animation.ImageAnimator;
import engine.ui.VNEngineUI;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import engine.Directories;
import engine.Engine;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

public class PlaceSpritePhrase extends SpritePhrase {

    private String spriteName;
    private double x, y, scale;

    public PlaceSpritePhrase(List<String> args) {
        String spriteDir = Directories.getSpriteDir();
        String spriteFileName = args.get(0);
        Image sprite = null;
        try {
            sprite = new Image(new FileInputStream(spriteDir + "/" + spriteFileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        spriteView = new ImageView(sprite);
        spriteName = args.get(1);
        x = Double.valueOf(args.get(2));
        y = Double.valueOf(args.get(3));
        scale = Double.valueOf(args.get(4));
    }

    @Override
    public void execute() {
        spriteView.setX(x);
        spriteView.setY(y);
        spriteView.setScaleX(scale);
        spriteView.setScaleY(scale);
        int index = spritePane.getChildren().indexOf(textPane);
        spritePane.getChildren().add(index,spriteView);
        VNEngineUI.getSpritePane().addSprite(spriteName,spriteView);
        ImageAnimator animator = ImageAnimator.getInstance();
        animator.fadeIn(spriteView);
    }
}
