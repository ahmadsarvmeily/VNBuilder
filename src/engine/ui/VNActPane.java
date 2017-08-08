package engine.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class VNActPane extends VBox {

    private Label actNumberLabel, actNameLabel;

    VNActPane() {
        actNumberLabel = new Label();
        actNameLabel = new Label();
        actNumberLabel.setFont(Font.font("Arial", FontWeight.BOLD,36));
        actNameLabel.setFont(Font.font("Arial Narrow", FontPosture.ITALIC, 48));
        actNumberLabel.setTextFill(Color.WHITE);
        actNameLabel.setTextFill(Color.WHITE);
        actNumberLabel.setAlignment(Pos.CENTER);
        actNameLabel.setAlignment(Pos.CENTER);
        this.setSpacing(50);
        this.setVisible(false);
        this.setPadding(new Insets(300,300,300,300));
        this.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        this.setPrefSize(1600,900);
        this.getChildren().addAll(actNumberLabel,actNameLabel);
    }

    public void setAct(String actNumber, String actName) {
        actNumberLabel.setText("Act "+actNumber);
        actNameLabel.setText(actName);
    }
}
