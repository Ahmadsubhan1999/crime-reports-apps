package com.example.crime_report_app;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crime_report_app.Java_Classes.DBHelper;
import com.example.crime_report_app.Java_Classes.MyAdapter;

import java.util.ArrayList;

public class YourCrimeReport extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> name,age,gender,adress,crime;
    DBHelper DB;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_crime_report);
        DB = new DBHelper(this);
        name = new ArrayList<>();
        age = new ArrayList<>();
        gender = new ArrayList<>();
        adress = new ArrayList<>();
        crime = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerview);
        adapter = new MyAdapter(this,name,age,gender,adress,crime);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();

    }

    private void displaydata() {
        Cursor cursor = DB.getdata();
        if (cursor.getCount()==0){
            Toast.makeText(YourCrimeReport.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            while (cursor.moveToNext())
            {
                name.add(cursor.getString(0));
                age.add(cursor.getString(1));
                gender.add(cursor.getString(2));
                adress.add(cursor.getString(3));
                crime.add(cursor.getString(4));
            }


        }
    }
}