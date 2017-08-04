package phrases.sprite;

import engine.ui.VNEngineUI;

import java.util.List;

public class RemoveSpritePhrase extends SpritePhrase {

    public RemoveSpritePhrase(List<String> args) {
        String spriteName = args.get(0);
        spriteView = VNEngineUI.getSpritePane().getSprite(spriteName);
    }

    @Override
    public void execute() {
        spritePane.getChildren().remove(spriteView);
    }
}
