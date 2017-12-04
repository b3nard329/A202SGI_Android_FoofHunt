package com.example.bernard.foodhunt;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by WongYeeKhang on 29/11/2017.
 */

public class MySQLiteHelper extends SQLiteOpenHelper {
    public static final String TABLE_COMMENTS = "comments";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_MEALS_TYPE = "meals_type";
    public static final String COLUMN_RESTAURANT_NAME = "restaurant_name";
    public static final String COLUMN_PRICE_RANGE = "price_range";
    public static final String COLUMN_PRICE_RANGE_VALUE = "price_range_value";
    public static final String COLUMN_OPENING_HOUR = "opening_hour";
    public static final String COLUMN_LOCATION = "location";


    private static final String DATABASE_NAME = "colleges.db";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE  =
            "create table " + TABLE_COMMENTS
            + "("
            +   COLUMN_ID +" "+"integer primary key autoincrement,"
            +   COLUMN_MEALS_TYPE +" "+"text not null,"
            +   COLUMN_RESTAURANT_NAME +" "+"text not null,"
            +   COLUMN_PRICE_RANGE +" "+"text not null,"
            +   COLUMN_LOCATION +" "+"text not null,"
            +   COLUMN_PRICE_RANGE_VALUE +" "+"text not null,"
            +   COLUMN_OPENING_HOUR +" "+"text not null"
            + ");";


    public MySQLiteHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database){
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion, int newVersion){
        Log.w(MySQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to"
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_COMMENTS);
        onCreate(db);
    }
}
