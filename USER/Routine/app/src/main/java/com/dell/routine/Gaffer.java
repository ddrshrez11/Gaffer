package com.dell.routine;

import android.content.Intent;
// import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

import static com.dell.routine.R.id.Schedule_card;




public class Gaffer extends AppCompatActivity implements View.OnClickListener{
    private CardView Calendercard,Assignmentcard,todolistcard,schedulecard,noticescard;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaffer);
        Calendercard=(CardView) findViewById(R.id.Calender_card);
        Assignmentcard=(CardView) findViewById(R.id.Assignment_card);
        todolistcard=(CardView) findViewById(R.id.Todolist_card);
        noticescard=(CardView) findViewById(R.id.notices_card);
        schedulecard=(CardView) findViewById(R.id.Schedule_card);

        //adding clicklistener to cards

        Calendercard.setOnClickListener(this);
        Assignmentcard.setOnClickListener(this);
        noticescard.setOnClickListener(this);
        schedulecard.setOnClickListener(this);
        todolistcard.setOnClickListener(this);



    }


    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId())
        {
            case R.id.Schedule_card : i = new Intent(this,Routine.class);
                startActivity(i);
            break ;
            case R.id.Assignment_card : i = new Intent(this,Assignment.class);
                startActivity(i);
                break ;
            case R.id.notices_card : i = new Intent(this,Notice.class);
                startActivity(i);
                break ;
            case R.id.Todolist_card : i = new Intent(this,ToDoList.class);
                startActivity(i);
                break ;
            case R.id.Calender_card : i = new Intent(this,Calender.class);
                startActivity(i);
                break ;

        }
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



