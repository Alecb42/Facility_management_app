package com.example.babychka.facility;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BathroomActivity extends AppCompatActivity {
    TextView t_counter,t_limit;
    Button workRecordButton, inventoryHistoryButton, entryHistoryButton;
    sensorServerHelper sensorServer = new sensorServerHelper();
    Bathroom bathroom = new Bathroom();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bathroom);
        setTitle(getIntent().getStringExtra("ID"));

        //Assigning UI variables to the layout ID items
        workRecordButton = (Button) findViewById(R.id.work_button);
        inventoryHistoryButton = (Button) findViewById(R.id.inventory_button);
        entryHistoryButton = (Button)  findViewById(R.id.entry_button);
        t_counter = (TextView) findViewById(R.id.count);
        t_limit = (TextView) findViewById(R.id.limit_number);

        checkEmployeeStatus(); //Sets the UI depending on the status of the employee.
        retreiveEntryCounter(); //Gets the count from the sensor and displays it in a text view

    }

    public void WorkRecordOnclick(){
        workRecordButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(BathroomActivity.this, firstFloorBathroom.class);
                startActivity(intent);
            }
        });
    }   //onClickListener to open the work recording activity

    public void WorkHistoryOnClick(){
        workRecordButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(BathroomActivity.this, Calendar_Activity.class);
                intent.putExtra("ID", getIntent().getStringExtra("ID"));
                intent.putExtra("Work", true);
                startActivity(intent);
            }
        });
    }   //OnClickListener to open the inventory history activity

    public void InventoryHistoryOnClick(){
        inventoryHistoryButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(BathroomActivity.this, Calendar_Activity.class);
                intent.putExtra("ID", getIntent().getStringExtra("ID"));
                intent.putExtra("Inventory", true); //Pass a boolean value, to indicate that the calendar will open the history entry.
                startActivity(intent);
            }
        });
    }   //OnclickListener to open the inventory history activity

    public void EntryHistoryOnClick(){
        entryHistoryButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(BathroomActivity.this, Calendar_Activity.class);
                intent.putExtra("ID", getIntent().getStringExtra("ID"));
                intent.putExtra("Entry", true); //Pass a boolean value, to indicate that the calendar will open the history entry.
                startActivity(intent);
            }
        });
    }   //OnclickListener to open the entry history activity

    public void checkEmployeeStatus(){
        if(getIntent().getBooleanExtra("Manager", false) == true)
        {
            workRecordButton.setText("View History Record");
            inventoryHistoryButton.setText("Inventory History");
            entryHistoryButton.setText("Entry History");
            WorkHistoryOnClick();   //Manager wants to open the work recording HISTORY feature
            InventoryHistoryOnClick();  //Manager want to open the inventory history feature
            EntryHistoryOnClick();  //Manager want to open the entry history feature
        }
        if(getIntent().getBooleanExtra("Employee", false) == true)
        {
            workRecordButton.setText("Record Work Activity");
            inventoryHistoryButton.setVisibility(View.GONE);    //Employee cannot see the inventory history button
            entryHistoryButton.setVisibility(View.GONE);    //Employee cannot se the entry history button
            WorkRecordOnclick();    //Employee wants to open the WORK RECORDING feature
        }
    }   //Checks the status of the employee, to build the corresponding UI.

    public void retreiveEntryCounter(){
        sensorServer.receive(BathroomActivity.this);
        t_counter.setText(""+sensorServer.getCounter());
    }   //Retreives the number of entries from the arduino server and assigns it to a textview.

}
