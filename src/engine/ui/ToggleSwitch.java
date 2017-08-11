package engine.ui;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;

public class ToggleSwitch extends Label
{
    private SimpleBooleanProperty switchedOn;

    ToggleSwitch(boolean defaultEnabled)
    {
        switchedOn = new SimpleBooleanProperty(!defaultEnabled);
        Button switchBtn = new Button();
        switchBtn.setPrefWidth(40);
        switchBtn.setOnAction(t -> switchedOn.set(!switchedOn.get()));
        setGraphic(switchBtn);

        switchedOn.addListener((ov, t, t1) -> {
            if (t1)
            {
                setPadding(new Insets(0,0,0,10));
                setText("ON ");
                setStyle("-fx-background-color: green;-fx-text-fill:white;-fx-font-weight: bold");
                setContentDisplay(ContentDisplay.RIGHT);
            }
            else
            {
                setPadding(new Insets(0,10,0,0));
                setText(" OFF");
                setStyle("-fx-background-color: grey;-fx-text-fill:black;-fx-font-weight: bold");
                setContentDisplay(ContentDisplay.LEFT);
            }
        });

        switchedOn.setValue(defaultEnabled);
    }

    public SimpleBooleanProperty switchOnProperty() { return switchedOn; }
}