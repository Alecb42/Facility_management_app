package com.example.babychka.facility;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BathroomActivity extends AppCompatActivity {
    TextView t1;
    Button b1;
    sensorServerHelper sensorServer = new sensorServerHelper();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bathroom);
        b1 = (Button) findViewById(R.id.button);
        t1 = (TextView) findViewById(R.id.count);
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sensorServer.receive(BathroomActivity.this);
                t1.setText(""+sensorServer.getCounter());
            }
        });

    }
}
