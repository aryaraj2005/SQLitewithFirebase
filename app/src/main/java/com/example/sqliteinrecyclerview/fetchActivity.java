package com.example.sqliteinrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AliasActivity;
import android.database.Cursor;
import android.os.Bundle;

import java.util.ArrayList;

public class fetchActivity extends AppCompatActivity {
RecyclerView recyclerView;
ArrayList<myModel> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch);
        recyclerView = findViewById(R.id.fetchrec);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    /// create a cursor for read all the data
        Cursor cursor = new dbManager(this).fetch_read();
        // cursor will move till the data is available
        while (cursor.moveToNext()){
            // now every record is move inside the obj
            myModel obj = new myModel(cursor.getString(1) , cursor.getString(2) , cursor.getString(3));
            // now this data will be added to list'
            list.add(obj);

        }

        myAdapter adapter = new myAdapter(list);
        recyclerView.setAdapter(adapter);
    }
}