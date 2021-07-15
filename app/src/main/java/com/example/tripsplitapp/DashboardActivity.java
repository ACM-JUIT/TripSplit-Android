package com.example.tripsplitapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer, new FragmentDashboard()).commit();
        bottomNavigationView = findViewById(R.id.bottomNavigation);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected( @NotNull MenuItem item) {
                Fragment temp = null;

                switch (item.getItemId())
                {
                    case R.id.menuDashboard: temp = new FragmentDashboard();
                    break;

                    case R.id.menuRecent: temp = new FragmentRecentTrips();
                    break;

                    case R.id.menuAdd: temp = new FragmentAddTrip();
                    break;

                    case R.id.menuProfile: temp = new FragmentProfile();
                    break;

                    case R.id.addMoney: temp = new FragmentAddMoney();
                }
     getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer, temp).commit();
                return true;
            }
        });


    }


}