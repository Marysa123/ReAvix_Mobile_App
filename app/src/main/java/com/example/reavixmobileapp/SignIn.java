package com.example.reavixmobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SignIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
    }

    public void onClickbtnBackPage(View view){
        startActivity(new Intent(getApplicationContext(),SignInandSignUp.class));
    }
    public void onClickbtnCreateAcc(View view){
        startActivity(new Intent(getApplicationContext(),SignUp.class));
    }
}