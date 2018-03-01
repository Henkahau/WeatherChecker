package h.henri.weatherchecker;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
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
    TextView tvDesc;
    WeatherCheckView weatherView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_check);

        Bundle extras = getIntent().getExtras();

        tvTemp = (TextView) findViewById(R.id.tvTemp);
        tvLocation = (TextView) findViewById(R.id.locationTV);
        tvWind = (TextView) findViewById(R.id.tvWind);
        tvClouds = (TextView) findViewById(R.id.tvClouds);
        tvDesc = (TextView) findViewById(R.id.tvDesc);

        location = extras.getString("keyLocation");


        new GetWeather().execute();
    }


    private class GetWeather extends AsyncTask<String, Void, Weather>
    {
        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
            Toast.makeText(WeatherCheckActivity.this,
                    R.string.get_data, Toast.LENGTH_LONG).show();
        }

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

           setWeatherView(weather);

        }
    }

    private void setWeatherView(Weather weather)
    {
        weatherView = (WeatherCheckView) findViewById(R.id.weatherView);
        weatherView.SetWeatherID(weather.getDescriptionID());
        tvLocation.setText(weather.getLocation());
        tvTemp.setText((float)Math.round(weather.getTemperature() - 273.15) + "°C");
        tvClouds.setText("Clouds: " + weather.getClouds() + "%");
        tvWind.setText("Wind: " + weather.getWind() + "m/s");
        tvDesc.setText(weather.getDescription());
    }

}
