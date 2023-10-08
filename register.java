package com.example.test2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class register extends AppCompatActivity {

    EditText firstName, lastName, userEmail, userPassword, userCPassword, userAddress;
    Spinner bloodType;
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        ImageView backBtn = (ImageView) findViewById(R.id.back_button); //onClick usage for back button (line 26-31)
        ImageView menuBtn = (ImageView) findViewById(R.id.menu_button); //onClick usage for menu button (line 33-38)
        TextView pageTitle = (TextView) findViewById(R.id.page_title); //sets page header (line 40)

        Spinner spinner = (Spinner) findViewById(R.id.blood_type); //spinner dropdown for blood type (line 42-47)

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(register.this, MainActivity.class);
                startActivity(intent);
            }
        });

        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(register.this, "Soon come", Toast.LENGTH_SHORT).show();
            }
        });

        pageTitle.setText("Register");

        //creating the array adapter (line 43)
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.blood_type, android.R.layout.simple_spinner_item);
        //choosing layout for choices (line 45)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //add adapter to the spinner (line 47)
        spinner.setAdapter(adapter);

        firstName = findViewById(R.id.first_name);
        lastName = findViewById(R.id.last_name);
        userEmail = findViewById(R.id.user_email);
        userPassword = findViewById(R.id.user_password);
        userCPassword = findViewById(R.id.user_cpassword);
        userAddress = findViewById(R.id.user_address);
        bloodType = findViewById(R.id.blood_type);

        reference = FirebaseDatabase.getInstance().getReference().child("users");

        Button btnRegister = (Button) findViewById(R.id.register_button);
        Button btnLogin = (Button) findViewById(R.id.login_button);

        //onclick for when login button is pressed
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                validateRegisterForm();

            }
        });

    }

    private Boolean validateRegisterForm(){

        String valueFirstName = firstName.getText().toString();
        String valueLastName   = lastName.getText().toString();
        String valueEmail  = userEmail.getText().toString();
        String valuePassword  = userPassword.getText().toString();
        String valueCPassword = userCPassword.getText().toString();
        String passwordValidation = "^" + "(?=.*[0-9])" + "(?=.*[a-z])" + "(?=.*[A-Z])" + "(?=.*[0-9])" + "(?=.*[@#$%^&+=])" + ".{6,}" + "$";
        String valueAddress  = userAddress.getText().toString();
        String blood = bloodType.getSelectedItem().toString();

        if (valueFirstName.isEmpty()) {
            firstName.setError("Field cannot be empty");
            return false;
        }else if (valueLastName.isEmpty()){
            lastName.setError("Field cannot be empty");
            return false;
        }else if (valueEmail.isEmpty()){
            userEmail.setError("Field cannot be empty");
            return false;
        }else if (valuePassword.isEmpty()) {
            userPassword.setError("Field cannot be empty");
            return false;
        }else if (!valuePassword.matches(passwordValidation)) {
            userPassword.setError("Password is too weak");
            return false;
        }else if (valueCPassword.isEmpty()){
            userCPassword.setError("Field cannot be empty");
            return false;
        }else if (valueAddress.isEmpty()){
            userAddress.setError("Field cannot be empty");
            return false;
        }else{
            firstName.setError(null);
            lastName.setError(null);
            userEmail.setError(null);
            userPassword.setError(null);
            userAddress.setError(null);
            insertUserData();
            return true;
        }
    }

    //String email pattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    private void insertUserData(){
        String fname = firstName.getText().toString();
        String lname = lastName.getText().toString();
        String email = userEmail.getText().toString();
        String password = userPassword.getText().toString();
        String address = userAddress.getText().toString();
        String blood = bloodType.getSelectedItem().toString();

        RegisterHelperClass registerHelperClass = new RegisterHelperClass(fname, lname, email, password, address, blood);

        reference.push().setValue(registerHelperClass);
        Toast.makeText(register.this, "Successful Register!", Toast.LENGTH_SHORT).show();
    }

    }