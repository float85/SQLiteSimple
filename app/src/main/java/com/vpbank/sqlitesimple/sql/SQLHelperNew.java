package com.vpbank.sqlitesimple.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLHelperNew extends SQLiteOpenHelper {
    final static String DB_NAME = "Product";
    final static int DB_VERSION = 2;

    public SQLHelperNew(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String querySQL = "CREATE TABLE Product (" +
                "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "des TEXT," +
                "price INTEGER" +
                ");";
        sqLiteDatabase.execSQL(querySQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            sqLiteDatabase.execSQL("drop table if exists " + DB_NAME);
            onCreate(sqLiteDatabase);
        }
    }
}
