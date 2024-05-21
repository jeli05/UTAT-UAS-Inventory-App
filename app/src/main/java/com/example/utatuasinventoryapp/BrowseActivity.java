package com.example.utatuasinventoryapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class BrowseActivity extends AppCompatActivity {
    private InventoryDatabaseHelper dbHelper;
    private InventoryAdapter adapter;
    private List<InventoryItem> inventoryList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);

        dbHelper = new InventoryDatabaseHelper(this);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        SearchView searchView = findViewById(R.id.search_view);
        Button backButton = findViewById(R.id.back_button);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new InventoryAdapter(this, inventoryList);
        recyclerView.setAdapter(adapter);

        loadInventory();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.filter(newText);
                return false;
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void loadInventory() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM inventory", null);
        while (cursor.moveToNext()) {
            InventoryItem item = new InventoryItem(
                    cursor.getInt(cursor.getColumnIndexOrThrow("id")),
                    cursor.getString(cursor.getColumnIndexOrThrow("name")),
                    cursor.getString(cursor.getColumnIndexOrThrow("itemID")),
                    cursor.getString(cursor.getColumnIndexOrThrow("category")),
                    cursor.getString(cursor.getColumnIndexOrThrow("subcategory")),
                    cursor.getString(cursor.getColumnIndexOrThrow("location")),
                    cursor.getInt(cursor.getColumnIndexOrThrow("quantity")),
                    cursor.getString(cursor.getColumnIndexOrThrow("status")),
                    cursor.getString(cursor.getColumnIndexOrThrow("notes"))
            );
            inventoryList.add(item);
        }
        cursor.close();
        adapter.notifyDataSetChanged();
    }
}
