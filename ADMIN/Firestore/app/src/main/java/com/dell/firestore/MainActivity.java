package com.dell.firestore;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView AddAssignmentcard,Editschedulecard,Addnoticescard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AddAssignmentcard=(CardView) findViewById(R.id.Assignmentadd);

        Addnoticescard=(CardView) findViewById(R.id.AddNotices);
        Editschedulecard=(CardView) findViewById(R.id.EditSchedule);

        //adding clicklistener to cards


        AddAssignmentcard.setOnClickListener(this);
        Addnoticescard.setOnClickListener(this);
        Editschedulecard.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId())
        {
            case R.id.EditSchedule :
                i = new Intent(this,editRoutine1.class);
                Toast.makeText(getApplicationContext(),"Edit Routine", Toast.LENGTH_SHORT).show();

                break ;

            case R.id.AddNotices : i = new Intent(this,create_notice.class);
                startActivity(i);
                break ;

            case R.id.Assignmentadd : i = new Intent(this,create_assignment.class);
                startActivity(i);
                break ;




        }



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.optionmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

//    FirebaseFirestore db = FirebaseFirestore.getInstance();
//    Button btn_ntc,btn_hw,btn_ntc_disp,btn_todo;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        btn_ntc = findViewById(R.id.btn_ntc);
//        btn_hw= findViewById(R.id.btn_hw);
//        btn_ntc_disp= findViewById(R.id.btn_ntc_disp);
//        btn_todo= findViewById(R.id.btn_todo);
//
//        btn_ntc.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(MainActivity.this,create_notice.class);
//                startActivity(i);
//            }
//        });
//
//        btn_hw.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent a = new Intent(MainActivity.this,create_assignment.class);
//                startActivity(a);
//            }
//        });
//
//        btn_ntc_disp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent b = new Intent(MainActivity.this,Notice.class);
//                startActivity(b);
//            }
//        });
//
//        btn_todo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent c = new Intent(MainActivity.this,ToDoList.class);
//                startActivity(c);
//            }
//        });
//    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.optionmenu,menu);
//        return super.onCreateOptionsMenu(menu);
//    }
}
