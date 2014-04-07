package com.jphili.recordsaver.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Pair;

import com.google.inject.Inject;
import com.jphili.recordsaver.app.models.Model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Repository {

    private final DbHelper dbHelper;

    @Inject
    public Repository(DbHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    public long insert(UUID uuid, String title, String content) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(Table.COLUMN_NAME_UUID, uuid.toString());
        values.put(Table.COLUMN_NAME_TITLE, title);
        values.put(Table.COLUMN_NAME_JSON_BODY, content);

        return db != null ? db.insert(Table.TABLE_NAME, null, values) : 0;
    }

    public List<Model> getData(Long id, UUID uuid, String title) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] projection = createProjection();
        Pair<String, String[]> selection = getSelectionAndArguments(id, uuid, title);

        assert db != null;

        Cursor cursor = db.query(
                Table.TABLE_NAME,                         // The table to query
                projection,                               // The columns to return
                selection.first,                          // The columns for the WHERE clause
                selection.second,                         // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                      // The sort order
        );

        List<Model> models = new ArrayList();

        while(cursor.moveToNext()) {
            String itemUUIDString = cursor.getString(cursor.getColumnIndexOrThrow(Table.COLUMN_NAME_UUID));
            String itemTitle = cursor.getString(cursor.getColumnIndexOrThrow(Table.COLUMN_NAME_TITLE));
            String itemContent = cursor.getString(cursor.getColumnIndexOrThrow(Table.COLUMN_NAME_JSON_BODY));
            UUID  itemUUID = UUID.fromString(itemUUIDString);
            models.add(new Model(itemUUID, itemTitle, itemContent));
        }
        return models;
    }

    private Pair<String, String[]> getSelectionAndArguments(Long id, UUID uuid, String title) {
        String selection = "";
        String[] arguments = {};
        if(id != null) {
            selection = Table._ID + " = ?";
            arguments = new String[]{String.valueOf(id)};
        }
        else if(uuid != null) {
            selection =Table.COLUMN_NAME_UUID + " = ?";
            arguments = new String[]{String.valueOf(uuid.toString())};
        }
        else if(title != null) {
            selection = Table.COLUMN_NAME_TITLE + " = ?";
            arguments = new String[]{String.valueOf(title)};
        }

        return new Pair(selection.toString(), arguments);
    }

    private String[] createProjection() {
        return new String[]{
                    Table.COLUMN_NAME_UUID,
                    Table.COLUMN_NAME_TITLE,
                    Table.COLUMN_NAME_JSON_BODY
            };
    }
}
