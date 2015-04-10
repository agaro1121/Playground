package org.hierro.implicitintent;

import android.app.Activity;
import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends ListActivity {
    private static final String[] ACTIVITY_CHOICES = new String[]{"Open Website Example", "Open Contacts",
            "Open Phone Dialer Example", "Search Google Example", "Start Voice Command"};
    private final String searchTerms = "batman";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ACTIVITY_CHOICES));

        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        getListView().setTextFilterEnabled(true);
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch ((int) id) {
                    case 0: //Opens web browser and navigates to given website
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.android.com")));
                        break;
                    case 1: //opens contacts application to browse contacts
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/")));
                        break;
                    case 2: //opens phone dialer and fills in the given number
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("tel:12125559999")));
                        break;
                    case 3: //search Google for the string
                        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                        intent.putExtra(SearchManager.QUERY, searchTerms);
                        startActivity(intent);
                        break;
                    case 4: //starts the voice command
                        startActivity(new Intent(Intent.ACTION_VOICE_COMMAND));
                        break;
                    default: break;
                }
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
