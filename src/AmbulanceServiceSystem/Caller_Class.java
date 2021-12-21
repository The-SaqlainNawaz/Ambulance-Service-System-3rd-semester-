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
public class Caller_Class {
    private String name;
    private String COntact_Number;
    private String relation;
    private String Duration;

    public String getName() {
        return name;
    }

    public String getCOntact_Number() {
        return COntact_Number;
    }

    public String getRelation() {
        return relation;
    }

    public String getDuration() {
        return Duration;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCOntact_Number(String COntact_Number) {
        this.COntact_Number = COntact_Number;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public void setDuration(String Duration) {
        this.Duration = Duration;
    }
    
    
    public Caller_Class(String name, String COntact_Number, String relation, String Duration) {
        this.name = name;
        this.COntact_Number = COntact_Number;
        this.relation = relation;
        this.Duration = Duration;
    }
    
    
    
}
