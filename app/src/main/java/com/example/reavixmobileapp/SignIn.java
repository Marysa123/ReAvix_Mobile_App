package com.example.reavixmobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class SignIn extends AppCompatActivity {

    DBHelper myDB;
    TextInputEditText username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        myDB = new DBHelper(this);

        username = findViewById(R.id.login);
        password = findViewById(R.id.password);

    }
    public void onClickbtnBackPage(View view){
        startActivity(new Intent(getApplicationContext(),SignInandSignUp.class));
    }
    public void onClickbtnCreateAcc(View view){
        startActivity(new Intent(getApplicationContext(),SignUp.class));
    }
    public void onClickbtnSign(View view){
        String user = username.getText().toString();
        String pass = password.getText().toString();
        if (user.equals("")|| pass.equals("")){
            Toast.makeText(SignIn.this, "Пожалуйста, заполните поля", Toast.LENGTH_SHORT).show();
        }
        else{
            Boolean result = myDB.checkusernamePassword(user,pass);
            if (result==true){
                Intent intent = new Intent(getApplicationContext(),MainPageApp2.class);
                startActivity(intent);
            }
            else
                Toast.makeText(SignIn.this, "Повторите попытку", Toast.LENGTH_SHORT).show();

            }

        }
    }
