package phrases;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.Directories;
import main.Engine;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class ChangeBackgroundPhrase extends Phrase {

    private ImageView backgroundView;
    private Image image;

    ChangeBackgroundPhrase(List<String> args) {
        backgroundView = Engine.getBackgroundView();
        String bgDir = Directories.getBgDir();
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

        Engine.advance();
    }
}
