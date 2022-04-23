package com.example.reavixmobileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SignInandSignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_inand_sign_up);

    }

    public void onCLickbtnSignIn(View view){
        startActivity(new Intent(getApplicationContext(),SignIn.class));

    }
    public void onCLickbtnSignUp(View view){
        startActivity(new Intent(getApplicationContext(),SignUp.class));

    }
}