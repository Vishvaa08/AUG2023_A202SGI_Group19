package com.example.account;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class bloodbank extends AppCompatActivity {

    Button bloodB, bloodA, bloodAB, bloodO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bloodbank);

        // page title
        TextView pageTitle = (TextView) findViewById(R.id.page_title);
        pageTitle.setText("Bank");

        bloodB = findViewById(R.id.btnB);
        bloodA = findViewById(R.id.btnA);
        bloodAB = findViewById(R.id.btnAB);
        bloodO = findViewById(R.id.btnO);

    }

}


// after press the blood type button, where will go?



