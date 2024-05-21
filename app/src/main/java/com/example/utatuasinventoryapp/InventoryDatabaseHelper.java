package com.example.utatuasinventoryapp;

// InventoryDatabaseHelper.java
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class InventoryDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "inventory.db";
    private static final int DATABASE_VERSION = 1;

    public InventoryDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE inventory (" +
                "id INTEGER PRIMARY KEY," +
                "name TEXT," +
                "itemID TEXT," +
                "category TEXT," +
                "subcategory TEXT," +
                "location TEXT," +
                "quantity INTEGER," +
                "status TEXT," +
                "notes TEXT" +
                ");");

        // Insert sample data
        db.execSQL("INSERT INTO inventory (name, id, itemID, category, subcategory, location, quantity, status, notes) " +
                "VALUES ('Cube Orange', 1, 'PX-C6', 'Avionics', 'Flight controllers', 'E2', 1, 'Signed out', 'N/A');");
        db.execSQL("INSERT INTO inventory (name, id, itemID, category, subcategory, location, quantity, status, notes) " +
                "VALUES ('Here 3 GPS', 21, 'H3-4', 'Avionics', 'GPS', 'F2', 1, 'Signed out', 'N/A');");
        db.execSQL("INSERT INTO inventory (name, id, itemID, category, subcategory, location, quantity, status, notes) " +
                "VALUES ('RFD900', 33, 'RF-1', 'Communication', 'Telemetry', 'F2', 1, 'Signed out by AEAC', 'N/A');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS inventory");
        onCreate(db);
    }
}
