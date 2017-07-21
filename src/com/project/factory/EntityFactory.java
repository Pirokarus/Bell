package com.project.factory;

import com.project.exceptions.MyNotPhoneNumberException;
import com.project.model.data.Contact;
import com.project.model.data.Entity;
import com.project.model.data.Group;

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
