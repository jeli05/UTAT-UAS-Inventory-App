package com.example.utatuasinventoryapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ItemDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        InventoryItem item = (InventoryItem) getIntent().getSerializableExtra("item");

        TextView itemName = findViewById(R.id.item_name);
        TextView itemDetails = findViewById(R.id.item_details);
        Button backButton = findViewById(R.id.back_button);

        itemName.setText(item.getName());
        itemDetails.setText("ID: " + item.getId() + "\n" +
                "Item ID: " + item.getItemID() + "\n" +
                "Category: " + item.getCategory() + "\n" +
                "Subcategory: " + item.getSubcategory() + "\n" +
                "Location: " + item.getLocation() + "\n" +
                "Quantity: " + item.getQuantity() + "\n" +
                "Status: " + item.getStatus() + "\n" +
                "Notes: " + item.getNotes());

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}