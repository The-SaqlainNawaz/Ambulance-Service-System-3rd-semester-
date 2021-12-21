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
public class Drivers extends Person{
    private int status;
    private String shift;
    private String pass;

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    
    public int getStatus() {
        return status;
    }

    public String getShift() {
        return shift;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public Drivers(String pass,int status, String shift, String Name, String ID_Card, String Contact_Number, String picture, String gender, long special_ID) {
        super(Name, ID_Card, Contact_Number, picture, gender, special_ID);
        this.status = status;
        this.shift = shift;
        this.pass=pass;
    }
    
    
   
    
}
