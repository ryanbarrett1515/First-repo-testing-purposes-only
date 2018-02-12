package org.cirdles.fileinputstuff;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author RyanBarrett
 */
public class People {

    ArrayList<Person> people;

    public People(int size) {
        people = new ArrayList<>(size);
    }

    public People() {
        people = new ArrayList<>();
    }

    public void add(Person p) {
        people.add(p);
    }

    public void remove(Person p) {
        people.remove(p);
    }

    public String peopleToString() {
        String text = "";
        for (int i = 0; i < people.size(); i++) {
            text += people.get(i) + "\n";
        }
        return text;
    }

    public Person get(int i) {
        return people.get(i);
    }

    public int size() {
        return people.size();
    }
}
