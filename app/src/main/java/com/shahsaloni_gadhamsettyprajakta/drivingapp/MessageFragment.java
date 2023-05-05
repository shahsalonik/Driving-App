package com.shahsaloni_gadhamsettyprajakta.drivingapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

public class MessageFragment extends Fragment {

    String date;
    String session_num;
    String minutes;
    String mileage;
    String night_mins = "temp";
    View view;

    public MessageFragment() {}

    public MessageFragment(String date, String session_num, String minutes, String mileage, String night_mins) {
        super();
        this.date = date;
        this.session_num = session_num;
        this.minutes = minutes;
        this.mileage = mileage;
        this.night_mins = night_mins;
    }
    //View inflation/instantiation
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.log, container,false);
    }
    // Setup requiring access to View starts here
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //this.view = view;
        String date = getArguments().getString("Date", "");
        String session_num = getArguments().getString("Session Number", "");
        String minutes = getArguments().getString("Minutes", "");
        String mileage = getArguments().getString("Mileage", "");
        String night_mins = getArguments().getString("Night Minutes", "");
        //TextView textView = view.findViewById(R.id.message);
        //textView.setText(""+ date + "\t" + session_num + "\t" + minutes + "\t" + mileage + "\t" + night_mins);
        //AppCompatButton button = view.findViewById(R.id.remove);
        //button.setTag(""+id);
    }

    public static MessageFragment newInstance(String date, String session_num, String minutes, String mileage, String night_mins) {
        Bundle args = new Bundle();
        MessageFragment fragment = new MessageFragment(date, session_num, minutes, mileage, night_mins);
        String final_string = date + "\t" + session_num + "\t" + minutes + "\t" + mileage;
        args.putString("Info", final_string);
        fragment.setArguments(args);
        return fragment;
    }
}
