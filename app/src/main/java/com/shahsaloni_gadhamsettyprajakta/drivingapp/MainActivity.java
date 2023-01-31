package com.shahsaloni_gadhamsettyprajakta.drivingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {

        Chronometer chronometer;
        ButtonBarLayout start, pause;
        long pauseOffset;
        boolean running;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            chronometer = (Chronometer) findViewById(R.id.chronometer);
            start = (ButtonBarLayout) findViewById(R.id.start_button);
            pause = (ButtonBarLayout) findViewById(R.id.pause_button);

            start.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                            if (!running) {
                                    chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
                                    chronometer.start();
                                    running = true;
                            }
                    }
            });

            pause.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                            if (running) {
                                    chronometer.stop();
                                    pauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase();
                                    running = false;
                            }
                    }
            });
        }

        public void startDriving(View view) {
                Intent intent = new Intent(getApplicationContext(), Driving.class);
                startActivity(intent);
        }

        public void viewLog(View view) {
                Intent intent = new Intent(getApplicationContext(), Log.class);
                startActivity(intent);
        }
}