package com.example.reavixmobileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;

public class MainPageApp2 extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> name_grupp,biografia,personal_data,xaracteristika;
    DBHandler dbHandler;
    MyAdapter adapter;

    TextView txt_id;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page_app2);
        recyclerView = findViewById(R.id.recyclesview);
        txt_id = findViewById(R.id.textView8);
        dbHandler = new DBHandler(this);
        name_grupp = new ArrayList<>();
        biografia = new ArrayList<>();
        personal_data = new ArrayList<>();
        xaracteristika = new ArrayList<>();

        RadarChart radarChart = findViewById(R.id.radarchart);

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





        adapter = new MyAdapter( this ,name_grupp,biografia,personal_data,xaracteristika);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        displaydata();

        Cursor cursor = dbHandler.viewData();
        if (cursor.getCount()==0){
            Toast.makeText(this, "Нет данных", Toast.LENGTH_SHORT).show();
        }else{
            while(cursor.moveToNext()){
                txt_id.setText(cursor.getString(0));
            }
        }
    }

    @SuppressLint("Range")
    private void displaydata() {
        Cursor cursor = dbHandler.getdata();
        if (cursor.getCount()==0 && cursor.moveToFirst()) {

        }
        else{
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
}