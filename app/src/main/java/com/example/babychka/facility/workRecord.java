package com.example.babychka.facility;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

/**
 * Created by Alec on 2017-03-20.
 */

public class workRecord {
    //------------- Private data members --------------
    private int clean_index;
    private Inventory inventory;
    private String comments;
    private int bathroomID;
    private int buildingID;
    private Calendar time_of_work;
    //private Employee employee;

    //-------------- Public member functions ----------
    //Constructors
    public workRecord(){
        clean_index = 0;
        inventory = new Inventory();
        comments = null;
        bathroomID = 0;
        buildingID = 0;

        //Assigning the time of creation to the calendar object.
        String[] ids = TimeZone.getAvailableIDs(-5*60*60*1000); //Creating the time zone
        SimpleTimeZone est = new SimpleTimeZone(-5 * 60*60*1000, ids[0]); //Creating the time zone est

        //Creating calendar object
        time_of_work = new GregorianCalendar(est);
        Date trialTime = new Date();    //Temporary date object, initialized with the time of creation.
        time_of_work.setTime(trialTime);    //Sets the calendar to the current data and time.
    }   //Empty workRecord constructor

    //get functions
    public int getClean_index(){return clean_index;}  //Returns to number of soap used.
    public Inventory getInventory(){return inventory;}
    public String getComments(){return comments;}
    public int getBathroomID(){return bathroomID;}
    public int getBuildingID(){return buildingID;}
    public Calendar getTime_of_work() {return time_of_work;}
    public String getTimeString(){return time_of_work.toString();}

    //set functions
    public void setClean_index(int cleanliness){clean_index = cleanliness;}
    public void setInventory(Inventory inventory_used){inventory = inventory_used;}
    public void setComments(String text){comments = text;}
    public void setBathroomID(int ID){bathroomID = ID;}
    public void setBuildingID(int ID){buildingID = ID;}
}
