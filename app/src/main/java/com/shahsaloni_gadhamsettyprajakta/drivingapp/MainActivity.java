package com.shahsaloni_gadhamsettyprajakta.drivingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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