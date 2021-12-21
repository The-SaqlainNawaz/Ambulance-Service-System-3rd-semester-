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
public class CTWOs extends Person{
     private int Login_status;
     private String shift;
    public CTWOs(int Login_status, String shift, String Name, String ID_Card, String Contact_Number, String picture, String gender, long special_ID) {
        super(Name, ID_Card, Contact_Number, picture, gender, special_ID);
        this.Login_status = Login_status;
        this.shift = shift;
    }

    public int getLogin_status() {
        return Login_status;
    }

    public String getShift() {
        return shift;
    }

    public void setLogin_status(int Login_status) {
        this.Login_status = Login_status;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }
    
    
    
}
