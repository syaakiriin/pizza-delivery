package com.example.user.pizzadelivery;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    static final String DatabaseNname = "Pizza.db";
    public static final String TableName = "Pizza";
    public static final String COL_1 = "ID";
    public static final String COl_2 = "tOrder";
    public static final String COL_3 = "editQuantity";
    public static final String COL_4 = "tTopping";

    public DatabaseHelper(Context context) {
        super(context, DatabaseNname, null, 2);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TableName + "(" + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " + COl_2 + " TEXT, " + COL_3 +
                " TEXT, " + COL_4 +  " TEXT " + ")";
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TableName);
        onCreate(db);
    }

    //Insert Data
    public boolean insertData(String tOrder, String editQuantity, String tTopping) {
        //write data dalam table dalam database
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COl_2, tOrder);
        contentValues.put(COL_3, editQuantity);
        contentValues.put(COL_4, tTopping);

        long result = db.insert(TableName,null,contentValues);

        if(result == -1)
            return false;
        else
            return true;
    }


    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("SELECT * FROM " + TableName,null);
        return result;
    }
}
