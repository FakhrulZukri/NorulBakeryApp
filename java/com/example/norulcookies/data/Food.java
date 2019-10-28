package com.example.norulcookies.data;

import android.database.Cursor;

public class Food {

    public int id;

    public String name;
    public String description;
    public String image;
    public Double price;

    public Food(Cursor cursor) {
        this.name = cursor.getString(cursor.getColumnIndex(FoodContract.FoodEntry.COLUMN_NAME));
        this.description = cursor.getString(cursor.getColumnIndex(FoodContract.FoodEntry.COLUMN_DESCRIPTION));
        this.image = cursor.getString(cursor.getColumnIndex(FoodContract.FoodEntry.COLUMN_IMAGE));
        this.price = cursor.getDouble(cursor.getColumnIndex(FoodContract.FoodEntry.COLUMN_PRICE));
    }
}
