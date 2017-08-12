package audio;

import javax.sound.sampled.Clip;

public class FadeInto extends Thread {

    private Clip from, into;
    private final int durationMillis, loops;
    private float finalGain;

    FadeInto(Clip from, Clip into, int durationMillis, float finalGain, int loops) {
        this.from = from;
        this.into = into;
        this.durationMillis = durationMillis;
        this.finalGain = finalGain;
        this.loops = loops;
    }

    @Override
    public void run() {
        new FadeOut(from, durationMillis).start();
        new FadeIn(into,durationMillis,finalGain,loops).start();
    }
}
