package engine.ui;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.HashMap;
import java.util.Map;

public class VNSpritePane extends Pane {

    private Map<String,ImageView> spriteMap;

    VNSpritePane(Node... children) {
        super(children);
        spriteMap = new HashMap<>();
    }

    public void addSprite(String name, ImageView imageView) {
        spriteMap.put(name, imageView);
    }

    public ImageView getSprite(String name) {
        return spriteMap.get(name);
    }
}
