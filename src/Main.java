import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Created by Ahmad on 17/07/2017.
 */
public class Main extends Application {
    //TODO: Launch menu - New VN/Load VN

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("VNBuilder");

        Button newVNButton = new Button("New Visual Novel");
        //Button loadVNButton = new Button("Load VNBuilder Project");

        StackPane launchMenuLayout = new StackPane(newVNButton);
        Scene launchMenuScene = new Scene(launchMenuLayout, 800, 600);

        primaryStage.setScene(launchMenuScene);
        primaryStage.show();
    }
}
