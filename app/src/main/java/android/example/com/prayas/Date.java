package android.example.com.prayas;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

import java.util.Calendar;

public class Date extends AppCompatActivity {
    EditText date;
    DatePickerDialog datePickerDialog;
    Button btn,ll;
    private FirebaseDatabase mFirebaseDtabase;
    private DatabaseReference mStudentDatabaseReference;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);
        date = (EditText) findViewById(R.id.date);
        btn=findViewById(R.id.nxt);
        mFirebaseDtabase=FirebaseDatabase.getInstance();
        //mFirebaseStorage= FirebaseStorage.getInstance();
        mStudentDatabaseReference=mFirebaseDtabase.getReference().child("Date");
        // perform click event on edit text
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(Date.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                date.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String ddd=date.getText().toString().trim();
                if(!TextUtils.isEmpty(ddd))
                {
                 mStudentDatabaseReference.setValue(ddd);
                }
                Intent intent = new Intent(Date.this,ScrollingActivity.class);
                startActivity(intent);
            }
        });
    }
}
