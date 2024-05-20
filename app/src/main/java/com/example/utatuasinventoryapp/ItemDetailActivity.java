package com.example.utatuasinventoryapp;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ItemDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        String item = getIntent().getStringExtra("item");
//        TextView title = findViewById(R.id.item_title);
//        title.setText("Item: " + item);

        // Set other item details similarly
    }
}