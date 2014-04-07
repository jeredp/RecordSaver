package com.jphili.recordsaver.db;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import java.util.UUID;

public class Repository {

    private final SQLiteDatabase db;

    public Repository(DbHelper dbHelper) {
        this.db = dbHelper.getWritableDatabase();
    }

    public long insert(UUID uuid, String title, String content) {
    // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(Table.COLUMN_NAME_UUID, uuid.toString());
        values.put(Table.COLUMN_NAME_TITLE, title);
        values.put(Table.COLUMN_NAME_JSON_BODY, content);

        return db.insert(Table.TABLE_NAME, null, values);
    }
}
