package com.example.mycapstoneproject;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "medicine_table")
public class Medicine {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;

    private String type;

    private int quantity;

    private String timestamp;


    public Medicine(String name, String type, int quantity, String timestamp) {
        this.name = name;
        this.type = type;
        this.quantity = quantity;
        this.timestamp = timestamp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
