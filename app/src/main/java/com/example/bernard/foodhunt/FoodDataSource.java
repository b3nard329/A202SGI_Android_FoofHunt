package com.example.bernard.foodhunt;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import static com.example.bernard.foodhunt.MySQLiteHelper.COLUMN_LOCATION;
import static com.example.bernard.foodhunt.MySQLiteHelper.COLUMN_MEALS_TYPE;
import static com.example.bernard.foodhunt.MySQLiteHelper.COLUMN_PRICE_RANGE;
import static com.example.bernard.foodhunt.MySQLiteHelper.COLUMN_RESTAURANT_NAME;
import static com.example.bernard.foodhunt.MySQLiteHelper.TABLE_COMMENTS;

/**
 * Created by WongYeeKhang on 29/11/2017.
 */

public class FoodDataSource {

    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] allColums = {MySQLiteHelper.COLUMN_ID,MySQLiteHelper.COLUMN_MEALS_TYPE, MySQLiteHelper.COLUMN_RESTAURANT_NAME,MySQLiteHelper.COLUMN_PRICE_RANGE,MySQLiteHelper.COLUMN_LOCATION,MySQLiteHelper.COLUMN_PRICE_RANGE_VALUE,
            MySQLiteHelper.COLUMN_OPENING_HOUR};

    public FoodDataSource(Context context){
        dbHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close(){
        dbHelper.close();
    }

    public boolean checkRecord(){
        boolean rValue = false;
        Cursor cursor = database.query(TABLE_COMMENTS,
                allColums,null,null,null,null,null);

        if (cursor.moveToFirst()) {
            do {
                // Data Is Exist;
                rValue = true;
            } while (cursor.moveToNext());
        }

        return rValue;
    }

    public void insertRecord(String meals_type,String restaurant_name,String price_range,String location,String price_value,String opening_hour) {
        ContentValues values = new ContentValues();

        values.put(MySQLiteHelper.COLUMN_MEALS_TYPE,meals_type);
        values.put(COLUMN_RESTAURANT_NAME,restaurant_name);
        values.put(COLUMN_PRICE_RANGE,price_range);
        values.put(MySQLiteHelper.COLUMN_LOCATION,location);
        values.put(MySQLiteHelper.COLUMN_PRICE_RANGE_VALUE,price_value);
        values.put(MySQLiteHelper.COLUMN_OPENING_HOUR,opening_hour);
        database.insert(TABLE_COMMENTS, null, values);
    }


    public void deleteComment(Restaurant restaurant) {
        long id = restaurant.getId();
        System.out.println("Comment deleted with id: " + id);
        database.delete(TABLE_COMMENTS, MySQLiteHelper.COLUMN_ID + "=" + id, null);
    }


    public List<Restaurant> get_searchRestaurant(String location_selected, String price_range_selected,String meal){
        List<Restaurant> restaurants = new ArrayList<Restaurant>();

        Cursor cursor = database.query(TABLE_COMMENTS,allColums,
                COLUMN_PRICE_RANGE + "='" +price_range_selected+ "'" + " AND " +COLUMN_LOCATION + "='" +location_selected+ "'"
                        + " AND " +COLUMN_MEALS_TYPE + "='" +meal+ "'",null,null,null,null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Restaurant restaurant = cursorToComment(cursor);
            restaurants.add(restaurant);
            cursor.moveToNext();
        }


        cursor.close();
        return restaurants;
    }


    private Restaurant cursorToComment (Cursor cursor) {
        Restaurant restaurant = new Restaurant();
        restaurant.setId(cursor.getLong(0));
        restaurant.setRestaurant_name(cursor.getString(2));
        restaurant.setRestaurant_price_range(cursor.getString(3));
        restaurant.setRestaurant_location(cursor.getString(4));
        restaurant.setRestaurant_price_range_value(cursor.getString(5));
        restaurant.setRestaurant_opening_hour(cursor.getString(6));
        return restaurant;
    }
}
