package android.example.com.prayas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

class Set2 extends Fragment {
    public Set2() {
    }
    private FirebaseDatabase mDatabase;
    private DatabaseReference mStudentDatabaseReference;
    private DatabaseReference mLocalReference;
    private StudentAdapter mStudentAdapter;
    private ListView mListView;
    private ChildEventListener mChildEventListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.content_scrolling, container, false);
        mDatabase=FirebaseDatabase.getInstance();
        mStudentDatabaseReference=mDatabase.getReference().child("student");
        mLocalReference=mStudentDatabaseReference.getRef().child("SET-2");
        List<Student> set2Students = new ArrayList<>();
        mStudentAdapter = new StudentAdapter(getContext(),set2Students);
        mListView= rootView.findViewById(R.id.list);
        mListView.setAdapter(mStudentAdapter);
        attachDatabaseListener();
        return rootView;
    }

    private void attachDatabaseListener() {
        if(mChildEventListener==null){
            mChildEventListener = new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    Student student =
                            dataSnapshot.getValue(Student.class);
                    mStudentAdapter.add(student);
                    mStudentAdapter.notifyDataSetChanged();
                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            };
            mLocalReference.addChildEventListener(mChildEventListener);
        }
    }
}
