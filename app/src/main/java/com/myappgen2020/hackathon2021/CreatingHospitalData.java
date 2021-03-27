package com.myappgen2020.hackathon2021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreatingHospitalData extends AppCompatActivity {

    EditText txtName, txtArea, txtNOD, txtNON, txtBeds, txtFreeBeds, txtPATAdmit, txtACTCases, txtRecover, txtEmail, txtPassword;
    Button btnCommit;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creating_hospital_data);



        txtName = findViewById(R.id.txt_name);
        txtArea = findViewById(R.id.txt_area);
        txtNOD = findViewById(R.id.txt_NOD);
        txtNON = findViewById(R.id.txt_NON);
        txtBeds = findViewById(R.id.txt_Beds);
        txtFreeBeds = findViewById(R.id.txt_FreeBeds);
        txtPATAdmit = findViewById(R.id.txt_patAdmit);
        txtACTCases = findViewById(R.id.txt_actCase);
        txtRecover = findViewById(R.id.txt_Recover);
        txtEmail = findViewById(R.id.txt_email1);
        txtPassword = findViewById(R.id.txt_password);

        btnCommit = findViewById(R.id.btn_submit);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Hospital");

        btnCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = txtName.getText().toString();
                String area = txtArea.getText().toString();
                Integer nod = Integer.parseInt(txtNOD.getText().toString());
                Integer non = Integer.parseInt(txtNON.getText().toString());
                Integer beds = Integer.parseInt(txtBeds.getText().toString());
                Integer freeBeds = Integer.parseInt(txtFreeBeds.getText().toString());
                Integer patAdmit = Integer.parseInt(txtPATAdmit.getText().toString());
                Integer active = Integer.parseInt(txtACTCases.getText().toString());
                Integer recovered = Integer.parseInt(txtRecover.getText().toString());
                String email = txtEmail.getText().toString();
                String password = txtPassword.getText().toString();
                String id = databaseReference.push().getKey();

                HospitalModel hospitalModel = new HospitalModel();
                hospitalModel.setName(name);
                hospitalModel.setArea(area);
                hospitalModel.setEmail(email);
                hospitalModel.setPassword(password);
                hospitalModel.setNod(nod);
                hospitalModel.setNon(non);
                hospitalModel.setBeds(beds);
                hospitalModel.setFreeBeds(freeBeds);
                hospitalModel.setPatAdmit(patAdmit);
                hospitalModel.setActCases(active);
                hospitalModel.setRecover(recovered);

                databaseReference.child(id).setValue(hospitalModel);

            }
        });
    }
}