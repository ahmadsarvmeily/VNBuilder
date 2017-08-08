package phrases.act;

import animation.FadeAnimator;
import engine.ui.VNActPane;
import engine.ui.VNEngineUI;
import phrases.Phrase;

public class BeginActPhrase extends Phrase {

    @Override
    public void execute() {
        FadeAnimator fadeAnimator = FadeAnimator.getInstance();
        VNActPane actPane = VNEngineUI.getActPane();
        fadeAnimator.fadeOut(actPane).setOnFinished(event -> actPane.setVisible(false));
    }
}
