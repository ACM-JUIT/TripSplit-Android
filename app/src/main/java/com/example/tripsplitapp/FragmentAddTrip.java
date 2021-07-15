package com.example.tripsplitapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


public class FragmentAddTrip extends Fragment {


    public FragmentAddTrip() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    EditText etLocation, etgroupName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_trip, container, false);
        etLocation = view.findViewById(R.id.etLocation);
        etgroupName = view.findViewById(R.id.etgroupName);

        etLocation.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if(hasFocus){
                    etLocation.setBackgroundResource(R.drawable.edit_text_focused);
                } else {
                    etLocation.setBackgroundResource(R.drawable.edit_text_normal);
                }
            }
        });

        etgroupName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if(hasFocus){
                    etgroupName.setBackgroundResource(R.drawable.edit_text_focused);
                } else {
                    etgroupName.setBackgroundResource(R.drawable.edit_text_normal);
                }

            }
        });

        return view;
    }
}