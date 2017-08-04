package phrases.sprite;

import engine.Engine;

import java.util.List;

public class ScaleSpritePhrase extends SpritePhrase {

    private double newScale;

    public ScaleSpritePhrase(List<String> args) {
        String spriteName = args.get(0);
        spriteView = Engine.getSprite(spriteName);
        newScale = Double.valueOf(args.get(1));
    }

    @Override
    public void execute() {
        spriteView.setScaleX(newScale);
        spriteView.setScaleY(newScale);
    }
}
