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

public class InventoryActivity extends AppCompatActivity {

    Inventory inventory = new Inventory();
    ArrayAdapter<String> adapter;
    TextView title,paper,soap;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);
        setTitle("Work History");
        title = (TextView) findViewById(R.id.title);
        title.setText("Inventory used on the "+  getIntent().getIntExtra("Year", 0) + "/" + getIntent().getIntExtra("Month", 0) + "/" + getIntent().getIntExtra("Day", 0));
        soap = (TextView) findViewById(R.id.soap_quantity);
        paper = (TextView) findViewById(R.id.paper_quantity);
        soap.setText("6");
        paper.setText("44");
        getDailyInventory();
        UIsetup();

    }

    public void getDailyInventory() {
        int bathroom_id = 1;//PARSE TO INTInteger.parseInt(getIntent().getStringExtra("ID"));
        //WILL BE REPLACED BY SEARCH QUER
        inventory.setSoap(5);
        inventory.setToiletPaper(12);

    }

    public void UIsetup() {
        soap.setText(""+inventory.getSoap());
        paper.setText(""+inventory.getToiletpaper());
    }
}
