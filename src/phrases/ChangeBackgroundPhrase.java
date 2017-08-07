package phrases;

import engine.ui.VNEngineUI;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import engine.Directories;
import engine.Engine;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class ChangeBackgroundPhrase extends Phrase {

    private ImageView backgroundView;
    private Image image;

    ChangeBackgroundPhrase(List<String> args) {
        backgroundView = VNEngineUI.getBackgroundView();
        String bgDir = Directories.getBackgroundImageDir();
        String bgFileName = args.get(0);
        try {
            image = new Image(new FileInputStream(bgDir + "/" + bgFileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void execute() {
        backgroundView.setImage(image);

        Engine.pauseExecution();
    }
}
