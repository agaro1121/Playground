package org.hierro.serviceforeground;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class SimpleService extends Service {
    private static final int NOTIFICATION_ID = 1;
    public SimpleService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    boolean paused = false;
    @Override
    public void onCreate() {
        super.onCreate();
        enforceForegroundMode();
        Toast.makeText(this, "Service created ...", Toast.LENGTH_LONG).show();
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
        releaseForegroundMode();
        Toast.makeText(this, "Service destroyed ...", Toast.LENGTH_LONG).show();
        paused = true;
    }
    private final void enforceForegroundMode() {
        startForeground(NOTIFICATION_ID, getForegroundNotification());
    }
    private final void releaseForegroundMode(){
        stopForeground(true);
    }

    protected Notification getForegroundNotification(){
// Set the icon, scrolling text, and timestamp
        Notification notification = new Notification(R.drawable.ic_launcher,
                "playback running",System.currentTimeMillis());
// the PendingIntent to launch the activity if the user selects this notification
        Intent startIntent=new Intent(getApplicationContext(),SimpleService.class);
        startIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, startIntent, 0);
// Set the info for the views that show in the notification panel
        notification.setLatestEventInfo(
                this,
                "Playing Music",
                "Playback running",
                contentIntent
        );
        return notification;
    }
    int[] notes = {R.raw.c5, R.raw.b4, R.raw.a4, R.raw.g4};
    int NOTE_DURATION = 400; //millisec
    MediaPlayer m_mediaPlayer;
    private void play_music() {
        for(int ii=0; ii<12; ii++) {
//Check to ensure main activity not paused
            if(!paused) {
                if(m_mediaPlayer != null) {m_mediaPlayer.release();}
                m_mediaPlayer = MediaPlayer.create(this, notes[ii%4]);
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
