package com.example.araprojem;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class sqlLite_places extends SQLiteOpenHelper {
    public sqlLite_places(Context c){
        super(c,"places",null,1);
    }

    public void onCreate(SQLiteDatabase db){
        String sql="create table places (venueid varchar(30),longitude varchar(30)," +
                "latitude varchar(30))";
        db.execSQL(sql);
    }
    public void onUpgrade (SQLiteDatabase db, int eski, int yeni){
        db.execSQL("drop table if exists places");
    }
}
