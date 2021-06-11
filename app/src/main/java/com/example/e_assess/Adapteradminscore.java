package com.example.e_assess;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_assess.R;
//import com.example.e_assess.ui.admingroup.BlankFragment;
import com.example.e_assess.ui.HomeAdmin.model;
import com.example.e_assess.ui.admingroup.BlankViewModel;


import android.content.Context;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Adapteradminscore extends RecyclerView.Adapter<Adapteradminscore.MyViewHolder> {
    ArrayList<Modeladminscore> mlist;
    Context context;
    public Adapteradminscore( Context context,ArrayList<Modeladminscore> mlist){
        this.mlist=mlist;
        this.context =context;

    }
    public Adapteradminscore(Context context) {
        this.context = context;
    }
    @NonNull
    @NotNull
    @Override
    public Adapteradminscore.MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.marks_cards,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Modeladminscore model= mlist.get(position);
        holder.ise1.setText(model.getISE1());
        holder.ise2.setText(model.getISE2());
        holder.mse.setText(model.getMSE());
        holder.ese.setText(model.getESE());
        holder.name.setText(model.getNAME());
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView ise1,ise2,mse,ese,name;

        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            ise1 = itemView.findViewById(R.id.isecol);
            ise2 = itemView.findViewById(R.id.ise2col);
            mse = itemView.findViewById(R.id.msecol);
            ese = itemView.findViewById(R.id.esecol);
            name = itemView.findViewById(R.id.studcol);
        }
    }
}