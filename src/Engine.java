import javafx.application.Application;
import javafx.stage.Stage;

import java.io.File;

public class Engine extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        File novelDir = new File("Novel");
        if(novelDir.isDirectory()) {
            System.out.println("Success");
        } else {
            System.out.println("Failure");
        }
    }
}
