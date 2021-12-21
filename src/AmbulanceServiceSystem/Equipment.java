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
public class Equipment implements Serializable{
    private String Name;
    private int Amount;
    private String Used_for;

    public Equipment(String Name, int Amount, String Used_for) {
        this.Name = Name;
        this.Amount = Amount;
        this.Used_for = Used_for;
    }

    public String getName() {
        return Name;
    }

    public int getAmount() {
        return Amount;
    }

    public String getUsed_for() {
        return Used_for;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setAmount(int Amount) {
        this.Amount = Amount;
    }

    public void setUsed_for(String Used_for) {
        this.Used_for = Used_for;
    }
    
}
