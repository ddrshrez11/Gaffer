package com.dell.routine;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class firebaseauth extends AppCompatActivity {

    private EditText Email1;
    private EditText Password1;
    private Button Register;
    private TextView Signhere;

    //Firebase variables

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebaseauth);


        mAuth = FirebaseAuth.getInstance();
        Email1 = findViewById(R.id.email);
        Password1 = findViewById(R.id.password);
        Register = findViewById(R.id.register);
        Signhere = findViewById(R.id.signhere);

        Signhere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(firebaseauth.this, verification.class);
                startActivity(intent);
            }
        });


        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String email = Email1.getText().toString().trim();
                final String password = Password1.getText().toString().trim();

                    if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {
                    mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){

                               // Toast.makeText(firebaseauth.this, "successful"+ email + password, Toast.LENGTH_SHORT).show();
                                mAuth.getCurrentUser().sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {

                                        Toast.makeText(firebaseauth.this, "Email Sent", Toast.LENGTH_SHORT).show();
                                        Intent intent= new Intent(firebaseauth.this,verification.class);
                                        startActivity(intent);
                                    }
                                });


                            }

                            }
                    });

                    }
                else {

                    Toast.makeText(getApplicationContext(), "Enter email and password", Toast.LENGTH_SHORT).show();
                }
            }



        });
    }

}





