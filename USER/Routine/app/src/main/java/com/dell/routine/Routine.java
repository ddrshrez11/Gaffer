package com.dell.routine;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

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

public class Routine extends AppCompatActivity {


        private RecyclerView recyclerView;
        private RecyclerView.Adapter adapter;
        private FirebaseFirestore mFirestore;
        private List<Routine_list> routine_lists;
        private DocumentSnapshot mLastQueriedDocument;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            getSupportActionBar().setTitle("Routine");
            setContentView(R.layout.activity_routine);

            mFirestore= FirebaseFirestore.getInstance();
            recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            routine_lists=new ArrayList<>();

            CollectionReference routineCollectionRef = mFirestore
                    .collection("Routine");

            Query routineQuery = null;
            if(mLastQueriedDocument != null){
                routineQuery = routineCollectionRef
                        .orderBy("SN", Query.Direction.ASCENDING)
                        .startAfter(mLastQueriedDocument);
            }
            else{
                routineQuery = routineCollectionRef
                        .orderBy("SN", Query.Direction.ASCENDING);
            }

            routineQuery.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if(task.isSuccessful()){

                        for(DocumentSnapshot document: task.getResult()){
                            Routine_list routine_list= document.toObject(Routine_list.class);
                            routine_lists.add(routine_list);
//                        Log.d(TAG, "onComplete: got a new note. Position: " + (mNotes.size() - 1));
                        }

                        if(task.getResult().size() != 0){
                            mLastQueriedDocument = task.getResult().getDocuments()
                                    .get(task.getResult().size() -1);
                        }
                        adapter.notifyDataSetChanged();
                    }

                }
            });

            adapter = new RoutineAdapter(routine_lists,this);
            recyclerView.setAdapter(adapter);


            adapter= new RoutineAdapter(routine_lists,this);
            recyclerView.setAdapter(adapter);
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
