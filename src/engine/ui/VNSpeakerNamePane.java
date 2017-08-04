package engine.ui;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class VNSpeakerNamePane extends StackPane {

    private Label label;

    VNSpeakerNamePane() {
        label = new Label();
        label.setFont(Font.font("Arial", FontWeight.SEMI_BOLD,36));
        label.setPadding(new Insets(0,25,0,25));
        label.setTextFill(Color.WHITE);
        this.getChildren().add(label);
        this.setBackground(new Background(new BackgroundFill(Color.color(0,0,0,0.7), new CornerRadii(10), Insets.EMPTY)));
        this.setLayoutX(5);
        this.setLayoutY(705);
        this.setVisible(false);
    }

    public Label getLabel() {
        return label;
    }
}
