package android.example.com.prayas;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ScrollingActivity extends AppCompatActivity {
    Spinner spinner;
  TextView txt;
    List<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        spinner=findViewById(R.id.spin);
        txt=findViewById(R.id.spintext);
        setSupportActionBar(toolbar);
        list = new ArrayList<String>();
        list.add("Set 1");
        list.add("Set 2");
        list.add("Set 3");
        //creating adapter for spinner
        ArrayAdapter<String> adp=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, list);
        adp.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        //setting the adapter
        spinner.setAdapter(adp);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                 Intent intent;
                switch (i){
                    case 0:
                        intent=new Intent(ScrollingActivity.this,Set_1.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(),"Set1",Toast.LENGTH_SHORT).show();
                        break;
                    case 1:intent=new Intent(ScrollingActivity.this,Set_2.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(),"Set1",Toast.LENGTH_SHORT).show();
                        break;
                    case 2:intent=new Intent(ScrollingActivity.this,Set_3.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(),"Set1",Toast.LENGTH_SHORT).show();
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
