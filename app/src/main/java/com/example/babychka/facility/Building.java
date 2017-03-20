package com.example.babychka.facility;

/**
 * Created by Alec on 2017-03-20.
 */

public class Building {
    //------------- Private data members --------------
    private int buildingID; //Contains the ID of the building.
    private int[] bathroomIDs;  //Can contain 10 different bathroom ids

    //-------------- Public member functions ----------
    //Constructors
    public Building(){
        buildingID = 0; //Sets the initial id of the building as zero.
        for (int i=0; i<9 ; i++)     //Loop that will assign a value of 0 to the first 10 array spot.
        {
            bathroomIDs[i] = 0;
        }
    }   //Empty Inventory constructor

    //get functions
    public int getBuildingID(){return buildingID;}  //Returns the id of the building.
    public int[] getBathroomIDs(){return bathroomIDs;}  //Returns a array of int, containing the IDs of the building's bathroom.

    //set functions
    public void setBuildingID(int ID){buildingID = ID;} //Sets the building ID
    public void insert_bathroomID(int ID) {
        int counter = 0;
        for(int i=0; bathroomIDs[i] == 0; i++)
        {
            counter++;
        }
        bathroomIDs[counter] = ID;
    }    //Adds a bathroom ID to the next empty ID array
}
