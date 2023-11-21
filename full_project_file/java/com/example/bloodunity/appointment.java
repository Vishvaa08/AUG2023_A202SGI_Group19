package com.example.bloodunity;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class appointment extends AppCompatActivity {

    DatabaseReference reference;
    FirebaseDatabase database;

    EditText name_appointment;

    Button btnSubmit;

    DatePicker datePicker;

    Spinner bloodPicker;

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        datePicker = findViewById(R.id.datePicker);
        btnSubmit = findViewById(R.id.submit_button);
        name_appointment = findViewById(R.id.nameAppointment);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);

        // page title
        TextView pageTitle = (TextView) findViewById(R.id.page_title);
        pageTitle.setText("Appointment");


        Spinner spinner1 = (Spinner)findViewById(R.id.bloodPicker);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(appointment.this, R.array.blood_type, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

        btnSubmit = findViewById(R.id.submit_button);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                bloodPicker.getSelectedItem().toString();

                String day, month, year;
                day = String.valueOf(datePicker.getDayOfMonth());
                month = String.valueOf(datePicker.getMonth() + 1);
                year = String.valueOf(datePicker.getYear());
                Toast.makeText(appointment.this,day+ "/" + month + "/" + year,Toast.LENGTH_SHORT).show();


                RegisterHelperClass registerHelperClass = new RegisterHelperClass(bloodPicker);

                FirebaseDatabase.getInstance().getReference("Appointment").child(String.valueOf(bloodPicker))
                        .setValue(registerHelperClass).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()){
                                    Toast.makeText(appointment.this, "Saved", Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(appointment.this, homepage.class);
                                    startActivity(intent);
                                }
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(appointment.this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

    }
}