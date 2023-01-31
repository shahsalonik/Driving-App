package com.shahsaloni_gadhamsettyprajakta.drivingapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DrivingFragment extends Fragment {

    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.driving, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.view = view;
    }

    public static DrivingFragment newInstance(String content, String author) {
        Bundle args = new Bundle();
        DrivingFragment fragment = new DrivingFragment();
        args.putString("DRIVING SCREEN", "DRIVING SCREEN");
        fragment.setArguments(args);
        return fragment;
    }

}