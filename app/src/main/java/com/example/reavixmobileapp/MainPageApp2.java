package com.example.reavixmobileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

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