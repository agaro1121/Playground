package org.hierro.serviceintentservice;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

public class SimpleIntentService extends IntentService {
    Notification notification=null;
    private NotificationManager mNManager;

    public SimpleIntentService() {
        super("SimpleIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        createNotification();
        if(intent.hasExtra("msg")){
            updateNotification(intent.getStringExtra("msg"));
            mNManager.notify(1, notification);
        }
    }

    protected void createNotification(){
        if(mNManager==null){
            mNManager = (NotificationManager)
                    getSystemService(Context.NOTIFICATION_SERVICE);
        }
        notification = new Notification(
                R.drawable.ic_launcher,
                "New event of importance",
                System.currentTimeMillis());
        // Set the icon, scrolling text, and timestamp
    }

    protected void updateNotification(final String text){
// the PendingIntent to launch the activity if the user
// selects this notification
        Intent startIntent=new Intent(getApplicationContext(),MainActivity.class);
        PendingIntent contentIntent =
                PendingIntent.getActivity(this, 0,startIntent, 0);
// Set the info for the views that show in the notification panel
        notification.setLatestEventInfo(
                this,
                "Message received",
                text,
                contentIntent
        );
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
