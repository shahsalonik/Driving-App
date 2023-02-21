package com.shahsaloni_gadhamsettyprajakta.drivingapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;

import com.mapbox.maps.MapView;
import com.mapbox.maps.Style;

public class Driving extends Activity implements LifecycleOwner {
    private Chronometer chronometer;
    private long pauseOffset;
    public boolean running;
    public MapView mapview;
    private final LifecycleRegistry lifecycleRegistry = new LifecycleRegistry (this);

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

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return lifecycleRegistry;
    }
}
