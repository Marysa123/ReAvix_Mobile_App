package com.example.reavixmobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class UpdataPages extends AppCompatActivity {

    EditText Name_grupp,Biografia,Personal_data,Xaracteristika;
    Button btnUpdate;
    String name_grupp,biografia,personal_data,xaracteristika;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updata_pages);

        Name_grupp = findViewById(R.id.Nomer_gruppi_update);
        Biografia = findViewById(R.id.Biografia_update);
        Personal_data = findViewById(R.id.personal_data_update);
        Xaracteristika = findViewById(R.id.Xaracter_update);
        btnUpdate = findViewById(R.id.updateBtn);

        String id = "";

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("Range")
            @Override
            public void onClick(View view) {

                name_grupp = Name_grupp.getText().toString();
                biografia = Biografia.getText().toString();
                personal_data = Personal_data.getText().toString();
                xaracteristika = Xaracteristika.getText().toString();

                DBHandler dbHandler = new DBHandler(UpdataPages.this);

                String item_content= null;

                Cursor cursor = dbHandler.viewData();
                if (cursor.getCount()==0){
                }else{
                    while(cursor.moveToNext()){
                        item_content = cursor.getString(cursor
                                .getColumnIndex(Student.UserDetails.COL_ID));
                    }
                }

                dbHandler.updateData(item_content,name_grupp,biografia,personal_data,xaracteristika);
            }
        });
        getIntentDate();

    }
    void getIntentDate(){
        if (getIntent().hasExtra("Name_grupp") && getIntent().hasExtra("Biografia") &&
                getIntent().hasExtra("Personal_data") && getIntent().hasExtra("Xaracteristika")){

            name_grupp = getIntent().getStringExtra("Name_grupp");
            biografia = getIntent().getStringExtra("Biografia");
            personal_data = getIntent().getStringExtra("Personal_data");
            xaracteristika = getIntent().getStringExtra("Xaracteristika");

            Name_grupp.setText(name_grupp);
            Biografia.setText(biografia);
            Personal_data.setText(personal_data);
            Xaracteristika.setText(xaracteristika);
        }else{
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }
}
