package com.example.reavixmobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.hbb20.CountryCodePicker;

public class sign_up_up3nd extends AppCompatActivity {

    ImageView backBtn;
    Button next,login;
    TextView titleText;

    String Fio,Login,Mail,Password,Pol,Datetime;
    TextInputEditText nomer_txt,adress_txt;
    
    DBHelper myDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_up3nd);

        backBtn = findViewById(R.id.up_back_button);
        next = findViewById(R.id.signip_next_btn);
        login = findViewById(R.id.signip_login_btn);
        titleText = findViewById(R.id.signip_title_text);
        
        nomer_txt = findViewById(R.id.Number_phone);
        adress_txt = findViewById(R.id.Adress_user);


        Bundle bundle = getIntent().getExtras(); //Вот тут получение с 2 окна регистрации
        if (bundle != null){
            Fio = bundle.get("Fio").toString();
            Login = bundle.get("Login").toString();
            Mail = bundle.get("Mail").toString();
            Password = bundle.get("Password").toString();
            Pol = bundle.get("Pol").toString();
            Datetime = bundle.get("Datetime").toString();
        }
        myDB = new DBHelper(this);


    }


    public void callNextSignupScreen(View view){

        Intent intent = new Intent(getApplicationContext(),MainPageApp.class);

        Pair[] pairs = new Pair[4];

        pairs[0] = new Pair<View,String>(backBtn,"transition_back_arrow_btn");
        pairs[1] = new Pair<View,String>(next,"transition_title_text");
        pairs[2] = new Pair<View,String>(login,"transition_next_btn");
        pairs[3] = new Pair<View,String>(titleText,"transition_login_btn");

        String Phone = nomer_txt.getText().toString();
        String Adress_user = adress_txt.getText().toString();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(sign_up_up3nd.this,pairs);
            startActivity(intent,options.toBundle());

            if (Fio.equals("") || Login.equals("") || Mail.equals("") || Password.equals("")|| Pol.equals("")|| Datetime.equals("") || Phone.equals("") || Adress_user.equals("")){
                Toast.makeText(sign_up_up3nd.this,"Пожалуйста, заполните данные",Toast.LENGTH_SHORT).show();
            }
            else{
                Boolean resultcheckUser = myDB.checkusername(Login);
                if (resultcheckUser == false){

                    Boolean regResult = myDB.insertData(Fio,Login,Mail,Password,Pol,Datetime,"Российская Федерация",Phone,Adress_user);
                    if (regResult == true){
                        Toast.makeText(sign_up_up3nd.this, "Регистрация прошла успешно", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(sign_up_up3nd.this, "Ошибка", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(sign_up_up3nd.this,"Такой пользователь уже существует \n Пожалуйста войдите",Toast.LENGTH_SHORT).show();
                }
            }
        }
        else{
            startActivity(intent);
        }

    }
}