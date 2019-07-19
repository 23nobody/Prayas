package android.example.com.prayas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Set_1 extends AppCompatActivity {
    //FloatingActionButton fab;
 MyCustomAdapter adapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_1);
       displaylistview();
       checked();
    }
    public void displaylistview()
    {
        ArrayList<Name> namelist = new ArrayList<Name>();
        Name name = new Name("IIT2018105","Bindu",false);
        namelist.add(name);
         name = new Name("IIT2018073","Shreyansh",false);
        namelist.add(name);
        name = new Name("IIT2018119","Nehal",false);
        namelist.add(name);
        name = new Name("IIT2018120","Sanjana",false);
        namelist.add(name);
        name = new Name("IIT2018118","Aayushi",false);
        namelist.add(name);
        adapter=new MyCustomAdapter(this,R.layout.list_item,namelist);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Name names = (Name)parent.getItemAtPosition(i);
                Toast.makeText(getApplicationContext(),"clicked on row" + names.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }
    private class MyCustomAdapter extends ArrayAdapter<Name>
    {
        private ArrayList<Name> namelist;
          public MyCustomAdapter(Context context,int textviewResourceId,ArrayList<Name>namelist)
          {
              super(context,textviewResourceId);
              this.namelist=new ArrayList<Name>();
              this.namelist.addAll(namelist);
          }


    private class ViewHolder
    {
        TextView code;
        CheckBox name;
    }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //return super.getView(position, convertView, parent);
            ViewHolder holder = null;
            if(convertView == null)
            {
                LayoutInflater vi =(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView=vi.inflate(R.layout.list_item,null);
                holder = new ViewHolder();
                holder.code=convertView.findViewById(R.id.code);
                holder.name=convertView.findViewById(R.id.roll);
                convertView.setTag(holder);

                holder.name.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        CheckBox cb =(CheckBox) view;
                        Name name=(Name)cb.getTag();
                        Toast.makeText(getApplicationContext(),"clicked on checkbox"+cb.getTag(),Toast.LENGTH_SHORT).show();
                        name.setSelected(cb.isChecked());
                    }
                });
            }
            else
            {
                holder=(ViewHolder)convertView.getTag();
            }
            Name name=namelist.get(position);
            holder.code.setText("("+name.getCode()+")");
            holder.name.setText(name.getName());
            holder.name.setChecked(name.isSelected());
            holder.name.setTag(name);
            return convertView;
        }
    }
    public void checked()
    {
        Button mButton=findViewById(R.id.findSel);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuffer res= new StringBuffer();
                res.append("selected following");
                ArrayList<Name> namelist=adapter.namelist;
                for(int i=0;i<namelist.size();i++)
                {
                    Name name=namelist.get(i);
                    if(name.isSelected())
                    {
                        res.append("\n"+name.getName());
                    }
                }
            }
        });
    }
}
