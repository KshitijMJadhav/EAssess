package com.example.e_assess.ui.dashboard;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_assess.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import javax.annotation.Nullable;

public class AdapterDashboard extends RecyclerView.Adapter<AdapterDashboard.MyViewHolder> {
  ArrayList<ModelDashboard> mlist;
  Context context;
    private DatabaseReference reference;
  public AdapterDashboard(Context context,ArrayList<ModelDashboard> mlist){
      this.mlist = mlist;
      this.context= context;
  }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
  ModelDashboard model = mlist.get(position);
        holder.Student1.setText(model.getStudent1());
        holder.Student2.setText(model.getStudent2());
        holder.Student3.setText(model.getStudent3());
        holder.TopicName.setText(model.getTopicName());
        holder.group.setText(model.getGroupNo());
        holder.guide.setText(model.getGuideName());
        holder.imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uid = FirebaseAuth.getInstance().getCurrentUser().getUid().toString();
                reference = FirebaseDatabase.getInstance().getReference().child("Groups").child(uid);
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for(DataSnapshot dataSnapshot :snapshot.getChildren()){
                            for(DataSnapshot dat :dataSnapshot.getChildren()) {
                                if(dat.getKey().equals(model.getGroupNo())){
                                    Log.i("data to be clicked ",dat.getKey());
                                    dat.getRef().removeValue();
                                }
                            }
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public static  class MyViewHolder extends RecyclerView.ViewHolder{
      TextView Student1,Student2,Student3,TopicName,guide,group;
      ImageButton imgbtn ;
          public MyViewHolder(@Nullable View itemView){
              super(itemView);
              Student1 = itemView.findViewById(R.id.textstud1name);
             Student2 = itemView.findViewById(R.id.textstud2name);
            Student3 = itemView.findViewById(R.id.textstud3name);
             TopicName = itemView.findViewById(R.id.txttopicname);
            guide=itemView.findViewById(R.id.txtguide);
             imgbtn = itemView.findViewById(R.id.deletegrp);
              group=itemView.findViewById(R.id.grpnoadmin);


        }
    }

}
