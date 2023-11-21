package com.example.bloodunity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;



public class account extends AppCompatActivity {

    EditText editName, editEmail, editAddress, editPassword;
    Button btnEditProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        // page title
        TextView pageTitle = (TextView) findViewById(R.id.page_title);
        pageTitle.setText("Account");


        editName = findViewById(R.id.editName);
        editEmail = findViewById(R.id.editEmail);
        editAddress = findViewById(R.id.editAddress);
        editPassword = findViewById(R.id.editPassword);
        btnEditProfile = findViewById(R.id.btnEditProfile);

        showUserData();
    }

    public void showUserData(){

        Intent intent = getIntent();

        String userName = intent.getStringExtra("name");
        String userAddress = intent.getStringExtra("address");
        String userPassword = intent.getStringExtra("password");
        String userEmail = intent.getStringExtra("email");


        editName.setText(userName);
        editAddress.setText(userAddress);
        editPassword.setText(userPassword);
        editEmail.setText(userEmail);


    }
}