package com.davidhousman.rainmaker;


import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;


/**
 * Created by davidhousman on 8/30/13.
 */
public class UserLocationManager implements LocationListener {

    public DisplayWeatherActivity myFriendDisplayWeatherActivity;
    private PopulateWeatherTask mPopulateDataTask;
    public LocationManager locationManager;

    //step 4
    public UserLocationManager(PopulateWeatherTask fuzzy){
        super();

        mPopulateDataTask = fuzzy;
        //going to register for GPS events right here.
        locationManager = (LocationManager) mPopulateDataTask.myFriendDisplayWeatherActivity.getSystemService(Context.LOCATION_SERVICE);


        try{
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,this);

        }catch(Exception e){

            e.printStackTrace();
        }

    }




    public UserLocationManager (DisplayWeatherActivity a){

        myFriendDisplayWeatherActivity = a;

    }


    //step 5
    @Override
    public void onLocationChanged(Location location) {

         //ill be told the location here
        mPopulateDataTask.receiveUserLocation(location);
        locationManager.removeUpdates(this);
        locationManager = null;
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
