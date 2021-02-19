package com.example.sensordown;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SensorManager snsManger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView accel, heart;

        final SensorManager snsManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);

        accel = new TextView(this);
        heart = new TextView(this);

        if (snsManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER ) != null){
            accel.setText("Accelerometre present sur ce telephone");
        }else{
            accel.setText("Accelerometre indisponible, fonctionnalite desactivee");
        }

        if (snsManager.getDefaultSensor(Sensor.TYPE_HEART_BEAT ) != null){
            heart.setText("Capteur de battement de coeur present");
        }else{
            heart.setText("Capteur de battements de coeur absent, fonctionnalite desactivee");
        }

        ll.addView(accel);
        ll.addView(heart);

        setContentView(ll);
    }
}