package com.myappgen2020.hackathon2021;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginPatient extends AppCompatActivity {

    EditText fName, lName, age, email, password;
    RadioGroup radioGroup;
    Button button;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_patient);
        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_title);

        fName = findViewById(R.id.txt_fname);
        lName = findViewById(R.id.txt_lname);
        email = findViewById(R.id.txt_email);
        password = findViewById(R.id.txt_password_patient);
        age = findViewById(R.id.txt_age);
        radioGroup = findViewById(R.id.radio_gender);
        button = findViewById(R.id.btn_commit);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("User");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PatientModel patientModel = new PatientModel();
                String id = databaseReference.push().getKey();
                String first = fName.getText().toString();
                String last = lName.getText().toString();
                String em = email.getText().toString();
                String pass = password.getText().toString();
                String gender = ((RadioButton)findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString();
                int ag = Integer.parseInt(age.getText().toString());
                patientModel.setId(id);
                patientModel.setPassword(pass);
                patientModel.setEmail(em);
                patientModel.setGender(gender);
                patientModel.setFirstName(first);
                patientModel.setLastName(last);
                patientModel.setAge(ag);
                databaseReference.child(id).setValue(patientModel);


                Intent i = new Intent(LoginPatient.this,HomeActivity.class);
                startActivity(i);
                finish();
            }
        });


    }
}