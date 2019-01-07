package com.dell.firestore;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class AssignmentDisp extends AppCompatActivity {

    private TextView title, desc;
    private FirebaseFirestore mFirestore;
    public static String Doc_id;
    private List<Assignment_list> assignment_lists;
    private DocumentSnapshot mLastQueriedDocument;
    //private String s ;
    public TextView Asgn_Title, Asgn_Subject,Asgn_Deadline,Asgn_Desc,Asgn_Teacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment_disp);

        mFirestore= FirebaseFirestore.getInstance();
        assignment_lists=new ArrayList<>();

        Asgn_Title= findViewById(R.id.Asgn_Title);
        Asgn_Subject= findViewById(R.id.Asgn_Subject);
        Asgn_Deadline= findViewById(R.id.Asgn_Deadline);
        Asgn_Teacher= findViewById(R.id.Asgn_Teacher);
        Asgn_Desc= findViewById(R.id.Asgn_Desc);

        CollectionReference assignmentCollectionRef = mFirestore
                .collection("Assignments");

        Query assignmentQuery = null;
        assignmentQuery = assignmentCollectionRef
                .whereEqualTo("assignment_id", Assignment_Adapter.assignment_id);

        assignmentQuery.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){

                    for(DocumentSnapshot document: task.getResult()){
                        Assignment_list assignment_list = document.toObject(Assignment_list.class);
                        assignment_lists.add(assignment_list);
//                        Log.d(TAG, "onComplete: got a new note. Position: " + (mNotes.size() - 1));
                        Asgn_Title.setText(assignment_list.getTitle());
                        Asgn_Subject.setText(assignment_list.getSubject());
                        Asgn_Deadline.setText(assignment_list.getDeadline());
                        Asgn_Teacher.setText(assignment_list.getTeacher());
                        Asgn_Desc.setText(assignment_list.getDesc());
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
