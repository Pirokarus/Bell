package main.java;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Model {
    private Set<Contact> contactSet;
    private Set<Group> groupSet;

    {
        ClassLoader classLoader = getClass().getClassLoader();
        String contactPath = classLoader.getResource("contactSet.out").getFile();
        String groupPath = classLoader.getResource("groupSet.out").getFile();
        try{
            FileInputStream contactFileInputStream = new FileInputStream(contactPath);
            ObjectInputStream conOIS = new ObjectInputStream(contactFileInputStream);
            contactSet = (Set<Contact>) conOIS.readObject();
        }catch (Exception e){
            contactSet = new HashSet<>();
        }

        try{
            FileInputStream grFileInputStream = new FileInputStream(groupPath);
            ObjectInputStream grOIS = new ObjectInputStream(grFileInputStream);
            groupSet = (Set<Group>) grOIS.readObject();
        }catch (Exception e){
            groupSet = new HashSet<>();
        }

    }

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

    public void save(){
        ClassLoader classLoader = getClass().getClassLoader();
        String contactPath = classLoader.getResource("contactSet.out").getFile();
        String groupPath = classLoader.getResource("groupSet.out").getFile();
        try{
            FileOutputStream contactFileOutputStream = new FileOutputStream(contactPath);
            ObjectOutputStream conOOS = new ObjectOutputStream(contactFileOutputStream);
            conOOS.writeObject(contactSet);
            conOOS.flush();
            conOOS.close();
        }catch (Exception e){
        }

        try{
            FileOutputStream grFileOutputStream = new FileOutputStream(groupPath);
            ObjectOutputStream grOOS = new ObjectOutputStream(grFileOutputStream);
            grOOS.writeObject(groupSet);
            grOOS.flush();
            grOOS.close();
        }catch (Exception e){
        }

    }
}
