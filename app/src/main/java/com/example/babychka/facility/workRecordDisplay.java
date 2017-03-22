package com.example.babychka.facility;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class workRecordDisplay extends AppCompatActivity {

    TextView comment_text, soap_text, toiletpaper_text, clealiness_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_record_display);

        //Assign textView to id
        comment_text = (TextView) findViewById(R.id.comment);
        soap_text = (TextView) findViewById(R.id.quantity_soap);
        toiletpaper_text = (TextView) findViewById(R.id.quantity_toilet_paper);
        clealiness_text = (TextView) findViewById(R.id.cleanliness);

        //Set text
        comment_text.setText(getIntent().getStringExtra("Comment"));
        soap_text.setText(getIntent().getIntExtra("Soap", 404)+"");
        toiletpaper_text.setText(getIntent().getIntExtra("ToiletPaper", 404)+"");
        clealiness_text.setText(getIntent().getIntExtra("Cleanliness", 404)+"");
    }
}
