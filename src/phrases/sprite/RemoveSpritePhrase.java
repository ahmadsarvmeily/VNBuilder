package phrases.sprite;

import animation.ImageAnimator;
import engine.ui.VNEngineUI;

import java.util.List;

public class RemoveSpritePhrase extends SpritePhrase {

    public RemoveSpritePhrase(List<String> args) {
        String spriteName = args.get(0);
        spriteView = VNEngineUI.getSpritePane().getSprite(spriteName);
    }

    @Override
    public void execute() {
        ImageAnimator animator = ImageAnimator.getInstance();
        animator.fadeOut(spriteView).setOnFinished(event -> spritePane.getChildren().remove(spriteView));
    }
}
