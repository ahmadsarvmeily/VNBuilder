package engine.ui;

import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public abstract class VNEngineUI {

    private static VNBackgroundPane backgroundPane;
    private static VNTextLogPane textLogPane;
    private static VNSpeakerNamePane speakerNamePane;
    private static VNSpritePane spritePane;
    private static VNTextPane textPane;

    public static void setup(Pane rootPane) {
        rootPane.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));

        backgroundPane = new VNBackgroundPane();
        textPane = new VNTextPane();
        speakerNamePane = new VNSpeakerNamePane();
        textLogPane = new VNTextLogPane();
        spritePane = new VNSpritePane(textPane,speakerNamePane,textLogPane);
        backgroundPane.getChildren().add(spritePane);
        rootPane.getChildren().add(backgroundPane);
    }

    public static ImageView getBackgroundView() {
        return backgroundPane.getBackgroundView();
    }

    public static VNSpeakerNamePane getSpeakerNamePane() {
        return speakerNamePane;
    }

    public static VNTextLogPane getTextLogPane() {
        return textLogPane;
    }

    public static VNSpritePane getSpritePane() {
        return spritePane;
    }

    public static VNTextPane getTextPane() {
        return textPane;
    }
}
