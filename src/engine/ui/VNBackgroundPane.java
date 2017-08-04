package engine.ui;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

class VNBackgroundPane extends Pane {

    private ImageView backgroundView;

    VNBackgroundPane() {
        backgroundView = new ImageView();
        backgroundView.setFitHeight(900);
        backgroundView.setFitWidth(1600);
        this.getChildren().add(backgroundView);
    }

    ImageView getBackgroundView() {
        return backgroundView;
    }
}
