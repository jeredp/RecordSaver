package com.jphili.recordsaver.db;

import android.provider.BaseColumns;

public final class Table implements BaseColumns {
        public static final String _ID = "_ID";
        public static final String TABLE_NAME = "JSON_DOCS";
        public static final String COLUMN_NAME_UUID = "entryid";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_JSON_BODY = "body";

        public static final String TEXT_TYPE = " TEXT";
        public static final String COMMA_SEP = ",";
        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY," +
                        COLUMN_NAME_UUID + TEXT_TYPE + COMMA_SEP +
                        COLUMN_NAME_TITLE + TEXT_TYPE + COMMA_SEP +
                        COLUMN_NAME_JSON_BODY + TEXT_TYPE +
                        " )";

        public static final String SQL_DELETE_TABLE =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
}
