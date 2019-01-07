package com.dell.firestore;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class create_assignment extends AppCompatActivity {

    private EditText title,subject,deadline, teacher, desc;
    private Button btn;
    private FirebaseFirestore mFirestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_assignment);

        mFirestore= FirebaseFirestore.getInstance();
        title= findViewById(R.id.hw_title);
        subject=findViewById(R.id.hw_subject);
        deadline=findViewById(R.id.hw_deadline);
        teacher=findViewById(R.id.hw_teacher);
        desc= findViewById(R.id.hw_desc);
        btn = findViewById(R.id.btn_create_hw);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt_title= title.getText().toString();
                String txt_subject = subject.getText().toString();
                String txt_deadline = deadline.getText().toString();
                String txt_teacher = teacher.getText().toString();
                String txt_desc= desc.getText().toString();

                DocumentReference newNoteRef = mFirestore
                        .collection("Assignments")
                        .document();

                Assignment_list assignment_list = new Assignment_list();
                assignment_list.setTitle(txt_title);
                assignment_list.setDesc(txt_desc);
                assignment_list.setSubject(txt_subject);
                assignment_list.setDeadline(txt_deadline);
                assignment_list.setTeacher(txt_teacher);
                assignment_list.setAssignment_id(newNoteRef.getId());

                newNoteRef.set(assignment_list).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Documents has been Saved", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Error: " , Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                finish();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.optionmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.LogOut:
                FirebaseAuth mAuth;
                mAuth= FirebaseAuth.getInstance();

                mAuth.signOut();
                Intent intent= new Intent(getApplicationContext(),verification.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
