package org.hierro.threadsmusic;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startButton = (Button) findViewById(R.id.trigger);
        startButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
        //Stand-alone play_music() function call causes
        //main thread to hang. Instead, create
        //separate thread for time-consuming task.
                Thread initBkgdThread = new Thread(new Runnable() {
                    public void run() {
                        play_music();
                    }
                });
                initBkgdThread.start();
            }
        });
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

    boolean paused = false;
    @Override
    protected void onPause() {
        paused = true;
        super.onPause();
    }
    @Override
    protected void onResume() {
        super.onResume();
        paused = false;
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
