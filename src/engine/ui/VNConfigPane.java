package engine.ui;

import audio.MusicPlayer;
import audio.SfxPlayer;
import audio.SpeechPlayer;
import engine.Engine;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;
import java.util.List;

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
        animationToggleSwitch.switchOnProperty().addListener((observable, oldValue, newValue) -> Engine.toggleTextAnimationEnabled());
        GridPane.setHalignment(animationToggleSwitch, HPos.CENTER);
        gridPane.add(animationToggleLabel,0,0);
        gridPane.add(animationToggleSwitch,1,0);
        Slider animationSpeedSlider = new Slider(0.01,0.05,0.03);
        animationSpeedSlider.valueProperty().addListener((observable, oldValue, newValue)
                -> Engine.setTextAnimationSpeed(newValue.floatValue()));

        setupSliderRow(animationSpeedSlider,gridPane,1,"Animation speed");

        textConfigPane.getChildren().add(gridPane);
    }

    private void setAudioConfigPane() {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(40));
        gridPane.setHgap(50);
        gridPane.setVgap(50);

        Slider masterSlider = new Slider(0,1,0.5);

        Slider bgmSlider = new Slider(0,1,0.5);
        Slider speechSlider = new Slider(0,1,0.5);
        Slider sfxSlider = new Slider(0,1,0.5);

        List<Slider> sliders = new ArrayList<>();
        sliders.add(bgmSlider);
        sliders.add(speechSlider);
        sliders.add(sfxSlider);

        bgmSlider.valueProperty().addListener((observable, oldValue, newValue)
                -> MusicPlayer.getInstance().setVolume(newValue.floatValue()));
        speechSlider.valueProperty().addListener((observable, oldValue, newValue)
                -> SpeechPlayer.getInstance().setVolume(newValue.floatValue()));
        sfxSlider.valueProperty().addListener((observable, oldValue, newValue)
                -> SfxPlayer.getInstance().setVolume(newValue.floatValue()));

        masterSlider.valueProperty().addListener((observable, oldValue, newValue) -> sliders.forEach(slider -> {
            if(slider.getValue() < newValue.doubleValue()) {
                double dValue = newValue.doubleValue() - oldValue.doubleValue();
                slider.setValue(slider.getValue()+slider.getValue()*dValue);
            }
        }));

        setupSliderRow(masterSlider, gridPane,0,"Master volume");
        setupSliderRow(bgmSlider, gridPane,1,"BGM");
        setupSliderRow(speechSlider, gridPane,2,"Speech");
        setupSliderRow(sfxSlider, gridPane,3,"SFX");

        audioConfigPane.getChildren().add(gridPane);
    }

    private void setVideoConfigPane() {
        GridPane gridPane = new GridPane();
        gridPane.setDisable(true);
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

    private void setupSliderRow(Slider slider, GridPane parent, int row, String text) {
        Label label = new Label(text);
        label.setFont(Font.font("Arial", FontWeight.BOLD,20));
        label.setTextFill(Color.WHITE);
        parent.add(label,0,row);
        parent.add(slider,1,row);
    }
}
