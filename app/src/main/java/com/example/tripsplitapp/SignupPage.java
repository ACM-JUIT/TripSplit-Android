package com.example.tripsplitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class SignupPage extends AppCompatActivity {


    EditText etName, etEmail, etPassword;
    TextView logIn;
    Button signUpBack, signupBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.color_background));
        }


        setContentView(R.layout.activity_signup_page);

        logIn = findViewById(R.id.textViewLogin);
        etName = findViewById(R.id.etAddMoney2);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        signUpBack = findViewById(R.id.signUpBack);
        signupBtn = findViewById(R.id.signupBtn);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        etName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (hasFocus) {
                    etName.setBackgroundResource(R.drawable.edit_text_focused);
                } else {
                    etName.setBackgroundResource(R.drawable.edit_text_normal);
                }
            }
        });

        etEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (hasFocus) {
                    etEmail.setBackgroundResource(R.drawable.edit_text_focused);
                } else {
                    etEmail.setBackgroundResource(R.drawable.edit_text_normal);
                }
            }
        });

        etPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (hasFocus) {
                    etPassword.setBackgroundResource(R.drawable.edit_text_focused);
                } else {
                    etPassword.setBackgroundResource(R.drawable.edit_text_normal);
                }
            }
        });

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupPage.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        signUpBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupPage.this, Homepage_Activity.class);
                startActivity(intent);
                finish();
            }
        });

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String name = etName.getText().toString();
                final String email = etEmail.getText().toString();
                final String password = etPassword.getText().toString();
                final String url = "";

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }

                }){
                    @Override
                    protected Map<String, String> getParams(){

                        Map<String, String> params = new HashMap<String, String>();

                        params.put("name", name);
                        params.put("email", email);
                        params.put("password", password);

                        return params;
                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(stringRequest);

                Intent intent = new Intent(SignupPage.this, DashboardActivity.class);
                startActivity(intent);
                finish();

            };
        });


    }
}