package h.henri.weatherchecker;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import javax.xml.transform.Result;

public class WeatherCheckActivity extends AppCompatActivity {

    String location;
    TextView tvTemp;
    TextView tvLocation;
    TextView tvWind;
    TextView tvClouds;
    //Double temperature;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_check);

        Bundle extras = getIntent().getExtras();

        tvTemp = (TextView) findViewById(R.id.tvTemp);
        tvLocation = (TextView) findViewById(R.id.tvLocation);
        tvWind = (TextView) findViewById(R.id.tvWind);
        tvClouds = (TextView) findViewById(R.id.tvClouds);

        location = extras.getString("keyLocation");
        tvLocation.setText(location);
        new GetWeather().execute();
    }

    private class GetWeather extends AsyncTask<String, Void, Weather>
    {/*
        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
            Toast.makeText(WeatherCheckActivity.this,
                    "@strings/getting_data", Toast.LENGTH_LONG).show();
        }
*/
        @Override
        protected Weather doInBackground(String...arg0)
        {
            Weather oWeather = new Weather();
            WeatherCheckerHTTPClient weatherClient = new WeatherCheckerHTTPClient();

            String weatherJSON = weatherClient.getWeatherData(location);

            if(weatherJSON != null)
            {
                try
                {
                    oWeather = WeatherCheckerJSONParser.GetWeather(weatherJSON);
                }
                catch (final JSONException e)
                {
                    Log.e("JSON parsing error:", e.getMessage());
                }
            }

            return oWeather;
        }

        @Override
        protected  void onPostExecute(Weather weather)
        {
            super.onPostExecute(weather);

            tvTemp.setText("Temperature: " + (weather.getTemperature() - 273.15) + " celcius");
            tvClouds.setText("Clouds" + weather.getClouds() + "%");
            tvWind.setText("Wind: " + weather.getWind() + "m/s");

        }
    }
}
