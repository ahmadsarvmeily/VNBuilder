package engine.ui;

import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public abstract class VNEngineUI {

    private static VNBackgroundPane backgroundPane;
    private static VNTextLogPane textLogPane;
    private static VNSpeakerNamePane speakerNamePane;
    private static VNForegroundPane foregroundPane;
    private static VNTextPane textPane;
    private static VNActPane actPane;
    private static VNConfigPane configPane;
    private static VNMainMenuPane mainMenuPane;

    public static void setup(Pane rootPane) {
        rootPane.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));

        backgroundPane = new VNBackgroundPane();
        textPane = new VNTextPane();
        speakerNamePane = new VNSpeakerNamePane();
        textLogPane = new VNTextLogPane();
        actPane = new VNActPane();
        configPane = new VNConfigPane();
        mainMenuPane = new VNMainMenuPane();
        foregroundPane = new VNForegroundPane(textPane,speakerNamePane,textLogPane,configPane,actPane,mainMenuPane);
        backgroundPane.getChildren().add(foregroundPane);
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

    public static VNForegroundPane getForegroundPane() {
        return foregroundPane;
    }

    public static VNTextPane getTextPane() {
        return textPane;
    }

    public static VNActPane getActPane() {
        return actPane;
    }

    public static VNConfigPane getConfigPane() {
        return configPane;
    }
}
