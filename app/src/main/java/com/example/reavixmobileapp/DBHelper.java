package com.example.reavixmobileapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context){
        super(context,"Login.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDB) {
        sqLiteDB.execSQL("create Table users(id INTEGER PRIMARY KEY AUTOINCREMENT,fio Text NOT NULL,login Text NOT NULL,mail Text NOT NULL,password Text NOT NULL,pol Text NOT NULL,datetime Text NOT NULL,country Text NOT NULL,numberphone Text NOT NULL,adress Text NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDB, int i, int i1) {
        sqLiteDB.execSQL("drop Table if exists users");
    }

    public  Boolean insertData(String fio,String login,String mail,String password,String pol,String datetime,String country,String numberphone,String adress){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("fio",fio);
        contentValues.put("login",login);
        contentValues.put("mail",mail);
        contentValues.put("password",password);
        contentValues.put("pol",pol);
        contentValues.put("datetime",datetime);
        contentValues.put("country",country);
        contentValues.put("numberphone",numberphone);
        contentValues.put("adress",adress);
        long result = database.insert("users",null,contentValues);

        if (result == -1){

            return false;
        }
        else{
            return true;
        }
    }
    public  Boolean checkusername(String login){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from users where login = ?",new String[] {login});
        if (cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }
    public Cursor viewDataEmail(){
        SQLiteDatabase database = this.getReadableDatabase();
        String query = "SELECT mail FROM users ORDER BY id DESC LIMIT 1";
        Cursor cursor = database.rawQuery(query,null);

        return cursor;
    }
    public Cursor viewDataFio(){
        SQLiteDatabase database = this.getReadableDatabase();
        String query = "SELECT fio FROM users ORDER BY id DESC LIMIT 1";
        Cursor cursor = database.rawQuery(query,null);

        return cursor;
    }

    public  Boolean checkusernamePassword(String login,String password){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from users where login = ? and password = ?",new String[] {login,password});
        if (cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }

    }
}
