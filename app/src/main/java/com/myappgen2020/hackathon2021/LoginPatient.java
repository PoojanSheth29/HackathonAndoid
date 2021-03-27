package com.myappgen2020.hackathon2021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginPatient extends AppCompatActivity{
    EditText txt_fname, txt_lname, txt_age, txt_email, txt_password;
    RadioButton radio_gender_name;
    RadioGroup radio_gender;
    Button btn_comit;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_patient);
        txt_fname = findViewById(R.id.txt_fname);
        txt_lname = findViewById(R.id.txt_lname);
        txt_age = findViewById(R.id.txt_age);
        txt_email = findViewById(R.id.txt_email);
        txt_password = findViewById(R.id.txt_password_patient);
        radio_gender = (RadioGroup) findViewById(R.id.radio_gender);
        btn_comit = findViewById(R.id.btn_commit);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("User");

        btn_comit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PatientModel model = new PatientModel();
                String fn = txt_fname.getText().toString();
                String ln = txt_lname.getText().toString();
                String email = txt_email.getText().toString();
                String password = txt_password.getText().toString();
                //String value = ((String) findViewById(radio_gender.getCheckedRadioButtonId())).getText().toString();
                Integer age = Integer.parseInt(txt_age.getText().toString());
                String id = databaseReference.push().getKey();
                model.setFirstName(fn);
                model.setLastName(ln);
                model.setEmail(email);
                //model.setGender(value);
                model.setAge(age);
                model.setPassword(password);
                model.setId(id);
                databaseReference.child(id).setValue(model);
            }
        });

    }
}
