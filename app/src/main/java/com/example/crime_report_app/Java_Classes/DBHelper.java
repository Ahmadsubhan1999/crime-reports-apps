package com.example.crime_report_app.Java_Classes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {


    public DBHelper(Context context) {
        super(context, "Userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create table Userdetails(name TEXT primary key, age TEXT, gender TEXT, adress TEXT, crime TEXT)");

    }


    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop table if exists Userdetails");
    }

    public boolean insertuserdata(String name, String age, String gender, String adress, String crime) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("name", name);
        contentValues.put("age", age);
        contentValues.put("gender", gender);
        contentValues.put("adress", adress);
        contentValues.put("crime", crime);
        long result = DB.insert("Userdetails", null, contentValues);
        if (result == -1)
        {
            return false;
        }
        else
            return true;

    }
    public Cursor getdata()
    {
        SQLiteDatabase DB =this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Userdetails", null);
        return cursor ;
    }
}