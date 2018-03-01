package h.henri.weatherchecker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.constraint.solver.widgets.Rectangle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import h.henri.weatherchecker.Weather;

/**
 * Created by henri on 19/02/2018.
 */

public class WeatherCheckView extends View{

    Weather weather = new Weather();
    private int view_center_x = 0;
    private int view_center_y = 0;
    private int weatherID;
    private float temp = 0;

    public WeatherCheckView (Context context)
    {
        super(context);
    }

    public WeatherCheckView (Context context, AttributeSet attributes)
    {
        super(context, attributes);


    }

    public void onSizeChanged( int current_width_of_this_view,
                               int current_height_of_this_view,
                               int old_width_of_this_view,
                               int old_height_of_this_view )
    {
        view_center_x = current_width_of_this_view / 2;
        view_center_y = current_height_of_this_view / 2;

    }

    public void SetWeatherID(int id)
    {
        weatherID = id;
        invalidate();
    }

    //Set the icon by weather id
    public Bitmap WeatherIcon()
    {
        Bitmap bitmap;

        Resources res = getResources();

        //ICON FOR THUNDER
        if(weatherID >= 200 && weatherID <= 232)
        {
            bitmap = BitmapFactory.decodeResource(res, R.drawable._lightning);
            return bitmap;
        }
        //ICONS FOR DIFFERENT RAIN TYPES
        if(weatherID >= 300 && weatherID <= 321)
        {
            bitmap = BitmapFactory.decodeResource(res, R.drawable._semi_rain);
            return bitmap;
        }
        if(weatherID == 500)
        {
            bitmap = BitmapFactory.decodeResource(res, R.drawable._light_rain);
            return bitmap;
        }
        if(weatherID == 501)
        {
            bitmap = BitmapFactory.decodeResource(res, R.drawable._semi_rain);
            return bitmap;
        }
        if(weatherID >= 502 && weatherID <= 531 )
        {
            bitmap = BitmapFactory.decodeResource(res, R.drawable._hard_rain);
            return bitmap;
        }

        //ICONS FOR SNOW AND SLEET
        if(weatherID == 600)
        {
            bitmap = BitmapFactory.decodeResource(res, R.drawable._light_snow);
            return bitmap;
        }
        if(weatherID == 601)
        {
            bitmap = BitmapFactory.decodeResource(res, R.drawable._snow);
            return bitmap;
        }
        if(weatherID == 602)
        {
            bitmap = BitmapFactory.decodeResource(res, R.drawable._snow);
            return bitmap;
        }
        if(weatherID >=612 && weatherID <= 622 )
        {
            bitmap = BitmapFactory.decodeResource(res, R.drawable._sleet);
            return bitmap;
        }

        //ICON FOR MIST
        if(weatherID >700 && weatherID <= 781 )
        {
            bitmap = BitmapFactory.decodeResource(res, R.drawable._mist);
            return bitmap;
        }
        //ICON FOR CLEAR SKY
        if(weatherID == 800)
        {
            bitmap = BitmapFactory.decodeResource(res, R.drawable._sunny);
            return bitmap;
        }
        //ICONS FOR CLOUDS
        if(weatherID == 801)
        {
            bitmap = BitmapFactory.decodeResource(res, R.drawable._mostly_sunny);
            return bitmap;
        }
        if(weatherID == 802)
        {
            bitmap = BitmapFactory.decodeResource(res, R.drawable._partial_cloud);
            return bitmap;
        }
        if(weatherID >=803 && weatherID <= 804 )
        {
            bitmap = BitmapFactory.decodeResource(res, R.drawable._cloudy);
            return bitmap;
        }

        else
        {
            bitmap = BitmapFactory.decodeResource(res, R.drawable._sunny);
            return bitmap;
        }

    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        RectF rect = new RectF();
        rect.set(0,0,view_center_x * 2,view_center_y * 2);

        canvas.drawBitmap(WeatherIcon(), null, rect, null);

    }
}
