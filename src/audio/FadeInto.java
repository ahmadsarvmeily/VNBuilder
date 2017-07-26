package audio;

import javax.sound.sampled.Clip;

public class FadeInto extends Thread {

    private Clip from, into;
    private final int durationMillis, loops;

    FadeInto(Clip from, Clip into, int durationMillis, int loops) {
        this.from = from;
        this.into = into;
        this.durationMillis = durationMillis;
        this.loops = loops;
    }

    @Override
    public void run() {
        new FadeOut(from, durationMillis).start();
        new FadeIn(into,durationMillis,loops).start();
    }
}
