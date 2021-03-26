package com.myappgen2020.hackathon2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class OptionalPatientDr extends AppCompatActivity {
    ImageButton imgbtnPat,imgbtnHosp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_optional_patient_dr);
        imgbtnPat = findViewById(R.id.imgbtn_pat);
        imgbtnHosp = findViewById(R.id.imgbtn_hosp);


        imgbtnPat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(OptionalPatientDr.this,LoginPatient.class);
                startActivity(i);
                finish();

            }
        });
        imgbtnHosp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(OptionalPatientDr.this,SignUpHospital.class);
                startActivity(i);
                finish();

            }
        });
    }
}