package org.cirdles.fileinputstuff;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author RyanBarrett
 */
public class Person implements Comparable, Serializable {

    private String firstName;
    private String lastName;
    private String DOB;

    public Person(String f, String l, String d) {
        firstName = f;
        lastName = l;
        DOB = d;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String f) {
        firstName = f;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String l) {
        lastName = l;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String d) {
        DOB = d;
    }

    public String toString() {
        return firstName + " " + lastName + " " + DOB;
    }

    @Override
    public int compareTo(Object o) {
        int returnValue = 0;
        if (!(o instanceof Person)) {
            returnValue = -1;
        } else if (!(((Person) o).equals(this.toString()))) {
            returnValue = 1;
        }
        return returnValue;
    }

    @Override
    public boolean equals(Object o) {
        boolean returnValue = true;
        if (!(o instanceof Person)) {
            returnValue = false;
        } else if (!((Person) o).toString().equals(this.toString())){
            returnValue = false;
        }
        return returnValue;
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }
}
