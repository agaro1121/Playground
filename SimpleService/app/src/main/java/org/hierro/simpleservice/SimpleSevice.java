package org.hierro.simpleservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class SimpleSevice extends Service {
    boolean paused = false;

    public SimpleSevice() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "Service created ...",
                Toast.LENGTH_LONG).show();
        paused = false;
        Thread initBkgdThread = new Thread(new Runnable() {
            public void run() {
                play_music();
            }
        });
        initBkgdThread.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service destroyed ...",
                Toast.LENGTH_LONG).show();
        paused = true;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    int[] notes = {R.raw.c5, R.raw.b4, R.raw.a4, R.raw.g4};
    int NOTE_DURATION = 400; //millisec
    MediaPlayer m_mediaPlayer;

    private void play_music() {
        for (int ii = 0; ii < 12; ii++) {
    //Check to ensure main activity not paused
            if (!paused) {
                if (m_mediaPlayer != null) {
                    m_mediaPlayer.release();
                }
                m_mediaPlayer = MediaPlayer.create(this, notes[ii % 4]);
                m_mediaPlayer.start();
                try {
                    Thread.sleep(NOTE_DURATION);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
