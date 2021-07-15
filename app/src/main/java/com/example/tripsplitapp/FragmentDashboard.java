package com.example.tripsplitapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.icu.text.Transliterator;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class FragmentDashboard extends Fragment {

    public FragmentDashboard() {
    }

    PieChart pieChart;
    CardView tripDetails;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        pieChart = view.findViewById(R.id.pieChart);
        tripDetails = view.findViewById(R.id.tripDetails);

        ArrayList<PieEntry> records = new ArrayList<>();
        records.add(new PieEntry(32,  "Member1"));
        records.add(new PieEntry(20, "Member2"));
        records.add(new PieEntry(28,  "Member3"));
        records.add(new PieEntry(10, "Member4"));

        PieDataSet dataSet = new PieDataSet(records, "Expenses");

        dataSet.setColors (new int[] {getResources().getColor(R.color.purple1),
                getResources().getColor(R.color.purple2),getResources().getColor(R.color.purple3),
                getResources().getColor(R.color.purple4)});

        dataSet.setValueTextColor(Color.WHITE);
        dataSet.setValueTextSize(15f);
        dataSet.setForm(Legend.LegendForm.CIRCLE);
        dataSet.setSliceSpace(5f);

        PieData pieData = new PieData(dataSet);

        pieChart.setData(pieData);
        pieChart.getDescription().setEnabled(true);
        pieChart.setEntryLabelColor(Color.WHITE);
        pieChart.setCenterText("Trip Name");
        pieChart.setCenterTextSize(22);
        pieChart.setHoleRadius(60);
        pieChart.setCenterTextTypeface(Typeface.DEFAULT_BOLD);
        pieChart.setCenterTextColor(Color.WHITE);
        pieChart.setHoleColor(getResources().getColor(R.color.hole_color));
        pieChart.setTransparentCircleRadius(2);
        pieChart.setDrawEntryLabels(false);
        pieChart.animate();
        pieChart.setExtraLeftOffset(50f);

        Legend legend = pieChart.getLegend();
        legend.setOrientation(Legend.LegendOrientation.VERTICAL);
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        legend.setTextColor(Color.WHITE);
        legend.setTextSize(15f);

        tripDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TripDetails.class);
                startActivity(intent);
            }
        });



        return view;
    }
}