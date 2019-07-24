package android.example.com.prayas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.List;

public  class Set1 extends Fragment {

    private StudentAdapter mStudentAdapter;
    private ChildEventListener mChildEventListener;
    ArrayList<String> arrayList = new ArrayList<>();
    private ListView mListView;
    String name[] = {"bindu", "mummy", "dramil"};
    String roll[] = {"201", "205", "456"};
    private DatabaseReference mStudentDatabaseReference;

    //mListView=findViewById(R.id.list);
    public Set1() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.content_scrolling, container, false);
        mListView = rootView.findViewById(R.id.list);

        return rootView;
        //set_dapter();

    }
        public void attchDatabaseListener() {
            if(mChildEventListener == null) {
                mChildEventListener = new ChildEventListener() {
                    @Override
                    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                        Student friendlyMessage = dataSnapshot.getValue(Student.class);
                        mStudentAdapter.add(friendlyMessage);

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
                mStudentDatabaseReference.addChildEventListener(mChildEventListener);
            }
        }


}




