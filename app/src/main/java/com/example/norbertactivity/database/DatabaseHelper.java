package com.example.norbertactivity.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "children.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_CHILDREN = "children";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_AGE = "age";
    private static final String COLUMN_ENROLLED = "enrolled";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CHILDREN_TABLE = "CREATE TABLE " + TABLE_CHILDREN + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_AGE + " INTEGER,"
                + COLUMN_ENROLLED + " INTEGER" + ")";
        db.execSQL(CREATE_CHILDREN_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHILDREN);
        onCreate(db);
    }

    // CRUD operations
    public void addChild(String name, int age, boolean enrolled) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_AGE, age);
        values.put(COLUMN_ENROLLED, enrolled ? 1 : 0);

        long result = db.insert(TABLE_CHILDREN, null, values);
        if (result == -1) {
            Log.e("DatabaseHelper", "Error inserting data: " + name);
        } else {
            Log.i("DatabaseHelper", "Inserted data: " + name);
        }
        db.close();
    }

    public Cursor getAllChildren() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_CHILDREN, null);
    }
    // Update method in DatabaseHelper
    public void updateChild(int id, String name, int age, boolean enrolled) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_AGE, age);
        values.put(COLUMN_ENROLLED, enrolled ? 1 : 0);

        // Update the child record with the specified ID
        db.update(TABLE_CHILDREN, values, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
        db.close();
    }

    // Method to delete a child by ID
    public void deleteChild(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CHILDREN, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
        db.close();
    }
}
