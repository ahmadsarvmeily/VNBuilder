package phrases.foreground_image;

import animation.FadeAnimator;
import engine.ui.VNEngineUI;

import java.util.List;

public class RemoveImagePhrase extends ImagePhrase {

    public RemoveImagePhrase(List<String> args) {
        String imageName = args.get(0);
        imageView = VNEngineUI.getForegroundPane().getImage(imageName);
    }

    @Override
    public void execute() {
        FadeAnimator animator = FadeAnimator.getInstance();
        animator.fadeOut(imageView).setOnFinished(event -> foregroundPane.getChildren().remove(imageView));
    }
}
