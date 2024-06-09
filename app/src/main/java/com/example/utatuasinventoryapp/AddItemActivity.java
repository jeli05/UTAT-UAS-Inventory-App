package com.example.utatuasinventoryapp;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddItemActivity extends AppCompatActivity {

    private InventoryDatabaseHelper dbHelper;

    private EditText nameEditText;
    private EditText itemIDEditText;
    private EditText categoryEditText;
    private EditText subcategoryEditText;
    private EditText locationEditText;
    private EditText quantityEditText;
    private EditText statusEditText;
    private EditText notesEditText;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        dbHelper = new InventoryDatabaseHelper(this);

        nameEditText = findViewById(R.id.edit_text_name);
        itemIDEditText = findViewById(R.id.edit_text_item_id);
        categoryEditText = findViewById(R.id.edit_text_category);
        subcategoryEditText = findViewById(R.id.edit_text_subcategory);
        locationEditText = findViewById(R.id.edit_text_location);
        quantityEditText = findViewById(R.id.edit_text_quantity);
        statusEditText = findViewById(R.id.edit_text_status);
        notesEditText = findViewById(R.id.edit_text_notes);
        addButton = findViewById(R.id.button_add);
        Button backButton = findViewById(R.id.back_button);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItemToDatabase();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void addItemToDatabase() {
        String name = nameEditText.getText().toString();
        String itemID = itemIDEditText.getText().toString();
        String category = categoryEditText.getText().toString();
        String subcategory = subcategoryEditText.getText().toString();
        String location = locationEditText.getText().toString();
        String quantity = quantityEditText.getText().toString();
        String status = statusEditText.getText().toString();
        String notes = notesEditText.getText().toString();

        if (name.isEmpty() || itemID.isEmpty() || category.isEmpty() || subcategory.isEmpty() || location.isEmpty() || quantity.isEmpty() || status.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("itemID", itemID);
        values.put("category", category);
        values.put("subcategory", subcategory);
        values.put("location", location);
        values.put("quantity", Integer.parseInt(quantity));
        values.put("status", status);
        values.put("notes", notes);

        long newRowId = db.insert("inventory", null, values);
        if (newRowId != -1) {
            Toast.makeText(this, "Item added successfully", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(this, "Error adding item", Toast.LENGTH_SHORT).show();
        }
    }
}
