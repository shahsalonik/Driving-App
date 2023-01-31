package com.shahsaloni_gadhamsettyprajakta.drivingapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TableLayout;

import androidx.annotation.Nullable;

public class Log extends Activity {

    Button exportLog = findViewById(R.id.export_button);
    RelativeLayout logScreen = findViewById(R.id.log_screen);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log);
    }

    public void back(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    public void shareSheet (View view) {
        Bitmap bitmap = Bitmap.createBitmap(logScreen.getWidth(), logScreen.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_STREAM, bitmap);
        shareIntent.setType("image/jpeg");
        startActivity(Intent.createChooser(shareIntent, null));
    }
}
