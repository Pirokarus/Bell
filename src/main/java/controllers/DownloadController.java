package main.java.controllers;

import main.java.model.Model;
import main.java.model.Service;
import main.java.model.data.Base;
import main.java.model.data.Contact;
import main.java.model.data.Group;

import java.util.Observable;
import java.util.Observer;
import java.util.Set;

public class DownloadController {

    Model model = Model.getInstance();
    Service service = new Service();

    public void downloadModelData(){
        Base base = service.downloadData();
        model.setContactSet(base.getContactSet());
        model.setGroupSet(base.getGroupSet());
    }

    public void updateModelContactSet(Set<Contact> contactSet) {
        model.setContactSet(contactSet);
        save();
    }

    public void updateModelGroupSet(Set<Group> groupSet) {
        model.setGroupSet(groupSet);
        save();
    }

    public void save(){
        Base base = new Base();
        base.setContactSet(model.getContactSet());
        base.setGroupSet(model.getGroupSet());
        service.save(base);
    }
}
