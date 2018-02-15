package h.henri.weatherchecker;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText editText;
    Button searchButton;
    String locationStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.locationET);
        searchButton = (Button) findViewById(R.id.search_button);

        if(editText.getText() == null)
            searchButton.setActivated(false);

        searchButton.setOnClickListener(this);
    }


    public void onClick(View view)
    {
        Button btn;

        if(view instanceof Button)
        {
            btn = (Button) view;

            if (btn.getId() == R.id.search_button)
            {
                //send given location to WeatherCheckActivity
                locationStr = editText.getText().toString();
                Intent intent = new Intent(this, WeatherCheckActivity.class);
                intent.putExtra("keyLocation", locationStr);
                startActivity(intent);
            }
        }
    }


}
