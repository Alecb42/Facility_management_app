package com.example.babychka.facility;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ManagerActivity extends AppCompatActivity {








   /* Button Inventory;       //Initialized Inventory variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

        //Indicating Button id that equals to Inventory object
        Inventory = (Button) findViewById(R.id.InventoryButton);

        //this Inventory button brings to another activity -> InventoryActivity class
        Inventory.setOnClickListener(new View.OnClickListener(){

            public void onClick(View Building) {

                startActivity(new Intent(ManagerActivity.this, InventoryActivity.class));
                Toast.makeText(ManagerActivity.this, "Accessed Inventory Page", Toast.LENGTH_SHORT).show();
            }

        });
    } */

    //It has function, log out
    @Override
    public boolean onCreateOptionsMenu (Menu menu2){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu2, menu2);
        return super.onCreateOptionsMenu(menu2);
    }



}
