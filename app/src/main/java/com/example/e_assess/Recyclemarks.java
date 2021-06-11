package com.example.e_assess;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Recyclemarks extends AppCompatActivity {
    RecyclerView review;
    Context context;
    DatabaseReference refise,refise2,refmse,refese;
    //adaptermarksise adapter;
   // ArrayList<Marks> list;
    String userid;
    String studentt1,studentt2;
    TextView R1Ise1,R2Ise1,R3Ise1,R4Ise1,R5Ise1,totalise1;
    TextView R1Ise2,R2Ise2,R3Ise2,R4Ise2,R5Ise2,totalise2;
    TextView R1mse,R2mse,R3mse,R4mse,R5mse,totalmse;
    TextView R1ese,R2ese,R3ese,R4ese,R5ese,totalese;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclemarks);
        review=findViewById(R.id.viewmarksguide);
        R1Ise1=(TextView)findViewById(R.id.rubric1stud1) ;
        R2Ise1=(TextView)findViewById(R.id.rubric2stud1) ;
        R3Ise1=(TextView)findViewById(R.id.rubric3stud1) ;
        R4Ise1=(TextView)findViewById(R.id.rubric4stud1) ;
        R5Ise1=(TextView)findViewById(R.id.rubric5stud1) ;
        totalise1=(TextView)findViewById(R.id.Totalstud1) ;

        R1Ise2=(TextView)findViewById(R.id.rubric1ise2stud1) ;
        R2Ise2=(TextView)findViewById(R.id.rubric2ise2stud1) ;
        R3Ise2=(TextView)findViewById(R.id.rubric3ise2stud1) ;
        R4Ise2=(TextView)findViewById(R.id.rubric4ise2stud1) ;
        R5Ise2=(TextView)findViewById(R.id.rubric5ise2stud1) ;
        totalise2=(TextView)findViewById(R.id.Totalise22) ;

        R1mse=(TextView)findViewById(R.id.rubric1msestud1) ;
        R2mse=(TextView)findViewById(R.id.rubric2msestud1) ;
        R3mse=(TextView)findViewById(R.id.rubric3msestud1) ;
        R4mse=(TextView)findViewById(R.id.rubric4msestud1) ;
        R5mse=(TextView)findViewById(R.id.rubric5msestud1) ;
        totalmse=(TextView)findViewById(R.id.Totalmse11) ;

        R1ese=(TextView)findViewById(R.id.rubric1esestud1) ;
        R2ese=(TextView)findViewById(R.id.rubric2esestud1) ;
        R3ese=(TextView)findViewById(R.id.rubric3esestud1) ;
        R4ese=(TextView)findViewById(R.id.rubric4esestud1) ;
        R5ese=(TextView)findViewById(R.id.rubric5esestud1) ;
        totalese=(TextView)findViewById(R.id.Totalese11) ;

        studentt1 =getIntent().getStringExtra("studname").toString();

        final String stuname=studentt1;
        refise = FirebaseDatabase.getInstance().getReference("Marks").child(studentt1).child("ISE1");
        refise2= FirebaseDatabase.getInstance().getReference("Marks").child(studentt1).child("ISE2");
        refmse = FirebaseDatabase.getInstance().getReference("Marks").child(studentt1).child("MSE");
        refese = FirebaseDatabase.getInstance().getReference("Marks").child(studentt1).child("ESE");

        //review.setHasFixedSize(true);
        //review.setLayoutManager(new LinearLayoutManager(this));
        //list = new ArrayList<>();
        //adapter=new adaptermarksise(this,list);
        //review.setAdapter(adapter);

        //    for getting the details of the person who logg in !!
        //userid = FirebaseAuth.getInstance().getCurrentUser().getUid().toString();
        refise.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
               //for (DataSnapshot snapshot1:snapshot.getChildren()) {
                String Totalise11=null , R1s1ise=null , R2S1ise1=null , R3S1ise1=null , R4S1ise1=null , R5S1ise1=null ;
                   for (DataSnapshot dat : snapshot.getChildren()) {
                    if(dat.getKey().equals("TotalIse1"))
                    {
                        Totalise11 = dat.getValue(String.class);
                        totalise1.setText(Totalise11);
                    }
                       if(dat.getKey().equals("Problem_Statement_Identification"))
                       {
                           R1s1ise = dat.getValue(String.class);
                           R1Ise1.setText(R1s1ise);
                       }
                       if(dat.getKey().equals("Objective_Defined"))
                       {
                           R2S1ise1 = dat.getValue(String.class);
                           R2Ise1.setText(R2S1ise1);
                       }
                       if(dat.getKey().equals("Tools_and_Methodology"))
                       {
                           R3S1ise1  = dat.getValue(String.class);
                           R3Ise1.setText(R3S1ise1);
                       }
                       if(dat.getKey().equals("Question_and_Answer"))
                       {
                           R4S1ise1 = dat.getValue(String.class);
                           R4Ise1.setText(R4S1ise1);
                       }
                       if(dat.getKey().equals("Presentation_Skills"))
                       {
                           R5S1ise1 = dat.getValue(String.class);
                          R5Ise1.setText(R5S1ise1);
                       }


                   }

               }

            //}
                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {

                                }
                            });

        refise2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //for (DataSnapshot snapshot1:snapshot.getChildren()) {
                String Totalise11=null , R1s1ise=null , R2S1ise1=null , R3S1ise1=null , R4S1ise1=null , R5S1ise1=null ;
                for (DataSnapshot dat : snapshot.getChildren()) {
                    if(dat.getKey().equals("TotalIse2"))
                    {
                        Totalise11 = dat.getValue(String.class);
                        totalise2.setText(Totalise11);
                    }
                    if(dat.getKey().equals("Objective_Achieved_ise2"))
                    {
                        R1s1ise = dat.getValue(String.class);
                        R1Ise2.setText(R1s1ise);
                    }
                    if(dat.getKey().equals("Project_Design_ise2"))
                    {
                        R2S1ise1 = dat.getValue(String.class);
                        R2Ise2.setText(R2S1ise1);
                    }
                    if(dat.getKey().equals("Demonstration_ise2"))
                    {
                        R3S1ise1  = dat.getValue(String.class);
                        R3Ise2.setText(R3S1ise1);
                    }
                    if(dat.getKey().equals("Incorporation_of_Suggesstion_ise2"))
                    {
                        R4S1ise1 = dat.getValue(String.class);
                        R4Ise2.setText(R4S1ise1);
                    }
                    if(dat.getKey().equals("Question_And_Answer_ise2"))
                    {
                        R5S1ise1 = dat.getValue(String.class);
                        R5Ise2.setText(R5S1ise1);
                    }


                }

            }

            //}
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        refmse.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String Totalise11=null , R1s1ise=null , R2S1ise1=null , R3S1ise1=null , R4S1ise1=null , R5S1ise1=null ;
                for (DataSnapshot dat : snapshot.getChildren()) {
                    if(dat.getKey().equals("TotalMse"))
                    {
                        Totalise11 = dat.getValue(String.class);
                        totalmse.setText(Totalise11);
                    }
                    if(dat.getKey().equals("Objective_Achieved"))
                    {
                        R1s1ise = dat.getValue(String.class);
                        R1mse.setText(R1s1ise);
                    }
                    if(dat.getKey().equals("Project_Design"))
                    {
                        R2S1ise1 = dat.getValue(String.class);
                        R2mse.setText(R2S1ise1);
                    }
                    if(dat.getKey().equals("Demonstration_Mse"))
                    {
                        R3S1ise1  = dat.getValue(String.class);
                        R3mse.setText(R3S1ise1);
                    }
                    if(dat.getKey().equals("Incorporation_of_Suggesstion"))
                    {
                        R4S1ise1 = dat.getValue(String.class);
                        R4mse.setText(R4S1ise1);
                    }
                    if(dat.getKey().equals("Question_And_Answer"))
                    {
                        R5S1ise1 = dat.getValue(String.class);
                        R5mse.setText(R5S1ise1);
                    }


                }

            }

            //}
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        refese.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String Totalise11=null , R1s1ise=null , R2S1ise1=null , R3S1ise1=null , R4S1ise1=null , R5S1ise1=null ;
                for (DataSnapshot dat : snapshot.getChildren()) {
                    if(dat.getKey().equals("TotalEse"))
                    {
                        Totalise11 = dat.getValue(String.class);
                        totalese.setText(Totalise11);
                    }
                    if(dat.getKey().equals("Objective_Achieved_ese"))
                    {
                        R1s1ise = dat.getValue(String.class);
                        R1ese.setText(R1s1ise);
                    }
                    if(dat.getKey().equals("Result_And_Analysis"))
                    {
                        R2S1ise1 = dat.getValue(String.class);
                        R2ese.setText(R2S1ise1);
                    }
                    if(dat.getKey().equals("Novelty"))
                    {
                        R3S1ise1  = dat.getValue(String.class);
                        R3ese.setText(R3S1ise1);
                    }
                    if(dat.getKey().equals("Presentation_skills_ese"))
                    {
                        R4S1ise1 = dat.getValue(String.class);
                        R4ese.setText(R4S1ise1);
                    }
                    if(dat.getKey().equals("Application(social,dept,eco,etc)"))
                    {
                        R5S1ise1 = dat.getValue(String.class);
                        R5ese.setText(R5S1ise1);
                    }


                }

            }

            //}
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


                    }



            }

            /*@Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dat : snapshot.getChildren()) {
                    //final String nameOfstud1 = snapshot.child("Student1").getValue(String.class);
                    // Log.i("nameg the md",nameOfGuide);
                    reference = FirebaseDatabase.getInstance().getReference().child("Marks");
                    reference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            //Groups
                            for (DataSnapshot datas : snapshot.getChildren()) {
                                //id under the group
                                for (DataSnapshot data : datas.getChildren()) {
                                    //name of guide
                                    String s = data.getKey();
                                    if (s.equals(nameOfGuide)) {
                                        for (DataSnapshot dat : data.getChildren()) {
                                            String stud1, stud2, stud3, topic, grpno;
                                            grpno = dat.child("GroupNo").getValue(String.class);
                                            stud1 = dat.child("Student1").getValue(String.class);
                                            stud2 = dat.child("Student2").getValue(String.class);
                                            stud3 = dat.child("Student3").getValue(String.class);
                                            topic = dat.child("TopicName").getValue(String.class);
                                            Marks marks = new Guide(grpno, stud1, stud2, stud3, topic);
                                            list.add(model);
                                        }
                                        recyclemarks.notifyDataSetChanged();
                                    }
                                }
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });*/

                    //Log.i("name of the guide ",name);


                    // end of the trial






