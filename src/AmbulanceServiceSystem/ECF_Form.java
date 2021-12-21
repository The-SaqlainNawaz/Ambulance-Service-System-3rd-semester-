/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AmbulanceServiceSystem;

/**
 *
 * @author Hassan Nawaz
 */
public class ECF_Form {
    private Caller_Class caller_class;
    private String Emergency_nature;
    private String Location;
    private String Date;
    private Ambulances ambulance;
    private Linked_List<EMTs> emts;
    private Drivers driver;
    private String Hospital_Location;

    public ECF_Form(Caller_Class caller_class, String Emergency_nature, String Location, String Date, Ambulances ambulance, Linked_List<EMTs> emts, Drivers driver, String Hospital_Location) {
        this.caller_class = caller_class;
        this.Emergency_nature = Emergency_nature;
        this.Location = Location;
        this.Date = Date;
        this.ambulance = ambulance;
        this.emts = emts;
        this.driver = driver;
        this.Hospital_Location = Hospital_Location;
    }

    public Caller_Class getCaller_class() {
        return caller_class;
    }

    public String getEmergency_nature() {
        return Emergency_nature;
    }

    public String getLocation() {
        return Location;
    }

    public String getDate() {
        return Date;
    }

    public Ambulances getAmbulance() {
        return ambulance;
    }

    public Linked_List<EMTs> getEmts() {
        return emts;
    }

    public Drivers getDriver() {
        return driver;
    }

    public String getHospital_Location() {
        return Hospital_Location;
    }

    public void setCaller_class(Caller_Class caller_class) {
        this.caller_class = caller_class;
    }

    public void setEmergency_nature(String Emergency_nature) {
        this.Emergency_nature = Emergency_nature;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public void setAmbulance(Ambulances ambulance) {
        this.ambulance = ambulance;
    }

    public void setEmts(Linked_List<EMTs> emts) {
        this.emts = emts;
    }

    public void setDriver(Drivers driver) {
        this.driver = driver;
    }

    public void setHospital_Location(String Hospital_Location) {
        this.Hospital_Location = Hospital_Location;
    }
    
    
    
}
