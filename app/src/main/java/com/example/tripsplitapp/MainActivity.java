package com.example.tripsplitapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editTextGroupName, editTextPassword;
    TextView textViewSignup;
    Button logInBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.color_background));
        }

        setContentView(R.layout.activity_main);

        editTextGroupName = findViewById(R.id.editTextGroupName);
        editTextPassword = findViewById(R.id.editTextPassword);
        textViewSignup = findViewById(R.id.textViewSignup);
        logInBack = findViewById(R.id.logInBack);



        editTextGroupName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if(hasFocus)
                {
                  editTextGroupName.setBackgroundResource(R.drawable.edit_text_focused);
                } else {
                    editTextGroupName.setBackgroundResource(R.drawable.edit_text_normal);
                }
            }
        });

        editTextPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if(hasFocus)
                {
                    editTextPassword.setBackgroundResource(R.drawable.edit_text_focused);
                }
                else
                    {
                        editTextPassword.setBackgroundResource(R.drawable.edit_text_normal);
                    }
            }
        });

        textViewSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, SignupPage.class);
               startActivity(intent);
               finish();
            }
        });

        logInBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Homepage_Activity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}