package com.example.reavixmobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class MainPageApp extends AppCompatActivity {

    TextInputEditText name_grupp,biografia,personal_data,xaracteristika;

    ArrayList<String> list;
    ArrayAdapter adapter;

    DBHandler dbHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page_app);

       list = new ArrayList<>();

        name_grupp = findViewById(R.id.Nomer_gruppi);
        biografia = findViewById(R.id.Biografia);
        personal_data = findViewById(R.id.personal_data);
        xaracteristika = findViewById(R.id.Xaracter);

        dbHandler = new DBHandler(this);

        findViewById(R.id.button_addinfo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Name_gruppi = name_grupp.getText().toString();
                String Biografia = biografia.getText().toString();
                String Personal_data = personal_data.getText().toString();
                String Xaracteristika = xaracteristika.getText().toString();

                Boolean status = dbHandler.addStudent(Name_gruppi,Biografia,Personal_data,Xaracteristika);
                if (status) {
                    if (Name_gruppi.equals("") || Biografia.equals("") || Personal_data.equals("") || Xaracteristika.equals("")){
                        Toast.makeText(MainPageApp.this, "Пожалуйста, заполните поля", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(MainPageApp.this, "Данные добавлены", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainPageApp.this,SignIn.class);
                        startActivity(intent);
                    }
                }
                else{
                    Toast.makeText(MainPageApp.this, "Ошибка добавления", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}