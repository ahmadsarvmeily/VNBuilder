package phrases.act;

import animation.FadeAnimator;
import engine.Engine;
import engine.ui.VNActPane;
import engine.ui.VNEngineUI;
import phrases.Phrase;

import java.util.List;

public class ActPhrase extends Phrase {

    private String actNumber, actName;

    public ActPhrase(List<String> args) {
        actNumber = args.get(0);
        if(args.size() == 2)
            actName = args.get(1);
    }

    @Override
    public void execute() {
        VNActPane actPane = VNEngineUI.getActPane();
        actPane.setAct(actNumber,actName);
        actPane.setVisible(true);
        FadeAnimator fadeAnimator = FadeAnimator.getInstance();
        fadeAnimator.fadeIn(actPane);
        Engine.pauseExecution();
    }
}
