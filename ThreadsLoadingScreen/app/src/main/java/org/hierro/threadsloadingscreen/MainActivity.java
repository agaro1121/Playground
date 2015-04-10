package org.hierro.threadsloadingscreen;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity implements Runnable{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading);

        Thread thread = new Thread(this);
        thread.start();
    }


    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            setContentView(R.layout.activity_main);
        }
    };

    public void run() {
        initializeArrays();
        mHandler.sendEmptyMessage(0);
    }

    final static int NUM_SAMPS = 3000;
    static double[][] correlation;

    void initializeArrays() {
        if (correlation != null) return;
        correlation = new double[NUM_SAMPS][NUM_SAMPS];
//calculation
        for (int k = 0; k < NUM_SAMPS; k++) {
            for (int m = 0; m < NUM_SAMPS; m++) {
                correlation[k][m] = Math.cos(2 * Math.PI * (k + m) / 1000);
            }
        }
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
