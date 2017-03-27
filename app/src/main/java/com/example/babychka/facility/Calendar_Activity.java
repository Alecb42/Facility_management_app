package com.example.babychka.facility;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;

public class Calendar_Activity extends AppCompatActivity {

    CalendarView calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_);

        calendar = (CalendarView) findViewById(R.id.calendarView);  //Assignement calendar object to the layout item

               if(getIntent().getBooleanExtra("Entry", false) == true) {    //Check if the intent is too access entry/calendar
                    onDataListenerEntryHistory();
                }
                if(getIntent().getBooleanExtra("Work", false) == true) {
                    onDataListenerWorkHistory();
                }
                if(getIntent().getBooleanExtra("Inventory", false) == true)
                {
                    onDataListenerInventoryHistory();
                }
                else {
                   Toast.makeText(getBaseContext(),"ERROR", Toast.LENGTH_LONG).show();
               }

    }   //onClickListener that listens when a data is clicked.
    public void onDataListenerEntryHistory(){
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayofMonth) {
                    Intent intent_entry_history = new Intent(Calendar_Activity.this, EntryHistoryActivity.class);   //Start the entry history activity
                    intent_entry_history.putExtra("ID", getIntent().getIntExtra("ID",404));   //Pass the type of activity that needs to be displayed
                    intent_entry_history.putExtra("Year", year);    //Pass the year for which we need to display the entry
                    intent_entry_history.putExtra("Month", month);  //Pass the month for which we need to display the entry
                    intent_entry_history.putExtra("Day", dayofMonth);   //Pass the day for which we need to display the entry
                    startActivity(intent_entry_history);
            }
        });
    }
    public void onDataListenerWorkHistory(){
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayofMonth) {
                Intent intent_work_history = new Intent(Calendar_Activity.this, WorkHistoryActivity.class);   //Start the entry history activity
                intent_work_history.putExtra("ID", getIntent().getIntExtra("ID",404));   //Pass the type of activity that needs to be displayed
                intent_work_history.putExtra("Year", year);    //Pass the year for which we need to display the entry
                intent_work_history.putExtra("Month", month);  //Pass the month for which we need to display the entry
                intent_work_history.putExtra("Day", dayofMonth);   //Pass the day for which we need to display the entry
                startActivity(intent_work_history);
            }
        });
    }
    public void onDataListenerInventoryHistory(){
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayofMonth) {
                Intent intent_inventory_history = new Intent(Calendar_Activity.this, InventoryActivity.class);   //Start the entry history activity
                intent_inventory_history.putExtra("ID", getIntent().getIntExtra("ID",404));   //Pass the type of activity that needs to be displayed
                intent_inventory_history.putExtra("Year", year);    //Pass the year for which we need to display the entry
                intent_inventory_history.putExtra("Month", month);  //Pass the month for which we need to display the entry
                intent_inventory_history.putExtra("Day", dayofMonth);   //Pass the day for which we need to display the entry
                startActivity(intent_inventory_history);
            }
        });
    }
}
