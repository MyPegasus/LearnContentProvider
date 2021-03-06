package com.example.mypegasus.learncontentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by MyPegasus on 2015/10/21.
 */
public class MyProvider extends ContentProvider {

    SQLiteDatabase database;
    public static final Uri URI = Uri.parse("content://com.example.mypegasus.learncontentprovider.MyProvider");

    @Override
    public boolean onCreate() {
        database = getContext().openOrCreateDatabase("mycp.db3", Context.MODE_PRIVATE, null);
        database.execSQL("create table tab(_id integer primary key autoincrement, name text not null)");
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Cursor cursor = database.query("tab", null, null, null, null, null, null);
        return cursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        database.insert("tab", null, values);
//        database.close();
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
