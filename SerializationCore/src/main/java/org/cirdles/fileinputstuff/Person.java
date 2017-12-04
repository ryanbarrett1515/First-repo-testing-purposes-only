package org.cirdles.fileinputstuff;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RyanBarrett
 */
public class Person {
    private String firstName;
    private String lastName;
    private String DOB;
    
    public Person(String f, String l, String d){
        firstName = f;
        lastName = l;
        DOB = d;
    }
    
    public String getFirstName(){return firstName;}
    public void setFirstName(String f){firstName = f;}
    public String getLastName(){return lastName;}
    public void setLastName(String l){lastName = l;}
    public String getDOB(){return DOB;}
    public void setDOB(String d){DOB = d;}
    public String toString(){return firstName + " " + lastName + " " + DOB;}
}
