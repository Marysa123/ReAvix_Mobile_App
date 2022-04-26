package com.example.reavixmobileapp;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StatisticsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StatisticsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public StatisticsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StatisticsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StatisticsFragment newInstance(String param1, String param2) {
        StatisticsFragment fragment = new StatisticsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_statistics, container, false);
        RadarChart radarChart = view.findViewById(R.id.radarchart);

        ArrayList<RadarEntry> visitorsFirstWebSite = new ArrayList<>();
        visitorsFirstWebSite.add(new RadarEntry(70));
        visitorsFirstWebSite.add(new RadarEntry(70));
        visitorsFirstWebSite.add(new RadarEntry(80));
        visitorsFirstWebSite.add(new RadarEntry(90));
        visitorsFirstWebSite.add(new RadarEntry(100));
        visitorsFirstWebSite.add(new RadarEntry(65));
        visitorsFirstWebSite.add(new RadarEntry(82));
        visitorsFirstWebSite.add(new RadarEntry(93));
        visitorsFirstWebSite.add(new RadarEntry(100));
        visitorsFirstWebSite.add(new RadarEntry(0));

        RadarDataSet radarDataSet = new RadarDataSet(visitorsFirstWebSite,"Общий процент качества знаний");
        radarDataSet.setColor(Color.RED);
        radarDataSet.setLineWidth(2f);
        radarDataSet.setValueTextColor(Color.BLACK);
        radarDataSet.setValueTextSize(14f);

        RadarData radarDataSet1 = new RadarData();
        radarDataSet1.addDataSet(radarDataSet);

        String[] levels = {"Январь","Февраль","Март","Апрель","Май","Июнь","Сентябрь","Октябрь","Ноябрь","Декабрь"};
        XAxis xAxis = radarChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(levels));

        radarChart.getDescription().setText("");
        radarChart.setData(radarDataSet1);
        return view;

    }
}