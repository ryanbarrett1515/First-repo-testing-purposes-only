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

    ArrayList<Person> list;

    public People(int size) {
        list = new ArrayList<>(size);
    }

    public People() {
        list = new ArrayList<>();
    }

    public void add(Person p) {
        list.add(p);
    }

    public void remove(Person p) {
        list.remove(p);
    }

    public String peopleToString() {
        String text = "";
        for (int i = 0; i < list.size(); i++) {
            text += list.get(i) + "\n";
        }
        return text;
    }

    public Person get(int i) {
        return list.get(i);
    }

    public int size() {
        return list.size();
    }

    public ArrayList<Person> getList() {
        return list;
    }

    public boolean equals(Object o) {
        boolean value = true;
        if (!(o instanceof People)) {
            value = false;
        } else {
            try {
                for (int i = 0; i < list.size(); i++) {
                    if (!list.get(i).equals(((People) o).get(i))) {
                        value = false;
                    }
                }
            } catch (Exception e) {
                value = false;
            }
        }
        return value;
    }
}
