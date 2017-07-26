package audio;

import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class FadeIn extends Thread {

    private Clip clip;
    private FloatControl gainControl;
    private int durationMillis, loops;

    FadeIn(Clip clip, int durationMillis, int loops) {
        this.clip = clip;
        gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(-80.0f);
        this.durationMillis = durationMillis;
        this.loops = loops;
    }

    @Override
    public void run() {
        final float initialGain = -80.0f;
        final float finalGain = -25.0f;
        final float dGain = Math.abs(finalGain-initialGain);

        clip.loop(loops);
        for(float newGain = initialGain; newGain < finalGain; newGain++) {
            gainControl.setValue(newGain);
            try {
                Thread.sleep((long)(durationMillis/dGain));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
