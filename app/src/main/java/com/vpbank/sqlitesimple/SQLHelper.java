package com.vpbank.sqlitesimple;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class SQLHelper extends SQLiteOpenHelper {

    static final String DB_NAME = "Product.db";
    static final String DB_NAME_TABLE = "Product";
    static final int DB_VERSION = 2;

    SQLiteDatabase sqLiteDatabase;
    ContentValues contentValues;


    public SQLHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCreaTable = "CREATE TABLE Product ( " +
                "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "name Text," +
                " quantity INTEGER )";


        //Chạy câu lệnh tạo bảng product
        db.execSQL(queryCreaTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion == newVersion) {
            db.execSQL("drop table if exists " + DB_NAME_TABLE);
            onCreate(db);
        }
    }

    public void insertProduct() {
        sqLiteDatabase = getWritableDatabase();
        contentValues = new ContentValues();
        contentValues.put("name", "Coca");
        contentValues.put("quantity", "15");

        sqLiteDatabase.insert(DB_NAME_TABLE, null, contentValues);
        closeDB();
    }

    private void closeDB() {
        sqLiteDatabase.close();
        contentValues.clear();
    }
}
