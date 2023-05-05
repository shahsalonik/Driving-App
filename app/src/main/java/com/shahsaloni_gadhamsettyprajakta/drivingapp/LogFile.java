package com.shahsaloni_gadhamsettyprajakta.drivingapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;

public class LogFile extends Activity {

    ListView listView;
    TextView textView;
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log);
        listView = findViewById(R.id.linearlayout);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, Driving.dataList);
        listView.setAdapter(arrayAdapter);
        //textView = findViewById(R.id.test_input2);
        //textView.setText(getIntent().getStringExtra("row"));
    }

    /*public void add(View view) {
        int id = 1;
        FrameLayout temp = new FrameLayout(this);
        linearLayout.addView(temp);
        temp.setId(id);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(id, new MessageFragment(date_string, 1, mins_string, (String) mileage.getText(), "temp"), String.valueOf(id));
        ft.commit();
        id++;
    }*/

    public void back(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    /*
    @Override
    protected void onResume() {
        super.onResume();
        for(int x = 0; x < Driving.sharedPreferences.getAll().size(); x++) {
            Driving.dataList.add(x, Driving.sharedPreferences.getString(String.valueOf(x), ""));
        }
    }*/

}
