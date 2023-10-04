package com.example.blooddonation;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the menuButton
        ImageButton menuButton = findViewById(R.id.menuButton);

        // Set an OnClickListener for the menuButton
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to open the MenuActivity
                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });

        // Initialize and set image resources for ImageViews
        ImageView imageView1 = findViewById(R.id.imageView1);
        imageView1.setImageResource(R.drawable.img1);

        ImageView imageView2 = findViewById(R.id.imageView2);
        imageView2.setImageResource(R.drawable.img2);

        ImageView imageView3 = findViewById(R.id.imageView3);
        imageView3.setImageResource(R.drawable.img3);
    }
}
