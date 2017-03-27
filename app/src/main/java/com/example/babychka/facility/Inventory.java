package com.example.babychka.facility;

/**
 * Created by Alec on 2017-03-19.
 */

public class Inventory {
    //------------- Private data members --------------
    private int soap;
    private int toilet_paper;
    //-------------- Public member functions ----------
    //Constructors
    public Inventory(){
        soap = 0;
        toilet_paper = 0;
    }   //Empty Inventory constructor
    public Inventory (int soap_quantity, int toilet_paper_quantity) {
        soap = soap_quantity;
        toilet_paper = toilet_paper_quantity;
    }   //Overloaded Inventory constructor

    //get functions
    public int getSoap(){return soap;}  //Returns to number of soap used.
    public int getToiletpaper(){return toilet_paper;}  //Returns the number of paper used
    //set functions
    public void setSoap(int quantity){soap = quantity;} //Sets the quantity of soap used
    public void setToiletPaper(int quantity) {toilet_paper = quantity;}    //Sets the quantity of paper used
}
