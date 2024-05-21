package com.example.utatuasinventoryapp;

import java.io.Serializable;

public class InventoryItem implements Serializable {
    private int id;
    private String name;
    private String itemID;
    private String category;
    private String subcategory;
    private String location;
    private int quantity;
    private String status;
    private String notes;

    public InventoryItem(int id, String name, String itemID, String category, String subcategory, String location, int quantity, String status, String notes) {
        this.id = id;
        this.name = name;
        this.itemID = itemID;
        this.category = category;
        this.subcategory = subcategory;
        this.location = location;
        this.quantity = quantity;
        this.status = status;
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getItemID() {
        return itemID;
    }

    public String getCategory() {
        return category;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public String getLocation() {
        return location;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getStatus() {
        return status;
    }

    public String getNotes() {
        return notes;
    }
}
