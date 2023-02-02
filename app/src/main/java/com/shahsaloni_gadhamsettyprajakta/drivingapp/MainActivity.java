package com.shahsaloni_gadhamsettyprajakta.drivingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {

        RelativeLayout logScreen;
        TableLayout tableLayout;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            logScreen = findViewById(R.id.log_screen);
            tableLayout = (TableLayout) findViewById(R.id.log_table);

        }

        public void startDriving(View view) {
                Intent intent = new Intent(getApplicationContext(), Driving.class);
                startActivity(intent);
        }

        public void viewLog(View view) {
                Intent intent = new Intent(getApplicationContext(), Log.class);
                startActivity(intent);
        }

        public void shareSheet(View view) {
            //Bitmap bitmap = Bitmap.createBitmap(logScreen.getWidth(), logScreen.getHeight(), Bitmap.Config.ARGB_8888);
            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            //shareIntent.putExtra(Intent.EXTRA_STREAM, bitmap);
            shareIntent.setType("application/pdf");
            startActivity(Intent.createChooser(shareIntent, null));
        }
}