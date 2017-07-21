package main.java.factory;

import main.java.exceptions.MyNotPhoneNumberException;
import main.java.model.data.Contact;
import main.java.model.data.Entity;
import main.java.model.data.Group;

public class EntityFactory {
    public Entity getContact(String name){
        return new Group(name);
    }

    public Entity getContact(String firstName, String number) throws MyNotPhoneNumberException {
        return new Contact(firstName, number);
    }

    public Entity getContact(String firstName, String lastName, String number) throws MyNotPhoneNumberException {
        return new Contact(firstName, lastName, number);
    }
}
