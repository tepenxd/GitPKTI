package com.example.ryzen.e_hospital;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Madapter extends RecyclerView.Adapter<Madapter.Mviewholder> {
    Context context;
    ArrayList<Hospital> hospital;
    public Madapter(Context c , ArrayList<Hospital> h){
        context = c;
        hospital = h;
    }
    @NonNull
    @Override
    public Mviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Mviewholder(LayoutInflater.from(context).inflate(R.layout.hospital_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Mviewholder mviewholder, int i) {
        mviewholder.Hname.setText(hospital.get(i).getHname());
        mviewholder.Haddress.setText(hospital.get(i).getHaddress());

    }

    @Override
    public int getItemCount() {
        return hospital.size();
    }

    class Mviewholder extends RecyclerView.ViewHolder{
        TextView Hname,Haddress;
        public Mviewholder(View itemView){
            super(itemView);
            Hname = (TextView) itemView.findViewById(R.id.hospital_name);
            Haddress = (TextView) itemView.findViewById(R.id.hospital_address);
        }
    }

}
