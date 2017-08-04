package phrases.sprite;

import engine.Engine;

import java.util.List;

public class RemoveSpritePhrase extends SpritePhrase {

    public RemoveSpritePhrase(List<String> args) {
        String spriteName = args.get(0);
        spriteView = Engine.getSprite(spriteName);
    }

    @Override
    public void execute() {
        spritePane.getChildren().remove(spriteView);
    }
}
