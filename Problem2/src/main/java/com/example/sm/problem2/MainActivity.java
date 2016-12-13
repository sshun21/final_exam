package com.example.sm.problem2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    MyBaseAdapter adapter;
    ListView listview;
    ArrayList<Employee> emp_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // need something here
        emp_list = new ArrayList<Employee>();

        adapter = new MyBaseAdapter(this, emp_list);
        listview = (ListView) findViewById(R.id.listView1) ;
        listview.setAdapter(adapter);
        listview.setOnItemClickListener((AdapterView.OnItemClickListener)adapter);
    }
    @Override
    public void onClick(View v){
        EditText edit_name = (EditText) findViewById(R.id.edit_name);
        EditText edit_age = (EditText) findViewById(R.id.edit_age);
        EditText edit_salary = (EditText) findViewById(R.id.edit_salary);

        Employee employee;

        switch (v.getId()){
            case R.id.btn_inc:
                int a=Integer.valueOf(edit_salary.getText().toString());
                a+=10000;
                edit_salary.setText(String.valueOf(a));
                break;

            case R.id.btn_dec:
                int b=Integer.valueOf(edit_salary.getText().toString());
                b-=10000;
                edit_salary.setText(String.valueOf(b));
                break;

            case R.id.btn_store:
                String name = edit_name.getText().toString();
                int age =Integer.valueOf(edit_age.getText().toString());
                int salary =Integer.valueOf(edit_salary.getText().toString());
                employee = new Employee(name,age,salary);
                emp_list.add(employee);
                break;

            case R.id.btn_modify:

                break;

            case R.id.btn_delete:
                emp_list.remove(emp_list.size()-1);
                break;
        }
    }
}

interface Payment {
    void increase();
    void decrease();
}
