package com.example.mendez26.a52_acelerometro;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private Sensor mysensor;
    private SensorManager senman;
    TextView ejex,ejey,ejez;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        senman = (SensorManager)getSystemService(SENSOR_SERVICE);
        mysensor = senman.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        ejex = (TextView)findViewById(R.id.ejex);
        ejey = (TextView)findViewById(R.id.ejey);
        ejez = (TextView)findViewById(R.id.ejez);

        senman.registerListener(this,mysensor,SensorManager.SENSOR_DELAY_NORMAL);

    }//onCreate

    public void onSensorChanged(SensorEvent event){
        ejex.setText("Eje x: "+event.values[0]);
        ejey.setText("Eje y: "+event.values[1]);
        ejez.setText("Eje z: "+event.values[2]);
    }//onSensorChanged

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy){
        //Sin hacer nada
    }//onAccuracyChanged

}//MainActivity
