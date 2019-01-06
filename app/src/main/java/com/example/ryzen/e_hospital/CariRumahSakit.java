package com.example.ryzen.e_hospital;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CariRumahSakit extends AppCompatActivity {
    DatabaseReference mdatabaseReference;
    RecyclerView recyclerView;
    Madapter madapter;
    ArrayList<Hospital> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cari_rumah_sakit);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        list = new ArrayList<Hospital>();

        mdatabaseReference = FirebaseDatabase.getInstance().getReference().child("Hospital");
        mdatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren()) {
                    Hospital h = dataSnapshot1.getValue(Hospital.class);
                    list.add(h);
                }
                madapter = new Madapter(CariRumahSakit.this,list);
                recyclerView.setAdapter(madapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(CariRumahSakit.this,"Oppss.. something wrong", Toast.LENGTH_SHORT).show();
            }
        });




    }
}
