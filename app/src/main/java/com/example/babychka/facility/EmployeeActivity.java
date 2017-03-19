package com.example.babychka.facility;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class EmployeeActivity extends AppCompatActivity {

    Button Bathroom1;    //Initialized Button variable for building area
    Button Bathroom2;
    Button Bathroom3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);

        Bathroom1 = (Button) findViewById(R.id.Bathroom1);

        Bathroom1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View Bathroom) {

                startActivity(new Intent(EmployeeActivity.this, BathroomActivity.class));
                Toast.makeText(EmployeeActivity.this, "Accessed 1st floor Bathroom Page", Toast.LENGTH_SHORT).show();
            }

        });

        Bathroom2 = (Button) findViewById(R.id.Bathroom2);

        Bathroom2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View Bathroom) {

                startActivity(new Intent(EmployeeActivity.this, secondFloorBathroom.class));
                Toast.makeText(EmployeeActivity.this, "Accessed 2nd floor Bathroom Page", Toast.LENGTH_SHORT).show();
            }

        });

        Bathroom3 = (Button) findViewById(R.id.Bathroom3);

        Bathroom3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View Bathroom) {

                startActivity(new Intent(EmployeeActivity.this, thirdFloorBathroom.class));
                Toast.makeText(EmployeeActivity.this, "Accessed 3rd floor Bathroom Page", Toast.LENGTH_SHORT).show();
            }

        });



        /*
        TextView textViewEmployee = (TextView)findViewById(R.id.TextViewEmployeeUserName);
        String Employee_username = getIntent().getStringExtra("empUsername");
        textViewEmployee.setText(Employee_username);
        */
    }

    //It has function, log out
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}