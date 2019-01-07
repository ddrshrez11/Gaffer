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

public class NoticeDisp extends AppCompatActivity {

    private TextView title, desc;
    private FirebaseFirestore mFirestore;
    public static String Doc_id;
    private List<Notice_list> notice_lists;
    private DocumentSnapshot mLastQueriedDocument;
    //private String s ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_disp);
        mFirestore= FirebaseFirestore.getInstance();
        notice_lists=new ArrayList<>();

        title=findViewById(R.id.ViewNoticeTitle);
        desc=findViewById(R.id.ViewNoticeDesc);
        CollectionReference noticeCollectionRef = mFirestore
                .collection("Notice");

        Query noticeQuery = null;
            noticeQuery = noticeCollectionRef
                    .whereEqualTo("notice_id", NoticeAdapter.notice_id);

        noticeQuery.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){

                    for(DocumentSnapshot document: task.getResult()){
                        Notice_list notice_list = document.toObject(Notice_list.class);
                        notice_lists.add(notice_list);
//                        Log.d(TAG, "onComplete: got a new note. Position: " + (mNotes.size() - 1));
                        title.setText(notice_list.getTitle());
                        desc.setText(notice_list.getDesc());
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
