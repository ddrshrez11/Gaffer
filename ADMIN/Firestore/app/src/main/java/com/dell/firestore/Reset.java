package com.dell.firestore;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Reset extends AppCompatActivity {

    private EditText Email4;
    private Button Reset1;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);

        Email4 = findViewById(R.id.Email3);
        Reset1 = findViewById(R.id.reset);

        mAuth =FirebaseAuth.getInstance();



        Reset1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email5 = Email4.getText().toString();
                //Toast.makeText(Reset.this, "email:" +Email5, Toast.LENGTH_SHORT).show();

                mAuth.sendPasswordResetEmail(Email5).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Reset.this, "Check email", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Reset.this,verification.class));
                        }else{
                            Toast.makeText(Reset.this, "error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
        /*Reset1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/




    }
}
