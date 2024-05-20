package com.example.utatuasinventoryapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ItemsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);

        String subcategory = getIntent().getStringExtra("subcategory");
//        TextView title = findViewById(R.id.items_title);
//        title.setText("Subcategory: " + subcategory);
    }

    public void openItemDetail(View view) {
        Intent intent = new Intent(this, ItemDetailActivity.class);
        intent.putExtra("item", "Futaba T10J");
        startActivity(intent);
    }

    // Add similar methods for other items
}