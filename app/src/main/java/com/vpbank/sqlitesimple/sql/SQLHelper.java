package com.vpbank.sqlitesimple.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

class SQLHelper extends SQLiteOpenHelper {
    private static final String TAG = "SQLHelper";
    static final String DB_NAME = "Product.db";
    static final String DB_NAME_TABLE = "Product";
    static final int DB_VERSION = 4;

    SQLiteDatabase sqLiteDatabase;
    ContentValues contentValues;
    Cursor cursor;


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
        if (oldVersion != newVersion) {
            db.execSQL("drop table if exists " + DB_NAME_TABLE);
            onCreate(db);
        }
    }

    public void insertProduct(String name, String quantity) {
        sqLiteDatabase = getWritableDatabase();
        contentValues = new ContentValues();

        contentValues.put("name", name);
        contentValues.put("quantity", quantity);

        sqLiteDatabase.insert(DB_NAME_TABLE, null, contentValues);
        closeDB();
    }

    public int deleteProduct(String id) {
        sqLiteDatabase = getWritableDatabase();
        return sqLiteDatabase.delete(DB_NAME_TABLE, " id=?",
                new String[]{String.valueOf(id)});
    }

    public boolean delAllProduct() {
        int result;
        sqLiteDatabase = getWritableDatabase();
        result = sqLiteDatabase.delete(DB_NAME_TABLE, null, null);
        closeDB();
        if (result == 1) return true;
        else return false;
    }

    public void updateProduct(String id, String name, String quantity) {
        sqLiteDatabase = getWritableDatabase();
        contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("quantity", quantity);

        sqLiteDatabase.update(DB_NAME_TABLE, contentValues, "id=?",
                new String[]{String.valueOf(id)});
        closeDB();
    }


    public void getAllProduct() {
        sqLiteDatabase = getReadableDatabase();
        cursor = sqLiteDatabase.query(false, DB_NAME_TABLE, null,
                null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            int quantity = cursor.getInt(cursor.getColumnIndex("quantity"));
            Log.d(TAG, "getAllProduct: " + "id - " + id + " - name - " + name + " - quantity - " + quantity);
        }
        closeDB();
    }

    public List<Product> getAllProductAdvanced() {
        List<Product> products = new ArrayList<>();
        Product product;

        sqLiteDatabase = getReadableDatabase();
        cursor = sqLiteDatabase.query(false, DB_NAME_TABLE, null, null, null
                , null, null, null, null);

        while (cursor.moveToNext()) {
            String id = cursor.getString(cursor.getColumnIndex("id"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String quantity = cursor.getString(cursor.getColumnIndex("quantity"));
            product = new Product(id, name, quantity);
            products.add(product);
        }
        closeDB();
        return products;
    }

    private void closeDB() {
        if (sqLiteDatabase != null) sqLiteDatabase.close();
        if (contentValues != null) contentValues.clear();
        if (cursor != null) cursor.close();
    }
}
