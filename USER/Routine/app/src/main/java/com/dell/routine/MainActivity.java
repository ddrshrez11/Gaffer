package com.dell.routine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button Assignments, ViewRoutine, Calender1, ToDo , Notices,Settings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("GAFFER");

        setContentView(R.layout.activity_main);

        Assignments= findViewById(R.id.Assignments);
        ViewRoutine= findViewById(R.id.ViewRoutine);
        Calender1 =findViewById(R.id.Calender);
        ToDo= findViewById(R.id.ToDO);
        Notices= findViewById(R.id.Notice);
        Settings= findViewById(R.id.Settings);

        Assignments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "You Clicked Assignments",Toast.LENGTH_SHORT).show();
                Intent d= new Intent(getApplicationContext(), Assignment.class);
                startActivity(d);
            }

        });

        Calender1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"You Clicked Calender", Toast.LENGTH_SHORT).show();
            }
        });
        ViewRoutine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Routine.class);
                Toast.makeText(getApplicationContext(),"You Clicked Routine", Toast.LENGTH_SHORT).show();

                startActivity(i);
            }
        });

        ToDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c= new Intent(getApplicationContext(), ToDoList.class);
                Toast.makeText(getApplicationContext(),"You Clicked To Do List", Toast.LENGTH_SHORT).show();
                startActivity(c);
            }
        });

        Notices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(getApplicationContext(),Notice.class);
                Toast.makeText(getApplicationContext(),"You Clicked Notices", Toast.LENGTH_SHORT).show();
                startActivity(a);
            }
        });

        Settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"You Clicked Setting", Toast.LENGTH_SHORT).show();

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

