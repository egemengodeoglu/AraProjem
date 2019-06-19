package com.example.araprojem;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class sqlLite_checkins extends SQLiteOpenHelper {
    public sqlLite_checkins(Context c){
        super(c,"checkins",null,1);
    }

    public void onCreate(SQLiteDatabase db){
        String sql="create table checkins (userid varchar(12),venueid varchar(30)," +
                "category varchar(50),city varchar(10))";
        db.execSQL(sql);
    }
    public void onUpgrade (SQLiteDatabase db, int eski, int yeni){
        db.execSQL("drop table if exists checkins");
    }
}
