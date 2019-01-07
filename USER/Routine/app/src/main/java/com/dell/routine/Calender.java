package com.dell.routine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Calender extends AppCompatActivity {

    private static final String TAG = "Calender";
    private CalendarView mCalenderView;
    ImageView addButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);

        mCalenderView = findViewById(R.id.calendarView);
        addButton = (ImageView) findViewById(R.id.addBtn);
        mCalenderView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2) {
                String date = (i1 + 1) + "/" + i2 + "/" + i;
                Log.d(TAG, "onSelectedDayChange: mm/dd/yy:" + date);
                Intent intent = new Intent(Calender.this, Calender_DayView.class);
                intent.putExtra("date", date);
                startActivity(intent);


            }
        });


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Add New Event",Toast.LENGTH_SHORT).show();
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

