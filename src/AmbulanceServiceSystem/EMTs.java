/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AmbulanceServiceSystem;

import java.io.Serializable;

/**
 *
 * @author Hassan Nawaz
 */
public class EMTs extends Person implements Serializable{
    
    private int status;
    private int login_status;
    private String shift;
    private String pass;

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPass() {
        return pass;
    }
    
    public EMTs(String pass,int status, int login_status, String shift, String Name, String ID_Card, String Contact_Number, String picture, String gender, long special_ID) {
        super(Name, ID_Card, Contact_Number, picture, gender, special_ID);
        this.status = status;
        this.login_status = login_status;
        this.shift = shift;
        this.pass=pass;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setLogin_status(int login_status) {
        this.login_status = login_status;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setID_Card(String ID_Card) {
        this.ID_Card = ID_Card;
    }

    public void setContact_Number(String Contact_Number) {
        this.Contact_Number = Contact_Number;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setSpecial_ID(long special_ID) {
        this.special_ID = special_ID;
    }

    public int getStatus() {
        return status;
    }

    public int getLogin_status() {
        return login_status;
    }

    public String getShift() {
        return shift;
    }

    public String getName() {
        return Name;
    }

    public String getID_Card() {
        return ID_Card;
    }

    public String getContact_Number() {
        return Contact_Number;
    }

    public String getPicture() {
        return picture;
    }

    public String getGender() {
        return gender;
    }

    public long getSpecial_ID() {
        return special_ID;
    }
    
    
}
