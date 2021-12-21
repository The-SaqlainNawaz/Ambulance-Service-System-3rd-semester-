/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AmbulanceServiceSystem;

import java.io.Serializable;
import javax.swing.JLabel;

/**
 *
 * @author Hassan Nawaz
 */
public class Ambulances implements Serializable{
    private String Model;
    private String Type;
    private String Number;
    private Linked_List<Equipment> amb_Equip=new Linked_List<>();
    private int jlable=-1;

    public int getJlable() {
        return jlable;
    }

    public void setJlable(int jlable) {
        this.jlable = jlable;
    }

    
    
    

    public Ambulances(String Model, String Type, String Number) {
        this.Model = Model;
        this.Type = Type;
        this.Number = Number;
    }

    public String getModel() {
        return Model;
    }

    public String getType() {
        return Type;
    }

    public String getNumber() {
        return Number;
    }

    public Linked_List<Equipment> getAmb_Equip() {
        return amb_Equip;
    }

    public void setModel(String Model) {
        this.Model = Model;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public void setNumber(String Number) {
        this.Number = Number;
    }

    public void setAmb_Equip(Linked_List<Equipment> amb_Equip) {
        this.amb_Equip = amb_Equip;
    }
    
    
    
}
