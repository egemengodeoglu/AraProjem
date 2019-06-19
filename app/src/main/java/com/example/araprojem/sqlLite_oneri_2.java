package com.example.araprojem;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class sqlLite_oneri_2 extends SQLiteOpenHelper {
    public sqlLite_oneri_2(Context c){
        super(c,"oneri_2",null,1);
    }

    public void onCreate(SQLiteDatabase db){
        String sql="create table oneri_2 (userid varchar(8),"+
                "venueid1 varchar(25),control1 varchar(1)," +
                "venueid2 varchar(25),control2 varchar(1)," +
                "venueid3 varchar(25),control3 varchar(1)," +
                "venueid4 varchar(25),control4 varchar(1)," +
                "venueid5 varchar(25),control5 varchar(1)," +
                "venueid6 varchar(25),control6 varchar(1)," +
                "venueid7 varchar(25),control7 varchar(1)," +
                "venueid8 varchar(25),control8 varchar(1)," +
                "venueid9 varchar(25),control9 varchar(1)," +
                "venueid10 varchar(25),control10 varchar(1),counter int)";

        db.execSQL(sql);
    }
    public void onUpgrade (SQLiteDatabase db, int eski, int yeni){
        db.execSQL("drop table if exists oneri_2");
    }
}
