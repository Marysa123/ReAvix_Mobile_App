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

public class sign_up_up3nd extends AppCompatActivity {

    ImageView backBtn;
    Button next,login;
    TextView titleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_up3nd);

        backBtn = findViewById(R.id.up_back_button);
        next = findViewById(R.id.signip_next_btn);
        login = findViewById(R.id.signip_login_btn);
        titleText = findViewById(R.id.signip_title_text);
    }


    public void callNextSignupScreen(View view){

        Intent intent = new Intent(getApplicationContext(),MainPageApp.class);

        Pair[] pairs = new Pair[4];

        pairs[0] = new Pair<View,String>(backBtn,"transition_back_arrow_btn");
        pairs[1] = new Pair<View,String>(next,"transition_title_text");
        pairs[2] = new Pair<View,String>(login,"transition_next_btn");
        pairs[3] = new Pair<View,String>(titleText,"transition_login_btn");

        //Возможна яошитбка

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(sign_up_up3nd.this,pairs);
            startActivity(intent,options.toBundle());

        }
        else{
            startActivity(intent);
        }

    }
}