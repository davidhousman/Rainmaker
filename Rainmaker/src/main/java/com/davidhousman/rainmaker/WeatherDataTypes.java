package com.davidhousman.rainmaker;

/**
 * Created by brittanyking on 9/3/13.
 */
public class WeatherDataTypes {

    private Double mApparentTemperature;
    private Double mHumidity;
    private String mSummary;
    private Double mTemperature;




    public Double getmApparentTemperature() {
        return mApparentTemperature;
    }

    public String getmApparentTemperatureString(){
        return mApparentTemperature.toString();
    }

    public void setmApparentTemperature(Double mApparentTemperature) {
        this.mApparentTemperature = mApparentTemperature;
    }

    public Double getmHumidity() {
        return mHumidity;
    }

    public String getmHumidityString(){
        return mHumidity.toString();
    }

    public void setmHumidity(Double mHumidity) {
        this.mHumidity = mHumidity;
    }

    public String getmSummary() {
        return mSummary;
    }

    public void setmSummary(String mSummary) {
        this.mSummary = mSummary;
    }

    public Double getmTemperature() {
        return mTemperature;
    }

    public String getmtemperatureString(){
        return mTemperature.toString();
    }

    public void setmTemperature(Double mTemperature) {
        this.mTemperature = mTemperature;
    }


}
