package phrases;

import main.Engine;

public class AdvancePhrase extends Phrase {

    @Override
    public void execute() {
        Engine.advance();
    }
}
