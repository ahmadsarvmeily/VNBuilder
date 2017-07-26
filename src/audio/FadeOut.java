package audio;

import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class FadeOut extends Thread {

    private Clip clip;
    private FloatControl gainControl;
    private int durationMillis;

    FadeOut(Clip clip, int durationMillis) {
        this.clip = clip;
        gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        this.durationMillis = durationMillis;
    }

    @Override
    public void run() {
        final float initialGain = gainControl.getValue();
        final float finalGain = -80.0f;
        final float dGain = Math.abs(finalGain-initialGain);

        for(float newGain = initialGain; newGain > finalGain; newGain--) {
            gainControl.setValue(newGain);
            try {
                Thread.sleep((long)(durationMillis/dGain));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        clip.stop();
    }
}
