package com.example.e_assess.ui.slideshow;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_assess.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;
    RecyclerView review;
    Context context;
    private DatabaseReference reference,ref;
    private Adapterguidescore adapter;
    FirebaseAuth auth;
    FirebaseUser user;
    String userid, nameOfGuide;
    ArrayList<Modelguidescore> list;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
       // final TextView textView = root.findViewById(R.id.viewmarksrecycle);
        //slideshowViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            //@Override
           // public void onChanged(@Nullable String s) {
             //   textView.setText(s);
            //}
       // });
        review=(RecyclerView)root.findViewById(R.id.viewmarksrecycle);
        review.setLayoutManager(new LinearLayoutManager(getContext()));
        context=container.getContext();
        list=new ArrayList<Modelguidescore>();
       adapter=new Adapterguidescore(context, list);
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
                    Modelguidescore model = new Modelguidescore(ise1,ise2,mse,ese,name);
                    list.add(model);

                    //     }
                    // }

                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });









        return root;
    }
}