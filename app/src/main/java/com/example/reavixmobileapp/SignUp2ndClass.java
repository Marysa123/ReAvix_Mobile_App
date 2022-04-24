package com.example.reavixmobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp2ndClass extends AppCompatActivity {

    ImageView backBtn;
    Button next,login;
    TextView titleText;
    RadioButton rdMale,rdFemale;

    String Fio,Login,Mail,Password,Var,Datetime;
    Integer day,month,year;

    DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2nd_class);

        backBtn = findViewById(R.id.up_back_button);
        next = findViewById(R.id.signip_next_btn);
        login = findViewById(R.id.signip_login_btn);
        titleText = findViewById(R.id.signip_title_text);

        rdMale = findViewById(R.id.radioButton3);
        rdFemale = findViewById(R.id.radioButton2);
        datePicker = findViewById(R.id.DateTime_picker);

        rdMale.setChecked(true);


        Bundle bundle = getIntent().getExtras(); //Вот тут получение с 1 окна регистрации
        if (bundle != null){
            Fio = bundle.get("Fio").toString();
            Login = bundle.get("Login").toString();
            Mail = bundle.get("Mail").toString();
            Password = bundle.get("Password").toString();
        }
    }

    public void callNextSignupScreen(View view){

        Intent intent = new Intent(getApplicationContext(),sign_up_up3nd.class);

        Pair[] pairs = new Pair[4];

        pairs[0] = new Pair<View,String>(backBtn,"transition_back_arrow_btn");
        pairs[1] = new Pair<View,String>(next,"transition_title_text");
        pairs[2] = new Pair<View,String>(login,"transition_next_btn");
        pairs[3] = new Pair<View,String>(titleText,"transition_login_btn");

        //Отправка
        if (rdMale.isChecked()){
            Var = rdMale.getText().toString();
        }
        if (rdFemale.isChecked()){
            Var = rdFemale.getText().toString();
        }

        day = datePicker.getDayOfMonth();
        month = datePicker.getMonth();
        year = datePicker.getYear();

        Datetime = day.toString()+"."+month.toString()+"."+year.toString();

        intent.putExtra("Fio",Fio); // ФИО
        intent.putExtra("Login",Login); // Логин
        intent.putExtra("Mail",Mail); // Почта
        intent.putExtra("Password",Password); // Пароль
        intent.putExtra("Pol",Var); // Пол
        intent.putExtra("Datetime",Datetime); // Дата рождения



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp2ndClass.this,pairs);
            startActivity(intent,options.toBundle());

        }
        else{
            startActivity(intent);
        }


    }

    public void onCLickbtnSignUp(View view){
        startActivity(new Intent(getApplicationContext(),SignIn.class));
    }
}