package chart.circle.lln;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ChartCircle chart = findViewById(R.id.chartCircle);

        chart.setOnClickListener(view -> chart.setPercentage(new Random().nextInt(100), true));

        //COLOR PROVIDER
        chart.setColorProvider(value -> {
            String color = "#33FFCC";

            /*if (value <= 25)
                color = "#F44336";
            else if (value <= 50)
                color = "#FFB300";
            else if (value <= 75)
                color = "#00E676";
            else
                color = "#18FFFF";*/

            return Color.parseColor(color);
        });

        //PROGRESS CHANGE LISTENER
        chart.setOnProgressChangeListener(new ChartCircle.OnProgressChangeListener() {
            @Override
            public void onProgressChanged(float progress) {
                Log.d(TAG, String.valueOf(progress));
            }
        });
    }
}
