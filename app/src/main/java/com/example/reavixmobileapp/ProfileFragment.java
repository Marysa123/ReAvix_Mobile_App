package com.example.reavixmobileapp;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<String> name_grupp,biografia,personal_data,xaracteristika;
    DBHandler dbHandler;
    DBHelper dbHelper;
    MyAdapter adapter;
    TextView textView;


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("Range")
    private void displaydata() {
        Cursor cursor = dbHandler.getdata();
        if (cursor.getCount() == 0 && cursor.moveToFirst()) {
        } else {
            if (cursor != null)
                if (cursor.moveToFirst()) {
                    do {
                        name_grupp.add(cursor.getString(cursor.getColumnIndex(Student.UserDetails.COL_NAME_GRUPPA)));
                        biografia.add(cursor.getString(cursor.getColumnIndex(Student.UserDetails.COL_BIOGRAFIA)));
                        personal_data.add(cursor.getString(cursor.getColumnIndex(Student.UserDetails.COL_PERSONADATA)));
                        xaracteristika.add(cursor.getString(cursor.getColumnIndex(Student.UserDetails.COL_XARACTERISTIKA)));
                    } while (cursor.moveToNext());
                }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclesview);
        dbHandler = new DBHandler(requireContext());
        name_grupp = new ArrayList<>();
        biografia = new ArrayList<>();
        personal_data = new ArrayList<>();
        xaracteristika = new ArrayList<>();

        adapter = new MyAdapter( requireContext() ,name_grupp,biografia,personal_data,xaracteristika);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        displaydata();

        textView = view.findViewById(R.id.Id_titl);
        dbHelper = new DBHelper((requireContext()));

        Cursor cursor = dbHelper.viewData();
        if (cursor.getCount()==0){
            Toast.makeText(requireContext(), "Нет данных", Toast.LENGTH_SHORT).show();
        }
        else{
            while(cursor.moveToNext()){
                textView.setText(cursor.getString(0));
            }
        }

        return  view;
    }
}