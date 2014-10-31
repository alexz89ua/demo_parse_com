package com.stfalcon.demoparse;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.parse.Parse;
import com.parse.ParseAnalytics;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Parse.initialize(this, "y2cC0qr4NB4lyhXTNH6rAOfjXdSDTcRlVDn9CBWX", "cwIFp05Wn2hhtNwE4KdNudjZvXVzHZBLabRephHE");
        ParseAnalytics.trackAppOpened(getIntent());

        Map<String, String> dimensions = new HashMap<String, String>();
        // What type of news is this?
        dimensions.put("category", "politics");
        // Is it a weekday or the weekend?
        dimensions.put("dayType", "weekday");
        // Send the dimensions to Parse along with the 'read' event

        ParseAnalytics.trackEvent("read", dimensions);
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
