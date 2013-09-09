package com.davidhousman.rainmaker;

import android.location.Location;
import android.media.MediaPlayer;
import android.nfc.Tag;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class DisplayWeatherActivity extends Activity {

    //public UserLocationManager mMyPersonalLocationManager;
    //public PopulateWeatherTask myWeatherDataPopulator;
    public PopulateWeatherTask  getWeatherData;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.v("First", "Initializing sounds...");

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.huckle1);

        Button play_button = (Button)this.findViewById(R.id.button);
        play_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.v("Second", "Playing sound...");
                mp.start();
            }
        });
        Log.v("Third", "Sounds initialized.");



        //goGetUserLocation();
        goGetWeatherData();

    }

    private void updateDisplay(){

    }

    //the following two methods are used to start other asynchronous
    //processes outside of this activity.

      //step 1
      public void goGetWeatherData(){
            getWeatherData = new  PopulateWeatherTask(this);
      }

    public void receiveWeatherData(WeatherDataTypes myData){

        TextView Humidity = (TextView)findViewById(R.id.HU);
        Humidity.setText(myData.getmHumidityString());

        TextView Summary = (TextView)findViewById(R.id.Summary);
        Summary.setText(myData.getmSummary());

        TextView AppTemp = (TextView)findViewById(R.id.apparentTemp);
        AppTemp.setText(myData.getmApparentTemperatureString());

        //trying to set a text to a ImageView, found a different method to use.
        TextView Temp = (TextView)findViewById(R.id.imageView);
        Temp.setText(myData.getmtemperatureString());




        //ListView myView = (ListView) findViewById(R.layout.activity_main);


        //updateDisplay();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        //Inflate the menu; this adds the items to the action bar if present.
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }


}