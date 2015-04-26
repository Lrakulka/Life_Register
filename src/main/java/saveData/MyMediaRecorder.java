package saveData;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaRecorder;

/**
 * Created by KrabiySok on 4/14/2015.
 */
public class MyMediaRecorder extends MediaRecorder {
    private boolean isClickSound;

    public void start(Context context) throws IllegalStateException {
        if (!isClickSound) {
            setMuteAll(true, context);
        }
        super.start();
        if (!isClickSound) {
            setMuteAll(false, context);
        }
    }

    public void stop(Context context) throws IllegalStateException {
        if (!isClickSound) {
            setMuteAll(true, context);
        }
        super.stop();
        if (!isClickSound) {
            setMuteAll(false, context);
        }
    }

    public void setClickSound(boolean isClickSound) {
        this.isClickSound = isClickSound;
    }

    public static void setMuteAll(boolean mute, Context context) {
        AudioManager manager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);

        int[] streams = new int[] { AudioManager.STREAM_ALARM, AudioManager.STREAM_DTMF,
                AudioManager.STREAM_MUSIC, AudioManager.STREAM_RING, AudioManager.STREAM_SYSTEM,
                AudioManager.STREAM_VOICE_CALL };

        for (int stream : streams)
            manager.setStreamMute(stream, mute);
    }
}
