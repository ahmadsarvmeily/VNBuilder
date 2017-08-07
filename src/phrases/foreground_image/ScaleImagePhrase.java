package phrases.foreground_image;

import engine.ui.VNEngineUI;

import java.util.List;

public class ScaleImagePhrase extends ImagePhrase {

    private double newScale;

    public ScaleImagePhrase(List<String> args) {
        String imageName = args.get(0);
        imageView = VNEngineUI.getForegroundPane().getImage(imageName);
        newScale = Double.valueOf(args.get(1));
    }

    @Override
    public void execute() {
        imageView.setScaleX(newScale);
        imageView.setScaleY(newScale);
    }
}
