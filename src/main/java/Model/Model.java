package main.java.model;

import main.java.model.dao.AbstractDAO;
import main.java.model.dao.SimpleDAO;
import main.java.model.data.Base;
import main.java.model.data.Contact;
import main.java.model.data.Group;

import java.util.HashSet;
import java.util.Set;

public class Model {                                //Класс - модель
    private Set<Contact> contactSet;
    private Set<Group> groupSet;
    private AbstractDAO dao;

    public Model(){                                 //Извличение данных происходит в конструкторе

        dao = new SimpleDAO();
        contactSet = dao.getBase().getContactSet();
        groupSet = dao.getBase().getGroupSet();
        Contact.setId_count(dao.getBase().getContactId());
        Group.setId_count(dao.getBase().getGroupId());
        if (contactSet == null){
            contactSet = new HashSet<>();
            Contact.setId_count(0);
        }
        if (groupSet == null){
            groupSet = new HashSet<>();
            Contact.setId_count(0);
        }
    }

    public void save(){                                 //Функция сохранения во внешнюю БД
        Base base = new Base();
        base.setContactSet(contactSet);
        base.setGroupSet(groupSet);
        base.setContactId(Contact.getId_count());
        base.setGroupId(Group.getId_count());
        dao.saveBase(base);
    }

    public Set<Contact> getContactSet() {
        return contactSet;
    }

    public void setContactSet(Set<Contact> contactSet) {
        this.contactSet = contactSet;
    }

    public Set<Group> getGroupSet() {
        return groupSet;
    }

    public void setGroupSet(Set<Group> groupSet) {
        this.groupSet = groupSet;
    }


    /*  Следующие функции являются аналогами функций реализованных в View, поэтому на данный момент не используются

    public boolean addContact(Contact contact){

        boolean out = true;

        for (Contact c : this.contactSet) {
            if(c.getNumber().equals(contact.getNumber())){
                out = false;
            }
        }

        if(out){
            this.contactSet.add(contact);
        }

        return out;
    }

    public boolean addGroup(Group group){

        boolean out = true;

        for (Group g : this.groupSet) {
            if(g.getName().equals(group.getName())){
                out = false;
            }
        }

        if(out){
            this.groupSet.add(group);
        }

        return out;
    }

    public void deliteContact(Contact contact){
        this.contactSet.remove(contact);
    }*/
}
