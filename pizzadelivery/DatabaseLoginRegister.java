package com.example.user.pizzadelivery;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseLoginRegister extends SQLiteOpenHelper{

    //database version
    private static final int DATABASE_VERSION = 1;

    //DATABASE NAME
    private static final String DATABASE_NAME = "Register.db";

    //Table Name
    private static final String Table_Name = "User";

    //publiv sqlite db
    private SQLiteDatabase db;

    //User Table Colums Name
    private static final String COLUMN_USERNAME = "editUsername";
    private static final String COLUMN_PASSWORD = "editPassword";
    private static final String COLUMN_EMAIL = "editEmail";
    private static final String COLUMN_ADDRESS = "editAddress";
    private static final String COLUMN_NOPHONE = "editPhone";

    //create table sql query
    private String CREATE_USER_TABLE = "CREATE TABLE " + Table_Name + "(" + COLUMN_USERNAME + "TEXT PRIMARY KEY," + COLUMN_PASSWORD
            + "INTEGER," + COLUMN_EMAIL + "TEXT," + COLUMN_ADDRESS + "TEXT," + COLUMN_NOPHONE + "TEXT" + ")";

    //drop table sql query
    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + Table_Name;

    public DatabaseLoginRegister(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //drop table user if exist
        db.execSQL(DROP_USER_TABLE);

        //create tables again
        onCreate(db);
    }

    //add user
    public void addUser(User user){
    }

    public void updateUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME, user.getUsername());
        values.put(COLUMN_PASSWORD, user.getPassword());
        values.put(COLUMN_EMAIL, user.getEmail());
        values.put(COLUMN_ADDRESS, user.getAddress());
        values.put(COLUMN_NOPHONE, user.getNoPhone());

        //updating row
        db.update(Table_Name, values,COLUMN_USERNAME + " =? ", new String[]{String.valueOf(user.getUsername())});
        db.close();
    }

    public void deleteUser(User user){
        SQLiteDatabase db = getWritableDatabase();

        //delete user record by username
        db.delete(Table_Name,COLUMN_USERNAME+ " = ?", new String[]{String.valueOf(user.getUsername())});
        db.close();
    }


    public String getSingleEntry(String username){
        Cursor cursor=db.query("User", null,"editUsername=?", new String[]{username},null,null,null);
        if(cursor.getCount()<1){
            cursor.close();
            return "Not EXIST";
        }
        cursor.moveToFirst();
        String password = cursor.getString(cursor.getColumnIndex("editPassword"));
        cursor.close();
        return password;
    }


}
