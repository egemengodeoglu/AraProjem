package com.example.araprojem;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class sqlLite_oneri_3 extends SQLiteOpenHelper {
    public sqlLite_oneri_3(Context c){
        super(c,"oneri_3",null,1);
    }

    public void onCreate(SQLiteDatabase db){
        String sql="create table oneri_3 (userid varchar(5),"+
                "venueid1 varchar(25),control1 bit," +
                "venueid2 varchar(25),control2 bit," +
                "venueid3 varchar(25),control3 bit," +
                "venueid4 varchar(25),control4 bit," +
                "venueid5 varchar(25),control5 bit," +
                "venueid6 varchar(25),control6 bit," +
                "venueid7 varchar(25),control7 bit," +
                "venueid8 varchar(25),control8 bit," +
                "venueid9 varchar(25),control9 bit," +
                "venueid10 varchar(25),control10 bit)";

        db.execSQL(sql);
    }
    public void onUpgrade (SQLiteDatabase db, int eski, int yeni){
        db.execSQL("drop table if exists oneri_3");
    }
}
