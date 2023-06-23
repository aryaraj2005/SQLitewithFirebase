package com.example.sqliteinrecyclerview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbManager  extends SQLiteOpenHelper {
    private  static final String   dbname = "dbConatact";

    public dbManager(@Nullable Context context) {

        super(context, dbname , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // query is created
        String qry = "create table tbl_contact (id integer primary key autoincrement  , name text , email text , contact text)";
        // now implement the query
        db.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
     String qry = "DROP TABLE IF EXISTS tbl_contact";
     db.execSQL(qry);
     onCreate(db);

    }

    public  String adddata(String name , String contact , String email){
        SQLiteDatabase sqldb = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name" , name);
        cv.put("contact" , contact);
        cv.put("email" , email);
       float result= sqldb.insert("tbl_contact" , null , cv);

        if (result == -1){
            return  "Failed";
        }
        return "Successfully Inserted";
    }
    public  Cursor fetch_read(){

        SQLiteDatabase sqldbs = this.getWritableDatabase();
        String  query = "SELECT * FROM tbl_contact order by id desc";
        Cursor cursor = sqldbs.rawQuery(query , null);
        return cursor;
    }
}
