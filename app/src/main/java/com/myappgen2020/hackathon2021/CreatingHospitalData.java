package com.myappgen2020.hackathon2021;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreatingHospitalData extends AppCompatActivity {

    EditText email, password, name, area;
    EditText nod, non, beds, freeBeds, patAdmit, actCases, recover;
    Button button;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creating_hospital_data);
        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_title);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Hospital");

        email = findViewById(R.id.txt_email1);
        password = findViewById(R.id.txt_password);
        area = findViewById(R.id.txt_area);
        name = findViewById(R.id.txt_name);
        nod = findViewById(R.id.txt_NOD);
        non = findViewById(R.id.txt_NON);
        beds = findViewById(R.id.txt_Beds);
        freeBeds = findViewById(R.id.txt_FreeBeds);
        recover = findViewById(R.id.txt_Recover);
        patAdmit = findViewById(R.id.txt_patAdmit);
        actCases = findViewById(R.id.txt_actCase);
        button = findViewById(R.id.btn_submit);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HospitalModel hospitalModel = new HospitalModel();
                String em = email.getText().toString();
                String pass = password.getText().toString();
                String ar = area.getText().toString();
                String nm = name.getText().toString();
                int NON = (Integer.parseInt(non.getText().toString()));
                int NOD = (Integer.parseInt(nod.getText().toString()));
                int bed = (Integer.parseInt(beds.getText().toString()));
                int freeBed = (Integer.parseInt(freeBeds.getText().toString()));
                int pat = (Integer.parseInt(patAdmit.getText().toString()));
                int actCase = (Integer.parseInt(actCases.getText().toString()));
                int rec = (Integer.parseInt(recover.getText().toString()));
                String id = databaseReference.push().getKey();
                hospitalModel.setRecover(rec);
                hospitalModel.setName(nm);
                hospitalModel.setPassword(pass);
                hospitalModel.setEmail(em);
                hospitalModel.setArea(ar);
                hospitalModel.setNon(NON);
                hospitalModel.setNod(NOD);
                hospitalModel.setBeds(bed);
                hospitalModel.setFreeBeds(freeBed);
                hospitalModel.setPatAdmit(pat);
                hospitalModel.setActCases(actCase);
                hospitalModel.setId(id);
                databaseReference.child(id).setValue(hospitalModel);
            }
        });


    }
}