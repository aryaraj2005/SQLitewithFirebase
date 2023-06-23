package com.example.sqliteinrecyclerview;

import android.content.Context;
import android.os.strictmode.WebViewMethodCalledOnWrongThreadViolation;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class myAdapter extends RecyclerView.Adapter<myAdapter.myViewholder> {
    ArrayList<myModel> list;

    public myAdapter(ArrayList<myModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public myViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerowdesign  , parent , false);
        return  new myViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewholder holder, int position) {
          holder.dname.setText(list.get(position).getName());
          holder.dcontact.setText(list.get(position).getContact());
          holder.demail.setText(list.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  class  myViewholder extends RecyclerView.ViewHolder {
       TextView dname , dcontact  , demail;

        public myViewholder(@NonNull View itemView) {
            super(itemView);
            dname = itemView.findViewById(R.id.displayname);
            dcontact = itemView.findViewById(R.id.displaycontact);
            demail = itemView.findViewById(R.id.displayemail);
        }
    }
}
