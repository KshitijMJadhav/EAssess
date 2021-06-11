package com.example.e_assess;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.example.e_assess.ui.HomeAdmin.model;
import com.example.e_assess.ui.dashboard.ModelDashboard;
import com.example.e_assess.ui.home.Guide;
import com.example.e_assess.ui.home.Recycle;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FinalMarksShow extends AppCompatActivity {
    RecyclerView review;
    Context context;
    private DatabaseReference reference,ref;
    private Adapteradminscore adapter;
    FirebaseAuth auth;
    FirebaseUser user;
    String userid, nameOfGuide;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_marks_show);
        review=(RecyclerView)findViewById(R.id.adminrecycle);
        review.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<Modeladminscore> options = new ArrayList<Modeladminscore>();
        adapter =  new Adapteradminscore(this,options);
        review.setAdapter(adapter);
        reference = FirebaseDatabase.getInstance().getReference("MarkStud");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String ise1,ise2,mse,ese,name;
                for(DataSnapshot datas : snapshot.getChildren()){
                    Log.i("printing data",snapshot.getValue().toString());
                    //  for(DataSnapshot datas : dataSnapshot.getChildren()){
                    // for(DataSnapshot datas : datass.getChildren()) {
                    Log.i("value os data", datas.getKey().toString());
                    Log.i("hey tag", datas.getValue().toString());
                    ise1 = datas.child("ISE1").getValue(String.class);
                    ise2 = datas.child("ISE2").getValue(String.class);
                    mse = datas.child("MSE").getValue(String.class);
                    ese = datas.child("ESE").getValue(String.class);
                    name = datas.child("NAME").getValue(String.class);
                    Modeladminscore model = new Modeladminscore(ise1,ise2,mse,ese,name);
                    options.add(model);

                    //     }
                    // }

                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




    }
}