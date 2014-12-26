package com.example.selvarag.calculatedistance;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends Activity {

    private TextView distance,time,person;
    private HandleJSON obj;
    private String names="", dists="", times="";  //Stores list of names, distance from destination and time to reach of respective person

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        distance = (TextView)findViewById(R.id.textDist);
        time = (TextView)findViewById(R.id.textTime);
        person = (TextView)findViewById(R.id.textName);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void open(View view){

        names="";dists="";times="";
        Inputs ips = new Inputs();                  //Class in which receiving inputs from server is implemented
        String source = ips.getSource();
        ArrayList<String> locs = ips.getLocs();     //Contains location of other participants

        for(int i=0;i<5;i++) {
            String url = "http://maps.googleapis.com/maps/api/directions/json?origin="+source+"&destination="+locs.get(i);
            obj = new HandleJSON(url);
            obj.fetchJSON();
            while (obj.parsingComplete) ;
            names += "Person"+" "+Integer.toString(i+1)+"\n";
            //names += ips.getNames(i);
            dists += obj.getDistanceNow()+"\n";
            times += obj.getTimeToday()+"\n";
            obj = null;
        }

        person.setText(names);
        distance.setText(dists);
        time.setText(times);
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
