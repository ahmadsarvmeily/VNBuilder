package engine.ui;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.HashMap;
import java.util.Map;

public class VNForegroundPane extends Pane {

    private Map<String,ImageView> imageNameMap;

    VNForegroundPane(Node... children) {
        super(children);
        imageNameMap = new HashMap<>();
    }

    public void getImage(String name, ImageView imageView) {
        imageNameMap.put(name, imageView);
    }

    public ImageView getImage(String name) {
        return imageNameMap.get(name);
    }
}
