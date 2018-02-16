/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cirdles.fileinputstuff;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

/**
 *
 * @author RyanBarrett
 */
public class PeopleConverter implements Converter {

    public boolean canConvert(Class clas) {
        return clas.equals(People.class);
    }

    public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) {
        People people = (People) value;

        writer.startNode("list");

        for (int i = 0; i < people.size(); i++) {
            Person person = people.get(i);

            writer.startNode("person");

            writer.startNode("first");
            writer.setValue(person.getFirstName());
            writer.endNode();
            writer.startNode("last");
            writer.setValue(person.getLastName());
            writer.endNode();
            writer.startNode("dob");
            writer.setValue(person.getDOB());
            writer.endNode();

            writer.endNode();
        }

        writer.endNode();
    }

    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        People people = new People();

        reader.moveDown();
        try {
            while (true) {
                reader.moveDown();

                reader.moveDown();
                String first = reader.getValue();
                reader.moveUp();

                reader.moveDown();
                String last = reader.getValue();
                reader.moveUp();

                reader.moveDown();
                String dob = reader.getValue();
                reader.moveUp();

                reader.moveUp();

                people.add(new Person(first, last, dob));
            }
        } catch (Exception e) {
        }

        return people;
    }
}
