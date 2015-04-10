package org.hierro.threadbackgroundtimer;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {
    //Keep track of button presses, a main thread task
    private int buttonPress=0;
    TextView mButtonLabel;
    //counter of time since app started, a background task
    private long mStartTime = 0L;
    private TextView mTimeLabel;
    //handler to handle the message to the timer task
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTimeLabel = (TextView) findViewById(R.id.text);
        mButtonLabel = (TextView) findViewById(R.id.trigger);

        if (mStartTime == 0L) {
            mStartTime = SystemClock.uptimeMillis();
            mHandler.removeCallbacks(mUpdateTimeTask);
            mHandler.postDelayed(mUpdateTimeTask, 100);
        }
        /**
         ***Code below is interchangeable with above IF statement --hasn't been tested though
         new CountDownTimer(30000, 1000) {
         public void onTick(long millisUntilFinished) {
         mTimeLabel.setText("seconds remaining: "
         + millisUntilFinished / 1000);
         }
         public void onFinish() {
         mTimeLabel.setText("done!");
         }
         }.start();
         */

        Button startButton = (Button) findViewById(R.id.trigger);
        startButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                mButtonLabel.setText("Pressed " + ++buttonPress
                        + " times");
            }
        });
    }

    private Runnable mUpdateTimeTask = new Runnable() {
        public void run() {
            final long start = mStartTime;
            long millis = SystemClock.uptimeMillis() - start;
            int seconds = (int) (millis / 1000);
            int minutes = seconds / 60;
            seconds = seconds % 60;
            int hours = minutes/60;
            mTimeLabel.setText(hours+":" + minutes + ":"
                    + String.format("%02d",seconds));
            mHandler.postDelayed(this, 200);
        }
    };
    @Override
    protected void onPause() {
        mHandler.removeCallbacks(mUpdateTimeTask);
        super.onPause();
    }
    @Override
    protected void onResume() {
        super.onResume();
        mHandler.postDelayed(mUpdateTimeTask, 100);
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
