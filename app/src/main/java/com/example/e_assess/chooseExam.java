package com.example.e_assess;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class chooseExam extends AppCompatActivity {

    String student1,student2,student3;
    // String c = "palak";
    private DatabaseReference mRootRef;
    TextView txt1,txt2,txt3,txt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_exam);

        txt1 = findViewById(R.id.txtise1);
        txt2 = findViewById(R.id.txtise2);
        txt3 = findViewById(R.id.txtmse);
        txt4 = findViewById(R.id.txtese);

        student1 =getIntent().getStringExtra("stud1name").toString();
        student2 =getIntent().getStringExtra("stud2name").toString();
        student3 =getIntent().getStringExtra("stud3name").toString();
        Log.i("stud1",student1);
        Log.i("stud1",student2);
        Log.i("stud1",student3);
        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chooseExam.this, Assignmarksise.class);
                intent.putExtra("stud1name",student1);
                intent.putExtra("stud2name",student2);
                intent.putExtra("stud3name",student3);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                String sample = "0";
                String sample1 = "0";
                String sample2 = "0";
                String sample3 = "0";

                Map<String, String> createhash = new HashMap<>();
                createhash.put("ISE1", sample);
                createhash.put("ISE2", sample1);
                createhash.put("MSE", sample2);
                createhash.put("ESE", sample3);
                createhash.put("NAME",student1);
                mRootRef = FirebaseDatabase.getInstance().getReference("MarkStud").child(student1);
                mRootRef.setValue(createhash)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {

                            @Override
                            public void onSuccess(Void aVoid) {
                                intent.putExtra("stud1name", student1);
                                intent.putExtra("stud2name", student2);
                                intent.putExtra("stud3name", student3);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                //startActivity(intent);
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                //   Toast.makeText(Assignmarksise.this, " " + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });

                Map<String, String> createhash1 = new HashMap<>();
                createhash1.put("ISE1", sample);
                createhash1.put("ISE2", sample1);
                createhash1.put("MSE", sample2);
                createhash1.put("ESE", sample3);
                createhash1.put("NAME",student2);
                mRootRef = FirebaseDatabase.getInstance().getReference("MarkStud").child(student2);
                mRootRef.setValue(createhash1)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                intent.putExtra("stud1name", student1);
                                intent.putExtra("stud2name", student2);
                                intent.putExtra("stud3name", student3);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                //startActivity(intent);
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                //   Toast.makeText(Assignmarksise.this, " " + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });


                Map<String, String> createhash2 = new HashMap<>();
                createhash2.put("ISE1", sample);
                createhash2.put("ISE2", sample1);
                createhash2.put("MSE", sample2);
                createhash2.put("ESE", sample3);
                createhash2.put("NAME",student3);
                mRootRef = FirebaseDatabase.getInstance().getReference("MarkStud").child(student3);
                mRootRef.setValue(createhash2)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                intent.putExtra("stud1name", student1);
                                intent.putExtra("stud2name", student2);
                                intent.putExtra("stud3name", student3);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                //   Toast.makeText(Assignmarksise.this, " " + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });

            }
        });

        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chooseExam.this, Ise2.class);
                intent.putExtra("stud1name",student1);
                intent.putExtra("stud2name",student2);
                intent.putExtra("stud3name",student3);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        txt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chooseExam.this, Mse.class);
                intent.putExtra("stud1name",student1);
                intent.putExtra("stud2name",student2);
                intent.putExtra("stud3name",student3);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        txt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chooseExam.this, Ese.class);
                intent.putExtra("stud1name",student1);
                intent.putExtra("stud2name",student2);
                intent.putExtra("stud3name",student3);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }
}