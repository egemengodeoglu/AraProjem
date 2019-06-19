package com.example.araprojem;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class sqlLite_oneri_1 extends SQLiteOpenHelper{
    public sqlLite_oneri_1(Context c){
        super(c,"oneri_1",null,1);
    }

    public void onCreate(SQLiteDatabase db){
        String sql="create table oneri_1 (userid varchar(8),venueid varchar(25)," +
                "control bit)";
        db.execSQL(sql);
    }
    public void onUpgrade (SQLiteDatabase db, int eski, int yeni){
        db.execSQL("drop table if exists oneri_1");
    }

}
