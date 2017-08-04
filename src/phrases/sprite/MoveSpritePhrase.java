package phrases.sprite;

import engine.ui.VNEngineUI;

import java.util.List;

public class MoveSpritePhrase extends SpritePhrase {

    private double newX, newY;

    public MoveSpritePhrase(List<String> args) {
        String spriteName = args.get(0);
        spriteView = VNEngineUI.getSpritePane().getSprite(spriteName);
        newX = Double.valueOf(args.get(1));
        newY = Double.valueOf(args.get(2));
    }

    @Override
    public void execute() {
        spriteView.setX(newX);
        spriteView.setY(newY);
    }
}
