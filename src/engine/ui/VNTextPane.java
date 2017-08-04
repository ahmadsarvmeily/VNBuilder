package engine.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class VNTextPane extends StackPane {

    private Label label;

    VNTextPane() {
        label = new Label("Start game");
        label.setFont(Font.font(32));
        label.setWrapText(true);
        label.setPadding(new Insets(10,0,40,40));
        label.setTextFill(Color.WHITE);
        this.getChildren().add(label);
        this.setBackground(new Background(new BackgroundFill(Color.color(0,0,0,0.7), new CornerRadii(10), new Insets(0,0,0,0))));
        this.setLayoutY(750);
        this.setPrefSize(1600,150);
        this.setAlignment(Pos.TOP_LEFT);
    }

    public Label getLabel() {
        return label;
    }
}
