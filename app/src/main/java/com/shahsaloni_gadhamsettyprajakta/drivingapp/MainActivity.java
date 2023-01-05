package com.shahsaloni_gadhamsettyprajakta.drivingapp;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public int counter;
    @TargetApi(Build.VERSION_CODES.O)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView counttime = findViewById(R.id.counttime);
        new CountDownTimer(50000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                counttime.setText(String.valueOf(counter));
                counter++;
            }

            @Override
            public void onFinish() {
                counttime.setText("Finished");
            }
        }.start();
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