package com.example.babychka.facility;

import android.content.Context;

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
    private Context context;

    Entry (int id, Context c) {
        context=c;
        bathroom = new Bathroom();  //Creation of bathroom object
        bathroom.setBathroomID(id); //Assigning the passed ID to the bathroom object
        getSensorData();    //Receives data from the sensor server
        setTime_of_entry(); //Records the current time
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
        sensorServer.receive(context);
        number_of_entries = sensorServer.getCounter();
    }

}