package com.example.e_assess;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ResetPassword extends AppCompatActivity {

    private EditText mailid;
    private Button btnclick;
    FirebaseAuth auth;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);


        mailid = findViewById(R.id.mailforget11);
        btnclick = findViewById(R.id.btnreset11);
        progressBar = findViewById(R.id.progbar11);
        //progressBar.setVisibility(View.VISIBLE);

        auth = FirebaseAuth.getInstance();
        btnclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                resetPassword();
            }
        });

    }

    public void resetPassword(){
        String email = mailid.getText().toString().trim();

        if(email.isEmpty()){
            mailid.setError("Email is required");
            mailid.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            mailid.setError("Please provide valid email");
            mailid.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    progressBar.setVisibility(View.INVISIBLE);
                    Toast.makeText(ResetPassword.this, "Check your email to reset your password", Toast.LENGTH_SHORT).show();
                }
                else{
                    progressBar.setVisibility(View.INVISIBLE);
                    Toast.makeText(ResetPassword.this, "Try again something went wrong", Toast.LENGTH_SHORT).show();

                }
            }
        });


    }

}