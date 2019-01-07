package com.dell.firestore;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class verification extends AppCompatActivity {

    private EditText Email;
    private EditText Password;
    private Button  Login;
    private TextView SignIn, reset;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);

        SignIn = findViewById(R.id.signin);
        Email =findViewById(R.id.email2);
       Login =findViewById(R.id.login2);
       Password =findViewById(R.id.password2);
       reset=findViewById(R.id.reset);
       mAuth = FirebaseAuth.getInstance();

        if(mAuth.getCurrentUser()!=null && mAuth.getCurrentUser().isEmailVerified()){
            this.finish();
            startActivity(new Intent(verification.this, adminGaffer.class));
            finish();
        }


       SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(verification.this,firebaseauth.class));
            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = Email.getText().toString().trim();
                String password = Password.getText().toString().trim();

                if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)){

                   mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                       @Override
                       public void onComplete(@NonNull Task<AuthResult> task) {
                           if(task.isSuccessful()){
                               checkUserVerification();
                           }else{
                               Toast.makeText(verification.this, "Login Failed.Try Again", Toast.LENGTH_SHORT).show();
                           }
                       }
                   });

                }


            }
        });
    }

    private void checkUserVerification(){
        if(mAuth.getCurrentUser().isEmailVerified()) {
        finish();
        Intent intent=new Intent(verification.this,adminGaffer.class);
        startActivity(intent);
        }else {
            Toast.makeText(this, "Please Verify Your Email....", Toast.LENGTH_SHORT).show();
            mAuth.signOut();
        }
        }
    }

