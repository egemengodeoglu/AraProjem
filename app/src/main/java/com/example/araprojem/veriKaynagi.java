package com.example.araprojem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public class veriKaynagi {
    SQLiteDatabase db_checkins;
    sqlLite_checkins bdb_checkins;
    SQLiteDatabase db_oneri_1;
    sqlLite_oneri_1 bdb_oneri_1;
    SQLiteDatabase db_oneri_2;
    sqlLite_oneri_2 bdb_oneri_2;
    SQLiteDatabase db_oneri_3;
    sqlLite_oneri_3 bdb_oneri_3;
    SQLiteDatabase db_places;
    sqlLite_places bdb_places;

    public veriKaynagi(Context c){
        bdb_checkins=new sqlLite_checkins(c);
        bdb_oneri_1=new sqlLite_oneri_1(c);
        bdb_oneri_2=new sqlLite_oneri_2(c);
        bdb_oneri_3=new sqlLite_oneri_3(c);
        bdb_places=new sqlLite_places(c);
    }

    public void ac(){
        db_checkins = bdb_checkins.getWritableDatabase();
        db_oneri_1=bdb_oneri_1.getWritableDatabase();
        db_oneri_2=bdb_oneri_2.getWritableDatabase();
        db_oneri_3=bdb_oneri_3.getWritableDatabase();
        db_places=bdb_places.getWritableDatabase();
    }
    public void kapat(){
        bdb_checkins.close();
        bdb_places.close();
        bdb_oneri_1.close();
        bdb_oneri_2.close();
        bdb_oneri_3.close();
    }
    public boolean isExistOneri_1(String user){
        String sql="Select userid from oneri_1 where userid="+user;
        Cursor c=db_oneri_1.rawQuery(sql,null);
        c.moveToFirst();
        if(c.getCount() > 0){
            c.close();
            return true;
        }else{
            c.close();
            return false;
        }
    }
    public Oneri_1 getir_oneri_1(String userX){
        String sql="Select userid,venueid,control from oneri_1 where userid="+userX;
        Cursor c=db_oneri_1.rawQuery(sql,null);
        c.moveToFirst();
        String userid=c.getString(0);
        String venueid=c.getString(1);
        String control=c.getString(2);
        Oneri_1 oneri=new Oneri_1();
        oneri.setUserid(userid);
        oneri.setVenueid(venueid);
        oneri.setControl(control);
        c.close();
        return oneri;
    }
    public Oneri_2 getir_oneri_2(String userX){
        if(isExistOneri_1(userX)) {
        String sql="Select userid,venueid1, control1, venueid2, control2, venueid3, control3," +
                " venueid4, control4, venueid5, control5, venueid6, control6, venueid7, control7," +
                " venueid8, control8, venueid9, control9, venueid10, control10, counter from oneri_2 where userid="+userX;
        Cursor c=db_oneri_2.rawQuery(sql,null);
        c.moveToFirst();
        Oneri_2 oneri=new Oneri_2();
        oneri.setUserid(c.getString(0));
        oneri.setVenueid1(c.getString(1));
        oneri.setControl1(c.getString(2));
        oneri.setVenueid2(c.getString(3));
        oneri.setControl2(c.getString(4));
        oneri.setVenueid3(c.getString(5));
        oneri.setControl3(c.getString(6));
        oneri.setVenueid4(c.getString(7));
        oneri.setControl4(c.getString(8));
        oneri.setVenueid5(c.getString(9));
        oneri.setControl5(c.getString(10));
        oneri.setVenueid6(c.getString(11));
        oneri.setControl6(c.getString(12));
        oneri.setVenueid7(c.getString(13));
        oneri.setControl7(c.getString(14));
        oneri.setVenueid8(c.getString(15));
        oneri.setControl8(c.getString(16));
        oneri.setVenueid9(c.getString(17));
        oneri.setControl9(c.getString(18));
        oneri.setVenueid10(c.getString(19));
        oneri.setControl10(c.getString(20));
        oneri.setCounter(Integer.parseInt(c.getString(21)));
        c.close();
        return oneri;
        }else
            return null;
    }
    public Oneri_3 getir_oneri_3(String userX){
        if(isExistOneri_1(userX)) {
            String sql = "Select userid,venueid1, control1, venueid2, control2, venueid3, control3," +
                    " venueid4, control4, venueid5, control5, venueid6, control6, venueid7, control7," +
                    " venueid8, control8, venueid9, control9, venueid10, control10, counter from oneri_3 where userid=" + userX;
            Cursor c = db_oneri_3.rawQuery(sql, null);
            c.moveToFirst();
            Oneri_3 oneri = new Oneri_3();
            oneri.setUserid(c.getString(0));
            oneri.setVenueid1(c.getString(1));
            oneri.setControl1(c.getString(2));
            oneri.setVenueid2(c.getString(3));
            oneri.setControl2(c.getString(4));
            oneri.setVenueid3(c.getString(5));
            oneri.setControl3(c.getString(6));
            oneri.setVenueid4(c.getString(7));
            oneri.setControl4(c.getString(8));
            oneri.setVenueid5(c.getString(9));
            oneri.setControl5(c.getString(10));
            oneri.setVenueid6(c.getString(11));
            oneri.setControl6(c.getString(12));
            oneri.setVenueid7(c.getString(13));
            oneri.setControl7(c.getString(14));
            oneri.setVenueid8(c.getString(15));
            oneri.setControl8(c.getString(16));
            oneri.setVenueid9(c.getString(17));
            oneri.setControl9(c.getString(18));
            oneri.setVenueid10(c.getString(19));
            oneri.setControl10(c.getString(20));
            oneri.setCounter(Integer.parseInt(c.getString(21)));
            c.close();
            return oneri;
        }else
            return null;
    }
    public Places getir_place(String venueidX){
        String sql="Select venueid,latitude,longitude from places where latitude=40.694334";
        Cursor c=db_places.rawQuery(sql,null);
        c.moveToFirst();
        String venueid=c.getString(0);
        String latitude=c.getString(1);
        String longitude=c.getString(2);
        Places place=new Places();
        place.setVenueid(venueid);
        place.setLatitude(latitude);
        place.setLongitude(longitude);
        c.close();
        return place;

    }
    public List<Checkins> checkins_listele(String userX){
        List<Checkins> liste=new ArrayList<Checkins>();
        String sql="Select userid,venueid,category,city from checkins where userid="+userX;
        Cursor c=db_checkins.rawQuery(sql,null);
        c.moveToFirst();
        while(!c.isAfterLast()){
            String user=c.getString(0);
            String venue=c.getString(1);
            String category=c.getString(2);
            String city=c.getString(3);
            Checkins kullanici=new Checkins();
            kullanici.setUserid(user);
            kullanici.setVenueid(venue);
            kullanici.setCategory(category);
            kullanici.setCity(city);
            liste.add(kullanici);
            c.moveToNext();
        }
        c.close();
        return liste;
    }
    public void placesEkle(String venueidX,String latitudeX, String longitudeX){
        ContentValues val=new ContentValues();
        val.put("venueid",venueidX);
        val.put("latitude",latitudeX);
        val.put("longitude",longitudeX);
        db_places.insert("places",null,val);
    }
    public void checkinsEkle(String useridX,String venueidX,String categoryX, String cityX){
        ContentValues val=new ContentValues();
        val.put("userid",useridX);
        val.put("venueid",venueidX);
        val.put("category",categoryX);
        val.put("city",cityX);
        db_checkins.insert("checkins",null,val);
    }
    public void oneri_1_Ekle(String useridX,String venueidX,String controlX){
        ContentValues val=new ContentValues();
        val.put("userid",useridX);
        val.put("venueid",venueidX);
        val.put("control",controlX);
        db_oneri_1.insert("oneri_1",null,val);
    }
    public void oneri_2_Ekle(String useridX,String venueid1,String control1,String venueid2,String control2,String venueid3,String control3,
                             String venueid4,String control4,String venueid5,String control5,String venueid6,String control6,String venueid7,String control7,
                             String venueid8,String control8,String venueid9,String control9,String venueid10,String control10,int counter){
        ContentValues val=new ContentValues();
        val.put("userid",useridX);
        val.put("venueid1",venueid1); val.put("control1",control1);
        val.put("venueid2",venueid2); val.put("control2",control2);
        val.put("venueid3",venueid3); val.put("control3",control3);
        val.put("venueid4",venueid4); val.put("control4",control4);
        val.put("venueid5",venueid5); val.put("control5",control5);
        val.put("venueid6",venueid6); val.put("control6",control6);
        val.put("venueid7",venueid7); val.put("control7",control7);
        val.put("venueid8",venueid8); val.put("control8",control8);
        val.put("venueid9",venueid9); val.put("control9",control9);
        val.put("venueid10",venueid10); val.put("control10",control10);
        val.put("counter",counter);
        db_oneri_2.insert("oneri_2",null,val);
    }
    public void oneri_3_Ekle(String useridX,String venueid1,String control1,String venueid2,String control2,String venueid3,String control3,
                             String venueid4,String control4,String venueid5,String control5,String venueid6,String control6,String venueid7,String control7,
                             String venueid8,String control8,String venueid9,String control9,String venueid10,String control10,int counter){
        ContentValues val=new ContentValues();
        val.put("userid",useridX);
        val.put("venueid1",venueid1); val.put("control1",control1);
        val.put("venueid2",venueid2); val.put("control2",control2);
        val.put("venueid3",venueid3); val.put("control3",control3);
        val.put("venueid4",venueid4); val.put("control4",control4);
        val.put("venueid5",venueid5); val.put("control5",control5);
        val.put("venueid6",venueid6); val.put("control6",control6);
        val.put("venueid7",venueid7); val.put("control7",control7);
        val.put("venueid8",venueid8); val.put("control8",control8);
        val.put("venueid9",venueid9); val.put("control9",control9);
        val.put("venueid10",venueid10); val.put("control10",control10);
        val.put("counter",counter);
        db_oneri_3.insert("oneri_3",null,val);
    }
    public void tablosil(){
        String sql="drop table places";
        db_places.execSQL(sql);
        sql="create table places (venueid varchar(25),latitude varchar(30),longitude varchar(30))";

        db_places.execSQL(sql);
    }
    public boolean isExistCheckins(String user){
        String sql="Select userid,venueid,category,city from checkins where userid="+user;
        Cursor c=db_checkins.rawQuery(sql,null);
        c.moveToFirst();
        if(c.getCount() > 0){
            c.close();
            return true;
        }else{
            c.close();
            return false;
        }
    }
    public void checkinsSil(){
        db_places.delete("places",null,null);
    }
    public int places_size(){
        String sql="Select venueid from places";
        Cursor c=db_places.rawQuery(sql,null);
        c.moveToFirst();
        int count=0;
        while(!c.isAfterLast()){
            c.moveToNext();
            count++;
        }
        c.close();
        return count;
    }
    public int checkins_size(){
        String sql="Select userid from checkins";
        Cursor c=db_checkins.rawQuery(sql,null);
        c.moveToFirst();
        int count=0;
        while(!c.isAfterLast()){
            c.moveToNext();
            count++;
        }
        c.close();
        return count;
    }
    public int oneri_1_Size(){
        String sql="Select userid from oneri_1";
        Cursor c=db_oneri_1.rawQuery(sql,null);
        c.moveToFirst();
        int count=0;
        while(!c.isAfterLast()){
            c.moveToNext();
            count++;
        }
        c.close();
        return count;
    }
    public int oneri_2_Size(){
        String sql="Select userid from oneri_2";
        Cursor c=db_oneri_2.rawQuery(sql,null);
        c.moveToFirst();
        int count=0;
        while(!c.isAfterLast()){
            c.moveToNext();
            count++;
        }
        c.close();
        return count;
    }
    public int oneri_3_Size(){
        String sql="Select userid from oneri_3";
        Cursor c=db_oneri_3.rawQuery(sql,null);
        c.moveToFirst();
        int count=0;
        while(!c.isAfterLast()){
            c.moveToNext();
            count++;
        }
        c.close();
        return count;
    }

}
