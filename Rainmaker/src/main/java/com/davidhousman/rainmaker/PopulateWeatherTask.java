package com.davidhousman.rainmaker;

import android.location.Location;
import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;

/**
 * Created by brittanyking on 9/3/13.
 */
public class PopulateWeatherTask extends AsyncTask<ForecastAPIRequestObject,Integer,WeatherDataTypes>{
    UserLocationManager getLocationData;
    DisplayWeatherActivity myFriendDisplayWeatherActivity;

    //step 2
    public PopulateWeatherTask(DisplayWeatherActivity activity){
        super();
        myFriendDisplayWeatherActivity = activity;
        goGetLocation();

    }

    //step 3
    public void goGetLocation(){
         getLocationData = new UserLocationManager(this);
    }





    //step 6
    public void receiveUserLocation(Location location){
        ForecastAPIRequestObject forecastAPIRequestObject = new ForecastAPIRequestObject(location);
        //old way - forecastAPIRequestObject.setMyLocation(terrible);
        this.execute(forecastAPIRequestObject);


   }

    @Override
    protected WeatherDataTypes doInBackground(ForecastAPIRequestObject... forecastAPIRequestObjects) {
        //get the information that we need from the API

        WeatherDataTypes myData = new WeatherDataTypes();
            HttpClient httpClient = new DefaultHttpClient();

            try {
            HttpGet g = new HttpGet(forecastAPIRequestObjects[0].getAssembledURL());

            HttpResponse httpResponse = httpClient.execute(g);
            StatusLine statusLine = httpResponse.getStatusLine();
            if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                httpResponse.getEntity().writeTo(out);
                out.close();
                String responseString = out.toString();

                //create a WeatherDataTypes object

                //parse the data from the api using JSONObject methods

                JSONObject rootJSON = new JSONObject(responseString);
                JSONObject currentlyJSON = rootJSON.getJSONObject("currently");

                //and put that data in the WeatherDataTypes(the fast way)
                myData.setmApparentTemperature(currentlyJSON.getDouble("apparentTemperature"));
                myData.setmHumidity(currentlyJSON.getDouble("humidity"));
                myData.setmTemperature(currentlyJSON.getDouble("temperature"));
                myData.setmSummary(currentlyJSON.getString("summary"));


            } else {
                httpResponse.getEntity().getContent().close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return myData;//return a WeatherDataTypes Object
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(WeatherDataTypes weatherDataTypes) {
        //gets the result of doInBackground as a WeatherDataTypes Object

        //put the data somewhere else to display it.
        super.onPostExecute(weatherDataTypes);

        myFriendDisplayWeatherActivity.receiveWeatherData(weatherDataTypes);

    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }
}
