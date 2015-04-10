package org.hierro.intentpassingprimitive;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {
    private static final int PLAY_GAME = 1010;
    private TextView tv;
    private int meaningOfLife = 42;
    private String userName = "Douglas Adams";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.startscreen_text);
        //Display initial values
        tv.setText(userName + ":" + meaningOfLife);
        //Set up button listener
        Button startButton = (Button) findViewById(R.id.play_game);
        startButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startGame();
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
    protected void onActivityResult(int requestCode,
                                    int resultCode, Intent data) {
        if (requestCode == PLAY_GAME && resultCode == RESULT_OK) {
            meaningOfLife = data.getExtras().getInt("returnInt");
            userName = data.getExtras().getString("returnStr");
            //Show it has changed
            tv.setText(userName + ":" + meaningOfLife);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void startGame() {
        Intent launchGame = new Intent(this, PlayGame.class);
        //passing information to launched activity
        launchGame.putExtra("meaningOfLife", meaningOfLife);
        launchGame.putExtra("userName", userName);
        startActivityForResult(launchGame, PLAY_GAME);
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
