package com.example.reavixmobileapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    private Context context;
    private ArrayList Name_grupp,Biografia,Personal_data,Xaracteristika;
    Activity activity;

    public MyAdapter(Activity activity){

    }

    public MyAdapter(Context context, ArrayList name_grupp, ArrayList biografia, ArrayList personal_data, ArrayList xaracteristika) {
        this.context = context;
        Name_grupp = name_grupp;
        Biografia = biografia;
        Personal_data = personal_data;
        Xaracteristika = xaracteristika;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate((R.layout.userentry), parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
       holder.name_txt.setText(String.valueOf(Name_grupp.get(position)));
       holder.biografia_txt.setText(String.valueOf(Biografia.get(position)));
       holder.personal_data_txt.setText(String.valueOf(Personal_data.get(position)));
       holder.xaracteristika_txt.setText(String.valueOf(Xaracteristika.get(position)));

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,UpdataPages.class);
                intent.putExtra("Name_grupp",String.valueOf(Name_grupp.get(position)));
                intent.putExtra("Biografia",String.valueOf(Biografia.get(position)));
                intent.putExtra("Personal_data",String.valueOf(Personal_data.get(position)));
                intent.putExtra("Xaracteristika",String.valueOf(Xaracteristika.get(position)));

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return Name_grupp.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name_txt,biografia_txt,personal_data_txt,xaracteristika_txt;
        LinearLayout mainLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name_txt= itemView.findViewById(R.id.namegrupp_lable);
            biografia_txt = itemView.findViewById(R.id.biograf_lable);
            personal_data_txt = itemView.findViewById(R.id.personaldata_lable);
            xaracteristika_txt = itemView.findViewById(R.id.xaracterisk_lable);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
