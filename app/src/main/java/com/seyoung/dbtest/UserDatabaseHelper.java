package com.seyoung.dbtest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class UserDatabaseHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "user.db";

    public UserDatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS USER_SEQ (id INTEGER PRIMARY KEY AUTOINCREMENT, NUMBER TEXT NOT NULL, APP_NAME TEXT NOT NULL, USE_TIME TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

    public void InsertUser(String _number, String _appName, String _useTime) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO USER_SEQ (NUMBER, APP_NAME, USE_TIME) VALUES ('" + _number + "', '" + _appName + "', '" + _useTime + "')");
    }
}
