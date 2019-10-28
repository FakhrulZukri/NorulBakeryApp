package com.example.norulcookies.data;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.norulcookies.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FoodDbHelper extends SQLiteOpenHelper {

    private static final String TAG = FoodDbHelper.class.getSimpleName();

    private static final String DATABASE_NAME = "norulcookies.db";
    private static final int DATABASE_VERSION = 1;
    Context context;
    SQLiteDatabase db;
    ContentResolver mContentResolver;

    private Resources mResources;

    public FoodDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        mResources = context.getResources();
        mContentResolver = context.getContentResolver();

        db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_FRAGRANCE_TABLE = "CREATE TABLE" + FoodContract.FoodEntry.TABLE_NAME + " (" +
                FoodContract.FoodEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                FoodContract.FoodEntry.COLUMN_NAME + " TEXT UNIQUE NOT NULL, " +
                FoodContract.FoodEntry.COLUMN_DESCRIPTION + " TEXT NOT NULL, " +
                FoodContract.FoodEntry.COLUMN_IMAGE + " TEXT NOT NULL, " +
                FoodContract.FoodEntry.COLUMN_PRICE + " REAL NOT NULL " + " );";

        final String SQL_CREATE_CART_FRAGRANCE_TABLE = "CREATE TABLE" + FoodContract.FoodEntry.CART_TABLE + " (" +
                FoodContract.FoodEntry._CARTID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                FoodContract.FoodEntry.COLUMN_CART_NAME + " TEXT UNIQUE NOT NULL, " +
                FoodContract.FoodEntry.COLUMN_CART_IMAGE + " TEXT NOT NULL, " +
                FoodContract.FoodEntry.COLUMN_CART_TOTAL_PRICE + " REAL NOT NULL " + " );";

        db.execSQL(SQL_CREATE_FRAGRANCE_TABLE);
        db.execSQL(SQL_CREATE_CART_FRAGRANCE_TABLE);
        Log.d(TAG, "Database Created Sucessfully");

        try {
            readFoodFromResources(db);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + FoodContract.FoodEntry.TABLE_NAME );
        db.execSQL("DROP TABLE IF EXISTS " + FoodContract.FoodEntry.CART_TABLE);
        onCreate(db);
    }

    private void readFoodFromResources(SQLiteDatabase db) throws IOException, JSONException {

        StringBuilder builder = new StringBuilder();
        InputStream in = mResources.openRawResource(R.raw.food);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        String line;
        while ((line = reader.readLine()) != null) {
            builder.append(line + "\n");
        }

        final String rawJson = builder.toString();

        final String BGS_FOODS = "foods";

        final String BGS_FOODNAME = "foodName";

        final String BGS_DESCRIPTION = "description";

        final String BGS_IMAGE = "image";

        final String BGS_PRICE = "price";

        try {
            JSONObject foodJson = new JSONObject(rawJson);
            JSONArray foodArray = foodJson.getJSONArray(BGS_FOODS);

            for (int i=0; i < foodArray.length();i++) {

                String foodName;
                String description;
                String image;
                Double price;

                JSONObject foodDetails = foodArray.getJSONObject(i);

                foodName = foodDetails.getString(BGS_FOODNAME);
                description = foodDetails.getString(BGS_DESCRIPTION);
                image = foodDetails.getString(BGS_IMAGE);
                price = foodDetails.getDouble(BGS_PRICE);

                ContentValues foodValues = new ContentValues();

                foodValues.put(FoodContract.FoodEntry.COLUMN_NAME, foodName);
                foodValues.put(FoodContract.FoodEntry.COLUMN_DESCRIPTION, description);
                foodValues.put(FoodContract.FoodEntry.COLUMN_IMAGE, image);
                foodValues.put(FoodContract.FoodEntry.COLUMN_PRICE, price);

                db.insert(FoodContract.FoodEntry.TABLE_NAME, null, foodValues);

                Log.d(TAG, "Inserted Successfully" + foodValues);

            }

            Log.d(TAG, "Inserted Successfully " + foodArray.length() );


        } catch (JSONException e) {
            Log.e(TAG, e.getMessage(), e);
            e.printStackTrace();

        }
    }


}
