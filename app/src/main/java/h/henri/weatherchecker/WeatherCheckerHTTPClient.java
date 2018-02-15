package h.henri.weatherchecker;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by henri on 14/02/2018.
 */

public class WeatherCheckerHTTPClient {

    private static String BASE_URL = "http://api.openweathermap.org/data/2.5/weather?q=";
    private String api_key = "f19445a739d4ac7835137f837e441d4b";

    public String getWeatherData(String location)
    {
        HttpURLConnection connection = null;
        InputStream is = null;

        try
        {
            connection = (HttpURLConnection) (new URL(BASE_URL + location + "&APPID=" + api_key)).openConnection();
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.connect();

            //Reads response:
            StringBuffer strBuffer = new StringBuffer();
            is = connection.getInputStream();
            BufferedReader bReader = new BufferedReader(new InputStreamReader(is));
            String line = null;

            while ((line = bReader.readLine()) != null)
            {
                strBuffer.append(line + "\r\n");
            }

            is.close();
            connection.disconnect();
            return strBuffer.toString();

        }

        catch (Throwable t)
        {
            t.printStackTrace();
        }

        finally
        {
            try{is.close();}catch (Throwable t){}
            try{connection.disconnect();} catch (Throwable t){}
        }

        return null;
    }
}
