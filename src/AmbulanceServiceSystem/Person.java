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
abstract public class Person implements Serializable{
    
    //attribute.........................................................................
    public String Name;
    public String ID_Card;
    public String Contact_Number;
    public String picture;
    public String gender;
    public long special_ID;

    // constructor.............................................
    public Person(String Name, String ID_Card, String Contact_Number, String picture, String gender, long special_ID) {
        this.Name = Name;
        this.ID_Card = ID_Card;
        this.Contact_Number = Contact_Number;
        this.picture = picture;
        this.gender = gender;
        this.special_ID = special_ID;
    }    
}
