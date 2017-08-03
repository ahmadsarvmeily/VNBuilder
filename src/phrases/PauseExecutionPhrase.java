package phrases;

import main.Engine;

public class PauseExecutionPhrase extends Phrase {

    @Override
    public void execute() {
        Engine.pauseExecution();
    }
}
