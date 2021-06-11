package com.example.e_assess.ui.slideshow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_assess.ui.slideshow.Adapterguidescore;
import com.example.e_assess.ui.slideshow.Modelguidescore;
import com.example.e_assess.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Adapterguidescore extends RecyclerView.Adapter<Adapterguidescore.MyViewHolder>{
    ArrayList<Modelguidescore> mlist;
    Context context;

    public Adapterguidescore(Context context, ArrayList<Modelguidescore> mlist) {
        this.mlist = mlist;
        this.context = context;

    }

    public Adapterguidescore(Context context) {
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public Adapterguidescore.MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        //LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        //View view = inflater.inflate(R.layout.marks_cards, parent, false);
        //return new Adapterguidescore.MyViewHolder(view);
        View v=LayoutInflater.from(context).inflate(R.layout.marks_cards,parent,false);
        return  new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapterguidescore.MyViewHolder holder, int position) {
        Modelguidescore model = mlist.get(position);
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


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView ise1, ise2, mse, ese, name;

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
