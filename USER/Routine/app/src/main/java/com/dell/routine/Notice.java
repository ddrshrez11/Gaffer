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

public class    Notice extends AppCompatActivity{

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private FirebaseFirestore mFirestore;
    public static String Doc_id;
    private List<Notice_list> notice_lists;
    private DocumentSnapshot mLastQueriedDocument;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("NOTICE");
        setContentView(R.layout.activity_notice);

        mFirestore= FirebaseFirestore.getInstance();
        recyclerView = findViewById(R.id.recyclerView1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        notice_lists=new ArrayList<>();

        CollectionReference noticeCollectionRef = mFirestore
                .collection("Notice");

        Query noticeQuery = null;
        if(mLastQueriedDocument != null){
            noticeQuery = noticeCollectionRef
                    .orderBy("timestamp", Query.Direction.ASCENDING)
                    .startAfter(mLastQueriedDocument);
        }
        else{
            noticeQuery = noticeCollectionRef
                    .orderBy("timestamp", Query.Direction.DESCENDING);
        }

        noticeQuery.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){

                    for(DocumentSnapshot document: task.getResult()){
                        Notice_list notice_list = document.toObject(Notice_list.class);
                        notice_lists.add(notice_list);
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

//        mFirestore.collection("Notice").addSnapshotListener(new EventListener<QuerySnapshot>() {
//            @Override
//            public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
//
//                if(e != null){
//                    Log.d("Firelog","Error: "+ e.getMessage() );
//                }
//                for(DocumentChange doc : documentSnapshots.getDocumentChanges()){
//                    if (doc.getType()== DocumentChange.Type.ADDED){
//
//                        Notice_list Notice_list = doc.getDocument().toObject(Notice_list.class);
//                        notice_lists.add(Notice_list);
//                        adapter.notifyDataSetChanged();
//
//                    }
//                }
//            }
//        });

        adapter= new NoticeAdapter(notice_lists,this);
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
