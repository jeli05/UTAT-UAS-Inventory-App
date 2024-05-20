package com.example.utatuasinventoryapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SubcategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subcategory);

        String category = getIntent().getStringExtra("category");
        TextView title = findViewById(R.id.subcategory_title);
        title.setText("Category: " + category);
    }

    public void openItems(View view) {
        Intent intent = new Intent(this, ItemsActivity.class);
        intent.putExtra("subcategory", "RC controllers");
        startActivity(intent);
    }

    // Add similar methods for other subcategories
}