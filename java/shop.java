package com.example.bloodunitytest;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class shop extends AppCompatActivity {

    RecyclerView recyclerView;

    String itemName[], itemDesc[], itemPrice[];
    int itemImages[] = {R.drawable.hand_sanitizer,R.drawable.face_mask,R.drawable.latex_glove,R.drawable.face_shield,R.drawable.first_aid_kit,R.drawable.plaster,R.drawable.antiseptic,R.drawable.thermometer,R.drawable.cotton_buds,};

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_recycler_view);

        recyclerView = findViewById(R.id.shop_recycler_view);

        itemName = getResources().getStringArray(R.array.shop_items);
        itemDesc = getResources().getStringArray(R.array.item_desc);
        itemPrice = getResources().getStringArray(R.array.item_price);

        recyclerViewAdapter myAdapter = new recyclerViewAdapter(this, itemName, itemDesc, itemPrice, itemImages);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        TextView pageTitle = (TextView) findViewById(R.id.page_title);
        pageTitle.setText("Shop");
    }
}
