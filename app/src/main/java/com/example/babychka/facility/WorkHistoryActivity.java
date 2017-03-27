
package com.example.babychka.facility;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

public class WorkHistoryActivity extends AppCompatActivity {

        workRecord[] daily_work = new workRecord[500];
        ArrayList<String> entry_list;
        ArrayAdapter<String> adapter;
        String[] workRecordList = new String[500];
        TextView title;
        ListView workListView;

        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_entry_history);
            setTitle("Work History");
            title = (TextView) findViewById(R.id.title);
            workListView = (ListView) findViewById(R.id.entry_list);
            title.setText(getIntent().getIntExtra("Year", 0) + "/" + getIntent().getIntExtra("Month", 0) + "/" + getIntent().getIntExtra("Day", 0));
            getWorkDone();
            UIsetup();

            workListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position,
                                        long id) {
                    Intent intent = new Intent(WorkHistoryActivity.this, workRecordDisplay.class);
                    intent.putExtra("Cleanliness", daily_work[position].getClean_index());
                    intent.putExtra("Soap", daily_work[position].getInventory().getSoap());
                    intent.putExtra("ToiletPaper", daily_work[position].getInventory().getToiletpaper());
                    intent.putExtra("Comment", daily_work[position].getComments());
                    startActivity(intent);
                }
            });

        }

    public void getWorkDone() {
        int bathroom_id = 1;//PARSE TO INTInteger.parseInt(getIntent().getStringExtra("ID"));
        //WILL BE REPLACED BY SEARCH QUERY
        for (int i = 0; i < 5; i++) {
            daily_work[i] = new workRecord();
            daily_work[i].setBathroomID(bathroom_id);
            daily_work[i].setComments("Test");
            daily_work[i].setClean_index(i);
        }
    }

    public void UIsetup() {
        for (int i = 0; i < 5; i++) {
            workRecordList[i] = "Work at: " + daily_work[i].getTime_of_work();
        }
        adapter = new ArrayAdapter<String>(this, R.layout.worklist, workRecordList);
        workListView.setAdapter(adapter);
    }
}

