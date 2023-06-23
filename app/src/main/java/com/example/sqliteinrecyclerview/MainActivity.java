package com.example.sqliteinrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

import javax.xml.namespace.QName;

public class MainActivity extends AppCompatActivity {
     TextInputLayout name , email , contact;
     Button submit;
     FloatingActionButton fb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         name = (TextInputLayout)findViewById(R.id.nametxt);
         email = (TextInputLayout) findViewById(R.id.emailtxt);
         contact = (TextInputLayout) findViewById(R.id.contacttxt);
         submit = findViewById(R.id.submitbtn);
         fb= findViewById(R.id.fb);
         fb.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 startActivity(new Intent(MainActivity.this , fetchActivity.class));
             }
         });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processInsert(name.getEditText().toString(), contact.getEditText().toString() , email.getEditText().toString());
            }
            
        });


    }

    private void processInsert(String n, String c, String e) {
        // now taking the data from the dbmanager
        String result = new dbManager(this).adddata(n , c , e);
        // after insert all the text get blank
        name.getEditText().setText("");
        email.getEditText().setText("");
        contact.getEditText().setText("");
        Toast.makeText(getApplicationContext() , result , Toast.LENGTH_SHORT).show();
    }


}