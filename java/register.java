package com.example.bloodunitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Spinner;

public class register extends AppCompatActivity {

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
                Toast.makeText(register.this, "Back", Toast.LENGTH_SHORT).show();
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

        Button btnRegister = (Button) findViewById(R.id.register_button);
        Button btnLogin = (Button) findViewById(R.id.login_button);

        //onclick for when login button is pressed
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void Register(View view){
        Intent intent = new Intent(register.this, shop.class);
        Button shop = (Button) findViewById(R.id.register_button);
        startActivity(intent);
    }

    }