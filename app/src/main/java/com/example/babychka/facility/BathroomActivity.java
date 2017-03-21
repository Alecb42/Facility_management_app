package com.example.babychka.facility;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BathroomActivity extends AppCompatActivity {
    TextView t_counter,t_limit;
    Button workRecordButton;
    sensorServerHelper sensorServer = new sensorServerHelper();
    Bathroom bathroom = new Bathroom();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bathroom);
        setTitle(getIntent().getStringExtra("ID"));
        workRecordButton = (Button) findViewById(R.id.button);
        t_counter = (TextView) findViewById(R.id.count);
        t_limit = (TextView) findViewById(R.id.limit_number);

        //bathroom.setBathroomID(getIntent().getIntExtra("ID",0));
        //t_limit.setText(getIntent().getStringExtra("ID"));

        sensorServer.receive(BathroomActivity.this);
        t_counter.setText(""+sensorServer.getCounter());

        onWorkRecordOnclick();

    }

    public void onWorkRecordOnclick(){
        workRecordButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(BathroomActivity.this, firstFloorBathroom.class);
                startActivity(intent);
            }
        });
    }
}
