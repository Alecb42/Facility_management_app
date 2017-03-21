package com.example.babychka.facility;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class EmployeeActivity extends AppCompatActivity {

    ListView bathroomList;
    ArrayAdapter<String> adapter;
    String[] bathrooms = {"1","2","3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);

        bathroomList = (ListView) findViewById(R.id.bathroom_list);
        for(int i=0; i<3; i++)
        {
            bathrooms[i]="Bathroom "+i;
        }
        adapter = new ArrayAdapter<String>(this,R.layout.bathroomlist, bathrooms);
        bathroomList.setAdapter(adapter);


        bathroomList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = new Intent(EmployeeActivity.this, BathroomActivity.class);
                intent.putExtra("ID", parent.getItemAtPosition(position).toString());
                startActivity(intent);
            }
        });
    }

    //It has function, log out
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

}