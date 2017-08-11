package engine.ui;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class VNConfigPane extends GridPane {

    private StackPane textConfigPane, audioConfigPane, videoConfigPane;

    VNConfigPane() {
        textConfigPane = new StackPane();
        audioConfigPane = new StackPane();
        videoConfigPane = new StackPane();
        setupTextConfigPane();
        setAudioConfigPane();
        setVideoConfigPane();
        this.setLayoutX(150);
        this.setLayoutY(100);
        this.setVisible(false);
        this.setGridLinesVisible(true);
        this.setBackground(new Background(new BackgroundFill(Color.color(0,0,0,0.7),new CornerRadii(10), Insets.EMPTY)));
        this.setHgap(40);
        this.add(textConfigPane,0,0);
        this.add(audioConfigPane,1,0);
        this.add(videoConfigPane,2,0);
    }

    private void setupTextConfigPane() {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(40));
        gridPane.setHgap(50);
        gridPane.setVgap(50);

        Label animationToggleLabel = new Label("Text animation");
        animationToggleLabel.setFont(Font.font("Arial", FontWeight.BOLD,20));
        animationToggleLabel.setTextFill(Color.WHITE);
        ToggleSwitch animationToggleSwitch = new ToggleSwitch(true);
        GridPane.setHalignment(animationToggleSwitch, HPos.CENTER);
        gridPane.add(animationToggleLabel,0,0);
        gridPane.add(animationToggleSwitch,1,0);

        setupSliderRow(gridPane,1,"Animation speed",0,100,50);

        textConfigPane.getChildren().add(gridPane);
    }

    private void setAudioConfigPane() {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(40));
        gridPane.setHgap(50);
        gridPane.setVgap(50);

        setupSliderRow(gridPane,0,"Master volume",0,100,50);
        setupSliderRow(gridPane,1,"BGM",0,100,50);
        setupSliderRow(gridPane,2,"Speech",0,100,50);
        setupSliderRow(gridPane,3,"SFX",0,100,50);

        audioConfigPane.getChildren().add(gridPane);
    }

    private void setVideoConfigPane() {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(40));
        gridPane.setHgap(50);
        gridPane.setVgap(50);

        Label resolutionLabel = new Label("Resolution");
        resolutionLabel.setFont(Font.font("Arial", FontWeight.BOLD,20));
        resolutionLabel.setTextFill(Color.WHITE);
        ComboBox<String> resolutionComboBox = new ComboBox<>();
        resolutionComboBox.getItems().addAll("1280 x 720","1600 x 900","1920 x 1080");
        resolutionComboBox.getSelectionModel().select(1);
        gridPane.add(resolutionLabel,0,0);
        gridPane.add(resolutionComboBox,1,0);

        Label fullscreenToggleLabel = new Label("Fullscreen");
        fullscreenToggleLabel.setFont(Font.font("Arial", FontWeight.BOLD,20));
        fullscreenToggleLabel.setTextFill(Color.WHITE);
        ToggleSwitch fullscreenToggleSwitch = new ToggleSwitch(false);
        GridPane.setHalignment(fullscreenToggleSwitch,HPos.CENTER);
        gridPane.add(fullscreenToggleLabel,0,1);
        gridPane.add(fullscreenToggleSwitch,1,1);

        videoConfigPane.getChildren().add(gridPane);
    }

    private void setupSliderRow(GridPane parent, int row, String text, int sliderMin, int sliderMax, int sliderValue) {
        Label animationSpeedLabel = new Label(text);
        animationSpeedLabel.setFont(Font.font("Arial", FontWeight.BOLD,20));
        animationSpeedLabel.setTextFill(Color.WHITE);
        Slider animationSpeedSlider = new Slider(sliderMin,sliderMax,sliderValue);
        parent.add(animationSpeedLabel,0,row);
        parent.add(animationSpeedSlider,1,row);
    }
}
