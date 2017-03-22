package com.example.babychka.facility;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

/**
 * Created by Alec on 2017-03-21.
 */

public class Entry {
    private Bathroom bathroom;
    private Calendar time_of_entry;
    private int number_of_entries;
    private String time = new String();
    private sensorServerHelper sensorServer = new sensorServerHelper();

    Entry (int id, int count) {
        bathroom = new Bathroom();
        bathroom.setBathroomID(id);
        number_of_entries = count;
        setTime_of_entry();
    }

    Entry (int id, int count, Calendar date) {
        bathroom = new Bathroom();
        bathroom.setBathroomID(id);
        setTime_of_entry();
    }

    public String getDate(){
        time = time_of_entry.toString();
        return time;
    }   //Returns the date

    public void setTime_of_entry(){
      //Assigning the time of creation to the calendar object.
        String[] ids = TimeZone.getAvailableIDs(-5*60*60*1000); //Creating the time zone
        SimpleTimeZone est = new SimpleTimeZone(-5 * 60*60*1000, ids[0]); //Creating the time zone est

        //Creating calendar object
        time_of_entry = new GregorianCalendar(est);
        Date trialTime = new Date();    //Temporary date object, initialized with the time of creation
        time_of_entry.setTime(trialTime);    //Sets the calendar to the current data and time
}   //Set the time of entry to the current time

    public void getSensorData(){
        //sensorServer.receive(BathroomActivity.this);
        //t_counter.setText(""+sensorServer.getCounter());
    }
}