package com.example.crime_report_app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.crime_report_app.Java_Classes.DBHelper;

public class PostActivity extends AppCompatActivity {
    EditText name,age,gender,adress,crime;
    Button submit;
    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        name =(EditText) findViewById(R.id.name1);
        age = (EditText) findViewById(R.id.age1);
        gender =(EditText) findViewById(R.id.gender1);
        adress = (EditText) findViewById(R.id.adress1);
        crime =(EditText) findViewById(R.id.crime1);
        submit = (Button) findViewById(R.id.submit);
        DB = new DBHelper(this);

submit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String nameTXT = name.getText().toString();
        String ageTXT = age.getText().toString();
        String genderTXT = gender.getText().toString();
        String adressTXT = adress.getText().toString();
        String crimeTXT = crime.getText().toString();

        Boolean cheakinsertdata = DB.insertuserdata(nameTXT,ageTXT,genderTXT,adressTXT,crimeTXT);

        if (cheakinsertdata==true)
        {
            Toast.makeText(PostActivity.this, "New Entery Insertd", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(PostActivity.this, "New Entery Not Insertd", Toast.LENGTH_SHORT).show();
        }

        }



});

    }
}