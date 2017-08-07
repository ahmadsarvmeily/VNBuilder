package phrases.foreground_image;

import engine.ui.VNEngineUI;

import java.util.List;

public class MoveImagePhrase extends ImagePhrase {

    private double newX, newY;

    public MoveImagePhrase(List<String> args) {
        String imageName = args.get(0);
        imageView = VNEngineUI.getForegroundPane().getImage(imageName);
        newX = Double.valueOf(args.get(1));
        newY = Double.valueOf(args.get(2));
    }

    @Override
    public void execute() {
        imageView.setX(newX);
        imageView.setY(newY);
    }
}
