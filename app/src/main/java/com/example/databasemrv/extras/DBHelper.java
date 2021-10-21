package com.example.databasemrv.extras;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "POS Daily-Report DB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table ReportTable(date_created date default current_date ,amount VARCHAR(20),id VARCHAR(10) primary key not null)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists ReportTable");
    }


    public Boolean insertData(String amount, String id){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("amount",amount);
        contentValues.put("id",id);
        Long result = db.insert("ReportTable",null,contentValues);
        if (result==-1){
            return false;
        }else{
            return true;
        }
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from ReportTable",null);
        return cursor;
    }

    public void deleteAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from ReportTable");
    }


}
