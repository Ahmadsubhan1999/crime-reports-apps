package com.example.crime_report_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UIActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uiactivity);
        firebaseAuth = FirebaseAuth.getInstance();

        FirebaseUser currentuser = FirebaseAuth.getInstance().getCurrentUser();

        if (currentuser == null) {
            sendtoLogin();
        }

        //  fireAuth = FirebaseAuth.getInstance();
    }

    //missing report
    public void yourMissingReports(View view) {
        Intent intent = new Intent(UIActivity.this, ContactusActivity.class);//main2activity
        startActivity(intent);
    }

    //your crime report
    public void yourCrimeReports(View view) {
        Intent intent = new Intent(UIActivity.this, AboutusActivity.class);//mainactivity
        startActivity(intent);
    }

    //report a crime
    public void reportCrime(View view) {
        Intent intent = new Intent(UIActivity.this, PostActivity.class);
        startActivity(intent);
    }

    //file a missing report
    public void fileMissingReport(View view) {
        Intent intent = new Intent(UIActivity.this, YourCrimeReport.class);

        startActivity(intent);
    }

    //your profile
    public void yourProfile(View view) {
        Intent intent = new Intent(UIActivity.this, ProfileActivity.class);

        startActivity(intent);
    }
    //your profile
    public void Logout(View view) {
        Intent intent = new Intent(UIActivity.this, LoginActivity.class);
        startActivity(intent);
        firebaseAuth.signOut();
        finish();
    }



    private void sendtoLogin() {
        Intent intent = new Intent(UIActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}


