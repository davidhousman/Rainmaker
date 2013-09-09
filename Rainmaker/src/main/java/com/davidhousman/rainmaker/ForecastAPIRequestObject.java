package com.davidhousman.rainmaker;

import android.location.Location;

/**
 * Created by brittanyking on 9/3/13.
 */
public class ForecastAPIRequestObject {



    private Double mLatitude;
    private Double mLongitude;
    private String mURl = "https://api.forecast.io/forecast/";
    private String mAPI_KEY = "9d38b0e9ca5a630d5b2fadb7160c52bc";
    private Location myLocation;


    public ForecastAPIRequestObject(Location terrible){

        setMyLocation(terrible);
    }



    public Location getMyLocation() {

        return myLocation;
    }

    public void setMyLocation(Location getMyLocation) {

        this.myLocation = getMyLocation;
        mLatitude = myLocation.getLatitude();
        mLongitude = myLocation.getLongitude();

    }



    public String getAssembledURL(){
        String davesUrl = mURl + mAPI_KEY + "/" + mLatitude.toString() + "," + mLongitude.toString();

        return davesUrl;


    }


    public Double getmLatitude() {
        return mLatitude;
    }

    public void setmLatitude(Double mLatitude) {
        this.mLatitude = mLatitude;
    }

    public Double getmLongitude() {
        return mLongitude;
    }

    public void setmLongitude(Double mLongitude) {
        this.mLongitude = mLongitude;
    }

    public String getmURl() {
        return mURl;
    }

    public void setmURl(String mURl) {
        this.mURl = mURl;
    }

    public String getmAPI_KEY() {
        return mAPI_KEY;
    }

    public void setmAPI_KEY(String mAPI_KEY) {
        this.mAPI_KEY = mAPI_KEY;
    }
}
