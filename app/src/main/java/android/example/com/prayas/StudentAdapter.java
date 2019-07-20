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


import static androidx.core.content.ContextCompat.startActivity;

public class StudentAdapter extends ArrayAdapter<Student> {
    public StudentAdapter(Context context, ArrayList<Student> objects) {
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
        roll.setText(student.getRoll());
        name.setText(student.getName());
        editIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(parent.getContext(),EditorActivity.class);
                intent.putExtra("roll",getItem(position).getRoll());
                startActivity(parent.getContext(),intent,null);
            }
        });

        return convertView;
    }
}
