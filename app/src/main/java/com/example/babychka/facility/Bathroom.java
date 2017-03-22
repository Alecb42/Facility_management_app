package com.example.babychka.facility;

/**
 * Created by Alec on 2017-03-20.
 */

public class Bathroom {
    //------------- Private data members --------------
    private int entryLimit;
    private int counter;
    private int bathroomID;
    private int buildingID;
    //-------------- Public member functions ----------
    //Constructors
    public Bathroom(){
        entryLimit = 200;
        counter = 0;
        bathroomID = 0; //STATIC ID?
        buildingID = 0;
    }   //Empty Inventory constructor

    //get functions
    public int getEntryLimit(){return entryLimit;}  //Returns to number of soap used.
    public int getCounter(){return counter;}  //Returns the number of paper used
    public int getBathroomID(){return bathroomID;}
    public int getBuildingID(){return buildingID;}

    //set functions
    public void setEntryLimit(int limit){entryLimit = limit;} //Sets the quantity of soap used
    public void setCounter(int count){counter = count;}    //Sets the quantity of p
    public void setBathroomID(int ID){bathroomID = ID;}
    public void setBuildingID(int ID){buildingID = ID;}

    //Server Functions
    //TODO public void retreiveBathroom(int ID);
    //TODO public void saveBathroom(int ID);
}
