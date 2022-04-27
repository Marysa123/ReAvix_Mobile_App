package com.example.reavixmobileapp;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBHandler extends SQLiteOpenHelper {

    public static final String DB_NAME = "Students.db";
    public  static  final int DB_VERSION = 1;

    Context context;

    public DBHandler(Context context) {

        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String USER_TABLE = "CREATE TABLE "+ Student.UserDetails.TABLE_NAME+" ( "+
                Student.UserDetails.COL_ID+" INTEGER PRIMARY KEY,"+
                Student.UserDetails.COL_NAME_GRUPPA+" TEXT,"+
                Student.UserDetails.COL_BIOGRAFIA+" TEXT,"+
                Student.UserDetails.COL_PERSONADATA+" TEXT,"+
                Student.UserDetails.COL_XARACTERISTIKA+" TEXT)";

        sqLiteDatabase.execSQL(USER_TABLE);
    }

    public boolean addStudent(String name_gruppa,String biografia,String personaldata,String xaracteristika){
        SQLiteDatabase database = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(Student.UserDetails.COL_NAME_GRUPPA,name_gruppa);
        values.put(Student.UserDetails.COL_BIOGRAFIA,biografia);
        values.put(Student.UserDetails.COL_PERSONADATA,personaldata);
        values.put(Student.UserDetails.COL_XARACTERISTIKA,xaracteristika);

        long sid = database.insert(Student.UserDetails.TABLE_NAME,null,values);

        if (sid>0){
            return true;

        }
        else {
            return false;
        }
    }
    public Cursor getdata(){
        String query = "SELECT * FROM " + Student.UserDetails.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if (db != null){
            cursor = db.rawQuery(query,null);
        }
        return cursor;
    }
    public void updateData(String row_id,String name_gruppa,String biografia,String personaldata,String xaracteristika){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Student.UserDetails.COL_NAME_GRUPPA,name_gruppa);
        cv.put(Student.UserDetails.COL_BIOGRAFIA,biografia);
        cv.put(Student.UserDetails.COL_PERSONADATA,personaldata);
        cv.put(Student.UserDetails.COL_XARACTERISTIKA,xaracteristika);

        long result = db.update(Student.UserDetails.TABLE_NAME,cv,"id=?",new String[]{row_id});

        if (result==-1){
            Toast.makeText(context, "Failed update", Toast.LENGTH_SHORT).show();
        }else{
                Toast.makeText(context, "Failed update", Toast.LENGTH_SHORT).show();
        }
    }
    public Cursor viewData(){
        SQLiteDatabase database = this.getReadableDatabase();
        String query = "SELECT id FROM student ORDER BY id DESC LIMIT 1";
        Cursor cursor = database.rawQuery(query,null);

        return cursor;
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop Table if exists student");
    }
}
