package com.project.controllers;

import com.project.model.Model;
import com.project.model.Service;
import com.project.model.data.Base;
import com.project.model.data.Contact;
import com.project.model.data.Group;

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
