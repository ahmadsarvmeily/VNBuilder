package phrases;

import engine.Engine;

public class PauseExecutionPhrase extends Phrase {

    @Override
    public void execute() {
        Engine.pauseExecution();
    }
}
