package com.example.snwak_000.ghn;

import android.app.DatePickerDialog;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.text.*;

import java.util.Calendar;


public class SignUpActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    int day, month, year, dayFinal, monthFinal, yearFinal;
    String emailFinal, passwordFinal, usernameFinal;
    EditText email;
    EditText password;
    EditText username;
    EditText dob;
    RadioGroup gender;
    RadioButton male;
    RadioButton female;
    Button signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        /* Assigning Variables to IDs*/

        email = (EditText) findViewById(R.id.emailSignUp);
        password = (EditText) findViewById(R.id.passwordSignUp);
        username = (EditText) findViewById(R.id.usernameSignUp);
        dob = (EditText)findViewById(R.id.DOBSignUp);
        gender = (RadioGroup)findViewById(R.id.radioGroup);
        male = (RadioButton)findViewById(R.id.maleRadioButton);
        female = (RadioButton) findViewById(R.id.femaleRadioButton);
        signUp = (Button)findViewById(R.id.signUpButton);

        dob.setOnClickListener(new View.OnClickListener() {         //adding listener to date of birth button

            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                year = c.get(Calendar.YEAR);
                month = c.get(Calendar.MONTH);
                day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(SignUpActivity.this, SignUpActivity.this, year, month, day);
                datePickerDialog.show();

            }
        });

    }
     public void rbGroup(View v){
         int radiobutton = gender.getCheckedRadioButtonId();
         RadioButton rb = (RadioButton) findViewById(radiobutton);
     }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        yearFinal = i;
        monthFinal = i1 + 1;
        dayFinal = i2;
        dob.setText(dayFinal + "/" + monthFinal + "/" + yearFinal);
    }
}
