package android.example.com.prayas;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


import static androidx.core.content.ContextCompat.startActivity;

public class StudentAdapter extends ArrayAdapter<Student> {
    public StudentAdapter(Context context, List<Student> objects) {
        super(context,0, objects);
    }


    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);

        }
        CheckBox roll = (CheckBox)convertView.findViewById(R.id.roll);
        TextView name = (TextView)convertView.findViewById(R.id.student_name);
        ImageView editIcon = (ImageView)convertView.findViewById(R.id.edit_member);

          Student student = getItem(position);
        roll.setText(Objects.requireNonNull(student).getRoll());
        name.setText(student.getName());
        editIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(parent.getContext(),EditorActivity.class);
                intent.putExtra("roll", Objects.requireNonNull(getItem(position)).getRoll());
                startActivity(parent.getContext(),intent,null);
            }
        });
        roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int set = Objects.requireNonNull(getItem(position)).getSet();
                String selectedRoll = Objects.requireNonNull(getItem(position)).getRoll();
                if(set==7){
                    if(Set1.selectedStudents1.contains(selectedRoll)){
                        Set1.selectedStudents1.remove(selectedRoll);
                    }
                    else{
                        Set1.selectedStudents1.add(selectedRoll);
                    }
                }
                else if(set==8){
                    if(Set2.selectedStudents2.contains(selectedRoll)){
                        Set2.selectedStudents2.remove(selectedRoll);
                    }
                    else{
                        Set2.selectedStudents2.add(selectedRoll);
                    }
                }
                else if(set==9){
                    if(Set3.selectedStudents3.contains(selectedRoll)){
                        Set3.selectedStudents3.remove(selectedRoll);
                    }
                    else{
                        Set3.selectedStudents3.add(selectedRoll);
                    }
                }
            }
        });
        return convertView;
    }
}
