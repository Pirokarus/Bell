package main.java.factory;

import main.java.exceptions.MyNotPhoneNumberException;
import main.java.model.data.Contact;
import main.java.model.data.Entity;
import main.java.model.data.Group;

public class EntityFactory {
    public Entity getEntity(String name){
        return new Group(name);
    }

    public Entity getEntity(String firstName, String number) throws MyNotPhoneNumberException {
        return new Contact(firstName, number);
    }

    public Entity getEntity(String firstName, String lastName, String number) throws MyNotPhoneNumberException {
        return new Contact(firstName, lastName, number);
    }
}
