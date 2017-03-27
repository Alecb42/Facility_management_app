package com.example.babychka.facility;
//TODO change name of this activity to work recording

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class firstFloorBathroom extends AppCompatActivity {

    TextView showValue1;            // it shows number of count
    TextView showValue2;
    int counter1 = 0;               // it's the count variable.
    int counter2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_floor_bathroom);


        showValue1 = (TextView) findViewById(R.id.counterValue1);
        showValue2 = (TextView) findViewById(R.id.counterValue2);
    }


    //on each click on the button counter value will be increase  for toilet paper
    public void countIN1 (View view) {
            counter1++;
            showValue1.setText(Integer.toString(counter1));
        }

    //on each click on the button counter value will be increase for toilet paper
    public void countDC1 (View v) {
            counter1--;
            showValue1.setText(Integer.toString(counter1));
        }

        //on each click on the button counter value will be increase for soup
    public void countIN2 (View view) {
        counter2++;
        showValue2.setText(Integer.toString(counter2));
    }

        //on each click on the button counter value will be decrease for soup
    public void countDC2 (View v) {
        counter2--;
        showValue2.setText(Integer.toString(counter2));
    }

    public void resetCounter (View view)
    {
        counter1 = 0;
        counter2 = 0;
        showValue1.setText(String.valueOf(counter1));
        showValue2.setText(String.valueOf(counter2));

    }


}
