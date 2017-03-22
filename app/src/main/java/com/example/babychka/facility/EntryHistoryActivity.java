package com.example.babychka.facility;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class EntryHistoryActivity extends AppCompatActivity {

    Entry[] daily_Entries = new Entry[500];
    ArrayList<String> entry_list;
    ArrayAdapter<String> adapter;
    String[] entrylist = new String[500];
    TextView title;
    ListView entryListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_history);
        setTitle("Entry History");
        title = (TextView) findViewById(R.id.title);
        entryListView = (ListView) findViewById(R.id.entry_list);
        title.setText( getIntent().getIntExtra("Year",0) + "/" + getIntent().getIntExtra("Month",0) + "/" + getIntent().getIntExtra("Day",0));
        getEntries();
        UIsetup();
    }
    public void getEntries(){
        int bathroom_id = 1;//PARSE TO INTInteger.parseInt(getIntent().getStringExtra("ID"));
        //search query with data and bathroom id 1.
        for (int i=0; i<5; i++) {
            daily_Entries[i] = new Entry(bathroom_id,1);
        }
    }
    public void UIsetup(){
        for (int i=0; i<5; i++) {
           entrylist[i]="Entry at: " + daily_Entries[i].getDate();
        }
        adapter = new ArrayAdapter<String>(this,R.layout.entrylist, entrylist);
        entryListView.setAdapter(adapter);
    }
}
