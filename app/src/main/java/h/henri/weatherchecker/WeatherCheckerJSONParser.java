package h.henri.weatherchecker;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by henri on 14/02/2018.
 */

public class WeatherCheckerJSONParser {



    public static Weather GetWeather(String data) throws JSONException
    {
        Weather oWeather = new Weather();

        JSONObject jObject = new JSONObject(data);

        //Get temperature
        JSONObject main = jObject.getJSONObject("main");
        oWeather.setTemperature(main.getDouble("temp"));

        //Get wind
        JSONObject wind = jObject.getJSONObject("wind");
        oWeather.setWind(wind.getDouble("speed"));

        //Get weather descriptionID
        JSONArray weather = jObject.getJSONArray("weather");
        JSONObject descriptionID = weather.getJSONObject(0);
        oWeather.setDescriptionID(descriptionID.getInt("id"));

        //Get weather description
        JSONObject description = weather.getJSONObject(0);
        oWeather.setDescription(description.getString("main"));

        //Get clouds %
        JSONObject clouds = jObject.getJSONObject("clouds");
        oWeather.setClouds(clouds.getDouble("all"));

        //Get location
        oWeather.setLocation(jObject.getString("name"));

        return oWeather;
    }


}
