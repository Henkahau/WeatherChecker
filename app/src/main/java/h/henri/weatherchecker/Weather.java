package h.henri.weatherchecker;

import android.util.Log;

/**
 * Created by henri on 14/02/2018.
 */

public class Weather {

    private double temperature;
    private double wind;
    private double clouds;
    private String location;
    private String description;
    private int descriptionID;


    public void setTemperature(double givenTemp)
    {
        this.temperature = givenTemp;
    }

    public double getTemperature()
    {
        return temperature;
    }

    public void setDescriptionID(int givenDesc)
    {
        this.descriptionID = givenDesc;
    }

    public int getDescriptionID()
    {
        return descriptionID;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String desc)
    {
        description = desc;
    }

    public void setWind(double wind)
    {
       this.wind = wind;

    }

    public double getWind()
    {
        return wind;
    }

    public void setClouds(double givenClouds)
    {
        this.clouds = givenClouds;
    }

    public double getClouds()
    {
        return clouds;
    }

    public void setLocation(String loc)
    {
        this.location = loc;
    }

    public String getLocation()
    {
        return location;
    }
}
