package com.example.crime_report_app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    Handler handler;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                firebaseAuth=FirebaseAuth.getInstance();

                if (firebaseAuth.getCurrentUser()!=null && !firebaseAuth.getCurrentUser().getEmail().equals("police@police.in"))
                {
                    //start user dashboard activity
                    startActivity(new Intent(getApplicationContext(),UIActivity.class));
                    finish();
                }


                else
                {
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        },3000);
    }
}
