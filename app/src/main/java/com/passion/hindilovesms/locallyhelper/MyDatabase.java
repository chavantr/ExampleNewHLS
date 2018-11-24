
package com.passion.hindilovesms.locallyhelper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

import java.util.ArrayList;
import java.util.List;


public class MyDatabase extends SQLiteAssetHelper {

    public MyDatabase(Context context, String name, CursorFactory factory,
                      int version) {
        super(context, name, factory, version);
    }

    public List<String> getUnionMessages() {
        List<String> lstUnionMessage = new ArrayList<>();
        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.rawQuery("select vaue from hsutsav union select name from hscategory union select name from specialday", null);
        if (cursor.moveToFirst()) {
            do {
                lstUnionMessage.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }
        return lstUnionMessage;
    }


    public List<String> getCategoryMessages(int category) {
        List<String> lstUnionMessage = new ArrayList<>();
        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT name FROM hscategory where cate_id=" + category, null);
        if (cursor.moveToFirst()) {
            do {
                lstUnionMessage.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }
        return lstUnionMessage;
    }


    public List<String> getUtsavMessages(int category) {
        List<String> lstUnionMessage = new ArrayList<>();
        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT vaue FROM hsutsav where type_id=" + category, null);
        if (cursor.moveToFirst()) {
            do {
                lstUnionMessage.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }
        return lstUnionMessage;
    }


    public List<String> getMessages(int category) {
        List<String> lstUnionMessage = new ArrayList<>();
        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT name FROM specialday where cate_id=" + category, null);
        if (cursor.moveToFirst()) {
            do {
                lstUnionMessage.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }
        return lstUnionMessage;
    }


}
