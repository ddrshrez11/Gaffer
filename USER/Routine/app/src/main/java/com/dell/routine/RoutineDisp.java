package com.dell.routine;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class RoutineDisp extends AppCompatActivity {

    private TextView title, desc;
    private FirebaseFirestore mFirestore;
    public static String Doc_id;
    private List<Routine_list> routine_lists;
    private DocumentSnapshot mLastQueriedDocument;

    public TextView textDay;
    public TextView textSubject1;
    public TextView textSubject2;
    public TextView textSubject3;
    public TextView textSubject4;
    public TextView textSubject5;
    public TextView time1,time2,time3,time4,time5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routine_disp);

        mFirestore= FirebaseFirestore.getInstance();
        routine_lists=new ArrayList<>();

        textDay= findViewById(R.id.textDay);
        textSubject1= findViewById(R.id.textSubject1);
        textSubject2= findViewById(R.id.textSubject2);
        textSubject3= findViewById(R.id.textSubject3);
        textSubject4= findViewById(R.id.textSubject4);
        textSubject5= findViewById(R.id.textSubject5);
        time1= findViewById(R.id.Time1);
        time2= findViewById(R.id.Time2);
        time3= findViewById(R.id.Time3);
        time4= findViewById(R.id.Time4);
        time5= findViewById(R.id.Time5);

        CollectionReference routineCollectionRef = mFirestore
                .collection("Routine");

        Query routineQuery = null;
        routineQuery = routineCollectionRef
                .whereEqualTo("SN", RoutineAdapter.routine_id);

        routineQuery.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){

                    for(DocumentSnapshot document: task.getResult()){
                        Routine_list routine_list = document.toObject(Routine_list.class);
                        routine_lists.add(routine_list);
//                        Log.d(TAG, "onComplete: got a new note. Position: " + (mNotes.size() - 1));
                        textDay.setText(routine_list.getDay());
                        textSubject1.setText(routine_list.getSubject1());
                        textSubject2.setText(routine_list.getSubject2());
                        textSubject3.setText(routine_list.getSubject3());
                        textSubject4.setText(routine_list.getSubject4());
                        textSubject5.setText(routine_list.getSubject5());
                        time1.setText(routine_list.getTime1());
                        time2.setText(routine_list.getTime2());
                        time3.setText(routine_list.getTime3());
                        time4.setText(routine_list.getTime4());
                        time5.setText(routine_list.getTime5());

                    }

                    if(task.getResult().size() == 0){
                        Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
                    }

                }

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
