package org.hierro.notification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {
    private NotificationManager mNManager;
    private static final int NOTIFY_ID = 1100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String ns = Context.NOTIFICATION_SERVICE;
        mNManager = (NotificationManager) getSystemService(ns);
        final Notification msg = new Notification(R.drawable.ic_launcher,
                "New event of importance",
                System.currentTimeMillis());
        Button start = (Button) findViewById(R.id.start);
        Button cancel = (Button) findViewById(R.id.cancel);
        start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Context context = getApplicationContext();
                CharSequence contentTitle = "ShowNotification Example";
                CharSequence contentText = "Browse Android Cookbook Site";
                Intent msgIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.pearson.com"));
                PendingIntent intent =
                        PendingIntent.getActivity(MainActivity.this,
                                0, msgIntent,
                                Intent.FLAG_ACTIVITY_NEW_TASK);
                msg.defaults |= Notification.DEFAULT_SOUND;
                msg.flags |= Notification.FLAG_AUTO_CANCEL;
                msg.setLatestEventInfo(context,
                        contentTitle, contentText, intent);
                mNManager.notify(NOTIFY_ID, msg);
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mNManager.cancel(NOTIFY_ID);
            }
        });

        /********************** NEW WAY     WITH PIC********************/
        Button startBigPic = (Button) findViewById(R.id.startBigPic);
        Button stopBigPic = (Button) findViewById(R.id.stopBigPic);
        startBigPic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Context context = getApplicationContext();
                CharSequence contentTitle = "Show Big Notification Example";
                CharSequence contentText = "Browse Android Cookbook Site";
                Intent msgIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.pearson.com"));
                PendingIntent intent =
                        PendingIntent.getActivity(MainActivity.this,
                                0, msgIntent,
                                Intent.FLAG_ACTIVITY_NEW_TASK);
                NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
                builder.setSmallIcon(R.drawable.ic_launcher);
                builder.setContentTitle(contentTitle);
                builder.setContentText(contentText);
                builder.setContentIntent(intent);
                NotificationCompat.BigPictureStyle pictureStyle = new
                        NotificationCompat.BigPictureStyle();
                Bitmap bigPicture = BitmapFactory.decodeResource(getResources(),
                        R.drawable.ic_launcher);
                pictureStyle.bigPicture(bigPicture);
                builder.setStyle(pictureStyle);
//                builder.setDefaults(NotificationCompat.DEFAULT_VIBRATE);
                builder.setDefaults(NotificationCompat.DEFAULT_SOUND);

                mNManager.notify(NOTIFY_ID + 1, builder.build());
            }
        });
        stopBigPic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mNManager.cancel(NOTIFY_ID + 1);
            }
        });

        /********************** NEW WAY     WITH TEXT********************/
        Button startInbox = (Button) findViewById(R.id.startInbox);
        Button stopInbox = (Button) findViewById(R.id.stopInbox);
        startInbox.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Context context = getApplicationContext();
                CharSequence contentTitle = "Show Big Notification Example";
                CharSequence contentText = "Browse Android Cookbook Site";
                Intent msgIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.pearson.com"));
                PendingIntent intent =
                        PendingIntent.getActivity(MainActivity.this,
                                0, msgIntent,
                                Intent.FLAG_ACTIVITY_NEW_TASK);
                NotificationCompat.Builder builder =
                        new NotificationCompat.Builder(context);
                builder.setSmallIcon(R.drawable.ic_launcher);
                builder.setContentTitle(contentTitle);
                builder.setContentText(contentText);
                NotificationCompat.InboxStyle inboxStyle =
                        new NotificationCompat.InboxStyle();
                for (int i = 0; i < 4; i++) {
                    inboxStyle.addLine("subevent #" + i);
                }
                builder.setStyle(inboxStyle);
                builder.setContentIntent(intent);
                mNManager.notify(NOTIFY_ID + 2, builder.build());
            }
        });
        stopInbox.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mNManager.cancel(NOTIFY_ID + 2);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
