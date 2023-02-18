package com.shahsaloni_gadhamsettyprajakta.drivingapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.mapbox.maps.MapView;
import com.mapbox.maps.Style;

import java.util.Timer;
import java.util.TimerTask;

public class Driving extends Activity {
    private Chronometer chronometer;
    private long pauseOffset;
    public boolean running;
    public MapView mapview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.driving);
        mapview = findViewById(R.id.mapView);
        mapview.getMapboxMap().loadStyleUri(Style.MAPBOX_STREETS);
        chronometer = findViewById(R.id.chronometer);
    }

    public void stopDriving(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        chronometer.setBase(SystemClock.elapsedRealtime());
        pauseOffset = 0;
    }

    public void startChronometer(View view) {
        if (!running) {
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
            chronometer.start();
            running = true;
        }
    }

    public void pauseChronometer(View view) {
        if (running) {
            chronometer.stop();
            pauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase();
            running = false;
        }
    }

}
