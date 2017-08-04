package engine.ui;

import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class VNTextLogPane extends StackPane {

    private VBox contentPane;
    private ScrollPane scrollPane;

    VNTextLogPane() {
        contentPane = new VBox(20);
        scrollPane = new ScrollPane(contentPane);
        scrollPane.vvalueProperty().bind(contentPane.heightProperty());
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setPannable(true);
        scrollPane.setStyle("-fx-background: transparent;\n -fx-background-color: transparent");
        scrollPane.setPadding(new Insets(40,40,40,40));
        this.getChildren().add(scrollPane);
        this.setBackground(new Background(new BackgroundFill(Color.color(0,0,0,0.7), new CornerRadii(10), Insets.EMPTY)));
        this.setLayoutX(40);
        this.setLayoutY(-10);
        this.setPrefSize(1520,710);
        this.setVisible(false);
    }

    public ScrollPane getScrollPane() {
        return scrollPane;
    }

    public VBox getContentPane() {
        return contentPane;
    }
}
