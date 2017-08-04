package builder;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Builder extends Application {

    private Scene launchMenuScene, builderScene;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("VNBuilder");

        setupLaunchMenu(primaryStage);
        setupBuilderMenu(primaryStage);

        primaryStage.setScene(launchMenuScene);
        primaryStage.show();
    }

    private void setupLaunchMenu(Stage stage) {
        Button newVNButton = new Button("New Visual Novel");
        newVNButton.setOnAction(e -> {
            //TODO: [LOW] Open file explorer to choose project root/create project files
            stage.hide();
            stage.setScene(builderScene);
            stage.centerOnScreen();
            stage.show();
        });

        Button loadVNButton = new Button("Load VNBuilder Project");
        //TODO: [LOW] Add loading functionality

        GridPane launchMenuPane = new GridPane();
        launchMenuPane.setAlignment(Pos.CENTER);
        launchMenuPane.add(newVNButton,0,0);
        GridPane.setHalignment(newVNButton, HPos.CENTER);
        launchMenuPane.add(loadVNButton,0,1);
        launchMenuPane.setVgap(40);

        launchMenuScene = new Scene(launchMenuPane, 400, 300);
    }

    private void setupBuilderMenu(Stage stage) {
        BorderPane rootBuilderPane = new BorderPane();

        //TODO: [HIGH] Create builder menu border elements

        builderScene = new Scene(rootBuilderPane, 800,600);
    }
}
