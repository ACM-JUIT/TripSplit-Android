package com.example.tripsplitapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class FragmentAddMoney extends Fragment {


    public FragmentAddMoney() {

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    EditText etAddMoney1, etAddMoney2, etAddMoney3, etAddMoney4;
    TextView tvTotalMoney;
    Button btnAddMoney;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_add_money, container, false);

        etAddMoney1 = view.findViewById(R.id.etAddMoney1);
        etAddMoney2 = view.findViewById(R.id.etAddMoney2);
        etAddMoney3 = view.findViewById(R.id.etAddMoney3);
        etAddMoney4 = view.findViewById(R.id.etAddMoney4);
        tvTotalMoney = view.findViewById(R.id.tvTotalMoney);
        btnAddMoney = view.findViewById(R.id.btnAddMoney);
        int money1, money2, money3, money4;
        int totalMoney = 0;


        etAddMoney1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (hasFocus)
                {
                    etAddMoney1.setBackgroundResource(R.drawable.edit_text_focused);
                } else {
                    etAddMoney1.setBackgroundResource(R.drawable.edit_text_normal);
                }
            }
        });

        etAddMoney2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (hasFocus)
                {
                    etAddMoney2.setBackgroundResource(R.drawable.edit_text_focused);
                } else {
                    etAddMoney2.setBackgroundResource(R.drawable.edit_text_normal);
                }
            }
        });

        etAddMoney3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (hasFocus)
                {
                    etAddMoney3.setBackgroundResource(R.drawable.edit_text_focused);
                } else {
                    etAddMoney3.setBackgroundResource(R.drawable.edit_text_normal);
                }
            }
        });

        etAddMoney4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (hasFocus)
                {
                    etAddMoney4.setBackgroundResource(R.drawable.edit_text_focused);
                } else {
                    etAddMoney4.setBackgroundResource(R.drawable.edit_text_normal);
                }
            }
        });

       btnAddMoney.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               if(etAddMoney1.getText().toString().isEmpty() || etAddMoney2.getText().toString().isEmpty()  || etAddMoney3.getText().toString().isEmpty() || etAddMoney4.getText().toString().isEmpty())
               {
                   Toast.makeText(getContext(), "Please enter amount in all fields", Toast.LENGTH_SHORT).show();
               } else {

                   int money1 , money2 , money3 , money4 , totalMoney = 0;
                   money1 = Integer.parseInt(etAddMoney1.getText().toString());
                   money2 = Integer.parseInt(etAddMoney2.getText().toString());
                   money3 = Integer.parseInt(etAddMoney3.getText().toString());
                   money4 = Integer.parseInt(etAddMoney4.getText().toString());

                   totalMoney = money1 + money2 + money3 + money4;
                   tvTotalMoney.setText("" + totalMoney + " Rs");
               }
           }
       });


        return view;
    }
}