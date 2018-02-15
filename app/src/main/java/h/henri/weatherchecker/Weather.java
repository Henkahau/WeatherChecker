package h.henri.weatherchecker;

import android.util.Log;

/**
 * Created by henri on 14/02/2018.
 */

public class Weather {

    private double temperature;
    private double wind;
    private double clouds;
    private String description;


    public void setTemperature(double givenTemp)
    {
        this.temperature = givenTemp;
    }

    public double getTemperature()
    {
        return temperature;
    }

    public void setDescription(String givenDesc)
    {
        description = givenDesc;
    }

    public String getDescription()
    {
        return description;
    }

    public void setWind(double givenWind)
    {
       this.wind = givenWind;

    }

    public double getWind()
    {
        return wind;
    }

    public void setClouds(double givenClouds)
    {
        clouds = givenClouds;
    }

    public double getClouds()
    {
        return clouds;
    }
}
