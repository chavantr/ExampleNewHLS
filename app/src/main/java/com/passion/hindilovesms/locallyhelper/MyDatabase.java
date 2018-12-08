
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

    public ArrayList<Object> getUnionMessages() {
        ArrayList<Object> lstUnionMessage = new ArrayList<>();
        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.rawQuery("select vaue from hsutsav union select name from hscategory union select name from specialday", null);
        if (cursor.moveToFirst()) {
            do {
                lstUnionMessage.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }
        return lstUnionMessage;
    }


    public ArrayList<Object> getCategoryMessages(int category) {
        ArrayList<Object> lstUnionMessage = new ArrayList<>();
        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT name FROM hscategory where cate_id=" + category, null);
        if (cursor.moveToFirst()) {
            do {
                lstUnionMessage.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }
        return lstUnionMessage;
    }


    public ArrayList<Object> getUtsavMessages(int category) {
        ArrayList<Object> lstUnionMessage = new ArrayList<>();
        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT vaue FROM hsutsav where type_id=" + category, null);
        if (cursor.moveToFirst()) {
            do {
                lstUnionMessage.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }
        return lstUnionMessage;
    }


    public ArrayList<Object> getMessages(int category) {
        ArrayList<Object> lstUnionMessage = new ArrayList<>();
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
