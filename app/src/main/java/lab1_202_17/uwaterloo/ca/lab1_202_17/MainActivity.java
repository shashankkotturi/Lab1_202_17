package lab1_202_17.uwaterloo.ca.lab1_202_17;

// import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
// import android.view.View;
import android.widget.LinearLayout;
// import android.widget.RelativeLayout;
// import android.widget.TextClock;
import android.widget.TextView;

/*
public class MainActivity extends Activity {
    TextView globalView;
    TextView anotherGlobalView;

    public View onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        globalView = new TextView(getApplicationContext());
        anotherGlobalView = (TextView) findViewById(R.id.label1);
    }
}
*/


class LightSensorEventListener implements SensorEventListener{
    TextView output;

    public LightSensorEventListener(TextView outputView){
        output = outputView;
    }

    public void onAccuracyChanged(Sensor s, int i) {}

    public void onSensorChanged(SensorEvent se){
        if (se.sensor.getType() == Sensor.TYPE_LIGHT){
            // The variable se.values is an array of type int[] or double[]
            // The first value (se.values[0]) contains the value
            // of the light sensor. Store it somewhere useful

            output.setText("Light sensor: "+ String.format("%2f", se.values[0]));


        }
    }
}


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        TextView tv = (TextView) findViewById(R.id.label1);
//        tv.setText("I've replaced the label!");

        LinearLayout l = (LinearLayout) findViewById(R.id.lin_layout);
        l.setOrientation(LinearLayout.VERTICAL);
        TextView tv1 = new TextView(getApplicationContext());
        tv1.setText("This is text for variable tv1...");
        l.addView(tv1);

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        SensorEventListener lightSensor1 = new LightSensorEventListener(tv1);
        sensorManager.registerListener(lightSensor1, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);

    }
}